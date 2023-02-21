package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainFormController {

    @FXML
    private Button btnRemove;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblId;

    @FXML
    private Label lblName;

    @FXML
    private Label lblPicture;

    @FXML
    private Label lblTitle;

    @FXML
    private TextField txtId;

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        System.out.println("Successfully Removed");
        txtId.setVisible(!(txtId.isVisible()));
        lblId.setVisible(!(lblId.isVisible()));
    }

}
