/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author shadn
 */
public class Supply {
    
    //Setting the ArrayList 
    private ArrayList<Products> products;
    private ArrayList<Parts> parts;
    private int removePro;
    
    //Setting up methods 
    public Supply(){
        products = new ArrayList <> ();
        parts = new ArrayList <> ();
    }
    
    public void productAdd(Products addProduct){
        if (addProduct != null){
            this.productAdd(addProduct);
        }
    }
    
    public boolean productRemove(int removePRO){
        for(int pro = 0; pro< products.size(); pro++){
            if(products.get(pro).getProID() == removePro){
                products.remove(pro);
                break;
            }else{
                return false;
            }            
        }
        return true;
    }
    
}
