/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    private TableView<?> partsTable;
    @FXML
    private TableColumn<?, ?> partID;
    @FXML
    private TableColumn<?, ?> partName;
    @FXML
    private TableColumn<?, ?> partSupply;
    @FXML
    private TableColumn<?, ?> partPrice;
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
    private TableColumn<?, ?> productID;
    @FXML
    private TableColumn<?, ?> productName;
    @FXML
    private TableColumn<?, ?> productCount;
    @FXML
    private TableColumn<?, ?> productPrice;

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
    private void addPart(MouseEvent event) {
    }

    @FXML
    private void modifyPart(MouseEvent event) {
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
    private void modifyProduct(MouseEvent event) {
    }

    @FXML
    private void addProduct(MouseEvent event) {
    }

    @FXML
    private void searchForProduct(MouseEvent event) {
    }
    
}
