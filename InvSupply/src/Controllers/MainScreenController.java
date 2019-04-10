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
    private void addButton(ActionEvent event) {
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
    private void prouctAddButton(ActionEvent event) {
    }

    @FXML
    private void productModifyButton(ActionEvent event) {
    }

    @FXML
    private void productDeleteButton(ActionEvent event) {
    }

    @FXML
    private void exitProgramButton(ActionEvent event) {
    }
    
}
