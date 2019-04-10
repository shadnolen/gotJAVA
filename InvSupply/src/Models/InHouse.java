/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Models.Parts;
import Models.Products;
import Models.SupplyInv;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author shadn
 */
public class InHouse extends Parts{
    private final IntegerProperty machID;
    
    
    public InHouse(int partID, String partName, double partPrice, int partSupply, int partMax, int partMin, int machID){
    
    this.partID = new SimpleIntegerProperty(partID);
    this.partName = new SimpleStringProperty(partName);
    this.partPrice = new SimpleDoubleProperty(partPrice);
    this.partSupply = new SimpleIntegerProperty(partSupply);
    this.partMax= new SimpleIntegerProperty(partMax);
    this.partMin = new SimpleIntegerProperty(partMin);
    this.machID = new SimpleIntegerProperty(machID);    
    }   
    
    public InHouse(){
    this.partID = new SimpleIntegerProperty(0);
    this.partName = new SimpleStringProperty(" ");
    this.partPrice = new SimpleDoubleProperty(0);
    this.partSupply = new SimpleIntegerProperty(0);
    this.partMax= new SimpleIntegerProperty(0);
    this.partMin = new SimpleIntegerProperty(0);
    this.machID = new SimpleIntegerProperty(0);    
    }
    
    public int getMachID(){
        return this.machID.get();
    }
    
    public void setMachID(int machID){
        this.machID.set(machID);
    }
    
    public IntegerProperty machIDP(){
        return machID;
    }
    
    
}
