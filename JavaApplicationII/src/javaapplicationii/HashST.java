/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationii;

import java.util.HashMap;

/**
 *
 * @author shadn
 */
public class HashST {
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
}
