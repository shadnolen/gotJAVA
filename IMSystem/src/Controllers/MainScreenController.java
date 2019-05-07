/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Parts;
import Models.Products;
import static Models.Supply.getPartsList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class MainScreenController implements Initializable {

    @FXML
    private TextField partSearch;
    @FXML
    private TableView<Parts> partsTable;
    @FXML
    private TableColumn<Parts, Integer> IDColumn;
    @FXML
    private TableColumn<Parts, String> NameColumn;
    @FXML
    private TableColumn<Parts, Integer> SupplyColumn;
    @FXML
    private TableColumn<Parts, Double> CostColumn;
    @FXML
    private TextField proSearch;
    @FXML
    private TableView<Products> productTable;
    @FXML
    private TableColumn<Products, Integer> proIDColumn;
    @FXML
    private TableColumn<Products, String> proNameColumn;
    @FXML
    private TableColumn<Products, Integer> proSupplyColumn;
    @FXML
    private TableColumn<Products, Double> proCostColumn;
    
    private static int index = -1;
    
    public static int indexS(){
        return index;
    }
   
    
// Reuseable Code 
        @FXML   
    void pageLoadPart(ActionEvent event, Parts part) throws IOException{
          //Page Load
     FXMLLoader fxLoad = new FXMLLoader();
    fxLoad.setLocation(getClass().getResource("/Views/Parts.fxml"));
    Parent parent = fxLoad.load();
    
    //Setting Stage&Scene
    Scene scene = new Scene(parent);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    
    PartsController partController = fxLoad.getController();
    partController.paging();
    
    //Hiding  the comp
    stage.hide();
    stage.setScene(scene);
    stage.show();
    }
    
    
    @FXML   
    void pageLoadPart(ActionEvent event) throws IOException{
        
        //Page Load
     FXMLLoader fxLoad = new FXMLLoader();
    fxLoad.setLocation(getClass().getResource("/Views/Parts.fxml"));
    Parent parent = fxLoad.load();
    
    //Setting Stage&Scene
    Scene scene = new Scene(parent);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    
    PartsController partController = fxLoad.getController();
    partController.paging();
    
    //Hiding  the comp
    stage.hide();
    stage.setScene(scene);
    stage.show();
    }
    
            @FXML   
    void pageLoadPro(ActionEvent event, Products products) throws IOException{
         //Page Load
     FXMLLoader fxLoad = new FXMLLoader();
    fxLoad.setLocation(getClass().getResource("/Views/Products.fxml"));
    Parent parent = fxLoad.load();
    
    //Setting Stage&Scene
    Scene scene = new Scene(parent);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    
    PartsController partController = fxLoad.getController();
    partController.paging();
    
    //Hiding  the comp
    stage.hide();
    stage.setScene(scene);
    stage.show();
    }
    
    @FXML   
    void pageLoadPro(ActionEvent event) throws IOException{
            //Page Load
     FXMLLoader fxLoad = new FXMLLoader();
    fxLoad.setLocation(getClass().getResource("/Views/Products.fxml"));
    Parent parent = fxLoad.load();
    
    //Setting Stage&Scene
    Scene scene = new Scene(parent);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    
    PartsController partController = fxLoad.getController();
    partController.paging();
    
    //Hiding  the comp
    stage.hide();
    stage.setScene(scene);
    stage.show();
    }
    
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void partSearch(ActionEvent event) {
    }

    @FXML
    private void addPart(ActionEvent event) throws IOException {
        pageLoadPart(event);
    }

    @FXML
    private void partMod(ActionEvent event) throws IOException{
        
        Parts partMod = partsTable.getSelectionModel().getSelectedItem();
        index = getPartsList().indexOf(partMod);
        
        if(partMod != null){
            pageLoadPart(event);
        }else{
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.initModality(Modality.NONE);
    alert.setTitle("No Part Selected ");
    alert.setHeaderText("You need to select something, yo!");
    alert.showAndWait();
        }
    }

    @FXML
    private void partDelete(ActionEvent event) {
        Parts partDel = partsTable.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void searchProducts(ActionEvent event) {
    }

    @FXML
    private void proAdd(ActionEvent event) throws IOException{
        pageLoadPro(event);
    }

    @FXML
    private void proMod(ActionEvent event) {
    }

    @FXML
    private void proDelete(ActionEvent event) {
    }

    @FXML
    private void exit(ActionEvent event) {
    }
    
}
