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
public class Outsourced  extends Parts{
    
   private String companyName;
   
    public String getCompanyName(){
    return this.companyName;
}
    
    public  void setCompanyName(String companyName){
    this.companyName = companyName;
}
    
    public Outsourced(){    
}
    
public Outsourced(int partID, String partName, double partPrice, int partInStock, int partMinStock, int partMaxStock){
    this.partID = partID;
    this.partName = partName;
    this.partPrice = partPrice;
    this.partInStock = partInStock;
    this.partMinStock = partMinStock;
    this.partMaxStock = partMaxStock;
    
    }    
}
