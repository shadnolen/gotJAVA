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
public class FloydR {
    
   // int rows = 20;
     
      static void floydR(){
       Scanner kb = new Scanner(System.in);
       
       System.out.println("How big you need your pyrmid yo?");
       int rows = kb.nextInt();
       System.out.println("Oh you want it " + rows + " high, huh");
      
        for(int i = 1; i < rows; i++){
            for(int j = 0; j<rows; ++j){
                System.out.print(" ");
            }
            
            rows--;
             for(int k = 1; k <= i; k++){
                System.out.print(i + " ");
             }
             System.out.println(rows);
        }
       
        
        
    }
    
}
