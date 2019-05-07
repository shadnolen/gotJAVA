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
public class PartsController implements Initializable {

    @FXML
    private RadioButton inhouse;
    @FXML
    private ToggleGroup groupToggle;
    @FXML
    private RadioButton outsourced;
    @FXML
    private TextField partID;
    @FXML
    private TextField partName;
    @FXML
    private TextField partSupply;
    @FXML
    private TextField partCost;
    @FXML
    private TextField partMax;
    @FXML
    private TextField partMin;
    @FXML
    private TextField machineID;
    @FXML
    private TextField partCompany;
    @FXML
    private Label partLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void toggle(ActionEvent event) {
    }

    @FXML
    private void savePart(ActionEvent event) {
    }

    @FXML
    private void cancelPart(ActionEvent event) {
    }

    void paging() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
