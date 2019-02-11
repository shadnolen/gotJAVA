/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class AddPartController implements Initializable {

    @FXML
    private RadioButton inHouseRadio;
    @FXML
    private ToggleGroup addPartToggleGroup;
    @FXML
    private RadioButton outSourcedRadio;
    @FXML
    private TextField addID;
    @FXML
    private TextField addName;
    @FXML
    private TextField addCount;
    @FXML
    private TextField addPrice;
    @FXML
    private TextField addMax;
    @FXML
    private TextField company;
    @FXML
    private TextField addMin;
    @FXML
    private Label companyLabel;
    @FXML
    private Button addCancel;
    @FXML
    private Button addSave;

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
    //Exit back to the main screen 
    private void cancelAddPart(MouseEvent event) throws IOException {
        Parent addPart = FXMLLoader.load(getClass().getResource("/views/MainScreen.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(addPart));
        window.show();
    }

    @FXML
    private void saveAddPart(MouseEvent event) {
        
        
    }
    
}
