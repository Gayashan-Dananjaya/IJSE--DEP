package lk.ijse.dep10.app.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SettingsViewControler {

    @FXML
    private Button btnApply;

    @FXML
    private Label lblTitle;

    @FXML
    private TextField txt;

    private SimpleStringProperty observable;

    public void initData(SimpleStringProperty input) {
        observable = input;
        txt.setText(input.getValue());
    }

    @FXML
    void btnApplyOnAction(ActionEvent event) {
        observable.setValue(txt.getText());
    }

    @FXML
    void txtOnAction(ActionEvent event) {

    }

}
