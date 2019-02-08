/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class AddProductController implements Initializable {

    @FXML
    private TextField addProductID;
    @FXML
    private TextField productName;
    @FXML
    private TextField productCount;
    @FXML
    private TextField productPrice;
    @FXML
    private TextField productMax;
    @FXML
    private TextField productMin;
    @FXML
    private TextField search;
    @FXML
    private TableView<?> partSearchTable;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addProductCancelButton;
    @FXML
    private TableView<?> assocPartsTable;
    @FXML
    private TableColumn<?, ?> associatedID;
    @FXML
    private TableColumn<?, ?> associatedName;
    @FXML
    private TableColumn<?, ?> associatedCount;
    @FXML
    private TableColumn<?, ?> associatedPrice;
    @FXML
    private Button productSaveButton;
    @FXML
    private Button productSearchButton;
    @FXML
    private TableColumn<?, ?> productIDCol;
    @FXML
    private TableColumn<?, ?> productNameCol;
    @FXML
    private TableColumn<?, ?> prodcutSupplyCol;
    @FXML
    private TableColumn<?, ?> partPriceCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clearTextField(MouseEvent event) {
    }

    @FXML
    private void searchForPart(MouseEvent event) {
    }

    @FXML
    private void clearField(MouseEvent event) {
    }

    @FXML
    private void addPart(MouseEvent event) {
    }

    @FXML
    private void deletePart(MouseEvent event) {
    }

    @FXML
    private void cancelAddProduct(MouseEvent event) {
    }

    @FXML
    private void saveAddProduct(MouseEvent event) {
    }
    
}
