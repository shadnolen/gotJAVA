/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import Model.Parts;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author shadn
 */
public class MainScreenController implements Initializable {
    
    private Label label;
    @FXML
    private TableView<Parts> tableView;
    @FXML
    private TableColumn<?, ?> firstNameCoumn;
    
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField emailField;
    
    @FXML
    protected void addPerson(ActionEvent event){
        ObservableList<Parts> partsList = tableView.getItems();
        partsList.add(new Parts(firstNameField.getText(),lastNameField.getText(),emailField.getText()));
        
        firstNameField.setText(" ");
        lastNameField.setText(" ");
        emailField.setText(" ");
        
    }
    
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
