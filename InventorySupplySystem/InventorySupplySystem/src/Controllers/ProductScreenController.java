/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DRY.MainLoad;
import Model.Supply;

import Model.Part;
import Model.Product;
import static Controllers.MainScreenController.selectedIndex;
import DRY.NoSelect;
import java.awt.Color;
import java.io.IOException;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class ProductScreenController {

    @FXML
    private TextField productId;

    @FXML
    private TextField productName;

    @FXML
    private TextField productCost;

    @FXML
    private TextField productMax;

    @FXML
    private TextField productMin;

    @FXML
    private TextField productInv;

    @FXML
    private TableView<Part> partNew;

    @FXML
    private TableColumn<Part, Integer> partIdNew;

    @FXML
    private TableColumn<Part, String> partNameNew;

    @FXML
    private TableColumn<Part, Integer> partInvNew;

    @FXML
    private TableColumn<Part, Double> partCostNew;

    @FXML
    private TextField productSearch;

    @FXML
    private TableView<Part> productParts;

    @FXML
    private TableColumn<Part, Integer> productPartId;

    @FXML
    private TableColumn<Part, String> productPartName;

    @FXML
    private TableColumn<Part, Integer> productPartInv;

    @FXML
    private TableColumn<Part, Double> productPartCost;
    
    @FXML
    private Label productLabel;
    
    private ObservableList<Part> currentParts = FXCollections.observableArrayList();
    
     /*** LOAD CLASS ***/    
    MainLoad ml = new MainLoad();
    NoSelect ns = new  NoSelect();
    
    @FXML
    void partAdd(ActionEvent event) {
        Boolean found = false;
        Part part = partNew.getSelectionModel().getSelectedItem();
        
      /*** PART SELECTED? ***/
        if(part != null) {
            for (int i = 0; i < currentParts.size(); i++) {
                if(currentParts.get(i).equals(part)) {
                    found = true;
                }
            } 
   /*** PART DUPLICATE ***/ 
            if(found) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("PartDuplication");
                alert.setHeaderText("Part already in Product");
                alert.setContentText("This part is already linked to the product");
                alert.showAndWait();
            } else {
                currentParts.add(part);
                productParts.setItems(currentParts);    
            }
        } else {
            ns.noAlert();
        }
    }

    @FXML
    void cancelProduct(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Confirm Product Cancel");
        alert.setHeaderText("Please confirm you want to cancel editing products");
        alert.setContentText("Any unsaved changes will be lost");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            ml.proMain(event);
        }
    }

    @FXML
    void partDelete(ActionEvent event) {
        Part partSelect = productParts.getSelectionModel().getSelectedItem();
        
        if(partSelect != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initModality(Modality.NONE);
            alert.setTitle("Part Removal Confirmation");
            alert.setHeaderText("Confirm removal of part");
            alert.setContentText("Are you sure you want to remove '" + partSelect.getName()+ "' from the Product?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                currentParts.remove(partSelect);
                proUpdateView();
            }    
        } else {
        ns.noAlert();
        }
        
    }
    
    public void initialize() {
        partIdNew.setCellValueFactory(cellData -> cellData.getValue().partIDProperty().asObject());
        partNameNew.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        partInvNew.setCellValueFactory(cellData -> cellData.getValue().inStockProperty().asObject());
        partCostNew.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        
        productPartId.setCellValueFactory(cellData -> cellData.getValue().partIDProperty().asObject());
        productPartName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        productPartInv.setCellValueFactory(cellData -> cellData.getValue().inStockProperty().asObject());
        productPartCost.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        
        partTableView();
        proUpdateView();
    }
    
    
    /*** VALID FIELDS / PRODUCT> COST
     * @param name
     * @param min
     * @param max
     * @param inv
     * @param price
     * @return  ***/
 
   
    public Boolean isProductValid(String name, String min, String max, String inv, String price) {
        String errorMessage = "";
        Integer intMin = null, intMax = null, intInv = null;
        Double pricing = null;
        Boolean valid;
        /*** NAME VALID? ***/
        if(name == null || name.length() == 0) {
            errorMessage += ("Product Name is blank \n");
        }
        
        try {
              /*** MIN VALID? ***/
            intMin = Integer.parseInt(min);
        } catch (NumberFormatException e) {
            errorMessage += ("Minimum must be a number \n");
        }
        
        try {
              /*** MAX VALID? ***/
            intMax = Integer.parseInt(max);
        } catch (NumberFormatException e) {
            errorMessage += ("Maximum must be a number \n");
        }
        
        if(intMin != null && intMin < 0) {
            errorMessage += ("Minimum cannot be negative \n");
        }
          /*** MIN < MAX VALID? ***/
        if(intMin != null && intMax != null && intMin > intMax) {
            errorMessage += ("Minimum must be less than max \n");
            
        }
        
        try {
            intInv = Integer.parseInt(inv);
              /*** SUPPY AMOUNT <= MAX/MIN  VALID? ***/
            if(intMin != null && intMax != null && intInv < intMin && intInv > intMax) {
               errorMessage += ("Supply amount must be between MIN and MAX \n"); 
            }
        } catch (NumberFormatException e) {
            errorMessage += ("Supply must be a number \n");
        }
        
        /*** PRICING ***/
        try {
            pricing = Double.parseDouble(price);
            
            if(pricing <= 0) {
               errorMessage += ("Price must be greater than ZER0 \n"); 
            }
        } catch (NumberFormatException e) {
            errorMessage += ("Price must be number \n");
        }
        
        /*** IS ITEM CONNECTED ***/
        if(currentParts.isEmpty()) {
            errorMessage += ("Product must be connected to at least one part \n");
        } else {
            
              /*** PRICING  PRICING > COST?***/
           
            Double partCost = 0.0;
            for (int i = 0; i < currentParts.size(); i++) {
                partCost += currentParts.get(i).getPrice();
            }
            if(pricing != null && partCost > pricing) {
                errorMessage += ("Product price ("+ pricing +") must be greater than the sum of the parts ("+ partCost +")\n");
            }
        }
      
        /*** IF ANY ERROR IS PRESENT ***/ 
        if (errorMessage.length() > 0) {
            errorMessage += ("\n Fix the listed errors to save");          
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

    @FXML
    void saveProduct(ActionEvent event) throws IOException {
        if(isProductValid(
                 /*** REFERENCE VARIABLE THAT REFERS TO THE CURRENT OBJECT  ***/
            this.productName.getText(), 
            this.productMin.getText(),
            this.productMax.getText(),
            this.productInv.getText(),
            this.productCost.getText()
        )) {
            Product product = new Product();
            product.setName(this.productName.getText());
            product.setInStock(Integer.parseInt(this.productInv.getText()));
            product.setMin(Integer.parseInt(this.productMin.getText()));
            product.setMax(Integer.parseInt(this.productMax.getText()));
            product.setPrice(Double.parseDouble(this.productCost.getText()));
            
            product.setProductParts(currentParts);
            
            if(this.productId.getText().length() == 0) {
                product.setProductID(Supply.getProductIndex());
                Supply.proAdd(product);
            } else {
                product.setProductID(Integer.parseInt(this.productId.getText()));
                Supply.proUpdate(selectedIndex(), product);
            }
            
            ml.proMain(event);
        }
    }

    @FXML
    void productSearch(ActionEvent event) {
        String ps = productSearch.getText();
        ObservableList partFound = Supply.partLookUp(ps);
        if(partFound.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("No Part match found");
            alert.setHeaderText("No Part Names found matching " + ps); 
            alert.showAndWait();
        } else {
            partNew.setItems(partFound);
        }
    }

   public void startProduct() {
        this.productLabel.setText("Add Product");
    }
    
   public void startProduct(Product product) {
        this.productLabel.setText("Modify Product");        
        this.productId.setText(Integer.toString(product.getProductID()));
        this.productName.setText(product.getName());
        this.productInv.setText(Integer.toString(product.getInStock()));
        this.productCost.setText(Double.toString(product.getPrice()));
        this.productMin.setText(Integer.toString(product.getMin()));
        this.productMax.setText(Integer.toString(product.getMax()));
        
        currentParts = product.getProductParts();
        proUpdateView();
    }
    
   /*** UPDATE THE VIEWS ***/
    public void partTableView() {
        partNew.setItems(Supply.getPartList());
    }

    private void proUpdateView() {
        productParts.setItems(currentParts);
    }
}
