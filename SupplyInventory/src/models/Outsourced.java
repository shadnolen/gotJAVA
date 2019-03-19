/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author shadn
 */
public class Outsourced  extends Parts{
    
   private final StringProperty companyName;
   
    public StringProperty getCompanyName(){
    return this.companyName;
}
    
    public  void setCompanyName(String companyName){
}

    
public Outsourced(int partID, String partName, double partPrice, int partInStock, int partMinStock, int partMaxStock, String companyName){
  this.partID = new SimpleIntegerProperty(partID);
    this.partName = new SimpleStringProperty(partName);
    this.partPrice = new SimpleDoubleProperty(partPrice);
    this.partInStock = new SimpleIntegerProperty(partInStock);
    this.partMin = new SimpleIntegerProperty(partMinStock);
    this.partMax = new SimpleIntegerProperty(partMaxStock);   
    this.companyName = new SimpleStringProperty(companyName);
    }    

public Outsourced(){
    this.partID = new SimpleIntegerProperty(0);
    this.partName = new SimpleStringProperty(" ");
    this.partPrice = new SimpleDoubleProperty(0);
    this.partInStock = new SimpleIntegerProperty(0);
    this.partMin = new SimpleIntegerProperty(0);
    this.partMax = new SimpleIntegerProperty(0);   
    this.companyName = new SimpleStringProperty("");
    
    }    
}
