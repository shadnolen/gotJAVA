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
public class SupplyInv {
    
    private static ObservableList<Parts> partsOL= FXCollections.observableArrayList();
    private static ObservableList<Products> productsOL = FXCollections.observableArrayList();
    private static int countPart = 0;
    private static int countProduct = 0;
    
    //partsOL actions 
    public static ObservableList<Parts> getPartsOL(){
        return partsOL;
    }
    
    //Add part to our ObservableList
    public static void addPart(Parts parts){
        partsOL.add(parts);
    }
    
    //Remove part from our ObservableList
    public static void removePart(Parts parts){
        partsOL.remove(parts);
    }
    
    //Update  part in our ObservableList
    public static void updatePart(int partIndex, Parts parts){
        partsOL.set(partIndex, parts);
    } 
    
    ////Add auto ID count to our  ObservableList
    public static int getCountPart(){
        countPart +=1;
        return countPart;
    }
    
   // Rollback auto incro
    public static int canelCountPart(){
            countPart -=1;
        return countPart;
    }
    
    public static ObservableList partLookUp(String searchText){
        ObservableList<Parts> partFound = FXCollections.observableArrayList();
        
        if(searchText.length()==0){
        partFound = partsOL;
    }else{
            for(int i = 0; i < partsOL.size(); i++){
                if(partsOL.get(i).getName().toLowerCase().contains(searchText.toLowerCase())){
                    partFound.add(partsOL.get(i));
                }
            }            
        }
        return partFound;
    }
    
    // Adding to the Products
    
    public static ObservableList<Products> getProductsOL(){
        return productsOL;
    }
    
    public static void addProducts(Products products){
        productsOL.add(products);
    }
    
    public static void removeProducts(Products products){
        productsOL.remove(products);
    }
    
    public static int getCountProduct(){
        countProduct += 1;
        return countProduct;
    }
    
    public static ObservableList<Products>  productLookup(String searchText){
        ObservableList<Products> productsFound = FXCollections.observableArrayList();
       
        if(searchText.length() == 0){
            productsFound = productsOL;
        }else{
            for(int i = 0; i < productsOL.size(); i++){
                if(productsOL.get(i).getName().toLowerCase().contains(searchText.toLowerCase())){
                    productsFound.add(productsOL.get(i));
                }
            }
        }
        return productsFound;
    }
    
    public static void updateProduct(int productIdex, Products products){
        productsOL.set(productIdex, products);
    }
    
}
