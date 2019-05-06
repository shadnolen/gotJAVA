/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javafx.collections.FXCollections;

/**
 *
 * @author shadn
 */
public class Supply {
    //Declare Arrays 
    public static ObservableList <Parts> partsList = FXCollections.observableArrayList();
    public static ObservableList <Products>productsList = FXCollections.observableArrayList();
    
    //Set count to zero
    public static int partCoiunt = 0;
    public static int partCount = 0;
    
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
    
    public static void partUpdate(Parts part){
        partsList.set(index, part);
    }
    
    public static int getPartCount(){
        partCount += 1;
        return partCount;
    }
    
    publc static int caneckPartCount(){
        partCount -= 1;
        return partCount;
    }
    
    
    
    
    
    
    
    
}
