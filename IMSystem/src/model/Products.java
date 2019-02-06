/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author shadn
 */
public class Products {
    
    private int proID;
    
    public Products(int proID){
        setProID(proID);
    }

    public void setProID(int proID) {
      this.proID = proID;
    }
    
    public int getProID(){
       return proID;
}
    
    
}
