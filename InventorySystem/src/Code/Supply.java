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
    
    private ArrayList<Parts>  partsTotal;
    private ArrayList<Products> productTotal;
    
    public Parts lookUpPart(int partLookUp){
        if(!partsTotal.isEmpty()){
            for(int i=0; i < partsTotal.size(); i++){
                if(partsTotal.get(i).getPartID()  == partLookUp){
                return partsTotal.get(i);
            }
          }
       }
        return null;
    }
    
    public Products lookUpProduct(int productLookUp){
        if(!productTotal.isEmpty()){
            for(int i=0;  i < productTotal.size(.); i++){
                if(productTotal.get(i).getProductID() == productLookUp){
                    return productTotal.get(i);
                }
            }
        }
        return null;
    }

    public ArrayList<Integer> retrievePartIDL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Integer> retrieveProductIDL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
