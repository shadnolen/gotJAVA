/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationiii;

/**
 *
 * @author shadn
 */
public  class Fibit {
    
    static void FibIt(){
       
        
      for(int fib = 0, step=1; fib < 42; fib=fib+step, step=fib-step ){
          System.out.println(fib + " ");
          }
       Long endTime = System.nanoTime();
          System.out.println(endTime);
       }
     }

