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
Random random;
int preRoll= 0; 
 
    public  DiceRoller(){
       
   this.random = new Random();      
    }
    
    public int roller(){
        int roll = this.random.nextInt(5) + 1;
        this.preRoll = roll;
        return roll;
    }
    
    
}
