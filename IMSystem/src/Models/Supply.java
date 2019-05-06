/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author shadn
 */
public class Supply {
    //Declare Arrays 
    public static ObservableList <Parts> partsList = FXCollections.observableArrayList();
    public static ObservableList <Products>productsList = FXCollections.observableArrayList();
    
    //Set count to zero
    public static int partCount = 0;
    public static int productCount = 0;
    
   // Parts fucnctions 
    public static ObservableList <Parts> getPartsList(){
        return partsList;
    }
    
    public static void partAdd(Parts part){
        partsList.add(part);
    }
    
    public static void partRemove(Parts  part){
        partsList.remove(part);
    }
    
    public static void partUpdate(int index, Parts part){
        partsList.set(index, part);
    }
    
    public static int getPartCount(){
        partCount += 1;
        return partCount;
    }
    
    public static int partCancel(){
        partCount -= 1;
        return partCount;
    }
    
    
    //Search
    
    public static ObservableList partLookUp (String search){
        ObservableList partFound = partsList;
    
    
    if(search.length() == 0){
        partFound = partsList;        
     }else{
        for(int i = 0; i< partsList.size(); i++){
            if(partsList.get(i).getName().toLowerCase().contains(search.toLowerCase())){
                partFound.add(partsList.get(i));
            }
        }
    }
    
    return partFound;
    }
    
    
    //Products decleration 
    
    public static ObservableList <Products>  getProductsList(){
        return productsList;
    }
    
    public static void productAdd(Products product){
        productsList.add(product);
    }
    
    public static void productRemove(Products product){
        productsList.remove(product);
    }
    
   public static int getProductCount(){
       productCount += 1;
       return productCount;
   }
   
   public static int productCountCancel(){
       productCount -=  1;
       return productCount;
   }
   
   public static ObservableList productLookUp(String search){
       ObservableList<Products> productFound = productsList;
       
       if(search.length() ==0){
           productFound = productsList;
       }else{
           for(int i =0; i< productsList.size(); i++){
               if(productsList.get(i).getName().toLowerCase().contains(search.toLowerCase())){
                  productFound.add(productsList.get(i));
               }
           }
       }
       
       return productFound;
   }
   
   public static void productUpdate(int index, Products product){
       productsList.set(index, product);
   }
}
