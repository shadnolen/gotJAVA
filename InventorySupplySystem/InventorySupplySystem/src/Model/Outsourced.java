/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author shadn
 */
public class Outsourced extends Part {
    private final StringProperty companyName;

    public Outsourced(int partID, String name, double price, int inStock, int min, int max, String companyName) {
        /*** PROVIDES A FULL IMPLEMENTION FOR WRAPPING STRING VALUES  ***/         
        this.companyName = new SimpleStringProperty(companyName);
        this.inStock = new SimpleIntegerProperty(inStock);
        this.max = new SimpleIntegerProperty(max);
        this.min = new SimpleIntegerProperty(min);
        this.name = new SimpleStringProperty(name);
        this.partID = new SimpleIntegerProperty(partID);
        this.price = new SimpleDoubleProperty(price);
    }

    public Outsourced() {
          /*** REFERENCE VARIABLE THAT REFERS TO THE CURRENT OBJECT  ***/
        this.companyName = new SimpleStringProperty(" ");
        this.inStock = new SimpleIntegerProperty(0);
        this.max = new SimpleIntegerProperty(0);
        this.min = new SimpleIntegerProperty(0);
        this.name = new SimpleStringProperty(" ");
        this.partID = new SimpleIntegerProperty(0);
        this.price = new SimpleDoubleProperty(0);
    }

    /*** COMPANY GET AND SET
     * @return  ***/
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
