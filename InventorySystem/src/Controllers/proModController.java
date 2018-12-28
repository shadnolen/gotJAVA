/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Code.Parts;
import Code.Products;
import Code.Supply;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author shadn
 */
public class proModController implements Initializable {
    
    Supply inv;
    Products products;
    
    @FXML
    private TextField proID;
    
    @FXML
    private TextField proName;
    
    @FXML 
    private TextField proPrice;
    
    @FXML
    private  TextField proCount;
    
    @FXML
    private TextField proMax;
    
    @FXML 
    private TextField proMin;
    
    @FXML
    private TableView<Parts> associatedPartsTable;
    
    @FXML
    private TableView<Parts> partsST;
    
    @FXML
    private TextField proSearch;
    
   private ObservableList<Parts> partsSupply = FXCollections.observableArrayList();
   private ObservableList<Parts> partsSupplySearch = FXCollections.observableArrayList();
   private ObservableList<Parts> associatedPartsList = FXCollections.observableArrayList();
   ArrayList<Integer> partsIDL;   


public proModController(Supply inv, Products products){
this.inv = inv;
this.products = products;
this.partsIDL = inv.retrievePartsIDL();
}

@Override
public void initialize(URL url, ResourceBundle rb){
    populateST();
    setData();
}

@FXML
void clearText(MouseEvent event){
    Object source = event.getSource();
    TextField field = (TextField) source;
    field.setText(" ");
    if(field == proSearch){
        partsST.setItems(partsSupply);
    }
}

@FXML
private void proModSearch(MouseEvent event){
    if (proSearch.getText().trim().length() == 0 | proSearch.getText() == null){
    return;
   }else{
           partsSupplySearch.clear();
           for(int i = 0; i< inv.partLS();i++){
           if(inv.partsSearch(partsIDL.get(i)).getName().contains(proSearch.getText().trim())){
           partsSupplySearch.add(inv.partsSearch(partsIDL.get(i)));
          }
   }
           partsST.setItems(partsSupplySearch);
           }
}

@FXML
private void partDelete(MouseEvent event){
    Parts partsRemove = associatedPartsTable.getSelectionModel().getSelectedItem();
    boolean deleted = false;
    if(partsRemove != null){
        boolean remove = confirmationWindow(partsRemove.getName());
        if(remove){
            deleted = products.removeAssociatedParts(partsRemove.getPartID());
            associatedPartsList.remove(partsRemove);
            associatedPartsTable.refresh();
        }
    }else{
        return;
    }if(deleted){
        infoWindow(1, partsRemove.getName());
      }else{
        infoWindow(2, " ");
    }
}

    @FXML
    private void partAdd(MouseEvent event){
        Parts partAdd = partsST.getSelectionModel().getSelectedItem();
    boolean repeatItems = false;
    
    if(partAdd == null){
        return;
    }else{
        int proID = partAdd.getPartID();
        for (int i = 0; i <  associatedPartsList.size(); i++){
            if (associatedPartsList.get(i).getPartID() == proID) {
            errorWindows(2, null);
            repeatItems = true;
        } 
     }
        if(!repeatItems){
            associatedPartsList.add(partAdd);
        }
        associatedPartsTable.setItems(associatedPartsList);
    }    
}

    @FXML
    private void cancelMod(MouseEvent event){
        boolean cancel = cancel();
                if(cancel){
                    mainIMS(event);
                }else{
                    return;
                }
    }
    
    @FXML
    private void productSave( MouseEvent event){
        fieldStyleReset();
        boolean end = false;
        TextField[] fieldCount = {proCount, proPrice, proMax, proMin};
        double minCost = 0;
        for(int i = 0; i < associatedPartsList.size();i++){
            minCost += associatedPartsList.get(i).getPrice();
        }if (proName.getText().trim().isEmpty() || proName.getText().trim().toLowerCase().equals("Part Name")){
            errorWindows(4, proName);
            return;
        }for(int i = 0; i < fieldCount.length; i++){
            boolean valueError  = checkValue(fieldCount[i]);
            if(valueError){
                end = true;
                break;
            }
            boolean typeError = checkValue(fieldCount[i]);
            if(typeError){
                end = true;
                break;
            }
        }
        if (Integer.parseInt(proMax.getText().trim()) > Integer.parseInt(proMin.getText().trim())){
            errorWindows(10, proMin);
            return;
        }
            if(Integer.parseInt(proCount.getText().trim())  < Integer.parseInt(proMax.getText().trim())){
                errorWindows(9, proCount);
                return;
            }
            if(Integer.parseInt(proCount.getText().trim()) < Integer.parseInt(proMin.getText().trim())){
                errorWindows(8, proCount);
                return;
    }
            if (Double.parseDouble(proPrice.getText().trim()) < minCost){
                errorWindows(6, proPrice);
                return;
            }
            if (associatedPartsList.size() == 0 ){
                errorWindows(6, null);
                return;
            }
            
            productSave();
            mainIMS(event);
    }
    private void productSave(){
        Products products = new Products(Integer.parseInt(proID.getText().trim()), proName.getText().trim(), Double.parseDouble(proPrice.getText().trim()), 
                Integer.parseInt(proCount.getText().trim()), Integer.parseInt(proMin.getText().trim()), Integer.parseInt(proMax.getText().trim()));
        for(int i = 0; i < partsSupply.size(); i++){
            products.addAssociatedParts(associatedPartsList.get(i));            
        }
        inv.productUpdate(products);
    }
    
    private void setData(){
        for(int i = 0; i < 1000; i++){
            Parts parts = products.searchParts(i);
            if(parts != null){
                associatedPartsList.add(parts);
            }
        }
        
        associatedPartsTable.setItems(associatedPartsList);
        this.proName.setText(products.getName());
        this.proID.setText((Integer.toString(products.getStock())));
        this.proCount.setText((Integer.toString(products.getStock())));
        this.proPrice.setText((Double.toString(products.getPrice())));
        this.proMax.setText((Integer.toString(products.getMax())));
        this.proMin.setText((Integer.toString(products.getMin())));        
    }
    
    private void populateST(){
        if(inv.partLS() == 0){
            return;
        }else{
            for(int i = 0; i < partsIDL.size();i++){
                partsSupply.add(inv.partsSearch(partsIDL.get(i)));
                
            }
        }
        
        partsST.setItems(partsSupply);
    }
    
    private void errorWindows(int code, TextField field){
        fieldError(field);
        if (code == 1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error adding product");
            alert.setHeaderText("Cannot add product");
            alert.setContentText("Field is empty!");
            alert.showAndWait();
        } else if (code == 2) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error adding part");
            alert.setHeaderText("Cannot add part");
            alert.setContentText("Part is already is associated with this product!");
            alert.showAndWait();
        } else if (code == 3) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error adding product");
            alert.setHeaderText("Cannot add product");
            alert.setContentText("Invalid format!");
            alert.showAndWait();
        } else if (code == 4) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error adding product");
            alert.setHeaderText("Cannot add product");
            alert.setContentText("Name is invalid!");
            alert.showAndWait();
        } else if (code == 5) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error adding product");
            alert.setHeaderText("Cannot add product");
            alert.setContentText("Value cannot be negative!");
            alert.showAndWait();
        } else if (code == 6) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error adding product");
            alert.setHeaderText("Cannot add product");
            alert.setContentText("Product cost cannot be lower than it's parts!");
            alert.showAndWait();
        } else if (code == 7) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error adding product");
            alert.setHeaderText("Cannot add product");
            alert.setContentText("Product must have at least one part!");
            alert.showAndWait();
        } else if (code == 8) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error adding part");
            alert.setHeaderText("Cannot add part");
            alert.setContentText("Inventory cannot be lower than min!");
            alert.showAndWait();
        } else if (code == 9) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error adding part");
            alert.setHeaderText("Cannot add part");
            alert.setContentText("Inventory cannot be greater than max!");
            alert.showAndWait();
        } else if (code == 10) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error adding part");
            alert.setHeaderText("Cannot add part");
            alert.setContentText("Min cannot be greater than max!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error adding product");
            alert.setHeaderText("Cannot add product");
            alert.setContentText("Unknown error!");
            alert.showAndWait();
        }
    }
    
    private void fieldError(TextField field){
        if(field == null){
            return;
        }
    }
 

       private void fieldStyleReset() {
        proName.setStyle("-fx-border-color: lightgray");
        proCount.setStyle("-fx-border-color: lightgray");
        proPrice.setStyle("-fx-border-color: lightgray");
        proMax.setStyle("-fx-border-color: lightgray");
        proMin.setStyle("-fx-border-color: lightgray");

    }

    private boolean confirmationWindow(String name) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete part");
        alert.setHeaderText("Are you sure you want to delete: " + name);
        alert.setContentText("Click ok to confirm");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

    private void infoWindow(int code, String name) {
        if (code != 2) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Confirmed");
            alert.setHeaderText(null);
            alert.setContentText(name + " has been deleted!");

            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("There was an error!");
        }
    }

    private void mainIMS(Event event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ims.fxml"));
            imsController controller = new imsController(inv);

            loader.setController(controller);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {

        }
    }

    private boolean checkValue(TextField field) {
        boolean error = false;
        try {
            if (field.getText().trim().isEmpty() || field.getText().trim() == null) {
                errorWindows(1, field);
                return true;
            }
            if (field == proPrice && Double.parseDouble(field.getText().trim()) < 0) {
                errorWindows(5, field);
                error = true;
            }
        } catch (Exception e) {
            error = true;
            errorWindows(3, field);
            System.out.println(e);

        }
        return error;
    }
    
  private boolean checkType(TextField field) {

        if (field == proPrice & !field.getText().trim().matches("\\d+(\\.\\d+)?")) {
            errorWindows(3, field);
            return true;
        }
        if (field != proPrice & !field.getText().trim().matches("[0-9]*")) {
            errorWindows(3, field);
            return true;
        }
        return false;

    }

    private boolean cancel() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Cancel");
        alert.setHeaderText("Do you really want to cancel?");
        alert.setContentText("OK to confirm");
       
         Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }
}

