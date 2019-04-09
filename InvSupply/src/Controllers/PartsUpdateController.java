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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class PartsUpdateController implements Initializable {

    @FXML
    private RadioButton inhousePart;
    @FXML
    private RadioButton outsourcedPart;
    @FXML
    private TextField partName;
    @FXML
    private TextField partCost;
    @FXML
    private TextField partMax;
    @FXML
    private TextField partMin;
    @FXML
    private Label partLabel;
    @FXML
    private TextField partID;
    @FXML
    private TextField partSupply;
    @FXML
    private TextField machineID;
    @FXML
    private TextField company;
    @FXML
    private ToggleGroup source;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void partType(ActionEvent event) {
    }

    @FXML
    private void saveButton(ActionEvent event) {
    }

    @FXML
    private void cancelButton(ActionEvent event) {
    }
    
}
