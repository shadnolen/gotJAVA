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
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 *
 * @author shadn
 */
public class imsController  implements Initializable {
    
    Supply inv;
    
    @FXML
    private Label label;
    
    @FXML
    private TextField partsSearchField;
    
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
 
    
    public imsController(Supply inv, Parts selected){
        this.inv = inv;
        partIDL = inv.retrievePartsIDL();
        productIDL = inv.retrieveProductsIDL();
    }
    
    // Let's go ahead and initialize the controller class

    public imsController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        generatePartsTable();
        generateProductsTable();        
    }       

    private void generatePartsTable() {
       if(!partIDL.isEmpty()){
           for(int i=0; i < partIDL.size(); i++){
               partSupply.add(inv.partsSearch(partIDL.get(i)));
           }
       }
       
       partsTable.setItems(partSupply);
       partsTable.refresh();
    }

    private void generateProductsTable() {
        if(!productIDL.isEmpty()){
            for(int i = 0; i <productIDL.size(); i++){
                productSupply.add(inv.productSearch(productIDL.get(i)));
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
        if(!partsSearch.getText().trim().isEmpty()){
            partSupplySearch.clear();
            for(int i=0; i<partIDL.size();i++){
               if (inv.partsSearch(partIDL.get(i)).getName().contains(partsSearch.getText().trim())){
                   partSupplySearch.add(inv.partsSearch(partIDL.get(i)));
               } 
            }
            
            partsTable.setItems(partSupply);
            partsTable.refresh();
        }
    }
    
    @FXML
    private void searchProductSupply(MouseEvent event){
        if(!productSearch.getText().trim().isEmpty()){
            productSupplySearch.clear();
            for(int i = 0; i < productIDL.size();i++ ) {
                if(inv.productSearch(productIDL.get(i)).getName().contains(productSearch.getText().trim())){
                    productSupplySearch.add(inv.productSearch(productIDL.get(i)));
                }
            }
            
            productsTable.setItems(productSupply);
            productsTable.refresh();
        }
    }
    
  
    @FXML
    private void partAdd(MouseEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/partAdd.fxml"));
            partsAddController controller = new partsAddController(inv);
            
            loader.setController(controller);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }catch(IOException e){
        }
    }
    
    @FXML
    private void modifyPart(MouseEvent event){
        try{
            Parts selected = partsTable.getSelectionModel().getSelectedItem();
            if(partSupply.isEmpty()){
                errorWindow(1);
                return;
            } if (!partSupply.isEmpty()) {
                errorWindow(2);
                return;                
            }else{
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI/proMod.fxml"));
                 imsController controller = new imsController(inv, selected);
                  loader.setController(controller);
           
                  Parent root = loader.load();         
                  Scene scene = new Scene(root);         
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();           
                  stage.setScene(scene);
                  stage.setResizable(false);          
                  stage.show();                    
           }
        }catch(IOException e){                    
                    }            
        }
        
        @FXML
        private void partDelete(MouseEvent event){
            Parts removePart = partsTable.getSelectionModel().getSelectedItem();
            if(partSupply.isEmpty()){
                errorWindow(1);
                return;
        }
            if(partSupply.isEmpty()){
                errorWindow(2);
            }else{
                boolean confirm = confirmationWindow(removePart.getName());
                if(!confirm){
                    return;
                }
                inv.partsDelete(removePart);
                partSupply.remove(removePart);
                partsTable.refresh();
            }
        }
        
        @FXML 
        private void deleteProduct(MouseEvent event){
        boolean deleted = false;
        Products removeProduct = productsTable.getSelectionModel().getSelectedItem();
        if(productSupply.isEmpty()){
            errorWindow(1);
            return;
        }
        if(!productSupply.isEmpty() && removePart == null){
            errorWindow(2);
            return;
        }
        if(productRemoval.getPartsLS() > 0){
            boolean confirm = confirmationWindow(removeProduct.getName());
            if(!confirm){
                return;
            }else{
                if(removeProduct != null){
                    infoWindow(1, removeProduct.getName());
                    deleted = true;
                    if(deleted){
                        return;
                    }else{
                        infoWindow(2, " ");
                    }
            }           
        }
            
            inv.productRemoval(removeProduct.getProductID());
            productSupply.remove(removeProduct);
            productsTable.setItems(productSupply);
            productsTable.refresh();
        }
        
     @FXML
    private void modifyProduct(MouseEvent event ) {
        try {
                Products productSelected = productsTable.getSelectionModel().getSelectedItem();
                if(productSupply.isEmpty()){
                    errorWindow(1);
                    return;
                }
                if(!productSupply.isEmpty() && productSelected == null){
                    errorWindow(2);
                    return;
                }else{
                 
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI/proMod"));
                    proModController controller = new proModController(int, productSelected);
                   
                  loader.setController(controller);
                  Parent root = loader.load();         
                  Scene scene = new Scene(root);         
                  Stage stage = (Stage) ((Node) event.getSource()).getSource().getWindow();           
                  stage.setScene(scene);
                  stage.setResizable(false);          
                  stage.show();      
                }
            }catch(IOException e){
                
            }
        }
        
        @FXML
        private void productAdd(MouseEvent event){
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/proAdd"));
                proAddController controller = new proAddController(inv);

                  loader.setController(controller);
                  Parent root = loader.load();         
                  Scene scene = new Scene(root);         
                 Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();         
                  stage.setScene(scene);
                  stage.setResizable(false);          
                  stage.show();      
          
            }catch(IOException e){                
            }
        }
        
        }
        
    private void errorWindow(int code) {
    if(code==1){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Empty Supply");
        alert.setContentText("Nothing Selected, YO!");
        alert.showAndWait();
    }
     if(code== 2){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invailid Choice");
        alert.setContentText("Select something!");
        alert.showAndWait();
      }
    }
    
    private boolean confirmationWindow(String name){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete This Part");
        alert.setHeaderText("Do you really want to delete  " + name + ", Since it still has parts assigned to it?");
        alert.setContentText("Click to Confirm");
        
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            return true;
        }else{
            return false;
        }
    }

    private void infoWindow(int code, String name) {
       if(code ==1){
           Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("Confirmed");
           alert.setHeaderText(null);
           alert.setContentText( name + ", has been Deleted!");
           alert.showAndWait();
    }else{
            Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("Error in your ways");
           alert.setHeaderText(null);
           alert.setContentText( "Correct you error!");
          }         
     }
}
