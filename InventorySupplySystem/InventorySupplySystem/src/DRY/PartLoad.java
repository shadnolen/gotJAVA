/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DRY;

import Controllers.PartScreenController;
import Model.Part;
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
public class PartLoad {
    
       public void partPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/PartScreen.fxml"));
        Parent parent = loader.load();  
       
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        PartScreenController controller = loader.getController();
        controller.startPart();
        
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }
    
   public  void partPage(ActionEvent event, Part part) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/PartScreen.fxml"));
        Parent parent = loader.load();  
       
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        PartScreenController controller = loader.getController();
        controller.startPart(part);
        
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }
    
}
