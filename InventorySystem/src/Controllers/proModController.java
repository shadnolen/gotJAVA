/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Code.Parts;
import Code.Products;
import Code.Supply;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import static jdk.nashorn.internal.objects.NativeString.search;

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
    popSearchTable();
    setData();
}

@FXML
void clearText(MouseEvent event){
    Object source = event.getSource();
    TextField field = (TextField) source;
    field.setText(" ");
    if(field == search){
        partsST.setItems(partsSupply);
    }
}

@FXML
private void proModSearch(MouseEvent event){
    if(search.getText().trim().length() = 0 | search.getText(). == null){
    return;
   }else{
           partsSupplySearch.clear();
           for(int i = 0; i< partsLS();i++){
           if(inv.partsLookUp(partsIDL.get(i)).getName().contains(search.getText().trim())){
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
        boolean remove = confirmWindow(partsRemove.getName());
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
        Parts addParts = partsST.getSelectionModel().getSelectedItem();
    boolean repeatItems = false;
    if(partAdd == null){
        return;
    }else{
        int proID = partAdd.getPartID();
        for(int i = 0; i <  associatedPartsList.size(); i++){
            if(associatedPartsList.get(i), getPartID()  == proID){
            errorWindow(2, null);
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
        boolean cancel = cancel()
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
        for(int i = 0; i < associatedPartsList;i++){
            minCost += associatedPartsList.get(i).getPrice();
        }if (name.getText().trim().isEmpty() || name.getText().trim().toLowerCase().equals("Part Name")){
            errorWindow(4, name);
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
            errorWindow(10, proMin);
            return;
        }
            if(Integer.parseInt(proCount.getText().trim())  < Integer.parseInt(proMax.getText().trim())){
                errorWindow(9, proCount);
                return;
            }
            if(Integer.parseInt(proCount.getText().trim()) < Integer.parseInt(proMin.getText().trim())){
                errorWindow(8, proCount);
                return;
    }
            if (Double.parseDouble(proPrice.getText().trim()) < minCost{
                errorWindow(6, proPrice);
                return;
            }
            if (partsSuppy.size() == 0 ){
                errorWindow(6, null);
                return;
            }
            
            productSave();
            mainIMS(event);
    }
    private void productSave(){
        Products products = new Products(Interger.parseInt(proID.getText().trim()), proName.getText().trim(), Double.parseDouble(proPrice.getText().trim()), 
                Integer.parseInt(proCount.getText().trim()), Integer.parseInt(proMin.getText().trim()), Integer.parseInt(proMax.getText().trim()));
        for(int i = 0; i < partsSupply; i++){
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
                partsSupply.add(inv.partsLookUp(partsIDL.get(i)));
                
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

    }
 

    
    
    private void mainIMS(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean cancel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


