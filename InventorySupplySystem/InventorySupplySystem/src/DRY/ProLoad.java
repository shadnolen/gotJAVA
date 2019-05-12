/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DRY;

import Controllers.ProductScreenController;
import Model.Product;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author shadn
 */
public class ProLoad {
    
     public void proPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/ProductScreen.fxml"));
        Parent parent = loader.load();  
       
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        ProductScreenController controller = loader.getController();
        controller.startProduct();
        
        stage.hide(); 
        stage.setScene(scene);
        stage.show();
    }
    
    public void proPage(ActionEvent event, Product product) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/ProductScreen.fxml"));
        Parent parent = loader.load();  
       
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        ProductScreenController controller = loader.getController();
        controller.startProduct(product);
        
        stage.hide(); 
        stage.setScene(scene);
        stage.show();
    }
    
}
