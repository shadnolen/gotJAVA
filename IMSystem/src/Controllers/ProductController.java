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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class ProductController implements Initializable {

    @FXML
    private TextField productID;
    @FXML
    private TextField productName;
    @FXML
    private TextField productSupply;
    @FXML
    private TextField productCost;
    @FXML
    private TextField productMax;
    @FXML
    private TextField productMin;
    @FXML
    private TextField productSearch;
    @FXML
    private TableView<?> partNew;
    @FXML
    private TableColumn<?, ?> partID;
    @FXML
    private TableColumn<?, ?> partName;
    @FXML
    private TableColumn<?, ?> partSupply;
    @FXML
    private TableColumn<?, ?> partCost;
    @FXML
    private TableView<?> proParts;
    @FXML
    private TableColumn<?, ?> proID;
    @FXML
    private TableColumn<?, ?> proName;
    @FXML
    private TableColumn<?, ?> proSupply;
    @FXML
    private TableColumn<?, ?> proPrice;
    @FXML
    private Label productLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchProducts(ActionEvent event) {
    }

    @FXML
    private void partAdd(ActionEvent event) {
    }

    @FXML
    private void partDelete(ActionEvent event) {
    }

    @FXML
    private void saveProduct(ActionEvent event) {
    }

    @FXML
    private void cancelProduct(ActionEvent event) {
    }
    
}
