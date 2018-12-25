/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Code.Parts;
import Code.Supply;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 *
 * @author shadn
 */
public class partsAddController {
    Supply inv;
    
    
    @FXML
    private RadioButton inSelect;
    
    @FXML
    private RadioButton outSelect;
    
    @FXML 
    private TextField idNum;
    
     @FXML 
    private TextField name;
     
     @FXML 
    private TextField count;
                
     @FXML 
    private TextField price;
  
    @FXML 
    private TextField max;
    
    @FXML 
    private TextField min;
       
    @FXML 
    private TextField comp;
    
     @FXML 
    private Label compName;
    
    public partsAddController(Supply inv) {
        this.inv = inv;
    }

 //   @Override
    public void initialize(URL url, ResourceBundle rb){
        generatePartID();
        resetFields();        
    }

    private void generatePartID() {
       boolean match;
       Random rn = new Random();
       Integer num = rn.nextInt(1000);
       
       if (inv.partLS() == 0){
           idNum.setText(num.toString());
       }
       
       if(inv.partLS() == 1000) {
        errorWindow(3, null);
       }else{
           match = generateNumber(num);
           
           if (match == false){
               idNum.setText(num.toString());
           }else{
               generatePartID();
           }
       }
    }
    
    
    private boolean generateNumber(Integer num){
        Parts match = inv.partsSearch(num);
        if(match != null){
            return true;
        }
        return false;
    }
    
    @FXML
    private void inHouse(MouseEvent event){
        compName.setText("Machine ID");
        comp.setText("Machine Name");
    }
    
    @FXML 
    
   private void outSourced(MouseEvent event ){
       compName.setText("Machine ID");
       comp.setText("Machine Name");
   }
   
   @FXML 
        private void disableID(MouseEvent event){      
   }
        
   @FXML
   private void partAddCancel(MouseEvent event){
       boolean cancel = cancel();
       if(cancel) {
           mainSceen(event);
    }else{
           return;
       }       
   }
   
   @FXML 
   private void partSave(MouseEvent event){
      fieldStyle();
      boolean end = false;
      TextField[] fieldCount = { count, price, max, min};
      if(inHouse.isSelected() || outSourced.isSelected()){
          for(int i = 0; i < fieldCount.length;i++){
              boolean errorValue = checkValue(fieldCount[i]);
              if (errorValue){
                  end = true;
                  break;
              }
              
              boolean errorType = checkType(fieldCount[i]);
              if(errorType){
                  end = true;
                  break;
              }
          }
          
          if(name.getText().trim().isEmpty() || name.getText().trim().toLowerCase().equals("Part Name")){
              errorWindow(4, name);
              return;
          }
               if(Integer.parseInt(min.getText().trim())> Integer.parseInt(max.getText().trim())){
              errorWindow(8, min);
              return;
          }
           
            if(Integer.parseInt(count.getText().trim())> Integer.parseInt(min.getText().trim())){
              errorWindow(6, count);
              return;
              
          if(Integer.parseInt(count.getText().trim()) > Integer.parseInt(min.getText().trim()));
          errorWindow(7, count);
          return;
          
     
          
         
         
         
          
         
          }
          
        if(end){
            return;
            
        }else if(comp.getText().trim().isEmpty() || comp.getText().trim().toLowerCase().equals("Company Name")){
            errorWindow(3, comp);
            return;
            
        } else if(inSelect.isSelected() && !comp.getText().trim().matches("[0-9]")){
            errorWindow(3, comp);
            return;
            
        }else if(inSelect.isSelected()){
            addInSelect();
            
        }else if(outSelect.isSelected()){
            addOutSelect();
        }
   }else{
          errorWindow(2, null);
       return;
   }
          mainIMS(event);
}

      private void addInHouse() {
        inv.addPart(new InHouse(Integer.parseInt(id.getText().trim()), name.getText().trim(),
                Double.parseDouble(price.getText().trim()), Integer.parseInt(count.getText().trim()),
                Integer.parseInt(min.getText().trim()), Integer.parseInt(max.getText().trim()), (Integer.parseInt(company.getText().trim()))));

    }
      
       private void addOutSourced(){
          inv.addPart(new OutSourced(Integer.parseInt(idNum.getText().trim()), name.getText().trim(),
                Double.parseDouble(price.getText().trim()), Integer.parseInt(count.getText().trim()),
                Integer.parseInt(min.getText().trim()), Integer.parseInt(max.getText().trim()), comp.getText().trim()));
      }
       
       
       private void errorWindow(int code, TextField field){
           errorField(field);
           if(code == 1){
               Alert alert = new Alert (AlertType.ERROR);
               alert.setTitle("Error Adding This Part");
               alert.setHeaderText("Can't Add This Part");
               alert.setContentText("Field Cannot Be Empty!");
               alert.showAndWait();
           }else if(code==2){
               Alert alert = new Alert (AlertType.ERROR);
               alert.setTitle("Error Adding This Part");
               alert.setHeaderText("Can't Add This Part");
               alert.setContentText("You Did't Specify In-House or Outsouced");
               alert.showAndWait();               
           }else if(code == 3){
               Alert alert = new Alert(AlertType.ERROR);
               alert.setTitle("Error Adding This Part");
               alert.setHeaderText("Can't Add This Part");
               alert.setContentText("Invaid System Format");
               alert.showAndWait();
           }else if(code == 4){
               Alert alert = new Alert(AlertType.ERROR);
               alert.setTitle("Error Adding This Part");
               alert.setHeaderText("Can't Add Part");
               alert.setContentText("Invalid Naming Convention");
               alert.showAndWait();
           }else if(code == 5){
               Alert alert = new Alert(AlertType.ERROR);
               alert.setTitle("Error Adding this Part");
               alert.setHeaderText("Can't Add This Part");
               alert.setContentText("Keep it Positive!");
               alert.showAndWait();
       }else if(code== 7){
               Alert alert = new Alert(AlertType.ERROR);
               alert.setTitle("Error Adding this Part");
               alert.setHeaderText("Can't Add This Part");
               alert.setContentText("Supply Needs to be Greater Than The Minimum");
               alert.showAndWait();
       }else if(code== 8){
               Alert alert = new Alert(AlertType.ERROR);
               alert.setTitle("Error Adding this Part");
               alert.setHeaderText("Can't Add This Part");
               alert.setContentText("Supply Can't Be Greater Than The Maximum");
               alert.showAndWait();   
       }else{
           Alert alert = new Alert(AlertType.ERROR);
               alert.setTitle("Error Adding this Part");
               alert.setHeaderText("Can't Add This Part");
               alert.setContentText("Unkown Pythagorean Theorem Error");
               alert.showAndWait();   
       }
 }
       
      
    private void resetFields() {
     name.setText("Part Name");
     count.setText("Inventory Number");
     price.setText("Price");
     max.setText("Max");
     min.setText("Min");
     compName.setText("Machine ID");
     comp.setText("MachineID");
     inSelect.setSelected(true);     
    }
    
    private void resetStyle(){
       
    }

    private void errorField(TextField field){
        if(field == null){
            return;
        }else{
            field.setStyle("-fx-boarder-color:purple");
        }
    }
    private void fieldStyle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean checkType(TextField textField) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
}
