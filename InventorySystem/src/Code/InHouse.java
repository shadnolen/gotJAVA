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
    private int machineID;
    public InHouse(int partID, String name, int stock, double partPrice, int max, int min, int machID){
     
        setPartID(partID);
        setName(name);
        setStock(stock);
        setPrice(partPrice);
        setMax(max);
        setMin(min);
       setMachineID(machID);
	}

	public void setMachineID(int id) {
		this.machineID = id;
	}

	public int getMachineID() {
		return machineID;
	}

}
