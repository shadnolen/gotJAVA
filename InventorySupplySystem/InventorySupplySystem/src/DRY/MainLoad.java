/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DRY;

import Controllers.MainScreenController;
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
public class MainLoad {
    
   //Parts
    public void partMain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/MainScreen.fxml"));
        Parent parent = loader.load();  
       
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        MainScreenController controller = loader.getController();
        controller.mainLoader(stage);
        
        stage.hide(); 
        stage.setScene(scene);
        stage.show();
    }
    
    //Products
        public void proMain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/MainScreen.fxml"));
        Parent parent = loader.load();  
       
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        MainScreenController controller = loader.getController();
        controller.mainLoader(stage);
        
        stage.setScene(scene);
        stage.show();
    }
    
}
