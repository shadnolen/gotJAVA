/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationii;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
// import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author shadn
 */
public class JavaApplicationII {
    

 // Scanner methods
   static void inScan(){
       Scanner keyboard = new Scanner(System.in);
       System.out.println("Enter the text: ");
       String text1 = keyboard.nextLine();
       System.out.println("This is your text? - " + text1);
   }
   
   static void date(){
       LocalDateTime dateNow = LocalDateTime.now();
       System.out.println(dateNow);
   }
   

static int fibonacci(int number){ 
    
    if(number == 1 || number == 2){
        return 1; 
    }
    return fibonacci(number-1) + fibonacci(number -2); 
}

//Simple counting method 
static void cNum(){
       for(int i = 0;i <= 6; i++){
    System.out.println("Number " + i + " Stunner");
}for (int i= 0; i>6;i++){
    System.out.println("Number " + i + " Stunner");
}
}
   
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
           HashST.myHash();
          date();    
          ArraySets.ArraySets();
          cNum();
    }

      
    } 

