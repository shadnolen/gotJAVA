/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationiv;

import java.util.Scanner;

/**
 *
 * @author shadn
 */
public class Auto {
    
   
 private String make,model, trim, plateID;
 int year;
  
   
        public int getYear(){
       return year;
   }
   
   public void setYear(int mYear){
       this.year = mYear;
   }
    public String getMake(){
        return make;
    }
    
    public void setMake(String newMake){
        this.make = newMake;
    }
    
    public String getModel(){
        return model;
    }
    
    public void setModel(String newModel){
        this.model = newModel;
    }
    
    public String getTrim(){
        return trim;
    }
    
    public void setTrim(String newTrim){
        this.trim = newTrim;
    }
    
    public String getPlateID(){
        return plateID;
    }
    
    public void setPlateID(String newPlateID){
        this.plateID = newPlateID;
    }
    
     void auto(){
        System.out.println(trim);
    }
      Auto(int year, String make, String model, String trim, String plateID) {
    }
      
         Scanner key = new Scanner(System.in);

   Auto autoI = new Auto(1994, "Ford", "Fusion", "SEL", "TURD!");
   
}
/***

static void test(){
  System.out.println("What is the Make: ");
    String make = key.nextLine();
    
     System.out.println("What is the Model: ");
    String model = key.nextLine();
   
    System.out.println("Your turd bucket: " + make + "\n" + model ) ;
    System.out.println(autoI.getModel());
}}
* 
* *****/