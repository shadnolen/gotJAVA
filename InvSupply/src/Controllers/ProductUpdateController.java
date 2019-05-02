/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Parts;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class ProductUpdateController implements Initializable {

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
    private TableColumn<Parts, Integer> partINew;
    @FXML
    private TableColumn<Parts, String> partNameNew;
    @FXML
    private TableColumn<Parts, Integer> partSupplyNew;
    @FXML
    private TableColumn<Parts, Double> partCostNew;
    @FXML
    private TableView<?> productParts;
    @FXML
    private TableColumn<Parts, Integer> productIdNew;
    @FXML
    private TableColumn<Parts, String> productNameNew;
    @FXML
    private TableColumn<Parts, Integer> productSupplyNew;
    @FXML
    private TableColumn<Parts, Double> productCostNew;
    @FXML
    private Label productLabel;
    
     private ObservableList <Parts> currentList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchProducts(ActionEvent event) {
    }

    @FXML
     void addPart(ActionEvent event) {
        Boolean partFound = false;
        Parts part = partNew.getSelectionModel().getSelectedItem();
        
        if(part != null){
            for(int i = 0; i < currentList.size(); i++){
                if(currentList.get(i).equals(part)){
                    partFound = true;
                }
            }
            
           if(partFound){
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.initModality(Modality.NONE);
               alert.setTitle(" Nothing Selected");
               alert.setHeaderText("Please select a part");
               alert.showAndWait();
           
        }else{
            currentList.add(part);
            partNew.setItems(currentList);
        }
    }else{
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.initModality(Modality.NONE);
    alert.setTitle("Nothing selected");
    alert.showAndWait();
        }
}

    @FXML
    private void deletePart(ActionEvent event) {
    }

    @FXML
    private void productSaveButton(ActionEvent event) {
    }

    @FXML
    private void productCancelButton(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/Views/MainScreen.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.showAndWait();
    }
    
     public Boolean isValid(String productID, String productName, String productCost,  String productMax, String partMin, String productSupply, String companyName, String machineID){
       String error = " ";
       Integer intMax = null,  intMin=null,  intSupply=null;
       Double ourCost = null;
  
      
       Boolean valid;
       
       if(productName == null | productName.length() == 0){
           error  += ("Part is empty");
       }
       try {
            intMin = Integer.parseInt(partMin);
        } catch (Exception e) {
            error += ("Minimum must be number \n");
        }
        
        try {
            intMax = Integer.parseInt(productMax);
        } catch (Exception e) {
            error += ("Maximum must be number \n");
        }
        
        if(intMin != null && intMin < 0) {
            error += ("Negative, on the negative input \n");
        }
        
        if(intMin != null && intMax != null && intMin > intMax) {
            error += ("Minimum must be less than maximum\n");
        }
        
        try {
            intSupply = Integer.parseInt(productSupply);
            
            if(intMin != null && intMax != null && intSupply < intMin && intSupply > intMax) {
               error += ("Supply count must be between Min and Max value \n"); 
            }
        } catch (Exception e) {
            error += ("Supply count  must be a number \n");
        }
        
        try {
            ourCost = Double.parseDouble(productCost);
            
            if(ourCost <= 0) {
               error += ("Price must be greater than ZERO \n"); 
            }
        } catch (Exception e) {
            error += ("Price must be a number, yo \n");
        }
        
     if(currentList.isEmpty()){
         error += ("You need at least one part \n");
     }
        
        if (error.length() > 0) {
            error += ("\nFix the listed errors and save again");
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Part Validation Error");
            alert.setHeaderText("Error");
            alert.setContentText(error);
            alert.showAndWait();
            valid = false;
        } else {
            valid = true;
        }
        
        return valid;
    
        
    }
    
}
