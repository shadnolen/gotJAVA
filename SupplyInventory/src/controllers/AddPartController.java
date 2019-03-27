 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.InHouse;
import models.Parts;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class AddPartController implements Initializable {

    @FXML
    private RadioButton partInhouse;
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

    
   
    private Parts sourcedSelected;
    @FXML
    private ToggleGroup toggle;
    @FXML
    private Label addPartLabel;
   
    
    void mainAccess(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("views/MainScreen.fxml"));
        Parent parentPage = loader.load();
        
        Scene scenePage = new Scene(parentPage);
        Stage appPage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        MainScreenController controller = loader.getController();
        controller.startMainStage(appPage);
        appPage.setScene(scenePage);
        appPage.show();
    }
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
    @FXML
    private void radioButtonSelected(ActionEvent event) {
        if(this.toggle.getSelectedToggle().equals(this.partInhouse)){
            this.partCompanyName.setEditable(false);
            this.partCompanyName.setDisable(true);
            this.partCompanyName.setText(" ");
            
           this.partMachineID.setEditable(true);
           this.partMachineID.setDisable(false);
        }else if(this.toggle.getSelectedToggle().equals(this.partOutsourced)){
            this.partMachineID.setEditable(false);
           this.partMachineID.setDisable(true);
           this.partMachineID.setText(" ");
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.NONE);
            alert.setTitle("Invalid Type");
            alert.setHeaderText("Try A Diffrent Part Type");
        }        
    }

    @FXML
    private void saveButton(ActionEvent event) {
        
        if(validPart(
        this.partName.getText(),
                this.partMinStock.getText(),
                this.partMaxStock.getText(),
                this.partsInStock.getText(),
                this.partPrice.getText(),
                this.partCompanyName.getText(),
                this.partMachineID.getText()))
        {      
            if(this.toggle.getSelectedToggle().equals(this.partInhouse)){
                InHouse pih = new InHouse();
            }
        }
    }

    @FXML
    private void cancelButtonPressed(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Confirm Cancel");
        alert.setHeaderText("Confirm Edit Cancel");
        alert.setContentText("Anything Unsaved Will Be Lost");
        Optional<ButtonType> buttonOption = alert.showAndWait();
        if(buttonOption.get()== ButtonType.OK){
            mainAccess( event);
        }
    }

    private boolean validPart(String partName, String partMax, String partMin, String partSupply, String partPrice, String company, String machine) {
        String errorMessage = " ";
        Integer pMin = null; 
        Integer pMax = null;
        Integer pSupply = null;
        Double pPrice = null;
        Boolean valid;
        
         if(partName == null || partName.length() == 0) {
            errorMessage += ("Part Name Can't blank\n");
        }
        
        try {
           pMax = Integer.parseInt(partMax);
        } catch (Exception e) {
            errorMessage += ("Minimum must be a Number \n");
        }
        
        try {
            pMin = Integer.parseInt(partMin);
        } catch (Exception e) {
            errorMessage += ("Maximum must be a Number \n");
        }
        
        if(pMin != null && pMin < 0) {
            errorMessage += ("Minimum Can't be Negative \n");
        }
        
        if(pMin != null && pMax != null && pMin > pMax) {
            errorMessage += ("Minimum must be less than Maximum \n");
        }
        try{
            pSupply = Integer.parseInt(partSupply); 
     if(pMin != null && pMax != null && pSupply<pMin && pMax> pMax){
         errorMessage  += ("Supply Count Must be between Min and Max Count");
     }
        }catch(NumberFormatException e){
            errorMessage +=("Supply Count Must Be A Number");
        }
            try {
            pPrice = Double.parseDouble(partPrice);
            
            if(pPrice <= 0) {
               errorMessage += ("Price must be greater than 0\n"); 
            }
        } catch (NumberFormatException e) {
            errorMessage += ("Price must be numeric\n");
        }
        
        try {
            if (this.toggle.getSelectedToggle().equals(this.partInhouse)){
                //intMachineId
                try {
                    Integer.parseInt(machine);
                } catch (NumberFormatException e) {
                    errorMessage += ("Machine ID must be numeric\n");
                }
            } else if (this.toggle.getSelectedToggle().equals(this.partOutsourced)) {
                if(company == null || company.length() == 0) {
                    errorMessage += ("Company Name is blank\n");
                }
            }    
        } catch(Exception e) {
           errorMessage += ("Part type of In-House or Outsourced must be selected\n"); 
        }
        
        if (errorMessage.length() > 0) {
            errorMessage += ("\nFix the listed errors and save again");
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Part Validation Error");
            alert.setHeaderText("Error");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            valid = false;
        } else {
            valid = true;
        }
        
        return valid;
    } 

    }
    
    
    

