/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarefresh;

import java.util.Random;

/**
 *
 * @author shadn
 */
public class DiceRoller {

    
    int die1 =(int)(Math.random()*6+1);
    int die2=(int) (Math.random()*6+1);
    
public DiceRoller(){

      int sum;
    sum = die1 + die2;
     System.out.println(sum);
  
 }
    
     
}
