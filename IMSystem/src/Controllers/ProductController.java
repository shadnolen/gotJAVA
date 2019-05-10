/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Parts;
import Models.Products;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
    private TableView<Parts> partNew;
    @FXML
    private TableColumn<Parts, Integer> partID;
    @FXML
    private TableColumn<Parts, String> partName;
    @FXML
    private TableColumn<Parts, Integer> partSupply;
    @FXML
    private TableColumn<Parts, Double> partCost;
    @FXML
    private TableView<Products> proParts;
    @FXML
    private TableColumn<Products, Integer> proID;
    @FXML
    private TableColumn<Products, String> proName;
    @FXML
    private TableColumn<Products, Integer> proSupply;
    @FXML
    private TableColumn<Products, Double> proPrice;
    @FXML
    private Label productLabel;

    /**
     * Initializes the controller class.
     */
    
    private ObservableList<Parts> prodList  = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchProducts(ActionEvent event) {
    }

    @FXML
    private void partAdd(ActionEvent event) {
        Boolean  partFound = false;
        Parts part = partNew.getSelectionModel().getSelectedItem();
        if(part != null){
            for(int i= 0; i< prodList.size();i++ ){
                if(prodList.get(i))
            }
        }
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
