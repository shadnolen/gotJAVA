/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarefresh;

import static java.lang.Double.max;
import java.util.Arrays;
import static java.util.Calendar.DATE;
import static javarefresh.Stairs.countPaths;


/**
 *
 * @author shadn
 */
public class JavaRefresh {

    private static int[] indices;
    
    public static int indexOf(int[] menu, int value, int excludeThis){
        for(int i=0; i<menu.length;i++){         
            if(menu[i] == value && i != excludeThis){
                return i;
            }
        }
        return -1;
    }  
    
    private static int[] getIndicesFromValues(int[] menu, int value, int value1) {
     int index = indexOf(menu, value, -1);
     int index1 = indexOf(menu, value1, index);
    
     int[ ] indices ={Math.min(index, index1), Math.max(index, index1)};
    
     return indices;
    }
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
        return indices;
       }

 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    System.out.println(indices);
    System.out.println(DATE);
    System.out.print(countPaths);
    }
    
}
