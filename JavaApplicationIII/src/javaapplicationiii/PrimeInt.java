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
public class PrimeInt {
    
    static void primeInt(){
     
        Scanner keyboard = new Scanner(System.in);
        int number = Integer.MAX_VALUE;
        System.out.println("Let's check to see if the number is optimus prime: ");
        
        while(number != 0){
            number = keyboard.nextInt();
             System.out.println(" Is " + number + " prime? \n " +  isPrime(number) +" "+ isPrimeOrNot(number) + " " + isPrimeNumber(number) + " that we have a PRIME NUMBER");
        }
       
    }

    // We need to check to see if the number is PRIME
    private static boolean isPrime(int number) {
     int sqrt = (int) Math.sqrt(number) + 1;
     for(int i = 2; i<sqrt;i++){
        // If we have perfect divisiblity 
         if(number % i ==0){
             return false;
         }
     }
     
     return true;
    }
    
    
    public static String isPrimeOrNot(int number){
        if(number < 0){
            return "Not vaild KID ";
        }if(number == 0 || number ==1){
            return "Not Prime SHUN! ";
        }if(number == 2 || number == 3){
            return "Optumus Prime ";
        }if((number * number - 1) % 24 == 0){
            return "Prime Rib";
        }else{
            return " What ever it is, it's not Prime ";
       }
    }
    
    
    public static boolean isPrimeNumber(int number){
        if(number == 2 || number == 3){
            return true;
        }if(number %2 ==0){
            return false;
        }
        
        int sqrt = (int) Math.sqrt(number)+1;
        for(int i = 3;i < sqrt; i =+2){
            if(number % i == 0){
            return false;
        }
    }
        return true;
  }  
}
    