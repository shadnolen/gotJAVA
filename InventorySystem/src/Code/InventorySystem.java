/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import Code.Supply;
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
    
   
    // Here we are setting the stage


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
        @Override
    public void start(Stage stage) throws Exception {
   FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/IMSgui.fxml"));
   Controllers.imsController controller = new Controllers.imsController(inv);
   loader.setController(controller);
   Parent root = loader.load();
   Scene scene = new Scene(root);
   stage.setScene(scene);
   stage.setResizable(false);
   stage.show();
   
    }
    
}
