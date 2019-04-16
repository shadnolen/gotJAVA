/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarefresh;

import java.util.Arrays;

/**
 *
 * @author shadn
 */
public class  Bands  extends JavaRefresh{
       //how to manipulate characters in a string.  
        String bandNames;
        int fans;
        String [] bands = {"Pink-Floyd",  "Slayer", "Kreator"};
        private int bandsCount = 0;
        
        public void fan(String bandNames, int fans){
            this.bandNames = bandNames;
            this.fans = fans;
        }
        
        public void fansDB(){
            System.out.print("Some like it, Louder then NlogN");
        }
        
        public int loudness(){
            return this.fans * 7;
        }
        
        public void fanNoise(){
        this.bandsCount = (this.bandsCount +1) %5;
        String myBand = this.bands[this.bandsCount];
        
}
       
}            
        
