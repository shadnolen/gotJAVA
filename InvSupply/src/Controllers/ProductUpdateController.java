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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TableView<?> partNew;
    @FXML
    private TableColumn<?, ?> partINew;
    @FXML
    private TableColumn<?, ?> partNameNew;
    @FXML
    private TableColumn<?, ?> partSupplyNew;
    @FXML
    private TableColumn<?, ?> partCostNew;
    @FXML
    private TableView<?> productParts;
    @FXML
    private TableColumn<?, ?> productIdNew;
    @FXML
    private TableColumn<?, ?> productNameNew;
    @FXML
    private TableColumn<?, ?> productSupplyNew;
    @FXML
    private TableColumn<?, ?> productCostNew;
    @FXML
    private Label productLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchProducts(ActionEvent event) {
    }

    @FXML
    private void addPart(ActionEvent event) {
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
    
}
