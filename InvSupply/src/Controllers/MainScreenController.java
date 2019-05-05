/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Parts;
import Models.Products;
import Models.SupplyInv;
import static Models.SupplyInv.getPartsOL;
import static Models.SupplyInv.getProductsOL;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
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
public class MainScreenController implements Initializable {

    @FXML
    private TextField searchPart;
    @FXML
    private TableView<Parts> partTable;
    @FXML
    private TableColumn<Parts, Integer> partIDCV;
    @FXML
    private TableColumn<Parts, String> partNameCV;
    @FXML
    private TableColumn<Parts, Integer> partSupplyCV;
    @FXML
    private TableColumn<Parts, Boolean> partCostCV;
    @FXML
    private TextField productSearch;
    @FXML
    private TableView<Products> productTable;
    @FXML
    private TableColumn<Products, Integer> productIdCV;
    @FXML
    private TableColumn<Products, String> productNameCV;
    @FXML
    private TableColumn<Products, Integer> productSupplyCV;
    @FXML
    private TableColumn<Products, Boolean> productCostColumn;

     private static int index = -1;
    
    public static int selectedIndex() {
        return index;
    }
    /**
     * Initializes the controller class.
     */
    
    void partsPage (ActionEvent event) throws IOException{
        Parent parentPage = FXMLLoader.load(getClass().getResource("/Views/PartUpdate.fxml"));
        Scene scene = new Scene(parentPage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();  
        stage.setScene(scene);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchParts(ActionEvent event) {
          String text = searchPart.getText();
        ObservableList partFound = SupplyInv.partLookUp(text);
        if(partFound.isEmpty()){
            Alert alert = new Alert(AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("No Match Found");
            alert.setHeaderText("Nothing Found Matching" + text);
            alert.showAndWait();
        }else{
            productTable.setItems(partFound);
        }
    }

    @FXML
    private void addButton(ActionEvent event) throws IOException {
       partsPage(event);  
    }

    
    @FXML
    private void productModifyButton(ActionEvent event) throws IOException {

        Products productSelect = productTable.getSelectionModel().getSelectedItem();
        index = getProductsOL().indexOf(productSelect);

        if(productSelect != null) {
        Parent parentPage = FXMLLoader.load(getClass().getResource("/Views/PartUpdate.fxml"));
        Scene scene = new Scene(parentPage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();           
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("No Product Selected");
            alert.setHeaderText("Please select a Product  from the existing list to modify"); 
            alert.showAndWait();
        }
  
 
  }
    @FXML
    private void deleteButton(ActionEvent event)throws IOException{
        Parent parent = FXMLLoader.load(getClass().getResource("/Views/MainScreen.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    private void searchProductButton(ActionEvent event) {
        String text = productSearch.getText();
        ObservableList productFound = SupplyInv.productLookup(text);
        if(productFound.isEmpty()){
            Alert alert = new Alert(AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("No Match Found");
            alert.setHeaderText("Nothing Found Matching" + text);
            alert.showAndWait();
        }else{
            productTable.setItems(productFound);
        }
    }

    @FXML
    private void prouctAddButton(ActionEvent event) throws IOException {
        Parent parentPage = FXMLLoader.load(getClass().getResource("/Views/ProductUpdate.fxml"));
        Scene scene = new Scene(parentPage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();      
    }

    @FXML
    private void modifyButton(ActionEvent event) throws IOException {
        
        Parts partSelect = partTable.getSelectionModel().getSelectedItem();        
        index = getPartsOL().indexOf(partSelect);
        
         if(partSelect != null) {
        Parent parentPage = FXMLLoader.load(getClass().getResource("/Views/PartUpdate.fxml"));
        Scene scene = new Scene(parentPage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();           
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("No Part selected");
            alert.setHeaderText("Please select a part from the existing list to modify"); 
            alert.showAndWait();
     }
    }

    @FXML
    private void productDeleteButton(ActionEvent event) {
    }

    @FXML
    private void exitProgramButton(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm Exit");
        alert.setHeaderText("Did you Save?");
        alert.setContentText("Click to Exit");
       Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        }
    }
    
}
