/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Parts;
import Models.Products;
import Models.Supply;
import static Models.Supply.getPartsList;
import static Models.Supply.getProductsList;
import static Models.Supply.partRemove;
import static Models.Supply.productRemove;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
    boolean partF;
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
    void noSelect(ActionEvent event) throws IOException{
          Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.setTitle("Unable to complete task!");
                alert.setHeaderText("Nothing Selected");
                alert.showAndWait();
    }
    
   @FXML
     void indexCount(Stage stage) throws IOException{
        index = 1;
        Parent parentPage = FXMLLoader.load(getClass().getResource("/Views/MainScreen.fxml"));
        Scene scene = new Scene(parentPage);
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


    @FXML
    private void partSearch(ActionEvent event) {
         String search = partSearch.getText();
        ObservableList partFound = Supply.partLookUp(search);
        if(partFound.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("Nothing found");
            alert.setHeaderText("Could'nt find anthing matching: " + partSearch );
            alert.showAndWait();
        }
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
             noSelect(event);
        }
    }

    @FXML
    private void partDelete(ActionEvent event) {
        Parts partDel = partsTable.getSelectionModel().getSelectedItem();
      
        
        if(partDel != null){
           partF = false;
            
            for(int i = 0; i< Supply.getProductsList().size(); i++){
                ObservableList<Parts> proParts = Supply.getProductsList().get(i).getProParts();
                for(int pp = 0; pp < proParts.size(); pp++){
                    if(proParts.get(pp).equals(pp)){
                    partF = true;
                    }
                }
            }
            
            if(partF){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.setTitle("Unable to complete task!");
                alert.setHeaderText("Object is linked to a current product");
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.setTitle("Confirm to complete task!");
                alert.setHeaderText("Do you really want to DELETE: " + partF + " ?");
                Optional<ButtonType> delete = alert.showAndWait();
                
                if(delete.get() == ButtonType.OK){
                    partRemove(partDel);
                    updatePartTable();
                }
            }
        }
    }

    @FXML
    private void searchProducts(ActionEvent event) {
        String search = proSearch.getText();
        ObservableList partFound = Supply.partLookUp(search);
        if(partFound.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("Nothing found");
            alert.setHeaderText("Could'nt find anthing matching: " + proSearch );
            alert.showAndWait();
        }
    }

    @FXML
    private void proAdd(ActionEvent event) throws IOException{
        pageLoadPro(event);
    }

    @FXML
    private void proMod(ActionEvent event) throws IOException {
        Products proSelect = productTable.getSelectionModel().getSelectedItem();
        index = getProductsList().indexOf(proSelect);
        
        if(proSelect != null){
            pageLoadPro(event, proSelect);
        }else{
            noSelect(event);
        }
    }

    @FXML
    private void proDelete(ActionEvent event) {
           Products proDel = productTable.getSelectionModel().getSelectedItem();
       
        
        if(proDel != null){
           partF = false;
            
            for(int i = 0; i< Supply.getProductsList().size(); i++){
                ObservableList<Parts> proParts = Supply.getProductsList().get(i).getProParts();
                for(int pp = 0; pp < proParts.size(); pp++){
                    if(proParts.get(pp).equals(pp)){
                    partF = true;
                    }
                }
            }
            
            if(partF){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.setTitle("Unable to complete task!");
                alert.setHeaderText("Object is linked to a current product");
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.setTitle("Confirm to complete task!");
                alert.setHeaderText("Do you really want to DELETE: " + partF + " ?");
                Optional<ButtonType> delete = alert.showAndWait();
                
                if(delete.get() == ButtonType.OK){
                    productRemove(proDel);
                    updatePartTable();
                }
            }
        }
    }

    @FXML
    private void exit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle("Exit!");
        alert.setHeaderText("Did you save?");
        alert.setContentText("Any unsaved work will be lost!");
        Optional<ButtonType> exit = alert.showAndWait();
        if(exit.get() == ButtonType.OK){
            System.exit(index);
        }
        
    }

  
    
    public void updatePartTable() {
      partsTable.setItems(getPartsList());
    }
    
    public void updateProTable(){
        ObservableList<Products> proItems = getProductsList();
        productTable.setItems(proItems);
    }

        @Override
    public void initialize(URL url, ResourceBundle rb) {
     IDColumn.setCellValueFactory(cellData -> cellData.getValue().partIDP().asObject());
     NameColumn.setCellValueFactory(cellData-> cellData.getValue().partNameP());
     SupplyColumn.setCellValueFactory(cellData -> cellData.getValue().inStockP().asObject());
     CostColumn.setCellValueFactory(cellData -> cellData.getValue().partPriceP().asObject());
     
      proIDColumn.setCellValueFactory(cellData -> cellData.getValue().proIDP().asObject());
     proNameColumn.setCellValueFactory(cellData-> cellData.getValue().proNameP());
     proSupplyColumn.setCellValueFactory(cellData -> cellData.getValue().proInStock().asObject());
     proCostColumn.setCellValueFactory(cellData -> cellData.getValue().proPriceP().asObject());
     
    }    
 
    
}
