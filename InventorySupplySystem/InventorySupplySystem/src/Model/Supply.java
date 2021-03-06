/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author shadn
 */
public class Supply {
   
   /*** SET UP ARRAY ***/
    private static final ObservableList<Part> partList = FXCollections.observableArrayList();
    private static final ObservableList<Product> productList = FXCollections.observableArrayList();
    
   /*** SET UP THE COUNTER ***/
    private static int partIndex = 0;
    private static int productIndex = 0;
    
  
    /*** PARTS
     * @return  ***/
    public static ObservableList<Part> getPartList() {
        return partList;
    }

    public static void partAdd(Part part) {
        partList.add(part);
    }
    
   
    public static void partRemove(Part part) {
        partList.remove(part);
    }

    public static void partUpdate(int index, Part part) {
        partList.set(index, part);
    }

    public static int getPartIndex() {
        partIndex += 1;
        return partIndex;
    }
    
    public static int cancelPartIndex() {
        partIndex -= 1;
        return partIndex;
    }

    public static ObservableList partLookUp(String searchps) {
        ObservableList<Part> partFound = FXCollections.observableArrayList();
        
        if(searchps.length() == 0) {
            partFound = partList;
            
        } else {            
            for (int i = 0; i < partList.size(); i++) {                
                if (partList.get(i).getName().toLowerCase().contains(searchps.toLowerCase())) {
                    partFound.add(partList.get(i));
                }
            }    
        }
        
        return partFound;
    }
    /*** END OF PARTS ***/
    
  
    /*** PRODUCTS ***/
  
 /*** @return  ***/
    public static ObservableList<Product> getProductList() {
        return productList;
    }

    public static void proAdd(Product product) {
        productList.add(product);
    }

    public static void proRemove(Product product) {
        productList.remove(product);
    }

    public static int getProductIndex() {
        productIndex += 1;
        return productIndex;
    }
   
    public static int cancelProductIndex() {
        productIndex -= 1;
        return productIndex;
    }

    public static ObservableList proLookUp(String searchps) {
        ObservableList<Product> proFound = FXCollections.observableArrayList();
        
        if(searchps.length() == 0) {
            proFound = productList;
        } else {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getName().toLowerCase().contains(searchps.toLowerCase())) {
                    proFound.add(productList.get(i));
                }
            }    
        }
        
        return proFound;
    }
    
    /*** END OF PRODUCTS ***/
    
    /*** UPDATE LIST ***/
    public static void proUpdate(int index, Product product) {
        productList.set(index, product);
    }
}
