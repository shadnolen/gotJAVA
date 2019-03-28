/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class MainScreenController implements Initializable {

    @FXML
    private TableView<?> partsTable;
    @FXML
    private TableColumn<?, ?> partID_Column;
    @FXML
    private TableColumn<?, ?> partName_Column;
    @FXML
    private TableColumn<?, ?> partSupplyCount_Column;
    @FXML
    private TableColumn<?, ?> partCost_Column;
    @FXML
    private TextField searchPart;
    @FXML
    private TableView<?> productsTable;
    @FXML
    private TableColumn<?, ?> productID_Column;
    @FXML
    private TableColumn<?, ?> productName_Column;
    @FXML
    private TableColumn<?, ?> productSupply_Column;
    @FXML
    private TableColumn<?, ?> productCost_Column;
    @FXML
    private TextField searchProduct;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addPart(ActionEvent event) {
    }

    @FXML
    private void changePart(ActionEvent event) {
    }

    @FXML
    private void deletePart(ActionEvent event) {
    }

    @FXML
    private void searchParts(ActionEvent event) {
    }

    @FXML
    private void addProduct(ActionEvent event) {
    }

    @FXML
    private void changeProduct(ActionEvent event) {
    }

    @FXML
    private void deleteProduct(ActionEvent event) {
    }

    @FXML
    private void searchProducts(ActionEvent event) {
    }

    @FXML
    private void exitProgram(ActionEvent event) {
    }
    
}
