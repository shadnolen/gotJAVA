/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasi;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author shadn
 */

//Directory Crawler 
public class Crawler {
    
 
   
    
   
    
    public static void main(String[] args){
       Scanner keyboard = new Scanner(System.in);
       String fName = keyboard.nextLine();    
       System.out.println("Directory or file to crawl: ");  
       
       File f = new File(fName);
       if(!f.exists()){
           System.out.println("No file found");
       }else{
           print(f);
       }
    }
    
    public static void print(File f){
        System.out.println(f.getPath());
        
        if(f.isDirectory()){
            File[] contents = f.listFiles();
            for(int i =0; i< contents.length;i++){
                print(contents[i]);
            }
        }
    }
}
