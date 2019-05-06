/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author shadn
 */

// Extending parts properties
public class InHouse extends Parts{
    private final IntegerProperty machineID;
    
    //InHouse setup
    
   public InHouse(int partID, String partName, double partPrice, int inStock, int partMin, int partMax, int machineID){
       this.partName = new SimpleStringProperty(partName);
       this.partID = new SimpleIntegerProperty(partID);
       this.inStock = new SimpleIntegerProperty(inStock);
       this.partMin = new SimpleIntegerProperty(partMin);
       this.partMax = new SimpleIntegerProperty(partMax);
       this.machineID = new SimpleIntegerProperty(machineID);
       
   }
   
   public InHouse(){
         this.partName = new SimpleStringProperty(" ");
       this.partID = new SimpleIntegerProperty(0);
       this.inStock = new SimpleIntegerProperty(0);
       this.partMin = new SimpleIntegerProperty(0);
       this.partMax = new SimpleIntegerProperty(0);
       this.machineID = new SimpleIntegerProperty(0);
   }
    
   
   
   // SET and GET mach ID
  public void setMachineID(int machineID){
      this.machineID.set(machineID);
  }
   
   public int getMachineID(){
       return this.machineID.get();
   }
   
   public IntegerProperty machineIDP(){
       return machineID;
   }
   
}
