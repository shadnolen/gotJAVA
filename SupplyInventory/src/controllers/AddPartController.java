/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.InHouse;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import supplyinventory.SupplyInventory;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class AddPartController implements Initializable {
    
    public boolean inhouseCheck;
    public boolean outhouseCheck;
    private static SupplyInventory supply = MainScreenController.accessInventory();
    private int newPartID;

    @FXML
    private RadioButton partInhouse;
    @FXML
    private ToggleGroup partType;
    @FXML
    private RadioButton partOutsourced;
    @FXML
    private TextField partID;
    @FXML
    private TextField partName;
    @FXML
    private TextField partsInStock;
    @FXML
    private TextField partPrice;
    @FXML
    private TextField partMinStock;
    @FXML
    private TextField partMaxStock;
    @FXML
    private Label partCompanyNameLabel;
    @FXML
    private TextField partCompanyName;
    @FXML
    private Label partMachineIDLabel;
    @FXML
    private TextField partMachineID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     // newPartID = SupplyInventory.getAllParts().size();
    // partID.setText("Auto-Generated: " + newPartID);
    }    

    @FXML
    private void radioButtonSelected(ActionEvent event) {  
        
        if (partInhouse.isSelected()) {
            outhouseCheck = false;
            inhouseCheck = true;
            partCompanyNameLabel.setVisible(false);
            partCompanyName.setVisible(false);
            partMachineIDLabel.setVisible(true);
            partMachineID.setVisible(true);
        }
        else if (partOutsourced.isSelected()) {
            outhouseCheck = true;
            inhouseCheck = false;
            partMachineIDLabel.setVisible(false);
            partMachineID.setVisible(false);
            partCompanyNameLabel.setVisible(true);
            partCompanyName.setVisible(true);
        }
    }

    @FXML
    private void saveButtonPressed(ActionEvent event) {
        if (inhouseCheck){
            InHouse addNewPart = new InHouse();
            addNewPart.setMachineID(Integer.parseInt(partMachineID.getText()));
            addNewPart.setPartName(partName.getText());
            addNewPart.setPartPrice(Double.parseDouble(partPrice.getText()));
            addNewPart.setPartInStock(Integer.parseInt(partsInStock.getText()));
            addNewPart.setPartID(newPartID);
            addNewPart.setPartMinStock(Integer.parseInt(partMinStock.getText()));
            addNewPart.setPartMaxStock(Integer.parseInt(partMaxStock.getText()));
            
            
            
        }
        
    }

    @FXML
      private void cancelButtonPressed(ActionEvent event) throws IOException {
              Parent addPart = FXMLLoader.load(getClass().getResource("/views/MainScreen.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(addPart));
        window.show();  
    
}}

