/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationiv;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author shadn
 */
public class Duplicate {
    
 static void duplicateString(String inputString){
      
       HashMap<Character, Integer> dupCount = new HashMap<>();
        
        char[]  sArray = inputString.toCharArray();
        
        for(char c : sArray){
            
            if(dupCount.containsKey(c)){
            
                dupCount.put(c, dupCount.get(c)+1);
            }else{
                dupCount.put(c, 1);
            }           
        }
        
        Set<Character> charString = dupCount.keySet();
        System.out.println("Duplicate characters in: " + inputString);
        
        for (Character ch : charString){
            if(dupCount.get(ch) > 1){
                 System.out.println(ch + " : "  + dupCount.get(ch));
            }
         duplicateString("Test Text ");   
        }
          
    }   

    static void duplicateString() {
    }

} 