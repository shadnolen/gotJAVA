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
public class FloydIn {
    
    FloydIn(){
        int rows = 10;
        int count = rows;  
        for(int i = 0; i <rows; i++){
            for(int j = 0; j<i*2; j++){
                System.out.print(" ");
            }
            for(int j = i+1; j<count; j++){
           System.out.print(" ");
            }
        }
    }
    
    
}
