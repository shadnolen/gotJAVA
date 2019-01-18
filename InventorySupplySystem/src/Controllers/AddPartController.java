/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.InHouse;
import Model.Supply;
import Model.OutSourced;
import Model.Part;


import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shadn
 */
public class AddPartController implements Initializable {

    Supply supply;

    //Field linking FXML
  
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField count;
    @FXML
    private TextField price;
    @FXML
    private TextField max;
    @FXML
    private TextField min;
    @FXML
    private TextField company;
    @FXML
    private Label companyLabel;    
    @FXML
    private RadioButton inHouseRadio;
    @FXML
    private RadioButton outSourcedRadio;
    
    public AddPartController(Supply supply) {
        this.supply = supply;
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param resource
     */
    @Override
    public void initialize(URL url, ResourceBundle resource) {
        generatePartID();
        resetFields();
    }

      private void addInHouse() {

        supply.addPart(new InHouse(Integer.parseInt(id.getText().trim()), name.getText().trim(),
                Double.parseDouble(price.getText().trim()), Integer.parseInt(count.getText().trim()),
                Integer.parseInt(min.getText().trim()), Integer.parseInt(max.getText().trim()), (Integer.parseInt(company.getText().trim()))));

    }

    private void addOutSourced() {
        supply.addPart(new OutSourced(Integer.parseInt(id.getText().trim()), name.getText().trim(),
                Double.parseDouble(price.getText().trim()), Integer.parseInt(count.getText().trim()),
                Integer.parseInt(min.getText().trim()), Integer.parseInt(max.getText().trim()), company.getText().trim()));

    } 
     private boolean generateNum(Integer num) {
        Part match = supply.lookUpPart(num);
        return match != null;
    }

    private void generatePartID() {
        boolean match;
        Random randomNum = new Random();
        Integer num = randomNum.nextInt(1000);

        if (supply.partListSize() == 0) {
            id.setText(num.toString());

        }
        if (supply.partListSize() == 1000) {
            errorWindow(3, null);
        } else {
            match = generateNum(num);

            if (match == false) {
                id.setText(num.toString());
            } else {
                generatePartID();
            }
        }
    }

 

    @FXML
    private void clearTextField(MouseEvent event) {
        Object source = event.getSource();
        TextField field = (TextField) source;
        field.setText("");
    }

    @FXML
    private void selectInHouse(MouseEvent event) {
        companyLabel.setText("Machine ID");
        company.setText("Machine Name");
    }

    @FXML
    private void selectOutSourced(MouseEvent event) {
        companyLabel.setText("Company Name");
        company.setText("Company Name");
    }

    @FXML
    private void idDisabled(MouseEvent event) {
    }

    @FXML
    private void cancelAddPart(MouseEvent event) {
        boolean cancel = cancel();
        if (cancel) {
            mainScreen(event);
        } else {
        }
    }
    
      private void resetFields() {
        name.setText("Part Name");
        count.setText("supply Count");
        price.setText("Part Price");
        min.setText("Min");
        max.setText("Max");
        company.setText("Machine ID");
        companyLabel.setText("Machine ID");
        inHouseRadio.setSelected(true);
    }

    @FXML
    private void saveAddPart(MouseEvent event) {
        resetFieldsStyle();
        boolean end = false;
        TextField[] fieldCount = {count, price, min, max};
        if (inHouseRadio.isSelected() || outSourcedRadio.isSelected()) {
            for (TextField fieldCount1 : fieldCount) {
                boolean valueError = checkValue(fieldCount1);
                if (valueError) {
                    end = true;
                    break;
                }
                boolean typeError = checkType(fieldCount1);
                if (typeError) {
                    end = true;
                    break;
                }
            }
            if (name.getText().trim().isEmpty() || name.getText().trim().toLowerCase().equals("part name")) {
                errorWindow(4, name);
                return;
            }
            if (Integer.parseInt(min.getText().trim()) > Integer.parseInt(max.getText().trim())) {
                errorWindow(8, min);
                return;
            }
            if (Integer.parseInt(count.getText().trim()) < Integer.parseInt(min.getText().trim())) {
                errorWindow(6, count);
                return;
            }
            if (Integer.parseInt(count.getText().trim()) > Integer.parseInt(max.getText().trim())) {
                errorWindow(7, count);
                return;
            }

            if (end) {
                return;
            } else if (company.getText().trim().isEmpty() || company.getText().trim().toLowerCase().equals("company name")) {
                errorWindow(3, company);
                return;

            } else if (inHouseRadio.isSelected() && !company.getText().trim().matches("[0-9]*")) {
                errorWindow(3, company);
                return;
            } else if (inHouseRadio.isSelected()) {
                addInHouse();

            } else if (outSourcedRadio.isSelected()) {
                addOutSourced();

            }

        } else {
            errorWindow(2, null);
            return;

        }
        mainScreen(event);
    }

      private void errorWindow(int code, TextField field) {
        fieldError(field);

        switch (code) {
            case 1:
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Field is empty!");
                    alert.showAndWait();
                    break;
                }
            case 2:
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Ooops, you forgot to select In House/OutSourced!");
                    alert.showAndWait();
                    break;
                }
            case 3:
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("supplyalid format!");
                    alert.showAndWait();
                    break;
                }
            case 4:
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Name is supplyalid!");
                    alert.showAndWait();
                    break;
                }
            case 5:
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Value can't be negative!");
                    alert.showAndWait();
                    break;
                }
            case 6:
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Supply can't be lower than min!");
                    alert.showAndWait();
                    break;
                }
            case 7:
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Supply can't be greater than max!");
                    alert.showAndWait();
                    break;
                }
            case 8:
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Min can't be greater than max!");
                    alert.showAndWait();
                    break;
                }
            default:
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Unknown error!");
                    alert.showAndWait();
                    break;
                }
        }
    }

    private void resetFieldsStyle() {
        name.setStyle("-fx-border-color: lightgray");
        count.setStyle("-fx-border-color: lightgray");
        price.setStyle("-fx-border-color: lightgray");
        min.setStyle("-fx-border-color: lightgray");
        max.setStyle("-fx-border-color: lightgray");
        company.setStyle("-fx-border-color: lightgray");

    }

    private void fieldError(TextField field) {
        if (field == null) {
        } else {
            field.setStyle("-fx-border-color: red");
        }
    }

    private void mainScreen(Event event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/MainScreen.fxml"));
            MainScreenController controller = new MainScreenController(supply);

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
            if (field.getText().trim().isEmpty() | field.getText().trim() == null) {
                errorWindow(1, field);
                return true;
            }
            if (field == price && Double.parseDouble(field.getText().trim()) < 0) {
                errorWindow(5, field);
                error = true;
            }
        } catch (NumberFormatException e) {
            error = true;
            errorWindow(3, field);
            System.out.println(e);

        }
        return error;
    }

    private boolean checkType(TextField field) {

        if (field == price & !field.getText().trim().matches("\\d+(\\.\\d+)?")) {
            errorWindow(3, field);
            return true;
        }
        if (field != price & !field.getText().trim().matches("[0-9]*")) {
            errorWindow(3, field);
            return true;
        }
        return false;

    }

    private boolean cancel() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Cancel");
        alert.setHeaderText("Are you sure you want to cancel?");
        alert.setContentText("Click ok to confirm");

        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }

}
