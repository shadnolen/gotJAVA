/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author shadn
 */
public abstract class Parts {
    protected int partID;
    protected String partName;
    protected double partPrice;
    protected int partInStock;
    protected int max;
    protected int min;
    
    
    public void setPartID(int partID){
        this.partID = partID;
    }
    
    public int getPartID(){
        return this.partID;
    }

   public void setName(String name){
       this.partName = name;
   }
   public String getName(){
       return this.partName;
   }
   
   public void setPrice(double price){
       this.partPrice = price;
   }
   
   public double getPrice(){
       return this.partPrice;
   }
   
   public void setStock(int quantityLeft){
       this.partInStock = quantityLeft;
   }
   
   public int getStock(){
       return partInStock;
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
   
}
