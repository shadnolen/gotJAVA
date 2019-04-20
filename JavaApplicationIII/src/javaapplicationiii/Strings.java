/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationiii;

/**
 *
 * @author shadn
 */
public class Strings {
    
   static void strings(){
       //basic string build 
       String textI = "Face the end of time, As we plunge headlong towards the day, Can't deny the signs \n" ;
       String textII = "When the sun burns red The earth will turn From blue to gray";
       
       System.out.printf(textI + textII + "\n");    
       System.out.printf(textI.toLowerCase() + textII.toUpperCase() + "\n");    
       
       // Let's Flip it and reverse the String;
       String rText = new StringBuffer(textI).reverse().toString();
       System.out.println("\n Flip it and reverse it: \n");
       System.out.printf(rText, textI);
  
   }
     
}
