/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationiii;

import java.util.Scanner;

/**
 *
 * @author shadn
 */
public class Pnum {
    
    static void pnum(){
        
        //Scanner  user input 
    Scanner keyboard = new Scanner(System.in);
    
    System.out.println("How big do you want your pyramid?");
    
    // turn our input into  our var
    int numRows = keyboard.nextInt();
    
    //Start with a row count of one.
    int rowCount = 1;
    
    // output our data 
    System.out.print("Here's your Pyramid of  \n " + numRows + " rows \n \n");
    
    //Build our pyramid 
    for(int i = numRows; i > 0; i-- ){
      
        //Add our blank spaces 
        for(int j = 1; j <= i; j++){
            System.out.print(" ");
        }for(int j = 1; j <= rowCount; j++){
            System.out.print(rowCount + " ");
        }for(int j = rowCount-1; j>=1; j--){
            System.out.print(j + "");
        }
        System.out.println();
        
        // and finally we need to increment the rows
        rowCount++;       
    }
    
    
}
}
