/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author shadn
 */
public class InHouse extends Parts{
    
    private final IntegerProperty machineID;
   
    public int getMachineID(){
    return this.machineID.get();
}
    
    public  void setMachineID(int machineID){
    this.machineID.set(machineID);
}
    

    
public InHouse(int partID, String partName, double partPrice, int partInStock, int partMinStock, int partMaxStock, int machineID){
  
    this.partID = new SimpleIntegerProperty(partID);
    this.partName = new SimpleStringProperty(partName);
    this.partPrice = new SimpleDoubleProperty(partPrice);
    this.partInStock = new SimpleIntegerProperty(partInStock);
    this.partMin = new SimpleIntegerProperty(partMinStock);
    this.partMax = new SimpleIntegerProperty(partMaxStock);   
    this.machineID = new SimpleIntegerProperty(machineID);
    }    

public InHouse(){
    this.partID = new SimpleIntegerProperty(0);
    this.partName = new SimpleStringProperty(" ");
    this.partPrice = new SimpleDoubleProperty(0);
    this.partInStock = new SimpleIntegerProperty(0);
    this.partMin = new SimpleIntegerProperty(0);
    this.partMax = new SimpleIntegerProperty(0);   
    this.machineID = new SimpleIntegerProperty(0);
}
}
