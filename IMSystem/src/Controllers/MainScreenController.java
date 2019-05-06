/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class MainScreenController implements Initializable {

    @FXML
    private TextField partSearch;
    @FXML
    private TableView<?> partsTable;
    @FXML
    private TableColumn<?, ?> IDColumn;
    @FXML
    private TableColumn<?, ?> NameColumn;
    @FXML
    private TableColumn<?, ?> SupplyColumn;
    @FXML
    private TableColumn<?, ?> CostColumn;
    @FXML
    private TextField proSearch;
    @FXML
    private TableView<?> productTable;
    @FXML
    private TableColumn<?, ?> proIDColumn;
    @FXML
    private TableColumn<?, ?> proNameColumn;
    @FXML
    private TableColumn<?, ?> proSupplyColumn;
    @FXML
    private TableColumn<?, ?> proCostColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void partSearch(ActionEvent event) {
    }

    @FXML
    private void addPart(ActionEvent event) {
    }

    @FXML
    private void partMod(ActionEvent event) {
    }

    @FXML
    private void partDelete(ActionEvent event) {
    }

    @FXML
    private void searchProducts(ActionEvent event) {
    }

    @FXML
    private void proAdd(ActionEvent event) {
    }

    @FXML
    private void proMod(ActionEvent event) {
    }

    @FXML
    private void proDelete(ActionEvent event) {
    }

    @FXML
    private void exit(ActionEvent event) {
    }
    
}
