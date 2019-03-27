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
 * @author ShadTheJavaSlayer
 */
public class Supply {
    
    private static ObservableList<Parts> partsList = FXCollections.observableArrayList();
    private static ObservableList<Products> productsList = FXCollections.observableArrayList();
    private static int partIDCount = 0;
    private static int productIDCount = 0;
    
    //Parts
    public static ObservableList<Parts> getPartList() {
        return partsList;
    }

    public static void partAdd(Parts part) {
        partsList.add(part);
    }
    
   
    public static void partRemove(Parts part) {
        partsList.remove(part);
    }

    public static void partUpdate(int index, Parts part) {
        partsList.set(index, part);
    }

    public static int getPartIDCount() {
        partIDCount += 1;
        return partIDCount;
    }
    
    public static int partIDCountCancel() {
        partIDCount -= 1;
        return partIDCount;
    }

    public static ObservableList lookupPart(String searchTerm) {
        ObservableList<Parts> foundParts = FXCollections.observableArrayList();
        
        if(searchTerm.length() == 0) {
            foundParts = partsList;//return all if blank as passed in as search term
        } else {
            for (int i = 0; i < partsList.size(); i++) {
                if (partsList.get(i).getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                    foundParts.add(partsList.get(i));
                }
            }    
        }
        
        return foundParts;
    }
    
    //Products
    public static ObservableList<Products> getProductList() {
        return productsList;
    }

    public static void productsAdd(Products product) {
        productsList.add(product);
    }

    public static void productsRemove(Products product) {
        productsList.remove(product);
    }

    public static int getProductIDCount() {
        productIDCount += 1;
        return productIDCount;
    }
   
    public static int productIDCountCancel() {
        productIDCount -= 1;
        return productIDCount;
    }

    public static ObservableList lookupProduct(String searchTerm) {
        ObservableList<Products> foundProducts = FXCollections.observableArrayList();
        
        if(searchTerm.length() == 0) {
            foundProducts = productsList;//return all if blank as passed in as search term
        } else {
            for (int i = 0; i < productsList.size(); i++) {
                if (productsList.get(i).getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                    foundProducts.add(productsList.get(i));
                }
            }    
        }
        
        return foundProducts;
    }
    
    public static void productsUpdate(int index, Products product) {
        productsList.set(index, product);
    }
}
