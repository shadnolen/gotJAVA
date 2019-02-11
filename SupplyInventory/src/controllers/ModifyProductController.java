/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
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
    private Button modifySearchButton;
    @FXML
    private TextField search;
    @FXML
    private TableView<?> partSearchTable;
    @FXML
    private TableColumn<?, ?> partIDCol;
    @FXML
    private TableColumn<?, ?> partNameCol;
    @FXML
    private TableColumn<?, ?> supplyCountCol;
    @FXML
    private TableColumn<?, ?> partPriceCol;
    @FXML
    private Button modifyProductAddButton;
    @FXML
    private Button modifyProductDeleteButton;
    @FXML
    private Button modifyProCancel;
    @FXML
    private TableView<?> assocPartsTable;
    @FXML
    private TableColumn<?, ?> associatedPriceID;
    @FXML
    private TableColumn<?, ?> associatedName;
    @FXML
    private TableColumn<?, ?> associatedCount;
    @FXML
    private TableColumn<?, ?> associatedPrice;
    @FXML
    private Button modifyProductSaveButton;

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
     private void cancelModify(MouseEvent event) throws IOException {
        Parent addPart = FXMLLoader.load(getClass().getResource("/views/MainScreen.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(addPart));
        window.show();
    }

    @FXML
    private void saveProduct(MouseEvent event) {
    }
    
}
