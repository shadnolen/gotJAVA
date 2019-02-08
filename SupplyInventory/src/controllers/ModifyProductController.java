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
public class ModifyProductController implements Initializable {

    @FXML
    private TextField search;
    @FXML
    private TableView<?> partSearchTable;
    @FXML
    private Button modifyProductAddButton;
    @FXML
    private Button modifyProductDeleteButton;
    @FXML
    private TableView<?> assocPartsTable;
    @FXML
    private Button modifyProductSaveButton;
    @FXML
    private TextField modifyProID;
    @FXML
    private TextField modifyProName;
    @FXML
    private TextField modifyProSupply;
    @FXML
    private TextField modifyProPrice;
    @FXML
    private TextField modifyProMax;
    @FXML
    private TextField modifyProMin;
    @FXML
    private TableColumn<?, ?> partIDCol;
    @FXML
    private TableColumn<?, ?> partNameCol;
    @FXML
    private TableColumn<?, ?> supplyCountCol;
    @FXML
    private TableColumn<?, ?> partPriceCol;
    @FXML
    private Button modifyProCancel;
    @FXML
    private TableColumn<?, ?> associatedPriceID;
    @FXML
    private TableColumn<?, ?> associatedName;
    @FXML
    private TableColumn<?, ?> associatedCount;
    @FXML
    private TableColumn<?, ?> associatedPrice;
    @FXML
    private Button modifySearchButton;

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
    private void modifyProductSearch(MouseEvent event) {
    }

    @FXML
    private void addPart(MouseEvent event) {
    }

    @FXML
    private void deletePart(MouseEvent event) {
    }

    @FXML
    private void cancelModify(MouseEvent event) {
    }

    @FXML
    private void saveProduct(MouseEvent event) {
    }
    
}
