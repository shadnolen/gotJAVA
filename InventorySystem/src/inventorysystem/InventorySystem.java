/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem;

import Models.Supply;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author shadn
 */
public class InventorySystem extends Application {
    Supply supply = new Supply();
    
    @Override
    public void start(Stage stage) throws Exception {
       FXMLLoader mainLoad =  FXMLLoader.load(getClass().getResource("/Views/FXMLDocument.fxml"));
       
       // Path to the controllers 
       Controllers.MainController main = new Controllers.MainController(supply);
       mainLoad.setController(main);
       
        Parent root = mainLoad.load(); 
      
        
        Scene scene = new Scene(root);        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }   
    
}
