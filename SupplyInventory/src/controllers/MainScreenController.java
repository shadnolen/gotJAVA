/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import supplyinventory.SupplyInventory;
import java.io.IOException;
import models.SupplyItems;
import models.Parts;
import models.Products;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class MainScreenController implements Initializable {
   //  private static SupplyItems inventory = new SupplyItems();
  // private ObservableList<Parts> partsTable = FXCollections.observableArrayList();
 // private ObservableList<Products> productsTable = FXCollections.observableArrayList();
  // private ObservableList<Parts> partsSupplySearch = FXCollections.observableArrayList();
  // private ObservableList<Products> productSupplySearch = FXCollections.observableArrayList();
    ArrayList<Integer> partIDList;
    ArrayList<Integer> productIDList;
    
    public static int selectPart;
    public static int selectProduct;
    
    public static int selectedParts(){
        return selectPart;
    }
    
    public static int selectedProducts(){
        return selectProduct;
    }
    
    private static SupplyInventory supply = new SupplyInventory();
    private static Parts modifyParts;
    private static Products modifyProd;
    private static int indexProd;
    private static int indexParts;
    
    @FXML
    private AnchorPane MainScreen;
    @FXML
    private MenuBar mainMenuBar;
    @FXML
    private MenuItem menuExitItem;
    @FXML
    private Label mainTitleLabel;
    @FXML
    private Button exiit;
    @FXML
    private TextField searchParts;
    @FXML
    private Button addPartButton;
    @FXML
    private Button modifyPartButton;
    @FXML
    private Button deletePartButton;
    @FXML
    private TableView<Parts> partsTable;
    @FXML
    private TableColumn<Parts,  Integer> partIDCol;
    @FXML
    private TableColumn<Parts, String> partNameCol;
    @FXML
    private TableColumn<Parts, Integer> partSupplyCol;    
    @FXML
    private TableColumn<Parts, Double> partPriceCol;
    @FXML
    private TextField searchProducts;
    @FXML
    private Button deleteProductButton;
    @FXML
    private Button modifyProductButton;
    @FXML
    private Button addProductButton;
    @FXML
    private TableView<Products> productsTable;
      @FXML
    private TableColumn<Products, Integer> productIDCol;
    @FXML
    private TableColumn<Products, Integer> productNameCol;
    @FXML
    private TableColumn<Products, Integer> productCountCol;
    @FXML
    private TableColumn<Products, Double> productPriceCol;


   
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               partIDCol.setCellValueFactory(new PropertyValueFactory<> ("partID"));   
               partNameCol.setCellValueFactory(new PropertyValueFactory<>("partName"));
               partSupplyCol.setCellValueFactory(new PropertyValueFactory<>("partSupply"));
               partPriceCol.setCellValueFactory(new PropertyValueFactory<>("partName"));
               
                productIDCol.setCellValueFactory(new PropertyValueFactory<> ("productID"));   
               productNameCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
               productCountCol.setCellValueFactory(new PropertyValueFactory<>("productSupply"));
               productPriceCol.setCellValueFactory(new PropertyValueFactory<>("productName"));        
    }    
    
    public void updatePartsTable(){
      partsTable.setItems((ObservableList<Parts>) SupplyInventory.getAllParts());
    }

    @FXML
    private void exitProgram(ActionEvent event) {
        
    }



    @FXML
    private void clearText(MouseEvent event) {
    }

    @FXML    
    // Linking to Addpart screen
    private void addPart(MouseEvent event) throws IOException {
        Parent addPart = FXMLLoader.load(getClass().getResource("/views/AddPart.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(addPart));
        window.show();
    }
    
    @FXML
      // Linking to Modifypart 
    private void modifyPart(MouseEvent event) throws IOException {
       
       
       modifyParts =  partsTable.getSelectionModel().getSelectedItem();
        indexParts = SupplyInventory.getAllParts().indexOf(modifyParts);
       
        Parent addPart = FXMLLoader.load(getClass().getResource("/views/ModifyPart.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(addPart));
        window.show();
    }
    
        @FXML
        // Linking To ModifiyProduct
    private void modifyProduct(MouseEvent event) throws IOException {
        
        modifyProd =  productsTable.getSelectionModel().getSelectedItem();
        indexProd = SupplyInventory.getAllProducts().indexOf(modifyProd);
        
        Parent addPart = FXMLLoader.load(getClass().getResource("/views/ModifyProduct.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(addPart));
        window.show();
    }

    @FXML
    //Linking to Addproduct
    private void addProduct(MouseEvent event) throws IOException {
        Parent addPart = FXMLLoader.load(getClass().getResource("/views/AddProduct.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(addPart));
        window.show();
    }
    
      
    @FXML
    private void deletePart(MouseEvent event) {  
    
     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Delete Product");
        alert.setHeaderText("Please confirm.");
        alert.setContentText("Are you sure you want to delete this product?");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK) {
            supply.removeProduct(productsTable.getSelectionModel().getSelectedItem());
            updateProductsTable();
        }
        else {
            System.out.println("Cancelling deleteProduct action.");
        }
      }
    
    public void updateProductsTable() { 
        productsTable.setItems((ObservableList<Products>) SupplyInventory.getAllProducts());   
    }

    

    @FXML
    private void searchForPart(MouseEvent event) {
            /****
           String searchText = searchParts.getText();
        FilteredList<Parts> searchAnimalResults = searchParts(searchText);
        SortedList<Parts> sortedData = new SortedList<>(searchAnimalResults);
        sortedData.comparatorProperty().bind(Parts.partName());
        Parts.setItems(sortedData);
        * ****/
    }

    @FXML
    private void deleteProduct(MouseEvent event) {
    }



    @FXML
    private void searchForProduct(MouseEvent event) {
    }
    
        @FXML
        
        // Exit this piece of codework
    private void exitProgramButton(MouseEvent event) {
         
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initModality(Modality.NONE);
        alert.setTitle("Confirm Exit");
        alert.setHeaderText(" Would you like to exit the program?");
        alert.setContentText("Please confirm.");        
        Optional<ButtonType> exit = alert.showAndWait();
        
        if (exit.get() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }
        else {
            System.out.println("Cancelling exit action.");
        }
    
    }

    private void removePart(Parts selectedPart) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void updatePartTableView() {
       productsTable.setItems((ObservableList<Products>) SupplyInventory.getAllProducts());
    }

    private FilteredList<Parts> searchParts(String searchText) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static SupplyInventory accessInventory() {    
          return supply;
    }
    
}
