/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author shadn
 */
public class MainScreenController implements Initializable {
    
    ListView<String> testingOne;
    
  
    
    @FXML
    private Label label;
    
       
           @FXML
    public TextField list;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {


 ObservableList<String> testing = FXCollections.observableArrayList("one", "two", "three");
        
     testingOne = new ListView<>(testing);
      System.out.print(testing);
    
      //  label.setText(" "); 
//   Scene scene = new Scene(testingOne);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
        
    
    }    
    
}
