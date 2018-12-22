/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

//importing  classes from diffrent package
import Code.Parts;
import Code.Products;
import Code.Supply;

//java imports
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


/**
 *
 * @author shadn
 */
public class imsController  implements Initializable {
    
    Supply inv;
    
    @FXML
    private Label label;
    
    @FXML
    private TextField partSearchField;
    
    @FXML
    private TextField proSearchField;
    
    @FXML
    private TableView<Parts>  partsTable;
    
    @FXML
    private TableView<Products> productsTable;

    private ObservableList<Parts> partSupply = FXCollections.observableArrayList();
    private ObservableList<Products> productSupply = FXCollections.observableArrayList();
    private ObservableList<Parts> partSupplySearch = FXCollections.observableArrayList();
    private ObservableList<Products> productSupplySearch = FXCollections.observableArrayList();
    ArrayList<Integer> partIDL;
    ArrayList<Integer>  productIDL;
    
    
    // Let's go ahead and initialize the controller class
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        generatePartsTable();
        generateProductsTable();        
    }       

    private void generatePartsTable() {
       if(!partIDL.isEmpty()){
           for(int i=0; i < partIDL.size(); i++){
               partSupply.add(inv.lookUpPart(partIDL.get(i)));
           }
       }
       
       partsTable.setItem(partSupply)
    }

    private void generateProductsTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
