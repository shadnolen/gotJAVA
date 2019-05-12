/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DRY;

import javafx.scene.control.Alert;
import javafx.stage.Modality;

/**
 *
 * @author shadn
 */
public class NoSelect {
    
    public void noAlert(){
    Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("Nothing selected");
            alert.setHeaderText("Please select  from the existing list to modify"); 
            alert.showAndWait();
     }
    
    public void associatedObject(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.setTitle("Object is Connected");
                alert.setHeaderText("Unable to delete object that is associated with other objects"); 
                alert.showAndWait();
    }
}
