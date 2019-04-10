/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

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
public class Products {
    private ObservableList<Parts> productPartsList = FXCollections.observableArrayList();
    private final IntegerProperty productID;
   private final StringProperty productName;
   private final DoubleProperty productPrice;
   private final IntegerProperty productSupplyCount;
   private final IntegerProperty productMax;
   private final IntegerProperty productMin;
   
   
   public Products(int productID, String productName, double productPrice, int productSupplyCount, int productMax, int productMin){
       this.productID = new SimpleIntegerProperty(productID);
       this.productName = new SimpleStringProperty(productName);
       this.productPrice = new SimpleDoubleProperty(productPrice);
       this.productSupplyCount = new SimpleIntegerProperty(productSupplyCount);
       this.productMax= new SimpleIntegerProperty(productMax);
       this.productMin = new SimpleIntegerProperty(productMin);
   }
   
   public Products(){
         this.productID = new SimpleIntegerProperty(0);
       this.productName = new SimpleStringProperty("");
       this.productPrice = new SimpleDoubleProperty(0);
       this.productSupplyCount = new SimpleIntegerProperty(0);
       this.productMax= new SimpleIntegerProperty(0);
       this.productMin = new SimpleIntegerProperty(0);
   }
   
   
   // aPL = associatedPartsList
   public void setProductPartList(ObservableList<Parts> aPL){
       productPartsList = aPL;
   }
   
   public ObservableList<Parts> getProductPartList(){
       return productPartsList;
   }
   
   public void setProductID(int productID){
      this.productID.set(productID);
   }
   
   public int getProductID(){
        return this.productID.get();
   }
   
   public IntegerProperty productIDProperty(){
       return productID;
   }
   
   //Product name get and set
   public void setProductName(String productName){
       this.productName.set(productName);
   }
   
   public String getProductName(){
       return this.productName.get();
   }
   
   public StringProperty productNameProperty(){
       return productName;
   }
   
     //Product pirce get and set
   public void setProductPrice(double productPrice){
       this.productPrice.set(productPrice);
   }
   
   public double getProductPrice(){
       return this.productPrice.get();
   }
   
   public DoubleProperty productPriceProperty(){
       return productPrice;
   }
   
   public void setProductSupplyCount(int productSupplyCount){
       this.productSupplyCount.set(productSupplyCount);
   }
   
   public int getProductSupplyCount(){
       return this.productSupplyCount.get();
   }
   
   public IntegerProperty productSupplyCountProperty(){
       return productSupplyCount;
   }
   
   
    
}
