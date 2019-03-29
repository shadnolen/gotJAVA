/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import InvSupply.InventorySupplySystem;
import Models.Parts;
import Models.Products;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
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
public class MainScreenController implements Initializable {

    @FXML
    private TableView<Parts> partsTable;
    @FXML
    private TableColumn<Parts, Integer> partID_Column;
    @FXML
    private TableColumn<Parts, String> partName_Column;
    @FXML
    private TableColumn<Parts, Integer> partSupplyCount_Column;
    @FXML
    private TableColumn<Parts, Double> partCost_Column;
    @FXML
    private TextField searchPart;
    @FXML
    private TableView<Products> productsTable;
    @FXML
    private TableColumn<Products, Integer> productID_Column;
    @FXML
    private TableColumn<Products, String> productName_Column;
    @FXML
    private TableColumn<Products, Integer> productSupply_Column;
    @FXML
    private TableColumn<Products, Double> productCost_Column;
    @FXML
    private TextField searchProduct;

    
    
     void partsAcc(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PartScreen.fxml"));
        Parent parentPage = loader.load();  
       
        Scene part_page_scene = new Scene(parentPage);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        PartsAddController controller = loader.getController();
        controller.startPart();
        
        app_stage.hide(); 
        app_stage.setScene(part_page_scene);
        app_stage.show();
    }
    

    
    void productsAcc(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ProductScreen.fxml"));
        Parent product_page_parent = loader.load();  
       
        Scene product_page_scene = new Scene(product_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        ProductsAddController controller = loader.getController();
        controller.startProduct();
        
        app_stage.hide(); //optional
        app_stage.setScene(product_page_scene);
        app_stage.show();
    }
    

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     {
        partID_Column.setCellValueFactory(cellData -> cellData.getValue().partIDProperty().asObject());
        partName_Column.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        partSupplyCount_Column.setCellValueFactory(cellData -> cellData.getValue().inStockProperty().asObject());
        partCost_Column.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        
        productID_Column.setCellValueFactory(cellData -> cellData.getValue().productIDProperty().asObject());
        productName_Column.setCellValueFactory(cellData -> cellData.getValue().productNameProperty());
        productSupply_Column.setCellValueFactory(cellData -> cellData.getValue().productInStockProperty().asObject());
        productCost_Column.setCellValueFactory(cellData -> cellData.getValue().productPriceProperty().asObject());
        
        updatePartTableView();
        updateProductTableView();
    }
    }    

   
     @FXML
     private void exitProgram(ActionEvent event)  {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Confirm Exit");
        alert.setHeaderText("Please confirm you want to exit.");
        alert.setContentText("Any unsaved changes will be lost.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        }
    }

    @FXML
    private void partsAdd(ActionEvent event) throws IOException {
        partsAcc(event);
    }

     @FXML
    private void partsChange(ActionEvent event) throws IOException {
        Parts partSelect = partsTable.getSelectionModel().getSelectedItem();
        index = getPartList().indexOf(partSelect);

        if(partSelect != null) {
            partsAcc(event, partSelect);    
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("No Part selected");
            alert.setHeaderText("Please select a part from the existing list to modify"); 
            alert.showAndWait();
        }
    }

    @FXML
    private void partsDelete(ActionEvent event) {
        Parts partSelect = partsTable.getSelectionModel().getSelectedItem();
        
        if(partSelect != null) {
            Boolean found = false;
            //this uses recursion, I'm sure there is a better way to do it
            for (int i = 0; i < InventorySupplySystem.getProductList().size(); i++) {
                ObservableList<Parts> productParts = InventorySupplySystem.getProductList().get(i).getProductParts();
                for(int x = 0; x < productParts.size(); x++) {
                    if(productParts.get(x).equals(partSelect)) {
                       found = true; 
                    }
                }
            } 
            
            if(found) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.setTitle("Unable to delete part");
                alert.setHeaderText("Part is linked to a current product and cannot be deleted"); 
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.initModality(Modality.NONE);
                alert.setTitle("Part Delete Confirmation");
                alert.setHeaderText("Confirm deletion of part");
                alert.setContentText("Are you sure you want to delete " + partSelect.getName()+ "?");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.OK) {
                    partRemove(partSelect);
                    updatePartTableView();
                }    
            }
            
            
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("No Part selected");
            alert.setHeaderText("Please select a part from the existing list to delete"); 
            alert.showAndWait();
        }
    }

    @FXML
    private void partsSearch(ActionEvent event) {
        String term = searchPart.getText();
        ObservableList foundParts = InventorySupplySystem.partLookup(term);
        if(foundParts.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("No Part match found");
            alert.setHeaderText("No Part Names found matching " + term); 
            alert.showAndWait();
        } else {
            partsTable.setItems(foundParts);
        }
    }

    @FXML
    private void productAdd(ActionEvent event) throws IOException {
         productsAcc(event);
     }

    @FXML
    private void productChange(ActionEvent event) throws IOException {
        Products productSelect = productsTable.getSelectionModel().getSelectedItem();
        index = getProductList().indexOf(productSelect);

        if(productSelect != null) {
            accessProduct(event, productSelect);    
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("No Product selected");
            alert.setHeaderText("Please select a product from the existing list to modify"); 
            alert.showAndWait();
        }
    }

    @FXML
    private void productDelete(ActionEvent event)  {
        //make Product has no parts, alert if true
        Products productSelect = productsTable.getSelectionModel().getSelectedItem();
        
        if(productSelect != null) {
            if(productSelect.getProductParts().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.initModality(Modality.NONE);
                alert.setTitle("Product Delete Confirmation");
                alert.setHeaderText("Confirm deletion of product");
                alert.setContentText("Are you sure you want to delete " + productSelect.getName()+ "?");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.OK) {
                    removeProduct(productSelect);
                    updatePartTableView();
                }    
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.setTitle("Product has parts");
                alert.setHeaderText("Unable to delete a product that has parts associated with it"); 
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("No Product selected");
            alert.setHeaderText("Please select a product from the existing list to delete"); 
            alert.showAndWait();
        }
    }

    @FXML
    private void productsSearch(ActionEvent event) {
        String term = searchProduct.getText();
        ObservableList foundProducts = InventorySupplySystem.productLookup(term);
        if(foundProducts.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("No Product match found");
            alert.setHeaderText("No Product Names found matching " + term); 
            alert.showAndWait();
        } else {
            productTable.setItems(foundProducts);
        }
    }
    
        public void startMain(Stage stage) throws IOException {
        index = -1;//reset index each time main screen loads
        Parent part_page_parent = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene part_page_scene = new Scene(part_page_parent);
        stage.setScene(part_page_scene);
        stage.show(); 
        
        updatePartTableView();
        updateProductTableView();
    }
        
          public void updatePartTableView() {
        partsTable.setItems(getPartList());
    }

    public void updateProductTableView() {
        ObservableList<Products> productItems = getProductList();
        productsTable.setItems(productItems);
    }
    
}
