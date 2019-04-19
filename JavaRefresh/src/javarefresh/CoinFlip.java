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
public class CoinFlip {
    public final int heads= 0;
    public final int tails =1;
    int headsUp;
    
    public CoinFlip(){
        flipIt();
    }
    
    public String flipIt(){
        Random random = new Random();
      headsUp = random.nextInt(2);
    
      if (headsUp == heads){
      //  return "Head up, Butter Cup";
        System.out.println("Heads Up");
        
    }else{
    //   return "Tails foo";
         System.out.println("Tails Down");
      }
      return null;
    }

}
