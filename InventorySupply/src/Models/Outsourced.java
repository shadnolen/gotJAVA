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
 * @author ShadTheJavaSlayer
 */
public class Outsourced extends Parts {
    private final StringProperty companyName;

    public Outsourced(int partID, String name, double price, int inStock, int min, int max, String companyName) {
        this.companyName = new SimpleStringProperty(companyName);
        this.supplyInStock = new SimpleIntegerProperty(inStock);
        this.supplyMax = new SimpleIntegerProperty(max);
        this.supplyMin = new SimpleIntegerProperty(min);
        this.partName = new SimpleStringProperty(name);
        this.partID = new SimpleIntegerProperty(partID);
        this.partPrice = new SimpleDoubleProperty(price);
    }

    public Outsourced() {
        this.companyName = new SimpleStringProperty("");
        this.supplyInStock = new SimpleIntegerProperty(0);
        this.supplyMax = new SimpleIntegerProperty(0);
        this.supplyMin = new SimpleIntegerProperty(0);
        this.partName = new SimpleStringProperty("");
        this.partID = new SimpleIntegerProperty(0);
        this.partPrice = new SimpleDoubleProperty(0);
    }

    public String getCompanyName() {
        return this.companyName.get();
    }

    public void setCompanyName(String companyName) {
        this.companyName.set(companyName);
    }
    
    public StringProperty companyNameProperty() {
            return companyName;
    }
}
