package lk.ijse.dep10.serialization.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    @FXML
    private Button btnHelloSerialization;

    @FXML
    private Button btnManageStudents;

    @FXML
    void btnHelloSerializationOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/HelloView.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(btnHelloSerialization.getScene().getWindow());
        stage.show();
        stage.setTitle("Hello Serialization");
        stage.centerOnScreen();
    }

    @FXML
    void btnManageStudentsOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/StudentView.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(btnManageStudents.getScene().getWindow());
        stage.show();
        stage.setTitle("Manage Students");
        stage.centerOnScreen();
    }

}
