/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class ModifyPartController implements Initializable {

    @FXML
    private AnchorPane modifyCount;
    @FXML
    private RadioButton inHouseRadio;
    @FXML
    private ToggleGroup source;
    @FXML
    private RadioButton outSourcedRadio;
    @FXML
    private TextField modifyID;
    @FXML
    private TextField modifyName;
    @FXML
    private TextField modifyPrice;
    @FXML
    private TextField modifyMax;
    @FXML
    private TextField company;
    @FXML
    private TextField modifyMin;
    @FXML
    private Label companyLabel;
    @FXML
    private Button modifyCancelButton;
    @FXML
    private Button modifySaveButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void selectInHouse(MouseEvent event) {
    }

    @FXML
    private void selectOutSourced(MouseEvent event) {
    }

    @FXML
    private void idDisabled(MouseEvent event) {
    }

    @FXML
    private void clearTextField(MouseEvent event) {
    }

    @FXML
    private void cancelModifyPart(MouseEvent event) {
    }

    @FXML
    private void saveModifyPart(MouseEvent event) {
    }
    
}
