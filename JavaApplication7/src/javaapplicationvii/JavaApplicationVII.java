/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationvii;

import java.util.Scanner;
import static javaapplicationvii.FindN.findN;

/**
 *
 * @author shadn
 */
public class JavaApplicationVII {
   static void findN(int arrayNum[], int numbers){
      Scanner kb = new Scanner(System.in);
     
     
       System.out.print(" Enter what is the number your looking for \n ");
        numbers = kb.nextInt();
       System.out.print("Your looking for " + numbers + " \n");
       for(int i =0;  i < arrayNum.length;  i++){
           for(int j = i+1; j <arrayNum.length; j++){
               if(arrayNum[i] + arrayNum[j] == numbers){
                   System.out.print(arrayNum[i] + " +  " + arrayNum[j] + " = "  + numbers +"\n");
               } else if(arrayNum[i] + arrayNum[j] + numbers == 0){
                   System.out.println(" no match");
                   break;
               }               
           } 
           
       }
    
   } 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
             findN(new int[] {2,3,4,5,6,7,9}, 14);
            findN(new int[] {2,3,4,5,6,7,9}, 16); 
    }
    
}
