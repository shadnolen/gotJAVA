/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supplyinventory;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import models.Parts;
import models.Products;

/**
 *
 * @author shadn
 */
public class SupplyInventory extends Application {
    
    public static ObservableList<Products> allProducts = FXCollections.observableArrayList();
    public static ObservableList<Parts> allParts = FXCollections.observableArrayList();
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/MainScreen.fxml"));        
        Scene scene = new Scene(root);        
        stage.setScene(scene);
        stage.show();
    }
      
    public static ObservableList<Products> getAllProducts() {
        return allProducts;
    }
    
     public static ObservableList<Parts> getAllParts() {
        return allParts;        
     }
     
    /**
     *
     * @param products
     * @return
     */
    public static boolean removeProduct(Products products) {
      return allProducts.remove(products);
    }
    
      /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
