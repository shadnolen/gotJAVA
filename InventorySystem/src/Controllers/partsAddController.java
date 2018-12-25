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
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 *
 * @author shadn
 */
public class partAddController {
    Supply inv;
    
    
    @FXML
    private RadioButton inHouse;
    
    @FXML
    private RadioButton outSourced;
    
    @FXML 
    private TextField partid;
    
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
    private Label compName;
    
    @FXML 
    private Label comp;
    
    
    public partAddController(Supply inv) {
        this.inv = inv;
    }

    @Override
    public void initialize(URL url, Resourcebundle rb){
        generatePartID();
        resetFields();        
    }

    private void generatePartID() {
       boolean match;
       Random rn = new Random();
       Integer num = rn.nextInt(1000);
       
       if (inv.partLS() == 0){
           id.setText(num.toString());
       }
       
       if(inv.partLS() == 1000) {
        errorWindow(3, null);
       }else{
           match = generateNumber(num);
           
           if (match == false){
               id.setText(num.toString());
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
    private void inSelect(MouseEvent event){
        compName.setText("Machine ID");
        comp.setText("Machine Name");
    }
    
    @FXML 
    
   private void outSelect(MouseEvent event ){
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
          
          if()
          
          
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
     inHouse.setSelected(true);     
    }

    
    
    
    private static class Resourcebundle {

        public Resourcebundle() {
        }
    }
    
}
