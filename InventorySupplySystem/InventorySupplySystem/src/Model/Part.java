/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author shadn
 */
public abstract class Part {
      /*** PROVIDES A FULL IMPLEMENTION FOR WRAPPING STRING VALUES  ***/
    protected IntegerProperty inStock;
    protected IntegerProperty max;
    protected IntegerProperty min;
    protected StringProperty name;
    protected IntegerProperty partID;
    protected DoubleProperty price;
            
  
    /***GET AND SET PARTS ***/
    
    
    /*** @param partID ***/
    public void setPartID(int partID) {
        this.partID.set(partID);
    }    
    public int getPartID() {
        return this.partID.get();
    }    
    public IntegerProperty partIDProperty() {
        return partID;
    }
    
    
    /*** NAME 
     * @param name ***/
    public void setName(String name) {
        this.name.set(name);    }
    
    public String getName() {
        return this.name.get();
    }    
    public StringProperty nameProperty() {
        return name;
    }
    
    
  /*** PRICE
   * @param price ***/
    public void setPrice(double price) {
        this.price.set(price);
    }    
    public double getPrice() {
        return this.price.get();
    }    
    public DoubleProperty priceProperty() {
        return price;
    }
    
    
 /*** InStock
  * @param inStock ***/
    public void setInStock(int inStock) {
        this.inStock.set(inStock);
    }    
    public int getInStock() {
        return this.inStock.get();
    }    
    public IntegerProperty inStockProperty() {
        return inStock;
    }
    
    
    /***  MIN
     * @param min ***/
    public void setMin(int min) {
        this.min.set(min);
    }    
    public int getMin() {
        return this.min.get();
    }    
    public IntegerProperty minProperty() {
        return min;
    }

    
   /***  MAX
    * @param max ***/
    public void setMax(int max) {
        this.max.set(max);
    }    
    public int getMax() {
        return this.max.get();
    }    
    public IntegerProperty maxProperty() {
        return max;
    }
}
