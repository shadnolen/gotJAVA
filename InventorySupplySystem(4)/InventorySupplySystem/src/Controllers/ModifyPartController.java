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
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
public class ModifyPartController implements Initializable {

    Supply supply;
    Part part;

    @FXML
    private RadioButton inHouseRadio;
    @FXML
    private RadioButton outSourcedRadio;
    @FXML
    private Label companyLabel;
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField price;
    @FXML
    private TextField count;
    @FXML
    private TextField min;
    @FXML
    private TextField max;
    @FXML
    private TextField company;


    public ModifyPartController(Supply supply, Part part) {
        this.supply = supply;
        this.part = part;
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param resource
     */
    @Override
    public void initialize(URL url, ResourceBundle resource) {
        setData();
    }

    private void setData() {

        if (part instanceof InHouse) {

            InHouse part1 = (InHouse) part;
            inHouseRadio.setSelected(true);
            companyLabel.setText("Machine ID");
            this.name.setText(part1.getName());
            this.id.setText((Integer.toString(part1.getPartID())));
            this.count.setText((Integer.toString(part1.getInStock())));
            this.price.setText((Double.toString(part1.getPrice())));
            this.min.setText((Integer.toString(part1.getMin())));
            this.max.setText((Integer.toString(part1.getMax())));
            this.company.setText((Integer.toString(part1.getMachineID())));

        }

        if (part instanceof OutSourced) {

            OutSourced part2 = (OutSourced) part;
            outSourcedRadio.setSelected(true);
            companyLabel.setText("Company Name");
            this.name.setText(part2.getName());
            this.id.setText((Integer.toString(part2.getPartID())));
            this.count.setText((Integer.toString(part2.getInStock())));
            this.price.setText((Double.toString(part2.getPrice())));
            this.min.setText((Integer.toString(part2.getMin())));
            this.max.setText((Integer.toString(part2.getMax())));
            this.company.setText(part2.getCompanyName());
        }
    }

    @FXML
    private void clearTextField(MouseEvent event
    ) {
        Object source = event.getSource();
        TextField field = (TextField) source;
        field.setText("");
    }

    @FXML
    private void selectInHouse(MouseEvent event
    ) {
        companyLabel.setText("Machine ID");

    }

    @FXML
    private void selectOutSourced(MouseEvent event
    ) {
        companyLabel.setText("Company Name");

    }

    @FXML
    private void idDisabled(MouseEvent event
    ) {
    }

    @FXML
    private void cancelModifyPart(MouseEvent event
    ) {
        boolean cancel = cancel();
        if (cancel) {
            mainScreen(event);
        } else {
        }
    }

    @FXML
    private void saveModifyPart(MouseEvent event
    ) {
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
            } else if (outSourcedRadio.isSelected() && company.getText().trim().isEmpty()) {
                errorWindow(1, company);
                return;
            } else if (inHouseRadio.isSelected() && !company.getText().matches("[0-9]*")) {
                errorWindow(1, company);
                return;

            } else if (inHouseRadio.isSelected() & part instanceof InHouse) {
                updateItemInHouse();

            } else if (inHouseRadio.isSelected() & part instanceof OutSourced) {
                updateItemInHouse();
            } else if (outSourcedRadio.isSelected() & part instanceof OutSourced) {
                updateItemOutSourced();
            } else if (outSourcedRadio.isSelected() & part instanceof InHouse) {
                updateItemOutSourced();
            }

        } else {
            errorWindow(2, null);
            return;

        }
        mainScreen(event);
    }

    private void updateItemInHouse() {
        supply.updatePart(new InHouse(Integer.parseInt(id.getText().trim()), name.getText().trim(),
                Double.parseDouble(price.getText().trim()), Integer.parseInt(count.getText().trim()),
                Integer.parseInt(min.getText().trim()), Integer.parseInt(max.getText().trim()), Integer.parseInt(company.getText().trim())));
    }

    private void updateItemOutSourced() {
        supply.updatePart(new OutSourced(Integer.parseInt(id.getText().trim()), name.getText().trim(),
                Double.parseDouble(price.getText().trim()), Integer.parseInt(count.getText().trim()),
                Integer.parseInt(min.getText().trim()), Integer.parseInt(max.getText().trim()), company.getText().trim()));
    }

    private void errorWindow(int code, TextField field) {
        fieldError(field);

        switch (code) {
            case 1:
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Field is empty!");
                    alert.showAndWait();
                    break;
                }
            case 2:
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Need to select In House or OutSourced!");
                    alert.showAndWait();
                    break;
                }
            case 3:
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Invaild format!");
                    alert.showAndWait();
                    break;
                }
            case 4:
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Name is supplyalid!");
                    alert.showAndWait();
                    break;
                }
            case 5:
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Value can't be negative!!");
                    alert.showAndWait();
                    break;
                }
            case 6:
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Supply can't be lower than min!");
                    alert.showAndWait();
                    break;
                }
            case 7:
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Supply can't be greater than max!");
                    alert.showAndWait();
                    break;
                }
            case 8:
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Min can't be higher than max!");
                    alert.showAndWait();
                    break;
                }
            default:
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error adding part");
                    alert.setHeaderText("Reason:");
                    alert.setContentText("Unknown error!");
                    alert.showAndWait();
                    break;
                }
        }
    }

    private void resetFieldsStyle() {
        name.setStyle("-fx-border-color: purple");
        count.setStyle("-fx-border-color: purple");
        price.setStyle("-fx-border-color: purple");
        min.setStyle("-fx-border-color: purple");
        max.setStyle("-fx-border-color: purple");
        company.setStyle("-fx-border-color: purple");

    }

    private void fieldError(TextField field) {
        if (field == null) {
            // do nothing
        } else {
            field.setStyle("-fx-background-color: red");
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
            if (field.getText().trim().isEmpty() || field.getText().trim() == null) {
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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancel");
        alert.setHeaderText("Are you sure you want to cancel?");
        alert.setContentText("Click ok to confirm");

        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }

}
