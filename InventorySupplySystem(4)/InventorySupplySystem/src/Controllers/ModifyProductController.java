/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.Supply;
import Model.Part;
import Model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class ModifyProductController implements Initializable {

    Supply supply;
    Product product;

    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField price;
    @FXML
    private TextField count;
    @FXML
    private TextField min;
    @FXML
    private TextField max;

    @FXML
    private TableView<Part> assocPartsTable;
    @FXML
    private TableView<Part> partSearchTable;
    @FXML
    private TextField search;

    private ObservableList<Part> partsSupply = FXCollections.observableArrayList();
    private ObservableList<Part> partsSupplySearch = FXCollections.observableArrayList();
    private ObservableList<Part> assocPartList = FXCollections.observableArrayList();
    ArrayList<Integer> partIDList;

    public ModifyProductController(Supply supply, Product product) {
        this.supply = supply;
        this.product = product;
        this.partIDList = supply.retrievePartsIDList();

    }

    /**
     * Initializes the controller class.
     * @param url
     * @param resource
     */
    @Override
    public void initialize(URL url, ResourceBundle resource) {
        populateSearchTable();
        setData();
    }

    @FXML
    void clearTextField(MouseEvent event) {
        Object source = event.getSource();
        TextField field = (TextField) source;
        field.setText("");
        if (field == search) {
            partSearchTable.setItems(partsSupply);
        }
    }

    @FXML
    private void modifyProductSearch(MouseEvent event) {
        if (search.getText().trim().length() == 0 | search.getText() == null) {
        } else {
            partsSupplySearch.clear();
            for (int i = 0; i < supply.partListSize(); i++) {
                if (supply.lookUpPart(partIDList.get(i)).getName().contains(search.getText().trim())) {
                    partsSupplySearch.add(supply.lookUpPart(partIDList.get(i)));
                }
            }
            partSearchTable.setItems(partsSupplySearch);
        }

    }

    @FXML
    private void deletePart(MouseEvent event) {
        Part removePart = assocPartsTable.getSelectionModel().getSelectedItem();
        boolean deleted = false;
        if (removePart != null) {
            boolean remove = confirmationWindow(removePart.getName());
            if (remove) {
                deleted = product.removeAssociatedPart(removePart.getPartID());
                assocPartList.remove(removePart);
                assocPartsTable.refresh();
            }
        } else {
            return;
        }
        if (deleted) {
            infoWindow(1, removePart.getName());
        } else {
            infoWindow(2, "");
        }

    }

    @FXML
    private void addPart(MouseEvent event) {
        Part addPart = partSearchTable.getSelectionModel().getSelectedItem();
        boolean repeatedItem = false;

        if (addPart == null) {
        } else {
            int id = addPart.getPartID();
            for (int i = 0; i < assocPartList.size(); i++) {
                if (assocPartList.get(i).getPartID() == id) {
                    errorWindow(2, null);
                    repeatedItem = true;
                }
            }

            if (!repeatedItem) {
                assocPartList.add(addPart);
            }
            assocPartsTable.setItems(assocPartList);
        }
    }

    @FXML
    private void cancelModify(MouseEvent event) {
        boolean cancel = cancel();
        if (cancel) {
            mainScreen(event);
        } else {
        }
    }

    @FXML
    private void saveProduct(MouseEvent event) {
        resetFieldsStyle();
        boolean end = false;
        TextField[] fieldCount = {count, price, min, max};
        double minCost = 0;
        for (int i = 0; i < assocPartList.size(); i++) {
            minCost += assocPartList.get(i).getPrice();
        }
        if (name.getText().trim().isEmpty() || name.getText().trim().toLowerCase().equals("part name")) {
            errorWindow(4, name);
            return;
        }
        for (TextField fieldCount1 : fieldCount) {
            boolean valueError = checkValue(fieldCount1);
            if (valueError) {
                end = true;
                break;
            }
            boolean typeError = checkType(fieldCount1);
            if (typeError) {
                end = true;
                break;
            }
        }
        if (Integer.parseInt(min.getText().trim()) > Integer.parseInt(max.getText().trim())) {
            errorWindow(10, min);
            return;
        }
        if (Integer.parseInt(count.getText().trim()) < Integer.parseInt(min.getText().trim())) {
            errorWindow(8, count);
            return;
        }
        if (Integer.parseInt(count.getText().trim()) > Integer.parseInt(max.getText().trim())) {
            errorWindow(9, count);
            return;
        }
        if (Double.parseDouble(price.getText().trim()) < minCost) {
            errorWindow(6, price);
            return;
        }
        if (assocPartList.isEmpty()) {
            errorWindow(7, null);
            return;
        }

        saveProduct();
        mainScreen(event);

    }

    private void saveProduct() {
        Product products = new Product(Integer.parseInt(id.getText().trim()), name.getText().trim(), Double.parseDouble(price.getText().trim()),
                Integer.parseInt(count.getText().trim()), Integer.parseInt(min.getText().trim()), Integer.parseInt(max.getText().trim()));
        for (int i = 0; i < assocPartList.size(); i++) {
            products.addAssociatedPart(assocPartList.get(i));
        }

        supply.updateProduct(products);

    }

    private void setData() {
        for (int i = 0; i < 1000; i++) {
            Part part = product.lookupAssociatedPart(i);
            if (part != null) {
                assocPartList.add(part);
            }
        }

        assocPartsTable.setItems(assocPartList);

        this.name.setText(product.getName());
        this.id.setText((Integer.toString(product.getProductID())));
        this.count.setText((Integer.toString(product.getInStock())));
        this.price.setText((Double.toString(product.getPrice())));
        this.min.setText((Integer.toString(product.getMin())));
        this.max.setText((Integer.toString(product.getMax())));

    }

    private void populateSearchTable() {
        if (supply.partListSize() == 0) {
            return;
        } else {
            for (int i = 0; i < partIDList.size(); i++) {
                partsSupply.add(supply.lookUpPart(partIDList.get(i)));
            }
        }

        partSearchTable.setItems(partsSupply);
    }

    private void errorWindow(int code, TextField field) {
        fieldError(field);

        switch (code) {
            case 1:
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error adding product");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Field is empty!");
                    alert.showAndWait();
                    break;
                }
            case 2:
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("This part is already is associated with this product!");
                    alert.showAndWait();
                    break;
                }
            case 3:
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error adding product");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Invalid format!");
                    alert.showAndWait();
                    break;
                }
            case 4:
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error adding product");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Name is Invaild!");
                    alert.showAndWait();
                    break;
                }
            case 5:
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error adding product");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Value cannot be negative!");
                    alert.showAndWait();
                    break;
                }
            case 6:
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error adding product");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Product cost cannot be lower than it's parts!");
                    alert.showAndWait();
                    break;
                }
            case 7:
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error adding product");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Product must have at least one part!");
                    alert.showAndWait();
                    break;
                }
            case 8:
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Supply cannot be lower than minimum!");
                    alert.showAndWait();
                    break;
                }
            case 9:
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Supply cannot be greater than maximum!");
                    alert.showAndWait();
                    break;
                }
            case 10:
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Minimum can't be greater than maximum!");
                    alert.showAndWait();
                    break;
                }
            default:
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error adding product");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Unknown error!");
                    alert.showAndWait();
                    break;
                }
        }
    }

    private void fieldError(TextField field) {
        if (field == null) {
        } else {
            field.setStyle("-fx-bacground-color: red");
        }
    }

    private void resetFieldsStyle() {
        name.setStyle("-fx-border-color: purple");
        count.setStyle("-fx-border-color: purple");
        price.setStyle("-fx-border-color: purple");
        min.setStyle("-fx-border-color: purple");
        max.setStyle("-fx-border-color: purple");

    }

    private boolean confirmationWindow(String name) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete part");
        alert.setHeaderText("Are you sure you want to delete: " + name);
        alert.setContentText("Click ok to confirm");

        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }

    private void infoWindow(int code, String name) {
        if (code != 2) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Confirmed");
            alert.setHeaderText(null);
            alert.setContentText(name + " has been deleted!");

            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("There was an error!");
        }
    }

    private void mainScreen(Event event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
            MainScreenController controller = new MainScreenController(supply);

            loader.setController(controller);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {

        }
    }

    private boolean checkValue(TextField field) {
        boolean error = false;
        try {
            if (field.getText().trim().isEmpty() || field.getText().trim() == null) {
                errorWindow(1, field);
                return true;
            }
            if (field == price && Double.parseDouble(field.getText().trim()) < 0) {
                errorWindow(5, field);
                error = true;
            }
        } catch (NumberFormatException e) {
            error = true;
            errorWindow(3, field);
            System.out.println(e);

        }
        return error;
    }

    private boolean checkType(TextField field) {

        if (field == price & !field.getText().trim().matches("\\d+(\\.\\d+)?")) {
            errorWindow(3, field);
            return true;
        }
        if (field != price & !field.getText().trim().matches("[0-9]*")) {
            errorWindow(3, field);
            return true;
        }
        return false;

    }

    private boolean cancel() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Cancel");
        alert.setHeaderText("Are you sure you want to cancel?");
        alert.setContentText("Click ok to confirm");

        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }
}