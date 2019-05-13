/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Supply;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Controllers.MainScreenController;


/**
 *
 * @author shadn
 */
public class SupplyInv extends Application {
   
    /***  INITIALIZE ***/
    private Stage mainStage;
    private AnchorPane mainScreen;
    
    @Override
    public void start(Stage stage) throws IOException {
     
       /*** SET UP THE STAGE ***/
        this.mainStage = stage;
        this.mainStage.setTitle("Supply Mangement System"); 
        mainScreen(stage);
    }

    /*** MAIN LOADER
     * @param stage
     * @throws java.io.IOException
     */
    public void mainScreen(Stage stage) throws IOException {
      
        /*** SET THE MAIN LOCATION ***/
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(SupplyInv.class.getResource("/Views/MainScreen.fxml"));
        this.mainScreen = (AnchorPane) loader.load();  
        MainScreenController controller = loader.getController();
    
       /*** SET STAGE MAINLOADER ***/
        controller.mainLoader(stage); 
    }
       /*** THE START OF ALL JAVA ***/
     public static void main(String[] args) {      
        launch(args);
    }
    
}
