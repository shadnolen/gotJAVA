/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.InHouse;
import models.Outsourced;
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
    private int newPartID;
    private static SupplyInventory supply = MainScreenController.accessInventory();
    
   
    
    

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
    @FXML
    private Label addPartLabel;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     newPartID = SupplyInventory.getAllParts().size();
     partID.setText("Auto-Generated: " + newPartID);
    }    

    @FXML
    private void radioButtonSelected(ActionEvent event) {  
        
        // Action for InHouse or OutSourced  using hidden field
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
    private void saveButton(ActionEvent event) throws IOException{
        if (inhouseCheck){
            InHouse addNewPart = new InHouse();
          
            addNewPart.setMachineID(Integer.parseInt(partMachineID.getText()));
            addNewPart.setPartName(partName.getText());
            addNewPart.setPartPrice(Double.parseDouble(partPrice.getText()));
            addNewPart.setPartInStock(Integer.parseInt(partsInStock.getText()));
            addNewPart.setPartID(newPartID);
            addNewPart.setPartMin(Integer.parseInt(partMinStock.getText()));
            addNewPart.setPartMax(Integer.parseInt(partMaxStock.getText()));
            
            supply.addPart(addNewPart);  
        }
        
         if (outhouseCheck){
            Outsourced addNewPart = new Outsourced();
           
            addNewPart.setCompanyName(partCompanyName.getText());
            addNewPart.setPartName(partName.getText());
            addNewPart.setPartPrice(Double.parseDouble(partPrice.getText()));
            addNewPart.setPartInStock(Integer.parseInt(partsInStock.getText()));
            addNewPart.setPartID(newPartID);
            addNewPart.setPartMin(Integer.parseInt(partMinStock.getText()));
            addNewPart.setPartMax(Integer.parseInt(partMaxStock.getText()));
            
            supply.addPart(addNewPart);  
        }   
         
         if(!inhouseCheck && outhouseCheck){
        Parent mainScreen = FXMLLoader.load(getClass().getResource("/views/MainScreen.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(mainScreen));
        window.show(); 
         }
         
         //Return us to the main screen 
        Parent mainScreen = FXMLLoader.load(getClass().getResource("/views/MainScreen.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(mainScreen));
        window.show(); 
    }

    
      private void cancelButton(ActionEvent event) throws IOException {
        Parent mainScreen = FXMLLoader.load(getClass().getResource("/views/MainScreen.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(mainScreen));
        window.show();      
    }
      
      void startPart() {
        this.partLabel.setText("Add Part");
        
        this.partInhouse.setToggleGroup(this.partType);
        this.partOutsourced.setToggleGroup(this.partType);
    }

    @FXML
    private void cancelButtonPressed(ActionEvent event) {
    }

    
}

