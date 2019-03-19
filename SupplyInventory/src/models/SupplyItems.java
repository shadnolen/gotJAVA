/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.lang.reflect.Array;
import java.lang.Object;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author shadn
 */
public class SupplyItems {
    
    private static ObservableList<Parts> partsList = FXCollections.observableArrayList();
    private static ObservableList<Products> productsList =  FXCollections.observableArrayList();
    private static int partsCount;
    private static int productCount;
    
    public static ObservableList<Parts> getPartsList(){
        return partsList;
    }
    
    public static void addParts(Parts parts)
    {
        partsList.add(parts);
    }
    
    public static void updateParts(int indexID, Parts parts){
        partsList.set(indexID, parts);
    }
    
    public static void removeParts(Parts parts){
        partsList.remove(parts);
    }
    
    public static int getPartsCount(){
        partsCount += 1;
        return partsCount;
    }
    public static int cancelPartsCount(){
        partsCount -= 1;
        return partsCount;
    }
    
     public static ObservableList partLookUp(String search){
          ObservableList<Parts> partsFound = FXCollections.observableArrayList();
          
          
          if(search.length() ==0){
              partsFound = partsList;
              
          }else{
              
              for(int i = 0; i < partsList.size(); i++){
                if(partsList.get(i).getPartName().toString().toLowerCase().contains(search.toLowerCase())){
                  partsFound.add(partsList.get(i));
         }
     }
 }
          return partsFound;
    } 
    
     
     // Products 
    

    
    
    
  public static ObservableList<Products> getProductsList(){
      return productsList;
  }
  
     public void addProducts(Products products){
         productsList.add(products);
     }
     
    public void removeProducts(Products products) {
         productsList.remove(products);
    }
    
        public static void updateProducts(int indexID, Products products){
        productsList.set(indexID, products);
    }
        
        
         public static int getProductsCount(){
        productCount += 1;
        return productCount;
    }
    public static int cancelProductsCount(){
       productCount -= 1;
        return productCount;
    }
    
        public static ObservableList prodLookUp(String search){
          ObservableList<Products> prodFound = FXCollections.observableArrayList();
          
          
          if(search.length() ==0){
              prodFound = productsList;
              
          }else{
              
              for(int i = 0; i < partsList.size(); i++){
                if(partsList.get(i).getPartName().toString().toLowerCase().contains(search.toLowerCase())){
                  prodFound.add(productsList.get(i));
         }
     }
 }
          return prodFound;
    } 
    
  
    
    
    
}
