/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    private TextField search;
    @FXML
    private TableView<?> partSearchTable;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addProductCancelButton;
    @FXML
    private TableView<?> assocPartsTable;
    @FXML
    private TableColumn<?, ?> associatedID;
    @FXML
    private TableColumn<?, ?> associatedName;
    @FXML
    private TableColumn<?, ?> associatedCount;
    @FXML
    private TableColumn<?, ?> associatedPrice;
    @FXML
    private Button productSaveButton;
    @FXML
    private Button productSearchButton;
    @FXML
    private TableColumn<?, ?> productIDCol;
    @FXML
    private TableColumn<?, ?> productNameCol;
    @FXML
    private TableColumn<?, ?> prodcutSupplyCol;
    @FXML
    private TableColumn<?, ?> partPriceCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        Parent addPart = FXMLLoader.load(getClass().getResource("/views/MainScreen.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(addPart));
        window.show();
    }

    @FXML
    private void saveAddProduct(MouseEvent event) {
        
      //    associatedID.setCellValueFactory(cellData -> cellData.getValue().associatedID());
       //  associatedName.setCellValueFactory(cellData -> cellData.getValue().associatedName());         
      //   associatedCount.setCellValueFactory(cellData -> cellData.getValue().associatedCount());
       //  associatedPrice.setCellValueFactory(cellData -> cellData.getValue().associatedPrice());
       
       
       /***
        Animal selectedAnimal = AnimalTable.getSelectionModel().getSelectedItem();
         if (selectedAnimal != null) {
             
            draftGroup.getmembers().add(selectedAnimal);
            AddedAnimalTable.setItems(draftGroup.getmembers()); 
         }
        else {//part not selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Animal is selected");
            alert.setContentText("Please select an animal from the top table.");
            alert.showAndWait();
        }
        ***/
    }
    
}
