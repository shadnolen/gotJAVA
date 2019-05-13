/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author shadn
 */
public class Product {
    
    /*** PROVIDES A FULL IMPLEMENTION FOR WRAPPING STRING VALUES  ***/
    private ObservableList<Part> productParts = FXCollections.observableArrayList();
    private final IntegerProperty productID;
    private final StringProperty productName;
    private final DoubleProperty productPrice;
    private final IntegerProperty productInStock;
    private final IntegerProperty productMin;
    private final IntegerProperty productMax;

     /*** REFERENCE VARIABLE THAT REFERS TO THE CURRENT OBJECT  ***/
    public Product(int productID, String name, double price, int inStock, int min, int max) {
        this.productID = new SimpleIntegerProperty(productID);
        this.productName = new SimpleStringProperty(name);
        this.productPrice = new SimpleDoubleProperty(price);
        this.productInStock = new SimpleIntegerProperty(inStock);
        this.productMin = new SimpleIntegerProperty(min);
        this.productMax = new SimpleIntegerProperty(max);
    }

    public Product() {
        this.productID = new SimpleIntegerProperty(0);
        this.productName = new SimpleStringProperty("");
        this.productPrice = new SimpleDoubleProperty(0);
        this.productInStock = new SimpleIntegerProperty(0);
        this.productMin = new SimpleIntegerProperty(0);
        this.productMax = new SimpleIntegerProperty(0);
    }

    /*** GET AND SET
     * @param productID ***/
    
    /*** ID
     * @param productID ***/
    public void setProductID(int productID) {
        this.productID.set(productID);
    }

    public int getProductID() {
        return this.productID.get();
    }

    public IntegerProperty productIDProperty() {
        return productID;
    }
    
   /*** NAME
     * @param name ***/
     public void setName(String name) {
        this.productName.set(name);
    }

    public String getName() {
        return this.productName.get();
    }

    public StringProperty productNameProperty() {
        return productName;
    }
    
    /*** PRICE
     * @param price ***/
    public void setPrice(double price) {
        this.productPrice.set(price);
    }

    public double getPrice() {
        return this.productPrice.get();
    }

    public DoubleProperty productPriceProperty() {
        return productPrice;
    }

    /*** INSTOCK
     * @param inStock ***/
    public void setInStock(int inStock) {
        this.productInStock.set(inStock);
    }

    public int getInStock() {
        return this.productInStock.get();
    }

    public IntegerProperty productInStockProperty() {
        return productInStock;
    }
    
    /*** MIN
     * @param min ***/
    public void setMin(int min) {
        this.productMin.set(min);
    }
    
    public int getMin() {
        return this.productMin.get();
    }

    public IntegerProperty productMinProperty() {
        return productMin;
    }
    
  /*** MAX
     * @param max ***/
     public void setMax(int max) {
        this.productMax.set(max);
    }

    public int getMax() {
        return this.productMax.get();
    }
    
    public IntegerProperty productMaxProperty() {
        return productMax;
    }
    
   /*** ASSOCIATED 
     * @param associatedParts ***/
    public void setProductParts(ObservableList<Part> associatedParts) {
        productParts = associatedParts;
    }
    
    public ObservableList<Part> getProductParts() {
        return productParts;
    }
    /*** END GET AND SET ***/

}
