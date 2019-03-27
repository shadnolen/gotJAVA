/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ShadTheJavaSlayer
 */
public class InHouse extends Parts {
    private final IntegerProperty machineID;
    
    public InHouse(int partID, String name, double price, int inStock, int min, int max, int machineID) {
        this.partID = new SimpleIntegerProperty(partID);
        this.partName = new SimpleStringProperty(name);
        this.partPrice = new SimpleDoubleProperty(price);
        this.supplyInStock = new SimpleIntegerProperty(inStock);
        this.supplyMin = new SimpleIntegerProperty(min);
        this.supplyMax = new SimpleIntegerProperty(max);
        this.machineID = new SimpleIntegerProperty(machineID);
    }

    public InHouse() {
        this.partID = new SimpleIntegerProperty(0);
        this.partName = new SimpleStringProperty("");
        this.partPrice = new SimpleDoubleProperty(0);
        this.supplyInStock = new SimpleIntegerProperty(0);
        this.supplyMin = new SimpleIntegerProperty(0);
        this.supplyMax = new SimpleIntegerProperty(0);
        this.machineID = new SimpleIntegerProperty(0);
    }
    
    //machineID
    public int getMachineID() {
        return this.machineID.get();
    }

    public void setMachineID(int machineID) {
        this.machineID.set(machineID);
    }
    
    public IntegerProperty machineIDProperty(){
        return machineID;
    }
}
