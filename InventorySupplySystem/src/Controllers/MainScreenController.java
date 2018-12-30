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
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
public class MainScreenController implements Initializable {

    Supply inv;

    @FXML
    private TextField partSearchBox;
    @FXML
    private TextField productSearchBox;
    @FXML
    private TableView<Part> partsTable;
    @FXML
    private TableView<Product> productsTable;

    private ObservableList<Part> partSupply = FXCollections.observableArrayList();
    private ObservableList<Product> productSupply = FXCollections.observableArrayList();
    private ObservableList<Part> partsSupplySearch = FXCollections.observableArrayList();
    private ObservableList<Product> productSupplySearch = FXCollections.observableArrayList();
    ArrayList<Integer> partIDList;
    ArrayList<Integer> productIDList;

    public MainScreenController(Supply inv) {
        this.inv = inv;
        partIDList = inv.retrievePartsIDList();
        productIDList = inv.retrieveProductIDList();
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param resource
     */
    @Override
    public void initialize(URL url, ResourceBundle resource) {
        generatePartsTable();
        generateProductsTable();
    }

    private void generatePartsTable() {
        if (!partIDList.isEmpty()) {
            for (int i = 0; i < partIDList.size(); i++) {
                partSupply.add(inv.lookUpPart(partIDList.get(i)));
            }
        }

        partsTable.setItems(partSupply);
        partsTable.refresh();
    }

    private void generateProductsTable() {
        if (!productIDList.isEmpty()) {
            for (int i = 0; i < productIDList.size(); i++) {
                productSupply.add(inv.lookUpProduct(productIDList.get(i)));
            }
        }
        System.out.println(productIDList.size());
        productsTable.setItems(productSupply);
        productsTable.refresh();
    }

    @FXML
    private void exitProgram(ActionEvent event
    ) {
        Platform.exit();
    }

    @FXML
    private void exitProgramButton(MouseEvent event
    ) {
        Platform.exit();
    }

    @FXML
    private void searchForPart(MouseEvent event) {
        if (!partSearchBox.getText().trim().isEmpty()) {
            partsSupplySearch.clear();
            for (int i = 0; i < partIDList.size(); i++) {
                if (inv.lookUpPart(partIDList.get(i)).getName().contains(partSearchBox.getText().trim())) {
                    partsSupplySearch.add(inv.lookUpPart(partIDList.get(i)));
                }
            }
            partsTable.setItems(partsSupplySearch);
            partsTable.refresh();
        }
    }

    @FXML
    private void searchForProduct(MouseEvent event
    ) {
        if (!productSearchBox.getText().trim().isEmpty()) {
            productSupplySearch.clear();
            for (int i = 0; i < productIDList.size(); i++) {
                if (inv.lookUpProduct(productIDList.get(i)).getName().contains(productSearchBox.getText().trim())) {
                    productSupplySearch.add(inv.lookUpProduct(productIDList.get(i)));
                }
            }
            productsTable.setItems(productSupplySearch);
            productsTable.refresh();
        }
    }

    @FXML
    void clearText(MouseEvent event
    ) {
        Object source = event.getSource();
        TextField field = (TextField) source;
        field.setText("");
        if (partSearchBox == field) {
            if (!partSupply.isEmpty()) {
                partsTable.setItems(partSupply);
            }
        }
        if (productSearchBox == field) {
            if (!productSupply.isEmpty()) {
                productsTable.setItems(productSupply);
            }
        }
    }

    @FXML
    private void addPart(MouseEvent event
    ) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPart.fxml"));
            AddPartController controller = new AddPartController(inv);

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

    @FXML
    private void modifyPart(MouseEvent event
    ) {
        try {
            Part selected = partsTable.getSelectionModel().getSelectedItem();
            if (partSupply.isEmpty()) {
                errorWindow(1);
                return;
            }
            if (!partSupply.isEmpty() && selected == null) {
                errorWindow(2);
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyPart.fxml"));
                ModifyPartController controller = new ModifyPartController(inv, selected);

                loader.setController(controller);
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            }
        } catch (IOException e) {

        }
    }

    @FXML
    private void deletePart(MouseEvent event
    ) {
        Part removePart = partsTable.getSelectionModel().getSelectedItem();
        if (partSupply.isEmpty()) {
            errorWindow(1);
            return;
        }
        if (!partSupply.isEmpty() && removePart == null) {
            errorWindow(2);
        } else {
            boolean confirm = confirmationWindow(removePart.getName());
            if (!confirm) {
                return;
            }
            inv.deletePart(removePart);
            partSupply.remove(removePart);
            partsTable.refresh();

        }
    }

    @FXML
    private void deleteProduct(MouseEvent event
    ) {
        boolean deleted = false;
        Product removeProduct = productsTable.getSelectionModel().getSelectedItem();
        if (productSupply.isEmpty()) {
            errorWindow(1);
            return;
        }
        if (!productSupply.isEmpty() && removeProduct == null) {
            errorWindow(2);
            return;
        }
        if (removeProduct.getPartsListSize() > 0) {
            boolean confirm = confirmDelete(removeProduct.getName());
            if (!confirm) {
                return;
            }
        } else {
            if (removeProduct != null) {
                infoWindow(1, removeProduct.getName());
                deleted = true;
                if (deleted) {
                    return;

                } else {
                    infoWindow(2, "");
                }

            }
        }
        inv.removeProduct(removeProduct.getProductID());
        productSupply.remove(removeProduct);
        productsTable.setItems(productSupply);
        productsTable.refresh();
    }

    @FXML
    private void modifyProduct(MouseEvent event
    ) {
        try {
            Product productSelected = productsTable.getSelectionModel().getSelectedItem();
            if (productSupply.isEmpty()) {
                errorWindow(1);
                return;
            }
            if (!productSupply.isEmpty() && productSelected == null) {
                errorWindow(2);

            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyProduct.fxml"));
                ModifyProductController controller = new ModifyProductController(inv, productSelected);

                loader.setController(controller);
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            }
        } catch (IOException e) {

        }
    }

    @FXML
    private void addProduct(MouseEvent event
    ) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProduct.fxml"));
            AddProductController controller = new AddProductController(inv);

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

    private void errorWindow(int code) {
        if (code == 1) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Empty Supply!");
            alert.setContentText("There's nothing to select!");
            alert.showAndWait();
        }
        if (code == 2) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Selection");
            alert.setContentText("You must select an item!");
            alert.showAndWait();
        }

    }

    private boolean confirmationWindow(String name) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete part");
        alert.setHeaderText("Are you sure you want to delete: " + name);
        alert.setContentText("Click ok to confirm");

        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }

    private boolean confirmDelete(String name) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete product");
        alert.setHeaderText("Are you sure you want to delete: " + name + " this product still has parts assigned to it!");
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

}