/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasi;

/**
 *
 * @author shadn
 */
public class Cars extends JasI {
    private String make;
    private String model;
    private int yearBuilt;   
    private int miles;
    private String plateID;
    
    Cars(String make, String model, int yearBuilt, int miles, String plateID){
        this.make = make;
        this.model = model;
        this.yearBuilt = yearBuilt;
         if(yearBuilt < 1900){
    throw new IllegalArgumentException();
}
        this.miles = 0;
        this.plateID = "Unknown";
    }

    // accessors of the basic mentality 
    public String getMake(){
        return make;
    }
    
    public void setMake(String make){
       this.make = make;
    }
    
    public String getModel(){
        return model;
    }
    
    public void setModel(String model){
        this.model = model;
    }
    
    public int getYearBuilt(){
        return yearBuilt;
    }
    
    public int setYearBuilt(int yearBuilt){
        return this.yearBuilt;
    }
    
    public int getMiles(){
        return miles;
    }
    
    public String getPlateID(){
        return plateID;
    }
    
    public void setPlateId(String plates){
       this.plateID = plates;
    }
    
    //Some mutators
    
    public void setMiles(int newMiles){
        if(newMiles < this.miles){
            throw new IllegalArgumentException();
        }
        this.miles =  newMiles;
            System.out.println(miles);
    }

    

    
}
