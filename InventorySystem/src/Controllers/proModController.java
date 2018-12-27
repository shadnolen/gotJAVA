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

    
    
    private void mainIMS(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean cancel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


