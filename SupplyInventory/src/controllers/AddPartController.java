 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Parts;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class AddPartController implements Initializable {

    @FXML
    private Label addPartLabel;
    @FXML
    private RadioButton partInhouse;
    @FXML
    private RadioButton partOutsourced;
    @FXML
    private TextField partID;
    @FXML
    private TextField partName;
    @FXML
    private TextField partsInStock;
    @FXML
    private TextField partPrice;
    @FXML
    private TextField partMinStock;
    @FXML
    private TextField partMaxStock;
    @FXML
    private Label partCompanyNameLabel;
    @FXML
    private TextField partCompanyName;
    @FXML
    private Label partMachineIDLabel;
    @FXML
    private TextField partMachineID;

    
   
    private Parts sourcedSelected;
    @FXML
    private ToggleGroup toggle;
   
    
    void mainAccess(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("views/MainScreen.fxml"));
        Parent parentPage = loader.load();
        
        Scene scenePage = new Scene(parentPage);
        Stage appPage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        MainScreenController controller = loader.getController();
        controller.startMainStage(appPage);
        appPage.setScene(scenePage);
        appPage.show();
    }
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
    @FXML
    private void radioButtonSelected(ActionEvent event) {
        if(this.toggle.getSelectedToggle().equals(this.partInhouse)){
            this.partCompanyName.setEditable(false);
            this.partCompanyName.setDisable(true);
            this.partCompanyName.setText(" ");
            
           this.partMachineID.setEditable(true);
           this.partMachineID.setDisable(false);
        }else if(this.toggle.getSelectedToggle().equals(this.partOutsourced)){
            this.partMachineID.setEditable(false);
           this.partMachineID.setDisable(true);
           this.partMachineID.setText(" ");
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.NONE);
            alert.setTitle("Invalid Type");
            alert.setHeaderText("Try A Diffrent Part Type");
        }        
    }

    @FXML
    private void saveButton(ActionEvent event) {
    }

    @FXML
    private void cancelButtonPressed(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Confirm Cancel");
        alert.setHeaderText("Confirm Edit Cancel");
        alert.setContentText("Anything Unsaved Will Be Lost");
        Optional<ButtonType> buttonOption = alert.showAndWait();
        if(buttonOption.get()== ButtonType.OK){
            mainAccess( event);
        }
    }
    
    
    
}
