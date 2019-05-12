/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Supply;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Controllers.MainScreenController;
import Controllers.PartScreenController;
import javafx.stage.Modality;

/**
 *
 * @author shadn
 */
public class SupplyInv extends Application {
    
    private Stage mainStage;
    private AnchorPane mainScreen;
    
    @Override
    public void start(Stage stage) throws IOException {
     
        //Set our stage
        this.mainStage = stage;
        this.mainStage.setTitle("Supply Mangement System"); 
        mainScreen(stage);
    }

    /**
     * @param stage
     * @throws java.io.IOException
     */
    public void mainScreen(Stage stage) throws IOException {
        //set our main location
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(SupplyInv.class.getResource("/Views/MainScreen.fxml"));
        this.mainScreen = (AnchorPane) loader.load();  

        // Give the controller access to the main app.
        MainScreenController controller = loader.getController();
    
        //  Call the main loader
        controller.mainLoader(stage); 
    }
        //The start of all Java
     public static void main(String[] args) {      
        launch(args);
    }
    
}
