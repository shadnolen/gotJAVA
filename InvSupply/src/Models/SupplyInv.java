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
}
