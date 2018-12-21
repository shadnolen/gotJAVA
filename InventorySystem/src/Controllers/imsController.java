/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Code.Parts;
import Code.Products;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;


/**
 *
 * @author shadn
 */
public class imsController  implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextField partSearchField;
    
    @FXML
    private TextField proSearchField;
    
    @FXML
    public TableView<Parts>  PartsTable;
    
    @FXML
    private TableView<Products> productsTable;

    private ObservableList<Parts> partInventory = FXCollections.observableArrayList();
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
