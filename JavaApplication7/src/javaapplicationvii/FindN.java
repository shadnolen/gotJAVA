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
    
   static void findN(int arrayNum[], int numbers){
       Scanner kb = new Scanner(System.in);
     numbers = kb.nextInt();
     
       System.out.print("Enter what is the number your looking for");
       System.out.print("Your looking for " + numbers);
       for(int i =0;  i < arrayNum.length;  i++){
           for(int j = i+1; j <arrayNum.length; j++){
               if(arrayNum[i] + arrayNum[j] == numbers){
                   System.out.print(arrayNum[i] + " + " + arrayNum[j] + "="  + numbers);
               }               
           } 
           findN(new int[] {2,3,4,5,6,7,9}, 14);
           findN(new int[] {2,3,4,5,6,7,9}, 16); 
       }
    
   }  
      
}
