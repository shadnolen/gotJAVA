/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author shadn
 */
public abstract class Parts {
    
    
   /**** 
    public  int partID;
    public String partName;
    public int partInStock;
    public double partPrice;
    public int partMaxStock;
    public int partMinStock;
   ****/
      
    protected IntegerProperty partID;
    protected StringProperty partName;
    protected DoubleProperty partPrice;
    protected IntegerProperty partInStock;
    protected IntegerProperty partMax;
    protected IntegerProperty partMin;
    
  
    

    
    public IntegerProperty getPartID(){
        return partID;
    }

    public void setPartID(int partID){
        this.partID.set(partID);
    }
    
    
    
    public StringProperty getPartName(){
        return partName;
    }
    
    public void setPartName(String partName){
        this.partName.set(partName);
    }
    
    public IntegerProperty getPartInStock(){
        return partInStock;
    }
    
    public void setPartInStock(int partInStock){
        this.partInStock.set(partInStock);
    }
    
    public DoubleProperty getPartPrice(){
        return partPrice;
    }
    
    public void  setPartPrice(double partPrice){
        this.partPrice.set(partPrice);
    }
    
    public IntegerProperty getPartMax(){
        return partMax;
    }
    
    public void setPartMax(int partMax){
        this.partMax.set(partMax);
    }
    
    public IntegerProperty getPartMin(){
    return partMin;
    }
    
    public void setPartMin(int partMin){
        this.partMin.set(partMin);
    }
}
