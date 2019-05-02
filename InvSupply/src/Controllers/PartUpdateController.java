/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.MainScreenController.selectedIndex;
import Models.InHouse;
import Models.OutSourced;
import Models.Parts;
import Models.SupplyInv;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
public class PartUpdateController implements Initializable {

    @FXML
    private RadioButton inhousePart;
    @FXML
    private ToggleGroup toggle;
    @FXML
    private RadioButton outsourcedPart;
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
    private TextField companyID;
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
    private void partSource() {
     if(this.toggle.getSelectedToggle().equals(this.inhousePart)){
         this.companyID.setEditable(false);
         this.companyID.setDisable(true);
         this.companyID.setText(" ");
         this.machineID.setEditable(true);
         this.machineID.setDisable(false);
     }else if(this.toggle.getSelectedToggle().equals(this.outsourcedPart)){
        this.machineID.setEditable(false);
        this.machineID.setDisable(true);
        this.machineID.setText(" ");
    }else{
         Alert  alert = new Alert(AlertType.ERROR);
         alert.initModality(Modality.NONE);
         alert.setTitle("Invalid Selection");
         alert.setHeaderText("The selection is invalid");
     }
    }

    @FXML
    private void source(ActionEvent event) {
    }
    
    

   public Boolean isValid(String partID, String partName, String partCost,  String partMax, String partMin,
           String partSupply, String companyName, String machineID){
       String error = " ";
       
       Integer intMax = null,  intMin=null,  intSupply=null;
       Double ourCost = null;
  
      
       Boolean valid;
       
       if(partName == null || partName.length() == 0){
           error  += ("Part is empty");
       }
       try {
            intMin = Integer.parseInt(partMin);
        } catch (Exception e) {
            error += ("Min must be number\n");
        }
        
        try {
            intMax = Integer.parseInt(partMax);
        } catch (Exception e) {
            error += ("Max must be number\n");
        }
        
        if(intMin != null && intMin < 0) {
            error += ("Negative, on using a negative number \n");
        }
        
        if(intMin != null && intMax != null && intMin > intMax) {
            error += ("Min must be less than max \n");
        }
        
        try {
            intSupply = Integer.parseInt(partSupply);
            
            if(intMin != null && intMax != null && intSupply < intMin && intSupply > intMax) {
               error += ("Supply count  must be between min and max \n"); 
            }
        } catch (Exception e) {
            error += ("Supply count must be a number \n");
        }
        
        try {
            ourCost = Double.parseDouble(partCost);
            
            if(ourCost <= 0) {
               error += ("Price must be greater than ZER0\n"); 
            }
        } catch (Exception e) {
            error += ("Price must be number \n");
        }
        
        try {
            if (this.toggle.getSelectedToggle().equals(this.inhousePart)){
                //intMachineId
                try {
                    Integer.parseInt(machineID);
                } catch (Exception e) {
                    error += ("MACHINE ID must be number \n");
                }
            } else if (this.toggle.getSelectedToggle().equals(this.outsourcedPart)) {
                if(companyName == null || companyName.length()== 0) {
                    error += ("You left COMPANY NAME blank \n");
                }
            }    
        } catch(Exception e) {
           error += ("IN-HOUSE or OUTSOURCED must be selected \n"); 
        }
        
        if (error.length() > 0) {
            error += ("\n Fix the errors to save");
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(" Validation Error");
            alert.setHeaderText(" Error");
            alert.setContentText(error);
            alert.showAndWait();
            valid = false;
        } else {
            valid = true;
        }
        
        return valid;
    
        
    }
    @FXML
    private void savePart(ActionEvent event) throws IOException{
        if(!isValid( this.partID.getText(),  this.partName.getText(), this.partCost.getText(), this.partMax.getText(),
                this.partMin.getText(), this.partSupply.getText(), this.companyID.getText(), this.machineID.getText())){
        } 
            if (this.toggle.getSelectedToggle().equals(this.inhousePart)){
                InHouse part = new InHouse();
                part.setMachID(Integer.parseInt(this.machineID.getText()));
                //common mutators
                part.setPartName(this.partName.getText());
                part. setSupplyCount(Integer.parseInt(this.partSupply.getText()));
                part.setPartMin(Integer.parseInt(this.partMin.getText()));
                part.setPartMax(Integer.parseInt(this.partMax.getText()));
                part.setPartPrice(Double.parseDouble(this.partCost.getText()));
                
                if(this.partID.getText().length() == 0) {
                    part.setPartID(SupplyInv.getCountPart());
                    SupplyInv.addPart(part);
                } else {
                    part.setPartID(Integer.parseInt(this.partID.getText()));
                    SupplyInv.updatePart(selectedIndex(), part);
                }
            } else {
                OutSourced part = new OutSourced();
                
                part.setCompanyID(Integer.parseInt(this.companyID.getText()));
                part.setPartID(Integer.parseInt(this.partID.getText()));
                part.setPartName(this.partName.getText());
                part.setPartPrice(Integer.parseInt(this.partCost.getText()));
                part.setPartMax(Integer.parseInt(this.partMax.getText()));
                part.setPartMin(Integer.parseInt(this.partMin.getText()));
                
                if(this.partID.getText().length()==0){
                
                part.setPartID(SupplyInv.getCountPart());
                }else{
                part.setPartID(Integer.parseInt(this.partID.getText()));
                SupplyInv.updatePart(selectedIndex(), part);
                }
            }
    }
    
    

    @FXML
    private void cancelPart(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/Views/MainScreen.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.showAndWait();
    }
    
    
    
    void addPart(){
        this.partLabel.setText("Add a part");
        this.inhousePart.setToggleGroup(toggle);
        this.outsourcedPart.setToggleGroup(toggle);
        
    }
    @FXML
    private void addPart(Parts part){
        this.partLabel.setText("Modify Part");
        this.inhousePart.setToggleGroup(toggle);
        this.outsourcedPart.setToggleGroup(toggle);
        
        partID.setText(Integer.toString(part.getPartID()));
        partName.setText(part.getPartName());
        partSupply.setText(Integer.toString(part.getSupplyCount()));
        partCost.setText(Double.toString(part.getPartPrice()));
        partMax.setText(Integer.toString(part.getPartMax()));
        partMin.setText(Integer.toString(part.getPartMin()));
        
        if(part instanceof InHouse){
       inhousePart.selectedProperty().set(true);
       machineID.setText(Integer.toString(((InHouse) part).getMachID()));
    }else{
            outsourcedPart.selectedProperty().set(true);
            companyID.setText(((OutSourced)part).getCompanyName());
        }
        
        partSource();
        
    }

    
    
}
