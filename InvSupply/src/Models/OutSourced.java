/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author shadn
 */
public class OutSourced extends Parts{
    
    private final StringProperty companyName;
    
    public String getCompanyName(){
        return this.companyName.get();
    }
    
    public void setComanyName(String companyName){
        
        this.companyName.set(companyName);
        
    }
    
    public StringProperty companyNameProperty(){
        return companyName;
    }
    
    public OutSourced(int partID, String partName, double partPrice, int partSupply, int partMax, int partMin, String companyName){
            this.partID = new SimpleIntegerProperty(partID);
    this.partName = new SimpleStringProperty(partName);
    this.partPrice = new SimpleDoubleProperty(partPrice);
    this.partSupply = new SimpleIntegerProperty(partSupply);
    this.partMax= new SimpleIntegerProperty(partMax);
    this.partMin = new SimpleIntegerProperty(partMin);
    this.companyName = new SimpleStringProperty(companyName);    
    }   
    
    public OutSourced(){
    this.partID = new SimpleIntegerProperty(0);
    this.partName = new SimpleStringProperty(" ");
    this.partPrice = new SimpleDoubleProperty(0);
    this.partSupply = new SimpleIntegerProperty(0);
    this.partMax= new SimpleIntegerProperty(0);
    this.partMin = new SimpleIntegerProperty(0);
    this.companyName = new SimpleStringProperty(" ");    
    }
}
