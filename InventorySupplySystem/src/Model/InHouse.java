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

		setPartID(partID);
		setName(name);
		setPrice(price);
		setInStock(numInStock);
		setMin(min);
		setMax(max);
		setMachineID(machID);
	}
                //Famed getters and setters
	public void setMachineID(int id) {
		this.machineID = id;
	}

	public int getMachineID() {
		return machineID;
	}

}