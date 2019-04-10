/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author shadn
 */
public abstract class Parts {
protected StringProperty partName;
protected IntegerProperty partID;
protected DoubleProperty partPrice;
protected IntegerProperty partSupply;
protected IntegerProperty partMax;
protected IntegerProperty partMin;


//Get and Set 
public void setPartID(int partID){
    this.partID.set(partID);
}

public int getPartID(){
    return this.partID.get();
}

public IntegerProperty partIDProperty(){
    return partID;
}

public void setPartName(String partName)
{
    this.partName.set(partName);
}

public String getPartName(){
    return this.partName.get();
}

public StringProperty partNameProperty(){
    return partName;
}

public void setPartPrice(double partPrice){
    this.partPrice.set(partPrice);
}

public double getPartPrice(){
    return this.partPrice.get();
}

public DoubleProperty partPriceProperty(){
    return  partPrice;
}

public void setPartMax(int partMax){
    this.partMax.set(partMax);
}

public int  getPartMax(){
    return this.partMax.get();
}

public IntegerProperty partMaxProperty(){
    return partMax;
}

public void setPartMin(int partMax){
    this.partMin.set(partMax);
}

public int  getPartMin(){
    return this.partMin.get();
}

public IntegerProperty partMinProperty(){
    return partMin;
}

public void setSupplyCount(int partMax){
    this.partSupply.set(partMax);
}

public int  getSupplyCount(){
    return this.partSupply.get();
}

public IntegerProperty supplyCountProperty(){
    return partSupply;
}


    
}
