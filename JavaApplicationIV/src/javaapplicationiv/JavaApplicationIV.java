/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationiv;

import java.util.Scanner;

/**
 *
 * @author shadn
 */
public class JavaApplicationIV {
    
    
   // Auto newAuto = new Auto();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   Scanner key = new Scanner(System.in);

   Auto autoI = new Auto(1994, "Ford", "Fusion", "SEL", "TURD!");
   
   System.out.println("What is the Make: ");
    String make = key.nextLine();
    
     System.out.println("What is the Model: ");
    String model = key.nextLine();
   
    System.out.println("Your turd bucket: " + make + "\n" + model ) ;
    System.out.println(autoI.getModel());
    }
    
}
