/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarefresh;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 *
 * @author shadn
 */
public class HashSets {
    
    public HashSets(){
        HashSet<String> bands = new HashSet<>();
        
        //Adding some test Elements
        bands.add("Pink Floyd");
        bands.add("Kreator");
        bands.add("Slayer");
        bands.add("Testament");
        
        Iterator<String> i = bands.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
             
        
        }
        
    /**
     *
     * @param initialCapacity
     * @param loadFactor
     * @param accessOrder
     */
 
       
   
        //Display hashset
        System.out.println(bands);
       
         System.out.println(bands);
          //System.out.println(i);
        
    }

      public HashSets(int initialCapacity,
             float loadFactor,
             boolean accessOrder){
            HashSets copy = new HashSets();
            System.out.println(copy);
    
        }
              
     
}
