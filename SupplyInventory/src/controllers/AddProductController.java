/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Parts;
import models.Products;
import supplyinventory.SupplyInventory;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class AddProductController implements Initializable {
    
   

    @FXML
    private TextField addProductID;
    @FXML
    private TextField productName;
    @FXML
    private TextField productCount;
    @FXML
    private TextField productPrice;
    @FXML
    private TextField productMax;
    @FXML
    private TextField productMin;
    @FXML
    private TableView<Parts> partSearchTable;
    @FXML
    private Button deleteButton;
    @FXML
    private TableView<Parts> assocPartsTable;
    @FXML
    private Button productSearchButton;
    
    
    private static SupplyInventory supply = new SupplyInventory();
    private ObservableList<Parts> productPart = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Parts, Integer> addPartIDCol;
    @FXML
    private TableColumn<Parts, String> addProductNameCol;
    @FXML
    private TableColumn<Parts, Integer> addProductSupplyCol;
    @FXML
    private TableColumn<Parts, Double> addPartPriceCol;
    @FXML
    private TableColumn<Parts, Integer> associatedIDCol;
    @FXML
    private TableColumn<Parts, String> associatedNameCol;
    @FXML
    private TableColumn<Parts, Integer> associatedCountCol;
    @FXML
    private TableColumn<Parts, Double> associatedPriceCol;
    @FXML
    private TextField searchField;
    @FXML
    private Button SaveButton;
    @FXML
    private Button CancelButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    

    @FXML
    private void clearTextField(MouseEvent event) {
    }

    @FXML
    private void searchForPart(MouseEvent event) {
    }

    @FXML
    private void clearField(MouseEvent event) {
    }

    @FXML
    private void addPart(MouseEvent event) {
        
        
    }

    @FXML
    private void deletePart(MouseEvent event) {
    }

    @FXML
    private void cancelAddProduct(MouseEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initModality(Modality.NONE);
        alert.setTitle("Confirm Cancel");
        alert.setHeaderText(" Cancel WITHOUT Saving?");
        alert.setContentText("Please confirm.");        
        Optional<ButtonType> optional = alert.showAndWait();
        
       if(optional.get() == ButtonType.OK){
        Parent mainScreen = FXMLLoader.load(getClass().getResource("/views/MainScreen.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(mainScreen));
        window.show();
       }
    }

    private void saveButton(MouseEvent event) throws IOException {
        
        Products newPro= new Products();
        
   newPro.setProductID(Integer.parseInt(addProductID.getText()));
   newPro.setProductName(productName.getText());
   newPro.setProductInStock(Integer.parseInt(productCount.getText()));
   newPro.setProductMax(Integer.parseInt(productMax.getText()));
   newPro.setProductMin(Integer.parseInt(productMin.getText()));
   if(  productPart.isEmpty()){
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.initModality(Modality.NONE);
       alert.setTitle("Error");
       alert.setHeaderText("No Parts Found");
       alert.setContentText("This product has no parts");
       alert.showAndWait();
   }else{
       newPro.setAssociatedParts(productPart);
       
      
       
         Parent mainScreen = FXMLLoader.load(getClass().getResource("/views/MainScreen.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(mainScreen));
        window.show();
      }
   }
    
    public void updatePartsTable(){
       
    }

 

    @FXML
    private void addButtonPro(ActionEvent event) {
        
    }

    @FXML
    private void saveAddProduct(MouseEvent event) {
    }
    
}
