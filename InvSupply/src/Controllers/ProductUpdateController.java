/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class ProductUpdateController implements Initializable {

    @FXML
    private TextField productID;
    @FXML
    private TextField productName;
    @FXML
    private TextField productSupply;
    @FXML
    private TextField productCost;
    @FXML
    private TextField productMax;
    @FXML
    private TextField productMin;
    @FXML
    private TextField productSearch;
    @FXML
    private TableView<?> partNew;
    @FXML
    private TableColumn<?, ?> partINew;
    @FXML
    private TableColumn<?, ?> partNameNew;
    @FXML
    private TableColumn<?, ?> partSupplyNew;
    @FXML
    private TableColumn<?, ?> partCostNew;
    @FXML
    private TableView<?> productParts;
    @FXML
    private TableColumn<?, ?> productIdNew;
    @FXML
    private TableColumn<?, ?> productNameNew;
    @FXML
    private TableColumn<?, ?> productSupplyNew;
    @FXML
    private TableColumn<?, ?> productCostNew;
    @FXML
    private Label productLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchProducts(ActionEvent event) {
    }

    @FXML
    private void addPart(ActionEvent event) {
    }

    @FXML
    private void deletePart(ActionEvent event) {
    }

    @FXML
    private void productSaveButton(ActionEvent event) {
    }

    @FXML
    private void productCancelButton(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/Views/MainScreen.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.showAndWait();
    }
    
     public Boolean isValid(String productID, String productName, String productCost,  String productMax, String partMin, String productSupply, String companyName, String machineID){
       String error = " ";
       Integer intMax = null,  intMin=null,  intSupply=null;
       Double ourCost = null;
  
      
       Boolean valid;
       
       if(productName == null | productName.length() == 0){
           error  += ("Part is empty");
       }
       try {
            intMin = Integer.parseInt(partMin);
        } catch (Exception e) {
            error += ("Minimum must be numeric\n");
        }
        
        try {
            intMax = Integer.parseInt(productMax);
        } catch (Exception e) {
            error += ("Maximum must be numeric\n");
        }
        
        if(intMin != null && intMin < 0) {
            error += ("Minimum cannot be negative\n");
        }
        
        if(intMin != null && intMax != null && intMin > intMax) {
            error += ("Minimum must be less than maximum\n");
        }
        
        try {
            intSupply = Integer.parseInt(productSupply);
            
            if(intMin != null && intMax != null && intSupply < intMin && intSupply > intMax) {
               error += ("Inventory must be between minimum and maximum\n"); 
            }
        } catch (Exception e) {
            error += ("Inventory must be numeric\n");
        }
        
        try {
            ourCost = Double.parseDouble(productCost);
            
            if(ourCost <= 0) {
               error += ("Price must be greater than 0\n"); 
            }
        } catch (Exception e) {
            error += ("Price must be numeric\n");
        }
        
        try {
            if (this.toggle.getSelectedToggle().equals(this.inhousePart)){
                //intMachineId
                try {
                    Integer.parseInt(machineID);
                } catch (Exception e) {
                    error += ("Machine ID must be numeric\n");
                }
            } else if (this.toggle.getSelectedToggle().equals(this.outsourcedPart)) {
                if(companyName == null || companyName.length()== 0) {
                    error += ("Company Name is blank\n");
                }
            }    
        } catch(Exception e) {
           error += ("Part type of In-House or Outsourced must be selected\n"); 
        }
        
        if (error.length() > 0) {
            error += ("\nFix the listed errors and save again");
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Part Validation Error");
            alert.setHeaderText("Error");
            alert.setContentText(error);
            alert.showAndWait();
            valid = false;
        } else {
            valid = true;
        }
        
        return valid;
    
        
    }
    
}
