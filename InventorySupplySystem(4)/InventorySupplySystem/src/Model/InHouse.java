/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author shadn
 */

// 
public class InHouse extends Part {

	private int machineID;
        
        
                    //vararg parameter (variable argument) you are only allowed to have one vararg parameter per method
	public InHouse(int partID, String name, double price, int numInStock, int min, int max, int machID) {

		this.setPartID(partID);
		this.setName(name);
		this.setPrice(price);
		this.setInStock(numInStock);
		this.setMin(min);
		this.setMax(max);
		this.setMachineID(machID);
	}
                //Famed getters and setters
	public void setMachineID(int id) {
		this.machineID = id;
	}

	public int getMachineID() {
		return machineID;
	}

}
