/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DRY.MainLoad;
import Model.InHouse;
import Model.Supply;
import Model.Outsourced;
import Model.Part;
import static Controllers.MainScreenController.selectedIndex;
import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

/**
 * FXML Controller class
 *
 * @author shadn
 */

public class PartScreenController {

    @FXML
    private TextField partId;

    @FXML
    private TextField partName;

    @FXML
    private TextField partCost;

    @FXML
    private TextField partMachineId;

    @FXML
    private TextField partCompany;

    @FXML
    private TextField partInv;

    @FXML
    private TextField partMin;

    @FXML
    private TextField partMax;

    @FXML
    private RadioButton InHouse;

    @FXML
    private RadioButton Outsourced;

    @FXML
    private Label partLabel;
    
    @FXML
    private ToggleGroup typeOfPart;
    
    private Part partSelect;
    
    MainLoad ml = new MainLoad();
    
    @FXML
    void cancelPart(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Confirm Part Cancel");
        alert.setHeaderText("Please confirm you want to cancel editing parts");
        alert.setContentText("Any unsaved changes will be lost");
        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.get() == ButtonType.OK) {
            ml.partMain(event);
        }
    }

    @FXML
    void partType() {
        if (this.typeOfPart.getSelectedToggle().equals(this.InHouse)){
            this.partCompany.setEditable(false);
            this.partCompany.setDisable(true);
            this.partCompany.setText("");
            
            this.partMachineId.setEditable(true);
            this.partMachineId.setDisable(false);
         } else if (this.typeOfPart.getSelectedToggle().equals(this.Outsourced)) {
            this.partMachineId.setEditable(false);
            this.partMachineId.setDisable(true);
            this.partMachineId.setText("");
            
            this.partCompany.setEditable(true); 
            this.partCompany.setDisable(false);
         } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.NONE);
            alert.setTitle("Invalid Part Type");
            alert.setHeaderText("The Part Type selected is not valid"); 
         }
    }

    @FXML
    void savePart(ActionEvent event) throws IOException {
        if(isPartValid(
            this.partName.getText(), 
            this.partMin.getText(),
            this.partMax.getText(),
            this.partInv.getText(),
            this.partCost.getText(),
            this.partCompany.getText(),
            this.partMachineId.getText()
        )) {
            if (this.typeOfPart.getSelectedToggle().equals(this.InHouse)){
                InHouse part = new InHouse();
                part.setMachineID(Integer.parseInt(this.partMachineId.getText()));
                //common mutators
                part.setName(this.partName.getText());
                part.setInStock(Integer.parseInt(this.partInv.getText()));
                part.setMin(Integer.parseInt(this.partMin.getText()));
                part.setMax(Integer.parseInt(this.partMax.getText()));
                part.setPrice(Double.parseDouble(this.partCost.getText()));
                
                if(this.partId.getText().length() == 0) {
                    part.setPartID(Supply.getPartIDCount());
                    Supply.partAdd(part);
                } else {
                    part.setPartID(Integer.parseInt(this.partId.getText()));
                    Supply.partUpdate(selectedIndex(), part);
                }
            } else {
                Outsourced part = new Outsourced();
                part.setCompanyName(this.partCompany.getText());
                //common mutators
                part.setName(this.partName.getText());
                part.setInStock(Integer.parseInt(this.partInv.getText()));
                part.setMin(Integer.parseInt(this.partMin.getText()));
                part.setMax(Integer.parseInt(this.partMax.getText()));
                part.setPrice(Double.parseDouble(this.partCost.getText()));
                
                if(this.partId.getText().length() == 0) {
                    part.setPartID(Supply.getPartIDCount());
                    Supply.partAdd(part);
                } else {
                    part.setPartID(Integer.parseInt(this.partId.getText()));
                    Supply.partUpdate(selectedIndex(), part);
                }
            }
           
             ml.partMain(event);
        }
    }
    
   public  void startPart() {
        this.partLabel.setText("Add Part");
        
        this.InHouse.setToggleGroup(this.typeOfPart);
        this.Outsourced.setToggleGroup(this.typeOfPart);
    }
    
    public void startPart(Part part) {
        this.partLabel.setText("Modify Part");

        this.InHouse.setToggleGroup(this.typeOfPart);
        this.Outsourced.setToggleGroup(this.typeOfPart);
        
        partId.setText(Integer.toString(part.getPartID()));
        partName.setText(part.getName());
        partInv.setText(Integer.toString(part.getInStock()));
        partCost.setText(Double.toString(part.getPrice()));
        partMin.setText(Integer.toString(part.getMin()));
        partMax.setText(Integer.toString(part.getMax()));
        
        if (part instanceof InHouse) {
            InHouse.selectedProperty().set(true);
            partMachineId.setText(Integer.toString(((InHouse) part).getMachineID()));
        } else {
            Outsourced.selectedProperty().set(true);
            partCompany.setText(((Outsourced) part).getCompanyName());
        }
        partType();
    }
    
    //Make sure the part data is valid
    public Boolean isPartValid(String name, String min, String max, String inv, String price, String company, String machine) {
        String errorMessage = "";
        Integer intMin = null, intMax = null, intInv = null;
        Double dPrice = null;
        Boolean valid;
        
        if(name == null || name.length() == 0) {
            errorMessage += ("Part Name is blank\n");
        }
        
        try {
            intMin = Integer.parseInt(min);
        } catch (Exception e) {
            errorMessage += ("Minimum must be numeric\n");
        }
        
        try {
            intMax = Integer.parseInt(max);
        } catch (Exception e) {
            errorMessage += ("Maximum must be numeric\n");
        }
        
        if(intMin != null && intMin < 0) {
            errorMessage += ("Minimum cannot be negative\n");
        }
        
        if(intMin != null && intMax != null && intMin > intMax) {
            errorMessage += ("Minimum must be less than maximum\n");
        }
        
        try {
            intInv = Integer.parseInt(inv);
            
            if(intMin != null && intMax != null && intInv < intMin && intInv > intMax) {
               errorMessage += ("Supply must be between minimum and maximum\n"); 
            }
        } catch (Exception e) {
            errorMessage += ("Supply must be numeric\n");
        }
        
        try {
            dPrice = Double.parseDouble(price);
            
            if(dPrice <= 0) {
               errorMessage += ("Price must be greater than 0\n"); 
            }
        } catch (Exception e) {
            errorMessage += ("Price must be numeric\n");
        }
        
        try {
            if (this.typeOfPart.getSelectedToggle().equals(this.InHouse)){
                //intMachineId
                try {
                    Integer.parseInt(machine);
                } catch (Exception e) {
                    errorMessage += ("Machine ID must be numeric\n");
                }
            } else if (this.typeOfPart.getSelectedToggle().equals(this.Outsourced)) {
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

