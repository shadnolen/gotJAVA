/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author shadn
 */
public abstract class Parts {
    protected StringProperty partName;
    protected IntegerProperty partID;
    protected  DoubleProperty partPrice;
    protected IntegerProperty inStock;    
    protected IntegerProperty partMin;
    protected IntegerProperty partMax;
  
  
   // Getter and Setters
    
    //NAME
    public void setPartName(String partName){
        this.partName.set(partName);
    }
    
    public String getPartName(){
        return this.partName.get();
    }
    
    public StringProperty partNameP(){
        return partName;
    }
    
    
    //ID
    public void setPartID(int partID){
        this.partID.set(partID);
    }
    
    public int getPartID(){
        return this.partID.get();
    }
    
    public IntegerProperty partIDP(){
        return partID;
    }
    
    //PRICE
    
    public void setPartPrice(double partPrice){
        this.partPrice.set(partPrice);
    }
    
    public double getPartPrice(){
        return this.partPrice.get();
    }
    
    public DoubleProperty partPriceP(){
        return partPrice;
    }
    
    //STOCK LEVEL
    
    public void setInStock(int inStock){
        this.inStock.set(inStock);
    }
    
    public int getInStock(){
        return this.inStock.get();
    }
    
    public IntegerProperty inStockP(){
        return inStock;
    }
    
   // MINIMUM
    
    public void setPartMin(int partMin){
        this.partMin.set(partMin);
    }
    
    public int getPartMin(){
        return this.partMin.get();
    }
    
    public IntegerProperty partMin(){
        return partMin;
    }
    
   //MAXIMUM
    
    public void setPartMax(int partMax){
        this.partMax.add(partMax);
    }
    
    public int getPartMax(){
        return this.partMax.get();
    }
    
    public IntegerProperty partMax(){
        return partMax;
    }
    
}
