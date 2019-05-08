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
public abstract class Products {

    private ObservableList<Parts> proPart = FXCollections.observableArrayList();
    
    private final StringProperty proName;
    private final IntegerProperty proID;
    private final DoubleProperty proPrice;
    private final IntegerProperty proInStock;
    private final IntegerProperty proMin;
    private final IntegerProperty proMax;
    
   public Products(String proName, int proID, double proPrice, int proInStock, int proMin, int proMax){
       this.proName = new SimpleStringProperty(proName);
       this.proID = new SimpleIntegerProperty(proID);
       this.proPrice = new SimpleDoubleProperty(proPrice);
       this.proInStock = new SimpleIntegerProperty(proInStock);
       this.proMin = new SimpleIntegerProperty(proMin);
       this.proMax = new SimpleIntegerProperty(proMax);
   }
   
   public Products(){
       this.proName = new SimpleStringProperty(" ");
       this.proID = new SimpleIntegerProperty(0);
       this.proPrice = new SimpleDoubleProperty(0);
       this.proInStock = new SimpleIntegerProperty(0);
       this.proMin = new SimpleIntegerProperty(0);
       this.proMax = new SimpleIntegerProperty(0);
   }
    
   
    public void setProName(String proName){
        this.proName.set(proName);
    }

    public String getProName(){
        return this.proName.get();        
    }
    public StringProperty proNameP(){
        return proName;
    }
        
    //ID   
    public void setProID (int proID){
       this.proID.set(proID);
   }
   
   public int geProID(){
       return this.proID.get();
   }
   
   public IntegerProperty proIDP(){
       return proID;
   }

   //PRICE
   
   public void setProPrice(double proPrice){
       this.proPrice.set(proPrice);
   }
   
   public double getProPrice(){
       return this.proPrice.get();
   }
   
   public DoubleProperty proPriceP(){
       return proPrice;
   }
   
   //INstock
   public void setProInStock(int proInStock){
   this.proInStock.set(proInStock);
   }
   
   
   public int getProInStock(){
       return this.proInStock.get();       
   }
   
   public IntegerProperty proInStock(){
       return proInStock;
   }
   
   //MINiMIUM
   
   public void setProMIn(int proMin){
       this.proMin.set(proMin);
   }
   
   public int getPRoMin(){
       return this.proMin.get();
   }
   
   public IntegerProperty proMinP(){
       return proMin;
   }
   
   //MAXiMUM
   
   public void setProMax(int proMax){
       this.proMax.set(proMax);
   }
    public int getPRoMax(){
        return this.getPRoMax();
    }    
     public IntegerProperty proMaxP(){
         return proMax;
    }
     
     public void setProPart(ObservableList<Parts> linkedParts){
         proPart = linkedParts;
     }
     
     public ObservableList<Parts> getProParts(){
         return proPart;
     }
}
