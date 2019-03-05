/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author shadn
 */
public abstract class Parts {
    
    
    
    public  int partID;
    public String partName;
    public int partInStock;
    public double partPrice;
    public int partMaxStock;
    public int partMinStock;
   
    

    
    public int getPartID(){
        return partID;
    }

    public void setPartID(int partID){
        this.partID = partID;
    }
    
    public String getPartName(){
        return partName;
    }
    
    public void setPartName(String partName){
        this.partName = partName;
    }
    
    public int getPartInStock(){
        return partInStock;
    }
    
    public void setPartInStock(int partInStock){
        this.partInStock = partInStock;
    }
    
    public double getPartPrice(){
        return partPrice;
    }
    
    public void  setPartPrice(double partPrice){
        this.partPrice = partPrice;
    }
    
    public int getPartMaxStock(){
        return partMaxStock;
    }
    
    public void setPartMaxStock(int partMaxStock){
        this.partMaxStock = partMaxStock;
    }
    
    public int getPartMinStock(){
        return partMinStock;
    }
    
    public void setPartMinStock(int partMinStock){
        this.partMinStock = partMinStock;
    }
    
    
    
    
    
    
}
