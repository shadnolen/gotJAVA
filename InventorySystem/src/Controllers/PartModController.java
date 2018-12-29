/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Code.InHouse;
import Code.Parts;
import Code.Supply;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
/**
 *
 * @author shadn
 */
    public class PartModController implements Initializable{
Supply inv;
Parts part;

@FXML
private RadioButton inHouseRadio;

@FXML
private RadioButton outSourcedRadio;

@FXML 
private Label companyName;

@FXML
 private TextField partID;

@FXML
private TextField partName;

@FXML 
private TextField partCount;

@FXML
private TextField partPrice;

@FXML
private TextField partMax;

@FXML
private TextField partMin;

@FXML
private Button partModSaveButton;

private PartModController (Supply inv, Parts parts){
this.inv = inv;
this.part = parts;
}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       setData();
    }

    private void setData() {
       if (part instanceof InHouse){
           InHouse in = (InHouse) part;
           inHouseRadio.setSelected(true);           
           companyName.setText("Machine ID");
          this.partName.setText(in.getPartName());
          this.partID.setText((Integer.toString(in.getPartID())));
          this.partCount.setText ((Integer.toString(in.getStock())));.
          this.partPrice.setText((Double.toString(in.getPrice())));
          this.partMax.setText(Integer.toString(in.getMax()));
          this.partMin.setText(Integer.toString(in.getMin()));
          this.companyName.setText((Integer.toString(in.getMachineID)));
       }
       
       if(part instanceof Outsourced){
           Outsourced out = (Outsourced) part;
          outSourcedRadio.setSelected(true);           
           companyName.setText("Machine ID");
          this.partName.setText(out.getPartName());
          this.partID.setText((Integer.toString(out.getPartID())));
          this.partCount.setText ((Integer.toString(out.getStock())));.
          this.partPrice.setText((Double.toString(out.getPrice())));
          this.partMax.setText(Integer.toString(out.getMax()));
          this.partMin.setText(Integer.toString(out.getMin()));
          this.companyName.setText((Integer.toString(out.getMachineID)));          
       }
    }
        @FXML 
        private void clearField(MouseEvent event){
            Object source = event.getSource();
            TextField field = (TextField) source;
            field.setText(" ");            
        }
        @FXML
        private void inHouseSelect(MouseEvent event){
            companyName.setText("Machine ID");            
        }
        
        @FXML
        private void outSourceSelect(MouseEvent event){
            companyName.setText("Company Name");
        }
        
        @FXML
        private void idDisable(MouseEvent event){
            //left blank 
        }
        
        @FXML 
        private void cancelPart(MouseEvent event){
            boolean cancel = cancel();
            if(cancel){
                mainIMS(event);
            }else{
                return;
            }
        }
        
        @FXML
        private void saveMod(MouseEvent event){
            resetFieldStyle();
            boolean end = false;
            TextField[] fieldCount = {partCount, partPrice, partMax, partMin};
         if(inHouseRadio.isSelected() || outSourcedRadio.isSelected()){
             for(int i = 0; i < fieldCount.length; i++){
                 boolean valueError = checkValue(fieldCount[i]);
                 if(valueError){
                     end = true;
                     break;
                 }
                 
                 boolean typeError = checkType(fieldCount[i]);
                 if(typeError){
                 end = true;
                 break;
        }
   }
             if(partName.getText().trim().isEmpty() || partName.getText().trim().toLowerCase().equals("Part Name")){
             errorWindow(4, partName);
             return;
         }
             if(Integer.parseInt(partMin.getText().trim()) < Integer.parseInt(partMax.getText().trim())){
                 errorWindow(8, partMin);
             }
             
             if(Integer.parseInt(partCount.getText().trim()) > Integer.parseInt(partMax.getText().trim())){
                 errorWindow(7, partCount);
                 return;
             }
             
             if(Integer.parseInt(partCount.getText().trim()) > Integer.parseInt(partMin.getText().trim())){
                 errorWindow(6, partCount);
                 return;
             }   
             
             if(end){
                 return;
             }else if(inHouseRadio.isSelected() && !company.getText().trim().matches("[0-9}*")){
                 errorWindow(1, company);
                 return;
             }else if(outSourced.isSelected() &&  company.getText.trim().isEmpty()){
                 errorWindow(1, company);
                 return;
             } else if (inHouseRadio.isSelected() & part instanceof InHouse) {
                updateItemInHouse();

            } else if (inHouseRadio.isSelected() & part instanceof OutSourced) {
                updateItemInHouse();
            } else if (outSourcedRadio.isSelected() & part instanceof OutSourced) {
                updateItemOutSourced();
            } else if (outSourcedRadio.isSelected() & part instanceof InHouse) {
                updateItemOutSourced();
            }

        } else {
            errorWindow(2, null);
            return;
        }
         mainIMS(event);
        }
        private void updateItemInHouse(){
            inv.updatePart(new InHouse(Integer.parseInt(partID.getText().trim()), partName.getText().trim(),
                    Double.parseDouble(partPrice.getText().trim()), Integer.parseInt(partCount.getText().trim()),
                   Integer.parseInt(partMax.getText().trim()), Integer.parseInt(partMin.getText().trim()), Integer.parseInt(company.getText().trim())));
        }
        
        private void updateItemOutSourced(){
            inv.updatePart(new OutSourced(Integer.parseInt(partID.getText().trim()), partName.getText().trim(),
                    Double.parseDouble(partPrice.getText().trim()), Integer.parseInt(partCount.getText().trim()),
                   Integer.parseInt(partMax.getText().trim()), Integer.parseInt(partMin.getText().trim()), company.getText().trim()));
        }
        
        private void errorWindow(int errorCode, TextField field){
            fieldError(field);
            
            if (errorCode == 1){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Adding This Part");
                alert.setHeaderText("Fix Problem:");
                alert.setContentText("Empty Field!");
                alert.showAndWait();
            }else if (errorCode == 2){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Adding This Part");
                alert.setHeaderText("Fix Problem:");
                alert.setContentText("Need To Choose InHouse or OutSourced");
                alert.showAndWait();
            } else if (errorCode == 3){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Adding This Part");
                alert.setHeaderText("Fix Problem:");
                alert.setContentText("Wrong Format");
                alert.showAndWait();
            }else if (errorCode == 4){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Adding This Part");
                alert.setHeaderText("Fix Problem:");
                alert.setContentText("Name is already used or wrong format");
                alert.showAndWait();
            }else if (errorCode == 5){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Adding This Part");
                alert.setHeaderText("Fix Problem:");
                alert.setContentText("Can't be Negative");
                alert.showAndWait();
            }else if (errorCode == 6){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Adding This Part");
                alert.setHeaderText("Fix Problem:");
                alert.setContentText("Can't be lower than the Minimum");
                alert.showAndWait();
            }else if (errorCode == 7){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Adding This Part");
                alert.setHeaderText("Fix Problem:");
                alert.setContentText("Can't be Higher than the Maximum");
                alert.showAndWait();
            }else if (errorCode == 8){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Adding This Part");
                alert.setHeaderText("Fix Problem:");
                alert.setContentText("Minimum Can't Exeed Maximum");
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Adding This Part");
                alert.setHeaderText("Fix Problem:");
                alert.setContentText("Unknown Error (Your Error Is to Smart For Us)");
                alert.showAndWait();
            }
        }
        
    private void resetFieldsStyle() {
        partName.setStyle("-fx-border-color: lightgray");
        partCount.setStyle("-fx-border-color: lightgray");
        partPrice.setStyle("-fx-border-color: lightgray");
        partMax.setStyle("-fx-border-color: lightgray");
        partMin.setStyle("-fx-border-color: lightgray");
        company.setStyle("-fx-border-color: lightgray");
    }

    private void errorField(TextField field){
        if(field == null){
    }else{
            field.setStyle("-fx-border-color: purple");
        }
    }
        
    private void mainIMS(Event event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ims.fxml"));
            ImsController controller = now ImsController(inv);
            
            loader.setController(controller);
            Parent root = loader.load();
            Scene scene = new Scene(root);
        }
    }
    
}