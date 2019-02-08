/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import models.SupplyItems;
import models.Parts;
import models.Products;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class MainScreenController implements Initializable {
    
       private ObservableList<Parts> partSupplyArray = FXCollections.observableArrayList();
    private ObservableList<Products> productSupplyArray = FXCollections.observableArrayList();
    private ObservableList<Parts> partsSupplySearch = FXCollections.observableArrayList();
    private ObservableList<Products> productSupplySearch = FXCollections.observableArrayList();
    ArrayList<Integer> partIDList;
    ArrayList<Integer> productIDList;

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
    private TableColumn<Parts, Integer> partID;
    @FXML
    private TableColumn<Parts, String> partName;
    @FXML
    private TableColumn<Parts, Integer> partSupply;
    @FXML
    private TableColumn<Parts, Double> partPrice;
    @FXML
    private TextField searchProducts;
    @FXML
    private Button deleteProductButton;
    @FXML
    private Button modifyProductButton;
    @FXML
    private Button addProductButton;
    @FXML
    private TableView<?> productsTable;
    @FXML
    private TableColumn<Products, Integer> productID;
    @FXML
    private TableColumn<Products, String> productName;
    @FXML
    private TableColumn<Products, Integer> productCount;
    @FXML
    private TableColumn<Products, Double> productPrice;
    

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void exitProgram(ActionEvent event) {
    }

    @FXML
    private void exitProgramButton(MouseEvent event) {
    }

    @FXML
    private void clearText(MouseEvent event) {
    }

    @FXML
    private void addPart(MouseEvent event) throws IOException {
        Parent addPart = FXMLLoader.load(getClass().getResource("/views/AddPart.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(addPart));
        window.show();
    }

    @FXML
    private void modifyPart(MouseEvent event) throws IOException {
        Parent addPart = FXMLLoader.load(getClass().getResource("/views/ModifyPart.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(addPart));
        window.show();
    }
    @FXML
    private void deletePart(MouseEvent event) {
    }

    @FXML
    private void searchForPart(MouseEvent event) {
    }

    @FXML
    private void deleteProduct(MouseEvent event) {
    }

    @FXML
    private void modifyProduct(MouseEvent event) throws IOException {
        Parent addPart = FXMLLoader.load(getClass().getResource("/views/ModifyProduct.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(addPart));
        window.show();
    }

    @FXML
    private void addProduct(MouseEvent event) throws IOException {
        Parent addPart = FXMLLoader.load(getClass().getResource("/views/AddProduct.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(addPart));
        window.show();
    }

    @FXML
    private void searchForProduct(MouseEvent event) {
    }
    
}
