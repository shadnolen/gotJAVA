/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Parts;
import Models.Products;
import static Models.SupplyInv.getProductsOL;
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
import javafx.scene.control.Alert.AlertType;
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
    private TableView<?> partTable;
    @FXML
    private TableColumn<?, ?> partIDCV;
    @FXML
    private TableColumn<?, ?> partNameCV;
    @FXML
    private TableColumn<?, ?> partSupplyCV;
    @FXML
    private TableColumn<?, ?> partCostCV;
    @FXML
    private TextField productSearch;
    @FXML
    private TableView<Products> productTable;
    @FXML
    private TableColumn<?, ?> productIdCV;
    @FXML
    private TableColumn<?, ?> productNameCV;
    @FXML
    private TableColumn<?, ?> productSupplyCV;
    @FXML
    private TableColumn<?, ?> productCostColumn;

     private static int index = -1;
    
    public static int selectedIndex() {
        return index;
    }
    /**
     * Initializes the controller class.
     */
    
    @FXML
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
    }

    @FXML
    private void addButton(ActionEvent event) throws IOException {
       partsPage(event);  
    }

    
    @FXML
    private void ModifyButton(ActionEvent event) throws IOException {

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
            alert.setTitle("No Part selected");
            alert.setHeaderText("Please select a part from the existing list to modify"); 
            alert.showAndWait();
        }
  
 
  }
    @FXML
    private void deleteButton(ActionEvent event) {
    }

    @FXML
    private void searchProductButton(ActionEvent event) {
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
    private void productModifyButton(ActionEvent event) {
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
    }
    
}
