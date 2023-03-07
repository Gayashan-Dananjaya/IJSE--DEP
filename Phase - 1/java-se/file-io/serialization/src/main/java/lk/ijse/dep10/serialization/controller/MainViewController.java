package lk.ijse.dep10.serialization.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.ijse.dep10.serialization.model.inherit1.D;

import java.io.IOException;

public class MainViewController {

    public Button btnSerializationWithInheritance;
    public Button btnSerializationWithInheritance2;
    public Button btnTransient;
    public Button btnSerialVersionUID;
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

    public void btnSerializationWithInheritanceOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(new FXMLLoader(this.getClass().getResource("/view/InheritanceView.fxml")).load()));
        stage.show();
        stage.setTitle("");
        stage.centerOnScreen();
    }

    public void btnSerializationWithInheritance2OnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(new FXMLLoader(this.getClass().getResource("/view/InheritanceView2.fxml")).load()));
        stage.show();
        stage.setTitle("Serialization with externalizable with inheritance");
        stage.centerOnScreen();
    }

    public void btnTransientOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(new FXMLLoader(this.getClass().getResource("/view/TransientView.fxml")).load()));
        stage.show();
        stage.setTitle("Transient View");
        stage.setMaximized(true);
        stage.centerOnScreen();
    }

    public void btnSerialVersionUIDOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(new FXMLLoader(this.getClass().getResource("/view/SerialVersionUIDView.fxml")).load()));
        stage.show();
        stage.setTitle("Serial Version UID");
        stage.centerOnScreen();
    }
}
