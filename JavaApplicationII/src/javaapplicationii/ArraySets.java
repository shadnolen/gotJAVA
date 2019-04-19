/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationii;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author shadn
 */
public class ArraySets extends JavaApplicationII{
       //Creating methods  inside classes
    
     static void ArraySets(){
     // ARRAYS   
       ArrayList<String> deathMetal = new ArrayList<>();
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
           
           //Sort the array and print 
           Collections.sort(deathMetal);
           System.out.println(deathMetal);    
           
           //Revese the array 
           Collections.sort(deathMetal, Collections.reverseOrder());
           System.out.println(deathMetal);
       }
    
    
}
