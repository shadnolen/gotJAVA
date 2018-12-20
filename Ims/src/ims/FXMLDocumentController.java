/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

/**
 *
 * @author shadn
 */
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FXMLDocumentController {
    
    @FXML
    private TableView<Part> tableview;
    
    @FXML
    private TableView<Part> tableview2;


    @FXML
    private TableColumn<?, ?> PartNumber;

    @FXML
    private TableColumn<?, ?> PartName;

    @FXML
    private TableColumn<?, ?> Cost;
    
    @FXML
    private TableColumn<?, ?> PartNumber2;

    @FXML
    private TableColumn<?, ?> PartName2;

    @FXML
    private TableColumn<?, ?> Cost2;


    @FXML
    private TextField SearchTextField;
    
    @FXML
    private TextField addPartNumber;

    @FXML
    private TextField addPartName;

    @FXML
    private TextField addPartCost;


    @FXML
    public ObservableList<Part> data=FXCollections.observableArrayList();
    @FXML
    public ObservableList<Part> data2=FXCollections.observableArrayList();
    @FXML
    void SearchTable(ActionEvent event) {

    String searchItem=SearchTextField.getText();
    boolean found=false;
    try{
        int itemNumber=Integer.parseInt(searchItem);
        for(Part p: data){
            if(p.getPartNumber()==itemNumber){
                System.out.println("This is part "+ itemNumber);
                found=true;

                data2 = tableview2.getItems();
                data2.add(p);

                    PartNumber2.setCellValueFactory(new PropertyValueFactory<>("partNumber"));
                    PartName2.setCellValueFactory(new PropertyValueFactory<>("partName"));
                    Cost2.setCellValueFactory(new PropertyValueFactory<>("cost"));

                tableview2.setItems(data2);
            
            }
            
        }
            if (found==false){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error!");
            alert.setContentText("Part not found");

            alert.showAndWait();
        }
    }
    catch(NumberFormatException e){
        for(Part p: data){
            if(p.getPartName().equals(searchItem)){
                System.out.println("This is part "+p.getPartNumber());
                found=true;

               data2 = tableview2.getItems();
                data2.add(p);
  

                PartNumber2.setCellValueFactory(new PropertyValueFactory<>("partNumber"));
                PartName2.setCellValueFactory(new PropertyValueFactory<>("partName"));
                Cost2.setCellValueFactory(new PropertyValueFactory<>("cost"));
                tableview2.setItems(data2);
            }
            
        }
            if (found==false){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error");
            alert.setContentText("Part not found");

            alert.showAndWait();
        }
    }

    }
    @FXML
    void addPart(ActionEvent event) {
        data = tableview.getItems();
        String part=addPartNumber.getText();
        String name=addPartName.getText();
        String cost=addPartCost.getText();
        data.add(new Part(Integer.parseInt(part),
            name,
            Double.parseDouble(cost)
        ));
        
//        System.out.println(data);
       PartNumber.setCellValueFactory(new PropertyValueFactory<>("partNumber"));
       PartName.setCellValueFactory(new PropertyValueFactory<>("partName"));
       Cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
       tableview.setItems(data);
       addPartNumber.setText("");
       addPartName.setText("");
       addPartCost.setText("");
    }
//        PartNumber.setText("0");
//        PartName.setText("");
//        Cost.setText("0.0");   
    
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}