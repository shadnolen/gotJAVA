/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationii;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author shadn
 */
public class JavaApplicationII {
    
    //Creating methods  inside classes
    static void myArrays(){
     // ARRAYS   
       ArrayList<String> deathMetal = new ArrayList<String>();
       deathMetal.add("Death");
        deathMetal.add("Carcass");
         deathMetal.add("Deicide");
          deathMetal.add("Pestilence");
           deathMetal.add("GorGuts");
           
           //get all in array 
           System.out.println(deathMetal);
           //get elemet at array spot #
           System.out.println(deathMetal.get(0));
           //get elemet at array spot #
           System.out.println(deathMetal.get(1));
         //get elemet at array spot #
           System.out.println(deathMetal.get(2));           
           
           //Get size of array
           System.out.println(deathMetal.size());
         
           //Change element in array
           System.out.println(deathMetal.set(4, "Kreator"));
           System.out.println(deathMetal);    
       }
  static void myHash(){
        // HashMaps 
        HashMap<String, String> bands = new HashMap<>();
        
        //Adding to HashMap
     bands.put("Slayer", "South of Heaven");
     bands.put("Iron Maiden", "Live - After Death");
     bands.put("Marylin Manson", "AntiChrist SuperStar");
     bands.put("Testament", "Practice What You Preach");
     
     //List all elements in HashMap
     System.out.println(bands);
     //List the number of elements in HashMap
       System.out.println(bands.size());
       
        //Loop though the HashMap key values
        bands.keySet().forEach((i) -> {
            System.out.println(i);
        });
        
        //Loop though the HashMap  values only
       bands.values().forEach((i) -> {
           System.out.println(i);
        });
       
       // Loop though the HashMap And print keys & values
       for(String i : bands.keySet()){
           System.out.println("Band: " + i + " Album: " + bands.get(i) );
       }
  }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      myHash();
       myArrays();
       myHash();
       myArrays();
    } 
}
