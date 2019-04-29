/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationiv;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author shadn
 */
public class JavaSkills {
    
    static void javaSkills(){
       // HashMap<String, Integer> bands = new HashMap<>();
        
        int rows, numbers = 1, counter, j;
        
        System.out.println(" How big do you want your Pink Floyd ");
        Scanner kb = new Scanner(System.in);
        
        System.out.println("*********");
        rows = kb.nextInt();
        
        for(counter = 1; counter <= rows; counter++){
            for(j=1; j <= counter; j++){
            System.out.println( " " + numbers +  "  ");
            numbers++;
        }
        System.out.println();
    }
    
    }
    
    
}
