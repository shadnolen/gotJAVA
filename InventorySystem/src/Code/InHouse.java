/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author shadn
 */
public class InHouse extends Parts{
    private int inHouseID;
    public InHouse(int partID, String name, int stock, double price, int max, int min, int houseID){
     
        setPartID(partID);
        setName(name);
        setStock(stock);
        setPrice(price);
        setMax(max);
        setMin(min);
        setInHouseID(houseID);
    }
    
    public void setInHouseID(int houseID){
        this.inHouseID = houseID;
    }
    
    public int getInHouseID(){
        return inHouseID;
    }
}


