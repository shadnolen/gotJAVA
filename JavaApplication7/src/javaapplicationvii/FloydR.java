    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationvii;

/**
 *
 * @author shadn
 */
public class FloydR {
    int rows = 20;
     
      FloydR(){
       
        for(int i = 0; i < rows; i++){
            for(int j = 0; j<rows; j++){
                System.out.print(" ");
            }
            
            rows--;
             for(int k = 1; k <= i; k++){
                System.out.print(i + " ");
             }
             System.out.println();
        }
       
        
        
    }
    
}
