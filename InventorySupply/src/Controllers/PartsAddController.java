/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author shadn
 */
public abstract class PartsAddController {

    @FXML
    private RadioButton inhouse;
    @FXML
    private ToggleGroup Toggle;
    @FXML
    private RadioButton outsourced;
    @FXML
    private TextField partId;
    @FXML
    private TextField partSupply;
    @FXML
    private TextField partCost;
    @FXML
    private TextField partSupplyMax;
    @FXML
    private TextField partSupplyMin;
    @FXML
    private TextField partMachineId;
    @FXML
    private TextField partCompany;
    @FXML
    private Label partLabel;

    @FXML
    private void source(ActionEvent event) {
    }

    @FXML
    private void partSave(ActionEvent event) {
    }
    
}
