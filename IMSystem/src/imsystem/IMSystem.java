/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imsystem;

//Import from model package


//List of Java Imports
import Models.Supply;
import javafx.scene.layout.AnchorPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author shadn
 */
public class IMSystem extends Application {

	/**
	 * @param args
	 */
    
            private Stage mainStage;
            private AnchorPane mainScreen;
            
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
	this.mainStage = mStage;
                     this.mainStage.setTitle(" IMS");
                     showMainStage(mStage);
                                        
                                    
                // Set our path to FXML
		FXMLLoader loadFx = new FXMLLoader(getClass().getResource("/Views/MainScreen.fxml"));
                                           loadFx.setLocation()
                                   
                // Set our Controllers 
		Controllers.MainScreenController controller = new Controllers.MainScreenController();
		loadFx.setController(controller);
		Parent root = loadFx.load();
                                  
                //Setting the stage
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

}
