/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author shadn
 */
public abstract class Products {
 
    
  private int prodID;
    private String prodName;
    private int prodInStock;
    private double prodPrice;
    private int prodMaxStock;
    private int prodMinStock;
   
    

    
    public int getProductID(){
        return prodID;
    }

    public void setProductID(int prodID){
        this.prodID = prodID;
    }
    
    public String getProductName(){
        return prodName;
    }
    
    public void setProductName(String prodName){
        this.prodName = prodName;
    }
    
    public int getProductInStock(){
        return prodInStock;
    }
    
    public void setProductInStock(int prodInStock){
        this.prodInStock = prodInStock;
    }
    
    public double getProductPrice(){
        return prodPrice;
    }
    
    public void  setProductPrice(double prodPrice){
        this.prodPrice = prodPrice;
    }
    
    public int getProductMaxStock(){
        return prodMaxStock;
    }
    
    public void setProductMaxStock(int prodMaxStock){
        this.prodMaxStock = prodMaxStock;
    }
    
    public int getProductMinStock(){
        return prodMinStock;
    }
    
    public void setProductMinStock(int prodMinStock){
        this.prodMinStock = prodMinStock;
    }
    
    
}
