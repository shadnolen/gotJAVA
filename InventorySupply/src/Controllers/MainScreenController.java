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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    private TableView<?> partsTable;
    @FXML
    private TableColumn<?, ?> partID_Column;
    @FXML
    private TableColumn<?, ?> partName_Column;
    @FXML
    private TableColumn<?, ?> partSupplyCount_Column;
    @FXML
    private TableColumn<?, ?> partCost_Column;
    @FXML
    private TextField searchPart;
    @FXML
    private TableView<?> productsTable;
    @FXML
    private TableColumn<?, ?> productID_Column;
    @FXML
    private TableColumn<?, ?> productName_Column;
    @FXML
    private TableColumn<?, ?> productSupply_Column;
    @FXML
    private TableColumn<?, ?> productCost_Column;
    @FXML
    private TextField searchProduct;

    
    
     void partsAcc(ActionEvent event, Parts partSelected) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PartScreen.fxml"));
        Parent parentPage = loader.load();  
       
        Scene part_page_scene = new Scene(parentPage);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        PartsAddController controller = loader.getController();
        controller.startPart();
        
        app_stage.hide(); 
        app_stage.setScene(part_page_scene);
        app_stage.show();
    }
    

    
    void productsAcc(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ProductScreen.fxml"));
        Parent product_page_parent = loader.load();  
       
        Scene product_page_scene = new Scene(product_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        ProductsAddController controller = loader.getController();
        controller.startProduct();
        
        app_stage.hide(); //optional
        app_stage.setScene(product_page_scene);
        app_stage.show();
    }
    

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
     @FXML
     private void exitProgram(ActionEvent event) {
     }

    @FXML
    private void partsAdd(ActionEvent event) throws IOException {
        partsAcc(event, partSelected);
    }

     @FXML
    private void partsChange(ActionEvent event) throws IOException {
        Parts partSelected = partsTable.getSelectionModel().getSelectedItem();
        index = getPartList().indexOf(partSelected);

        if(partSelected != null) {
            partsAcc(event, partSelected);    
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("No Part selected");
            alert.setHeaderText("Please select a part from the existing list to modify"); 
            alert.showAndWait();
        }
    }

    @FXML
    private void partsDelete(ActionEvent event) {
    }

    @FXML
    private void partsSearch(ActionEvent event) {
    }

    @FXML
    private void productAdd(ActionEvent event) throws IOException {
         productsAcc(event);
     }

    @FXML
    private void productChange(ActionEvent event) {
    }

    @FXML
    private void productDelete(ActionEvent event) {
    }

    @FXML
    private void productsSearch(ActionEvent event) {
    }
    
}
