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
public  class Products {
 
   private ObservableList<Parts> associatedParts = FXCollections.observableArrayList();
    
    private final  IntegerProperty prodID;
    private final  StringProperty prodName;
    private final  IntegerProperty prodInStock;
    private final  DoubleProperty prodPrice;
    private final  IntegerProperty prodMax;
    private final  IntegerProperty prodMin;
   
    
    public Products(int prodID,  String prodName, double prodPrice,int prodInStock, int prodMin, int prodMax){
        this.prodID = new SimpleIntegerProperty(prodID);
        // this.associatedParts = new SimpleIntegerProperty(associatedParts);
        this.prodName = new SimpleStringProperty(prodName);
        this.prodInStock = new SimpleIntegerProperty(prodInStock);
        this.prodPrice = new SimpleDoubleProperty(prodPrice);
        this.prodMax = new SimpleIntegerProperty(prodMax);
        this.prodMin = new SimpleIntegerProperty(prodMin);
    }
    
    public Products(){
          this.prodID = new SimpleIntegerProperty(0);
        // this.associatedParts = new SimpleIntegerProperty(associatedParts);
        this.prodName = new SimpleStringProperty(" ");
        this.prodInStock = new SimpleIntegerProperty(0);
        this.prodPrice = new SimpleDoubleProperty(0);
        this.prodMax = new SimpleIntegerProperty(0);
        this.prodMin = new SimpleIntegerProperty(0);
    }

    
    public IntegerProperty getProductID(){
        return prodID;
    }

    public void setProductID(int prodID){
        this.prodID.set(prodID);
    }
    
    public StringProperty getProductName(){
        return prodName;
    }
    
    public void setProductName(String prodName){
        this.prodName.set(prodName);
    }
    
    public IntegerProperty getProductInStock(){
        return prodInStock;
    }
    
    public void setProductInStock(int prodInStock){
        this.prodInStock.set(prodInStock);
    }
    
    public DoubleProperty getProductPrice(){
        return prodPrice;
    }
    
    public void  setProductPrice(double prodPrice){
        this.prodPrice.set(prodPrice);
    }
    
    public IntegerProperty getProductMax(){
        return prodMax;
    }
    
    public void setProductMax(int prodMax){
        this.prodMax.set(prodMax);
    }
    
    public IntegerProperty getProductMin(){
        return prodMin;
    }
    
    public void setProductMin(int prodMin){
        this.prodMin.set(prodMin);
    }
    
    public ObservableList<Parts> getAssociatedParts(){
        return associatedParts;
    }
    
    public void setAssociatedParts(ObservableList<Parts> associatedParts){
        this.associatedParts = associatedParts;
    }
    
    
}
