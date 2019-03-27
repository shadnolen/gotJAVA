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
 * @author ShadTheJavaSlayer
 */
public abstract class Parts {
    protected IntegerProperty supplyInStock;
    protected IntegerProperty supplyMax;
    protected IntegerProperty supplyMin;
    protected StringProperty partName;
    protected IntegerProperty partID;
    protected DoubleProperty partPrice;
            
    //partID
    public void setPartID(int partID) {
        this.partID.set(partID);
    }
    
    public int getPartID() {
        return this.partID.get();
    }
    
    public IntegerProperty partIDProperty() {
        return partID;
    }
    
    //name
    public void setName(String name) {
        this.partName.set(name);
    }
    
    public String getName() {
        return this.partName.get();
    }
    
    public StringProperty nameProperty() {
        return partName;
    }
    
    //price
    public void setPrice(double price) {
        this.partPrice.set(price);
    }
    
    public double getPrice() {
        return this.partPrice.get();
    }
    
    public DoubleProperty priceProperty() {
        return partPrice;
    }
    
    //inStock
    public void setInStock(int inStock) {
        this.supplyInStock.set(inStock);
    }
    
    public int getInStock() {
        return this.supplyInStock.get();
    }
    
    public IntegerProperty inStockProperty() {
        return supplyInStock;
    }
    
    //min
    public void setMin(int min) {
        this.supplyMin.set(min);
    }
    
    public int getMin() {
        return this.supplyMin.get();
    }
    
    public IntegerProperty minProperty() {
        return supplyMin;
    }
    
    //max
    public void setMax(int max) {
        this.supplyMax.set(max);
    }
    
    public int getMax() {
        return this.supplyMax.get();
    }
    
    public IntegerProperty maxProperty() {
        return supplyMax;
    }
}
