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
    
    public Parts lookUpPart(int partLookUp){
        if(!partsTotal.isEmpty()){
            for(int i=0; i < partsTotal.size(); i++){
                if(partsTotal.get(i).getPartID(). == partLookUp){
                return partsTotal.get(i);
            }
          }
       }
        return null;
    }
    
    
}
