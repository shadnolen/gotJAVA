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
    
    public OutSourced(String partName, int partID, double partPrice, int inStock, int partMin, int partMax, String companyName){
       
        this.partName = new SimpleStringProperty(partName);
        this.partID = new SimpleIntegerProperty(partID);
        this.partPrice = new SimpleDoubleProperty(partPrice);
        this.inStock = new SimpleIntegerProperty(inStock);
        this.partMin = new SimpleIntegerProperty(partMin);
        this.partMax = new SimpleIntegerProperty(partMax);
        this.companyName = new SimpleStringProperty(companyName);
        
    }
    
    public OutSourced(){
         this.partName = new SimpleStringProperty(" ");
        this.partID = new SimpleIntegerProperty(0);
        this.partPrice = new SimpleDoubleProperty(0);
        this.inStock = new SimpleIntegerProperty(0);
        this.partMin = new SimpleIntegerProperty(0);
        this.partMax = new SimpleIntegerProperty(0);
        this.companyName = new SimpleStringProperty(" ");
    }
    
    public void setCompanyName(String companyName){
        this.companyName.set(companyName);
    }
    
    public String getCompanyName(){
        return this.companyName.get();
    }
    
    public StringProperty companyNameP(){
        return companyName;
    }
    
}
