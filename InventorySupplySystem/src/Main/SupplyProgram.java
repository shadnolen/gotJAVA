/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

//Import from model package
import Model.Supply;

//List of Java Imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author shadn
 */
public class SupplyProgram extends Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Supply supply = new Supply();
                                        
                                    
                // Set our path to FXML
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/MainScreen.fxml"));
                                   
                // Set our Controllers 
		Controllers.MainScreenController controller = new Controllers.MainScreenController(supply);
		loader.setController(controller);
		Parent root = loader.load();
                                  
                //Setting the stage
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

}
