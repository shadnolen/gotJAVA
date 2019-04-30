/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationvii;

import java.util.Scanner;

/**
 *
 * @author shadn
 */
public class FindN {
    
      static void findN(int arrayNum[]){
        // Scanner Class for our input
      Scanner kb = new Scanner(System.in);
     
    
       System.out.print(" Enter what is the number your looking for \n ");
       //taking our input  and placing it in our numbers var
        int numbers = kb.nextInt();
        
        // show you what number your choosing
       System.out.print("Your looking for " + numbers + " \n");
       
       
       for(int i =0;  i < arrayNum.length;  i++){
           for(int j = i+1; j <arrayNum.length; j++){
               if(arrayNum[i] + arrayNum[j] == numbers){
                   System.out.print(arrayNum[i] + " +  " + arrayNum[j] + " = "  + numbers +"\n");
               }           
           } 
           
       }
   
    }
}
