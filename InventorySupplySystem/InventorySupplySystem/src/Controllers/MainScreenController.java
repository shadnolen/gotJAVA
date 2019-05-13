/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DRY.PartLoad;
import DRY.ProLoad;
import DRY.NoSelect;


import Model.Part;
import Model.Product;
import Model.Supply;


import static Model.Supply.getPartList;
import static Model.Supply.getProductList;
import static Model.Supply.partRemove;
import static Model.Supply.proRemove;


import java.io.IOException;
import java.util.Optional;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class MainScreenController {

      /*** PART TABLE ***/
    @FXML
    private TableView<Part> partTable;

    @FXML    private TableColumn<Part, Integer> ColumnID;

    @FXML    private TableColumn<Part, String> ColumnName;

    @FXML    private TableColumn<Part, Integer> ColumnSupply;

    @FXML    private TableColumn<Part, Double> ColumnPrice;

    @FXML    private TextField partSearch;

    /*** PRODUCT TABLE ***/
    @FXML
    private TableView<Product> productTable;

    @FXML    private TableColumn<Product, Integer> ColumnProID;

    @FXML    private TableColumn<Product, String> ColumnProName;

    @FXML    private TableColumn<Product, Integer> ColumnProSupply;

    @FXML    private TableColumn<Product, Double> ColumnProPrice;

    @FXML    private TextField productSearch;
    
    private static int index;
    
    public static int selectedIndex() {
        return index;
    }
    
  /*** DRY LOADERS ***/ 
 PartLoad pl = new PartLoad();
 ProLoad pro = new ProLoad();
 NoSelect ns = new NoSelect();

   
   
    /*** PARTS ***/
    @FXML
    void partAdd(ActionEvent event) throws IOException {
        pl.partPage(event);
    }

     @FXML
    void partModify(ActionEvent event) throws IOException {
        Part partSelect = partTable.getSelectionModel().getSelectedItem();
        index = getPartList().indexOf(partSelect);

        if(partSelect != null) {
            pl.partPage(event, partSelect);    
        } else {
            ns.noAlert();
        }
    }

    @FXML
    void partSearch(ActionEvent event) {
        /***sp = SEARCH PART ***/
        String sp = partSearch.getText();
        ObservableList partFound = Supply.partLookUp(sp);
        if(partFound.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("No Part match found");
            alert.setHeaderText("No Part found matching " + sp); 
            alert.showAndWait();
        } else {
            partTable.setItems(partFound);
        }
    }
    
    @FXML
    void partDelete(ActionEvent event) {
        Part partSelect = partTable.getSelectionModel().getSelectedItem();
        
        if(partSelect != null) {            
            /***pf = PART FOUND ***/
            Boolean pf = false;
      
            /*** ITERATE THOUGH LIST O(n) ALGORITHM WOULD BE SLOW IF HUGE ***/
            for (int i = 0; i < Supply.getProductList().size(); i++) {
                ObservableList<Part> products = Supply.getProductList().get(i).getProductParts();
                /*** MORE ITERATING ***/
                for(int x = 0; x < products.size(); x++) {
                    if(products.get(x).equals(partSelect)) {
                       pf = true; 
                    }
                }
            } 
            
            if(pf) {
                ns.associatedObject();
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.initModality(Modality.NONE);
                alert.setTitle("Part Delete Confirmation");
                alert.setHeaderText("Confirm delete");
                alert.setContentText("Are you sure you want to delete " + partSelect.getName() + "?");
               
                Optional<ButtonType> delete = alert.showAndWait();
                if (delete.get() == ButtonType.OK) {
                    partRemove(partSelect);
                    partTableView();
                }    
            }            
        } else {
           ns.noAlert();
        }
    }
    /*** END PARTS ***/
    
    /*** PRODUCTS ***/
       @FXML
    void proAdd(ActionEvent event) throws IOException {
        pro.proPage(event);
    }
    
        @FXML
    void proModify(ActionEvent event) throws IOException {
        Product proSelect = productTable.getSelectionModel().getSelectedItem();
        index = getProductList().indexOf(proSelect);

        if(proSelect != null) {
            pro.proPage(event, proSelect);    
        } else {
            ns.noAlert();
        }
    }
    
       @FXML
    void productSearch(ActionEvent event) {
          /***sp = SEARCH PRODUCT ***/
        String sp = productSearch.getText();
        ObservableList proFound = Supply.proLookUp(sp);
        if(proFound.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("No match found");
            alert.setHeaderText("No Product found matching " + sp); 
            alert.showAndWait();
        } else {
            productTable.setItems(proFound);
        }
    }

    @FXML
    void deleteProduct(ActionEvent event) {     
        Product proSelect = productTable.getSelectionModel().getSelectedItem();
        
        if(proSelect != null) {
            if(proSelect.getProductParts().isEmpty()) {
                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.initModality(Modality.NONE);
                alert.setTitle("Product Delete Confirmation");
                alert.setHeaderText("Confirm delete");
                alert.setContentText("Delete " + proSelect.getName() + "?");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.OK) {
                    proRemove(proSelect);
                    partTableView();
                }    
            } else {
                ns.associatedObject();
            }
        } else {
            ns.noAlert();
        }
    }
    /***EXIT PRODUCTS ***/
    
    @FXML
    void exitProgram(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Confirm Exit");
        alert.setHeaderText("Confirm you want to exit.");
        alert.setContentText("Any unsaved changes will be LOST.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        }
    }

    public void partTableView() {
        partTable.setItems(getPartList());
    }

    public void proTableView() {
        ObservableList<Product> productItems = getProductList();
        productTable.setItems(productItems);
    }
    
    public void initialize() {
        
        ColumnID.setCellValueFactory(cellData -> cellData.getValue().partIDProperty().asObject());
        ColumnName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        ColumnSupply.setCellValueFactory(cellData -> cellData.getValue().inStockProperty().asObject());
        ColumnPrice.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        
        ColumnProID.setCellValueFactory(cellData -> cellData.getValue().productIDProperty().asObject());
        ColumnProName.setCellValueFactory(cellData -> cellData.getValue().productNameProperty());
        ColumnProSupply.setCellValueFactory(cellData -> cellData.getValue().productInStockProperty().asObject());
        ColumnProPrice.setCellValueFactory(cellData -> cellData.getValue().productPriceProperty().asObject());
        
        partTableView();
        proTableView();
    }

    public void mainLoader(Stage stage) throws IOException {
        index = 0;
        
        Parent parent = FXMLLoader.load(getClass().getResource("/Views/MainScreen.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show(); 
        
        partTableView();
        proTableView();
    }
}
