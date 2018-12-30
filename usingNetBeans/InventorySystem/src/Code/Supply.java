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

	private ArrayList<Products> products;
	private ArrayList<Parts> totalParts;

	public Supply() {
		products = new ArrayList<>();
		totalParts = new ArrayList<>();
	}

	public void addProduct(Products productToAdd) {
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

	public Products lookUpProduct(int productToSearch) {
		if (!products.isEmpty()) {
			for (int i = 0; i < products.size(); i++) {
				if (products.get(i).getProductID() == productToSearch) {
					return products.get(i);
				}
			}
		}
		return null;
	}

	public void updateProduct(Products product) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductID() == product.getProductID()) {
				products.set(i, product);
				break;
			}
		}
		return;
	}

	public void addPart(Parts partToAdd) {
		if (partToAdd != null) {
			totalParts.add(partToAdd);
		}
	}

	public boolean deletePart(Parts partToDelete) {
		for (int i = 0; i < totalParts.size(); i++) {
			if (totalParts.get(i).getPartID() == partToDelete.getPartID()) {
				totalParts.remove(i);
				break;
			}
			else {
				return false;
			}
		}

		return true;
	}

	public Parts lookUpPart(int partToLookUp) {
		if (!totalParts.isEmpty()) {
			for (int i = 0; i < totalParts.size(); i++) {
				if (totalParts.get(i).getPartID() == partToLookUp) {
					return totalParts.get(i);
				}
			}

		}
		return null;

	}

	public void updatePart(Parts partToUpdate) {
		for (int i = 0; i < totalParts.size(); i++) {
			if (totalParts.get(i).getPartID() == partToUpdate.partID) {
				totalParts.set(i, partToUpdate);
				break;
			}
		}
		return;
	}

	public int productListSize() {
		return products.size();
	}

	public int partListSize() {
		return totalParts.size();
	}

	public ArrayList<Integer> retrievePartsIDList() {
		ArrayList<Integer> list = new ArrayList<>();
		if (!totalParts.isEmpty()) {
			for (int i = 0; i < totalParts.size(); i++) {
				list.add(totalParts.get(i).getPartID());
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