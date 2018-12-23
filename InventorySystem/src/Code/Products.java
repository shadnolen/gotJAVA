/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.util.ArrayList;


/**
 *
 * @author shadn
 */
public class Products {
    
    private ArrayList<Parts> associatedParts = new ArrayList<>();
    private int productID;
    private String name;
    private double price = 0.0;
    private int stock = 0;
    private double cost; 
    private int max;
    private int min;
    
    
    
    public Products(int productID, String name, double price, int stock, int max, int min){
        setProductID(productID);
        setName(name);
        setPrice(price);
        setStock(stock);
        setMax(max);
        setMin(min);
        
    }
    
    public void setProductID(int proID){
         this.productID = proID;
    }
    public int getProductID(){
        return this.productID;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    public void setStock(int stock){
        this.stock = stock;
    }
    
    public int getStock(){
        return this.stock;
    }
    
    public void setMax(int max){
        this.max = max;
    }
    
    public int getMax(){
        return this.max;
    }
    
    public void setMin(int min){
        this.min = min;
    }
    
    public int getMin(){
        return this.min;
    }
    
public void addAssociatedParts(Parts partAdd){
        associatedParts.add(partAdd);
}
    

 public boolean removeAssociatedParts(int partRemove){
      
      for(int i = 0; i < associatedParts.size(); i++){
     if(associatedParts.get(i).getPartID() == partRemove){
         associatedParts.remove(i);
         return true;
        }
    }
         return false;
 }
 
 public Parts searchParts(int searchPart){
     for(int i = 0; i < associatedParts.size(); i++){
         if(associatedParts.get(i).getPartID() == searchPart){
             associatedParts.get(i);
         }
      }
     return null;
   }           

 public int getPartSize(){
        return associatedParts.size();
}

}
