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
import java.awt.event.MouseEvent;

//java imports
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    
    public imsController(Supply inv){
        this.inv = inv;
        partIDL = inv.retrievePartIDL();
        productIDL = inv.retrieveProductIDL();
    }
    
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
       
       partsTable.setItems(partSupply);
       partsTable.refresh();
    }

    private void generateProductsTable() {
        if(!productIDL.isEmpty()){
            for(int i = 0; i <productIDL.size(); i++){
                productSupply.add(inv.lookUpProduct(productIDL.get(i)));
            }
        }
        System.out.println(productIDL.size());
        productsTable.setItems(productSupply);        
    }
    
    @FXML
    private void exitSystem(ActionEvent ae){
        Platform.exit();
    }
    
    @FXML
    private void exitSysemButtom(MouseEvent event){
        Platform.exit();
    }
    
    @FXML
    private void searchPartList(MouseEvent event){
        if(!partsSearchBox.getText().trim().isEmpty()){
            partsSupplySearch.clear();
            for(int i=0; i<partIDL.size();i++){
               if (inv.lookUpPart(partIDL.get(i)).getName().contains(partsSearchBox.getText().trim())){
                   partSupplySearch.add(inv.lookUpPart(partIDL.get(i)));
               } 
            }
            
            partsTable.setItems(partSupply);
            partsTable.refresh();
        }
    }
    
    @FXML
    private void searchProductSupply(MouseEvent event){
        if(!productSearchBox.getText().trim().isEmpty()){
            productSupplySearch.clear();
            for(int i = 0; i < productIDL.size();i++ ) {
                if(inv.lookUpProduct(productIDL.get(i)).getName().contains(productSearchBox.getText().trim())){
                    productSupplySearch.add(inv.lookUpProduct(productIDL.get(i)));
                }
            }
            
            productsTable.setItems(productSupply);
            productsTable.refresh();
        }
    }
    
  
    @FXML
    private void addPart(MouseEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addPart.fxml"));
            
        }
    }
    
    @FXML
    private void modifyPart(MouseEvent event){
        try{
            Parts
        }
    }
}
