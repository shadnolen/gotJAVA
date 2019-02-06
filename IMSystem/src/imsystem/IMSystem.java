/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imsystem;

//Import from model package
import model.Supply;

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
public class IMSystem extends Application {

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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Main.fxml"));
                                   
                // Set our Controllers 
		controllers.MainController controller = new controllers.MainController(supply);
		loader.setController(controller);
		Parent root = loader.load();
                                  
                //Setting the stage
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

}
