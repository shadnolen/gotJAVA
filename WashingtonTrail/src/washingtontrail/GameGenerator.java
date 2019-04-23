/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package washingtontrail;

import java.util.Random;

/**
 *
 * @author shadn
 */
public class GameGenerator {
     public static Random rand = new Random();
   
     static void gameGen(){
       System.out.println("Name of our fearless leader: " + Descriptions.getLeaderName() + " ");
       
       System.out.println("What type of whip we rolling out west in: " + Descriptions.getAutoType() + " ");
       
   
       System.out.println("What state map we need : " + Descriptions.getStateMap() + " ");
       System.out.println("What state state next : " + Descriptions.getStateName() + " ");  
       
       System.out.println("What music is in the tape deck: " + Descriptions.getMusic() + " ");
       
       
       
       //Let's have some fun and radomize our 
       int changeScene = 4;
       
       System.out.println(changeScene +  " Random adjectives(Name): " );
       for(int i =0 ; i < changeScene; i++){
           System.out.print(Descriptions.getStateName() + ((i != changeScene - 1)?", ": ""));
           System.out.println();
       }
       
       System.out.println(changeScene +  "  Random adjectives(Health): " );
       for(int i =0 ; i<changeScene; i++){
           System.out.print(Descriptions.getHealthEvent()+ ((i != changeScene - 1)?", ": ""));
           System.out.println();
       }
       
       System.out.println(changeScene +  " Random adjectives(State Map): " );
       for(int i =0 ; i<changeScene; i++){
           System.out.print(Descriptions.getStateMap() + ((i != changeScene - 1)?", ": ""));
           System.out.println();
       }
       
        System.out.println(changeScene +  " Random adjectives(Music): " );
       for(int i =0 ; i<changeScene; i++){
           System.out.print(Descriptions.getMusic() + ((i != changeScene - 1)?", ": ""));
           System.out.println();
       }
       
      int teamMate = 5;
      
       System.out.println(teamMate +  " Random adjectives(State Map): " );
       for(int i =0 ; i<teamMate; i++){
           System.out.print(Descriptions.getCoPilot() + ((i != teamMate - 1)?", ": ""));
           System.out.println();
       }
       
      // Test our code
    /***  
       System.out.println("State Map:" + Descriptions.getStateName(WashingtonTrail.TERRITORY_UNSET));
      System.out.println("Minnesota Map:" + Descriptions.getStateName(WashingtonTrail.TERRITORY_MINNESOTA));
      System.out.println("North Dakota Map" + Descriptions.getStateName(WashingtonTrail.TERRITORY_NDAKOTA));
      System.out.println("Montana Map:" + Descriptions.getStateName(WashingtonTrail.TERRITORY_MONTANA));
      System.out.println("Idaho Map:" + Descriptions.getStateName(WashingtonTrail.TERRITORY_IDAHO));
      System.out.println("Washington Map:" + Descriptions.getStateName(WashingtonTrail.TERRITORY_WASHINGTON));
     
      ***/
      
    
   }
    
}
