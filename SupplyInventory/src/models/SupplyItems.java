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
    private static int partCount;
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
    
    public static void updateProducts(int indexID, Products products){
        productsList.set(indexID, products);
    }
    
    
    
    public static Object getProductList() {
 throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void removeProduct(Products selectedItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static ObservableList partLookUp(String search){
          throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
