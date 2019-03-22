/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Parts;
import models.Products;
import models.SupplyItems;
import static models.SupplyItems.getPartsList;
import static models.SupplyItems.getProductsList;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class MainScreenController implements Initializable {

    @FXML
    private AnchorPane MainScreen;
    @FXML
    private MenuBar mainMenuBar;
    @FXML
    private MenuItem menuExitItem;
    @FXML
    private Label mainTitleLabel;
    @FXML
    private TableView<Parts> partsTable;
    @FXML
    private TableColumn<Parts, Integer> partIDCol;
    @FXML
    private TableColumn<Parts, String> partNameCol;
    @FXML
    private TableColumn<Parts, Integer> partSupplyCol;
    @FXML
    private TableColumn<Parts, Double> partPriceCol;
    @FXML
    private TableView<Products> productsTable;
    @FXML
    private TableColumn<Products, Integer> productIDCol;
    @FXML
    private TableColumn<Products, String> productNameCol;
    @FXML
    private TableColumn<Products, Integer> productCountCol;
    @FXML
    private TableColumn<Products, Double> productPriceCol;
    
    private static int indexID = 0;
    @FXML
    private TextField partsSearch;
    @FXML
    private TextField productSearch;
    
    private static int partsSelect;
    private static int productsSelect;
    
    
    public static int partsSelected(){
        return partsSelect;
    }
    
    public static int productsSelect(){
        return productsSelect;
    }
    
    
    
    
    public void updatePartsTable(){
        partsTable.setItems(getPartsList());
    }
    
     public void updateProductsTable(){
        ObservableList<Products> productItems = getProductsList();
        productsTable.setItems(productItems);
    }

  
    
    
    public void startMainStage(Stage stage)throws IOException{
        indexID = -0;
        Parent partParent = FXMLLoader.load(getClass().getResource("views/MainScreen.fxml"));
        Scene partScene = new Scene(partParent);
        stage.setScene(partScene);
        stage.show();
        
        updatePartsTable();
        updateProductsTable();        
    }

    @FXML
    private void exit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Do you  really want to Exit?");
        alert.setContentText("All UNSAVED data will be LOST!");
        Optional<ButtonType> exitYo = alert.showAndWait();
        if(exitYo.get() == ButtonType.OK){
            System.exit(0);
        }
    }

    @FXML
    private void partAdd(ActionEvent event) throws IOException{
      
        
    }

    @FXML
    private void partModify(ActionEvent event) {
    }

    @FXML
    private void partDelete(ActionEvent event) {
    }

    @FXML
    private void partsSearch(ActionEvent event) {
            String partSearch = productSearch.getText();
        ObservableList productsFound = SupplyItems.partLookUp(partSearch);
        if(productsFound.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.initModality(Modality.APPLICATION_MODAL);
           alert.setTitle("No Match");
           alert.setHeaderText("No Part Matching " + partSearch);
           alert.showAndWait();
        }else{
            partsTable.setItems(productsFound);
        }
    }

    @FXML
    private void productDelete(ActionEvent event) {
    }

    @FXML
    private void productModify(ActionEvent event) {
    }

    @FXML
    private void productAdd(ActionEvent event) {
    }

    @FXML
    private void productSearch(ActionEvent event) {
          String proSearch = productSearch.getText();
        ObservableList productsFound = SupplyItems.partLookUp(proSearch);
        if(productsFound.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.initModality(Modality.APPLICATION_MODAL);
           alert.setTitle("No Match");
           alert.setHeaderText("No Products Matching " + proSearch);
           alert.showAndWait();
        }else{
            productsTable.setItems(productsFound);
        }
    }
    
    
      /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      partIDCol.setCellValueFactory(cellData -> cellData.getValue().getPartID().asObject());
      partNameCol.setCellValueFactory(cellData-> cellData.getValue().getPartName());
      partSupplyCol.setCellValueFactory(cellData-> cellData.getValue().getPartInStock().asObject());
      partPriceCol.setCellValueFactory(cellData-> cellData.getValue().getPartPrice().asObject());
      
       productIDCol.setCellValueFactory(cellData-> cellData.getValue().getProductID().asObject());
      productNameCol.setCellValueFactory(cellData-> cellData.getValue().getProductName());
      productCountCol.setCellValueFactory(cellData-> cellData.getValue().getProductInStock().asObject());
      productPriceCol.setCellValueFactory(cellData-> cellData.getValue().getProductPrice().asObject());
      
      updatePartsTable();
      updateProductsTable();      
    }    
    
    
    
}
