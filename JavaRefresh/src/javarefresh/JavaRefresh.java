/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarefresh;


import java.util.Arrays;
import static java.util.Calendar.DATE;


import java.awt.*;
/**
 *
 * @author shadn
 */
public class JavaRefresh {
    
    
   

    //Working on inexing
    private static int[] index;
    
    
    
    public static int indexOf(int[] menu, int value, int excludeThis){
        for(int i=0; i<menu.length;i++){         
            if(menu[i] == value && i != excludeThis){
                return i;
            }
        }
        return -1;
    }  
    
    
    private static int[] getIndicesFromValues(int[] menu, int value, int value1) {
     int index1 = indexOf(menu, value, -1);
     int index2 = indexOf(menu, value1, index1);
    
     int[ ] index ={Math.min(index1, index1), Math.max(index2, index1)};
    
     return index;
    }
    
    // Working on sorting algorithm
   public static int[] findChoices(int[] menu, int money){
           int[] sortedMenu= menu.clone();
           
           Arrays.sort(sortedMenu);
           
           for (int i = 0; i< sortedMenu.length; i++){
               int complement = money - menu[i];
               int location = Arrays.binarySearch(sortedMenu, i + 1, sortedMenu.length, complement);
               if(location >= 0 && location < menu.length && menu[location] == complement){
                   int[ ] indices = getIndicesFromValues(menu, menu[i], complement);
                   return indices;
               }
           }
        return index;
       }

 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        //Simple math fuctions 
     double powerExample = Math.pow(5, 10);
     
     //Passing Variables
     double sroot = Math.sqrt(powerExample);
    
     System.out.println(powerExample);
    System.out.println(sroot);
    
    System.out.println(Arrays.toString(index));
    System.out.println(DATE);
 
    }
     
    //String replace
    
    
}
