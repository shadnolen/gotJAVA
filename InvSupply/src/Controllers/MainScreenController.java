/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
    private TableView<?> productTable;
    @FXML
    private TableColumn<?, ?> productIdCV;
    @FXML
    private TableColumn<?, ?> productNameCV;
    @FXML
    private TableColumn<?, ?> productSupplyCV;
    @FXML
    private TableColumn<?, ?> productCostColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchParts(ActionEvent event) {
    }

    @FXML
    private void addButton(ActionEvent event) throws IOException {
        Parent parentPage = FXMLLoader.load(getClass().getResource("/Views/PartUpdate.fxml"));
        Scene scene = new Scene(parentPage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();       
    }

    @FXML
    private void ModifyButton(ActionEvent event) {
        
        
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
