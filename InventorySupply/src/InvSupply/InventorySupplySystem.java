/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package InvSupply;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Controllers.MainScreenController;
import Controllers.PartsAddController;
import javafx.stage.Modality;

/**
 *
 * @author 
 */
public class InventorySupplySystem extends Application {
    
    private Stage mainStage;
    private AnchorPane mainScreen;
    
    @Override
    public void start(Stage stage) throws IOException {
        this.mainStage = stage;
        this.mainStage.setTitle("Inventory Supply Mangement System"); 
        showMainScreen(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void showMainScreen(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(InventorySupplySystem.class.getResource("/Views/MainScreen.fxml"));
        this.mainScreen = (AnchorPane) loader.load();  

        // Give the controller access to the main app.
        MainScreenController controller = loader.getController();
        
        controller.startMain(stage); 
    }
}
