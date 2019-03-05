/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author shadn
 */
public class InHouse extends Parts{
    
    private int machineID;
   
    public int getMachineID(){
    return this.machineID;
}
    
    public  void setMachineID(int machineID){
    this.machineID = machineID;
}
    
    public InHouse(){    
}
    
public InHouse(int partID, String partName, double partPrice, int partInStock, int partMinStock, int partMaxStock){
    this.partID = partID;
    this.partName = partName;
    this.partPrice = partPrice;
    this.partInStock = partInStock;
    this.partMinStock = partMinStock;
    this.partMaxStock = partMaxStock;
    
    }    
}
