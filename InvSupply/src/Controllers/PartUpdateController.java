/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.MainScreenController.selectedIndex;
import Models.InHouse;
import Models.OutSourced;
import Models.SupplyInv;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class PartUpdateController implements Initializable {

    @FXML
    private RadioButton inhousePart;
    @FXML
    private ToggleGroup toggle;
    @FXML
    private RadioButton outsourcedPart;
    @FXML
    private TextField partID;
    @FXML
    private TextField partName;
    @FXML
    private TextField partSupply;
    @FXML
    private TextField partCost;
    @FXML
    private TextField partMax;
    @FXML
    private TextField partMin;
    @FXML
    private TextField machineID;
    @FXML
    private TextField companyID;
    @FXML
    private Label partLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void source(ActionEvent event) {
    }

   public Boolean isValid(){
        return null;
        
    }
    @FXML
    private void savePart(ActionEvent event) throws IOException{
        if(isValid( this.partID.getText(),  this.partName.getText(), this.partCost.getText(), this.partMax.getText(),
                this.partMin.getText(), this.partSupply.getText(), this.companyID.getText(), this.machineID.getText())){
            if(this.toggle.getSelectedToggle().equals(.this.InHouse)){
                   
                    InHouse part = new InHouse();
                    
                    part.setMachID(Integer.parseInt(this.machineID.getText()));
                    part.setPartID(Integer.parseInt(this.partID.getText()));
                    part.setPartName(this.partName.getText());
                    part.setPartPrice(Integer.parseInt(this.partCost.getText()));
                    part.setPartMax(Integer.parseInt(this.partMax.getText()));
                    part.setPartMin(Integer.parseInt(this.partMin.getText()));
                    
                    if(this.partID.getText().length()==0){
                   
                        part.setPartID(SupplyInv.getCountPart());                   
                     }else{
                        part.setPartID(Integer.parseInt(this.partID.getText()));
                        SupplyInv.updatePart(selectedIndex(), part);
                    }
              }else{
                   
                    OutSourced part = new OutSourced();
                    
                    part.setCompanyName(Integer.parseInt(this.companyID.getText()));
                    part.setPartID(Integer.parseInt(this.partID.getText()));
                    part.setPartName(this.partName.getText());
                    part.setPartPrice(Integer.parseInt(this.partCost.getText()));
                    part.setPartMax(Integer.parseInt(this.partMax.getText()));
                    part.setPartMin(Integer.parseInt(this.partMin.getText()));
                    
                    if(this.partID.getText().length()==0){
                   
                        part.setPartID(SupplyInv.getCountPart());                   
                     }else{
                        part.setPartID(Integer.parseInt(this.partID.getText()));
                        SupplyInv.updatePart(selectedIndex(), part);
                    }
              }
            
        }
    }
    
    

    @FXML
    private void cancelPart(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/Views/MainScreen.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.showAndWait();
    }
    
}
