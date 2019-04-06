/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.MainScreenController.indexSelect;
import Models.Parts;
import Models.Products;
import Models.Supply;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class ProductController implements Initializable {

    @FXML
    private TextField productName;
    @FXML
    private TextField productCost;
    @FXML
    private TextField productMax;
    @FXML
    private TextField productMin;
    @FXML
    private TextField productSearch;
    @FXML
    private TableView<Parts> partNew;
    @FXML
    private TableView<Parts> productParts;
    @FXML
    private Label productLabel;
    @FXML
    private TableColumn<Parts, Integer> partID;
    @FXML
    private TableColumn<Parts, String> partName;
    @FXML
    private TableColumn<Parts, Integer> partSupply;
    @FXML
    private TableColumn<Parts, Double> partCost;
    @FXML
    private TableColumn<Parts, Integer> productPartID;
    @FXML
    private TableColumn<Parts, Integer> productSupplyCount;
    @FXML
    private TextField productID;
    @FXML
    private TextField productSupply;
    @FXML
    private TableColumn<Parts, String> productNameField;
    @FXML
    private TableColumn<Parts, Double> productCostField;
    
        void mainScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MainScreen.fxml"));
        Parent productParent = loader.load();  
       
        Scene productScene = new Scene(productParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        MainScreenController controller = loader.getController();
        controller.startMain(stage);
        
        stage.setScene(productScene);
        stage.show();
    }
        
        private ObservableList<Parts> addingParts = FXCollections.observableArrayList();
        //private ObservableList<Products> productParts = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        partID.setCellValueFactory(cellData -> cellData.getValue().partIDProperty().asObject());
        partName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        partSupply.setCellValueFactory(cellData -> cellData.getValue().inStockProperty().asObject());
        partCost.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        
        productPartID.setCellValueFactory(cellData -> cellData.getValue().partIDProperty().asObject());
        productNameField.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        productSupplyCount.setCellValueFactory(cellData -> cellData.getValue().inStockProperty().asObject());
        productCostField.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        
        updatePartTableView();
        updateProductPartTableView();
    }    

    @FXML
    private void productsSearch(ActionEvent event) {
         String searchPro = productSearch.getText();
        ObservableList foundParts = Supply.lookupPart(searchPro);
        if(foundParts.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("No Part match found");
            alert.setHeaderText("No Part Names found matching " + searchPro); 
            alert.showAndWait();
        } else {
            partNew.setItems(foundParts);
        }
    }

    @FXML
    private void partAdd(ActionEvent event) {
         Boolean found = false;
        Parts part = partNew.getSelectionModel().getSelectedItem();
        
       
        if(part != null) {
            for (int i = 0; i < addingParts.size(); i++) {
                if(addingParts.get(i).equals(part)) {
                    found = true;
                }
            } 

            if(found) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Part Duplication");
                alert.setHeaderText("Part already in Product");
                alert.setContentText("This part is already linked to the product");
                alert.showAndWait();
            } else if(!found) {
                addingParts.add(part);
                productParts.setItems(addingParts);    
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("No Part selected");
            alert.setHeaderText("Please select a part from the existing list to add to the product"); 
            alert.showAndWait();
        }
    }

    @FXML
    private void partDelete(ActionEvent event) {
         Parts partSelect = productParts.getSelectionModel().getSelectedItem();
        
        if(partSelect != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initModality(Modality.NONE);
            alert.setTitle("Part Removal Confirmation");
            alert.setHeaderText("Confirm removal of part");
            alert.setContentText("Are you sure you want to remove '" + partSelect.getName()+ "' from the Product?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                addingParts.remove(partSelect);
                updateProductPartTableView();
            }    
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("No Part selected");
            alert.setHeaderText("Please select a part from the existing list to delete from the product"); 
            alert.showAndWait();
        }
    }

    @FXML
    private void saveButton(ActionEvent event) throws IOException {
        if(vaildProducts(
            this.productName.getText(), 
            this.productMin.getText(),
            this.productMax.getText(),
            this.productSupply.getText(),
            this.productCost.getText()
        )) {
            Products product = new Products();
            product.setName(this.productName.getText());
            product.setInStock(Integer.parseInt(this.productSupply.getText()));
            product.setMin(Integer.parseInt(this.productMin.getText()));
            product.setMax(Integer.parseInt(this.productMax.getText()));
            product.setPrice(Double.parseDouble(this.productCost.getText()));
            
            product.setProductParts(addingParts);
            
            if(this.productID.getText().length() == 0) {
                product.setProductID(Supply.getProductIDCount());
                Supply.productsAdd(product);
            } else {
                product.setProductID(Integer.parseInt(this.productID.getText()));
                Supply.productsUpdate(indexSelect(), product);
            }
            
            mainScreen(event);
        }
    }

    @FXML
    private void cancelButton(ActionEvent event) throws IOException {
              Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Confirm Product Cancel");
        alert.setHeaderText("Please confirm you want to cancel editing products");
        alert.setContentText("Any unsaved changes will be lost");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            mainScreen(event);
        }
    }

     public void updatePartTableView() {
        partNew.setItems(Supply.getPartList());
    }

    private void updateProductPartTableView() {
        productParts.setItems(addingParts);
    }
    
    public Boolean vaildProducts(String name, String min, String max, String inv, String price) {
        String errorMessage = "";
        Integer intMin = null, intMax = null, intInv = null;
        Double dPrice = null;
        Boolean valid;
        
        if(name == null || name.length() == 0) {
            errorMessage += ("Product Name is blank\n");
        }
        
        try {
            intMin = Integer.parseInt(min);
        } catch (Exception e) {
            errorMessage += ("Minimum must be numeric\n");
        }
        
        try {
            intMax = Integer.parseInt(max);
        } catch (Exception e) {
            errorMessage += ("Maximum must be numeric\n");
        }
        
        if(intMin != null && intMin < 0) {
            errorMessage += ("Minimum cannot be negative\n");
        }
        
        if(intMin != null && intMax != null && intMin > intMax) {
            errorMessage += ("Minimum must be less than maximum\n");
        }
        
        try {
            intInv = Integer.parseInt(inv);
            
            if(intMin != null && intMax != null && intInv < intMin && intInv > intMax) {
               errorMessage += ("Inventory must be between minimum and maximum\n"); 
            }
        } catch (Exception e) {
            errorMessage += ("Inventory must be numeric\n");
        }
        
        try {
            dPrice = Double.parseDouble(price);
            
            if(dPrice <= 0) {
               errorMessage += ("Price must be greater than 0\n"); 
            }
        } catch (Exception e) {
            errorMessage += ("Price must be numeric\n");
        }
        
        if(addingParts.isEmpty()) {
            errorMessage += ("Product must have at least one part\n");
        } else {
            //loop through all the products and add up the cost
            //price of product cannot be less than the cost of the parts
            Double partCost = 0.0;
            for (int i = 0; i < addingParts.size(); i++) {
                partCost += addingParts.get(i).getPrice();
            }
            if(dPrice != null && partCost > dPrice) {
                errorMessage += ("Product price ("+dPrice+") must be greater than the sum of the parts ("+partCost+")\n");
            }
        }
        
        if (errorMessage.length() > 0) {
            errorMessage += ("\nFix the listed errors and save again");
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Product Validation Error");
            alert.setHeaderText("Error");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            valid = false;
        } else {
            valid = true;
        }
        
        return valid;
    }
    
      void proStart() {
        this.productLabel.setText("Add Product");
    }
    
    void proStart(Products product) {
        this.productLabel.setText("Modify Product");
        
        productID.setText(Integer.toString(product.getProductID()));
        productName.setText(product.getName());
        productSupply.setText(Integer.toString(product.getInStock()));
        productCost.setText(Double.toString(product.getPrice()));
        productMin.setText(Integer.toString(product.getMin()));
        productMax.setText(Integer.toString(product.getMax()));
        
        addingParts = product.getProductParts();
        updateProductPartTableView();
    }
    
}
