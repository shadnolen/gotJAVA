
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.InHouse;
import Models.Outsourced;
import Models.Parts;
import Models.Products;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;

/**
 *
 * @author shadn
 */
public abstract class PartsController {

    private RadioButton inhouse;
    @FXML
    private ToggleGroup toggle;
    private RadioButton outsourced;
    @FXML
    private TextField partId;
    private TextField partSupply;
    @FXML
    private TextField partCost;
    private TextField partSupplyMax;
    private TextField partSupplyMin;
    @FXML
    private TextField partMachineId;
    @FXML
    private TextField partCompany;
    @FXML
    private Label partLabel;
    @FXML
    private RadioButton inhousePart;
    @FXML
    private RadioButton outsourcedPart;
    @FXML
    private TextField partName;
    @FXML
    private TextField partInv;
    @FXML
    private TextField partMax;
    @FXML
    private TextField partMin;

    @FXML
    private void source(ActionEvent event) {
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
               errorMessage += ("Inventory must be between minimum and maximum\n"); 
            }
        } catch (Exception e) {
            errorMessage += ("Inventory must be numeric\n");
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
            if (this.toggle.getSelectedToggle().equals(this.inhouse)){
                //intMachineId
                try {
                    Integer.parseInt(machine);
                } catch (Exception e) {
                    errorMessage += ("Machine ID must be numeric\n");
                }
            } else if (this.toggle.getSelectedToggle().equals(this.outsourced)) {
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
    
    void startPart() {
        this.partLabel.setText("Add Part");
        
        this.inhouse.setToggleGroup(this.toggle);
        this.outsourced.setToggleGroup(this.toggle);
    }
    
    void startPart(Parts part) {
        this.partLabel.setText("Modify Part");

        this.inhouse.setToggleGroup(this.toggle);
        this.outsourced.setToggleGroup(this.toggle);
        
        partId.setText(Integer.toString(part.getPartID()));
        partName.setText(part.getName());
        partSupply.setText(Integer.toString(part.getInStock()));
        partCost.setText(Double.toString(part.getPrice()));
        partSupplyMin.setText(Integer.toString(part.getMin()));
        partSupplyMax.setText(Integer.toString(part.getMax()));
        
        if (part instanceof InHouse) {
            inhousePart.selectedProperty().set(true);
            partMachineId.setText(Integer.toString(((InHouse) part).getMachineID()));
        } else {
            outsourcedPart.selectedProperty().set(true);
            partCompany.setText(((Outsourced) part).getCompanyName());
        }
        partType();
    }
    
    @FXML
    void partType() {
        if (this.toggle.getSelectedToggle().equals(this.inhousePart)){
            this.partCompany.setEditable(false);
            this.partCompany.setDisable(true);
            this.partCompany.setText("");
            
            this.partMachineId.setEditable(true);
            this.partMachineId.setDisable(false);
         } else if (this.toggle.getSelectedToggle().equals(this.outsourcedPart)) {
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

    
}
