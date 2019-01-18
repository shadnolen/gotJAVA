/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author shadn
 */

//Main class
public class Supply {

                    //Set arraylist 
	private ArrayList<Product> products;
	private ArrayList<Part> partsTotal;

                   //Methods
	public Supply() {
		products = new ArrayList<>();
		partsTotal = new ArrayList<>();
	}

                    //Product methods
	public void addProduct(Product productToAdd) {
		if (productToAdd != null) {
			this.products.add(productToAdd);
		}
	}

	public boolean removeProduct(int productToRemove) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductID() == productToRemove) {
				products.remove(i);
				break;
			}
			else {
				return false;
			}
		}
		return true;
	}

	public Product lookUpProduct(int productToSearch) {
		if (!products.isEmpty()) {
			for (int i = 0; i < products.size(); i++) {
				if (products.get(i).getProductID() == productToSearch) {
					return products.get(i);
				}
			}
		}
		return null;
	}

	public void updateProduct(Product product) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductID() == product.getProductID()) {
				products.set(i, product);
				break;
			}
		}
	}
                      //Parts method
	public void addPart(Part partToAdd) {
		if (partToAdd != null) {
			partsTotal.add(partToAdd);
		}
	}

	public boolean deletePart(Part partToDelete) {
		for (int i = 0; i < partsTotal.size(); i++) {
			if (partsTotal.get(i).getPartID() == partToDelete.getPartID()) {
				partsTotal.remove(i);
				break;
			}
			else {
				return false;
			}
		}

		return true;
	}

	public Part lookUpPart(int partToLookUp) {
		if (!partsTotal.isEmpty()) {
			for (int i = 0; i < partsTotal.size(); i++) {
				if (partsTotal.get(i).getPartID() == partToLookUp) {
					return partsTotal.get(i);
				}
			}

		}
		return null;

	}

	public void updatePart(Part partToUpdate) {
		for (int i = 0; i < partsTotal.size(); i++) {
			if (partsTotal.get(i).getPartID() == partToUpdate.partID) {
				partsTotal.set(i, partToUpdate);
				break;
			}
		}
	}

	public int productListSize() {
		return products.size();
	}

	public int partListSize() {
		return partsTotal.size();
	}

	public ArrayList<Integer> retrievePartsIDList() {
		ArrayList<Integer> list = new ArrayList<>();
		if (!partsTotal.isEmpty()) {
			for (int i = 0; i < partsTotal.size(); i++) {
				list.add(partsTotal.get(i).getPartID());
			}
		}
		return list;
	}

	public ArrayList<Integer> retrieveProductIDList() {
		ArrayList<Integer> list = new ArrayList<>();
		if (!products.isEmpty()) {
			for (int i = 0; i < products.size(); i++) {
				list.add(products.get(i).getProductID());
			}
		}
		return list;
	}

}
