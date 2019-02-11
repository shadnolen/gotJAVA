/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author shadn
 */
public abstract class Parts {
    
     protected StringProperty name;
    protected  IntegerProperty age;
    protected StringProperty type;
    
    public  Parts(){
     name =  new SimpleStringProperty("animal");
       age = new SimpleIntegerProperty(10);
       type = new SimpleStringProperty("type");
}

    public static void removeProduct(Parts selectedItem) {
    }

    public String getName() {
      return name.get();
    }
    
     public StringProperty nameProperty() {
        return name;
    } 
    public StringProperty typeProperty() {
        return type;
    } 

}
