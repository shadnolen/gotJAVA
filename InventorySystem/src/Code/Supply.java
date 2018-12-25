/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.util.ArrayList;


/**
 *
 * @author shadn
 */
public class Supply {
    
    private ArrayList<Parts>  products;
    private ArrayList<Products> productTotal;
    int i;
    
    public Supply(){
    products = new ArrayList<>();
    productTotal = new ArrayList<>();    
}
    
    //ADD/REMOVE/MOD from product list 
    public void productAdd(Products addProduct){
        if(addProduct != null){
            this.productAdd(addProduct);
        }
    }    
    
    public boolean productRemoval(int productRemoval){
     
        for( i = 0; i< products.size(); i++){
            if(productTotal.get(i).getProductID() == productRemoval){
                products.remove(i);
                break;
            }else{
                return false;
            }
        }
        return true;
    }
    
    public Products productSearch(int searchProduct){
        if(!products.isEmpty()){
            for(i = 0; i <products.size();i++ ){
                if(productTotal.get(i).getProductID() == searchProduct);
            }
        }
            return null;
    }
    
    public Products productUpdate(Products product){
        for (i=0; i < products.size();i++){
            if(productTotal.get(i).getProductID() == product.getProductID()) {
            } else {
                productTotal.set(i, product);
                break;
            }
        }
        return null;
    }


//ADD/REMOVE/MOD from parts list 
    
    
    
    public void partsAdd(Parts partsAdd){
        if(partsAdd  != null){
            products.add(partsAdd);
        }
    }
    
    public boolean partsDelete(Parts partsDelete) {       
        for (i=0; i < products.size();i++){
                
        if (products.get(i).getPartID() == partsDelete.getPartID()){
            products.remove(i);
            break;
             }else{
            return false;
          }
        }       
        return true;
    }
    
    public Parts partsSearch(int partsSearch){
        if(!products.isEmpty()){
            for(int i=0; i < products.size(); i++){
                if(products.get(i).getPartID()  == partsSearch){
                return products.get(i);
            }
          }
       }
        return null;
    }
    
    
    
    public void   partsUpdate(Parts partsUpdate){
        for(int i = 0; i < products.size(); i++){
            if (products.get(i).getPartID() == partsUpdate.partID){
                products.set(i, partsUpdate);
                break;
            }
        }
        return;
    }

    
      // List Size Check
    public int productLS(){
        return products.size();
    }
    
    public int partLS(){
        return productTotal.size();
    }

         public ArrayList<Integer> retrievePartsIDL(){
        ArrayList<Integer> list = new ArrayList<>();
        if(!products.isEmpty()){
            for(int i = 0; i< products.size(); i++){
                list.add(products.get(i).getPartID());
            }
        }
        return list;
    }
    
            public ArrayList<Integer> retrieveProductsIDL(){
        ArrayList<Integer> list = new ArrayList<>();
        if(!productTotal.isEmpty()){
            for(int i = 0; i< productTotal.size(); i++){
                list.add(productTotal.get(i).getProductID());
            }
        }
        return list;
    }
}
