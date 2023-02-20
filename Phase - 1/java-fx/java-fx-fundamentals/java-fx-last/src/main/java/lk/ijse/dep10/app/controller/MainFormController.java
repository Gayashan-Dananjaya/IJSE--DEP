package lk.ijse.dep10.app.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainFormController {

    public Button btnListViewExercise;
    public Label lblTitle;
    @FXML
    private Button btnComboBox;

    @FXML
    private Button btnListView;

    @FXML
    private Button btnSceneSceneCommunication;

    @FXML
    private Button btnTableView;

    @FXML
    void btnListViewOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();

        URL url = this.getClass().getResource("/view/ListViewScene.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        AnchorPane root = fxmlLoader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("List View Demo");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(btnListView.getScene().getWindow());
        stage.show();
        stage.setResizable(false);
        stage.centerOnScreen();

    }

    @FXML
    void btnComboBoxOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();

        URL url = this.getClass().getResource("/view/ComboBoxScene.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        AnchorPane root = fxmlLoader.load();


        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(btnComboBox.getScene().getWindow());
        stage.setTitle("Combo Box Demo");
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void btnSceneSceneCommunicationOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
//        stage.setScene(new Scene(new FXMLLoader(this.getClass().getResource("/view/SettingsView.fxml")).load()));

        URL url = this.getClass().getResource("/view/SettingsView.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        AnchorPane root = fxmlLoader.load();

        SimpleStringProperty observable2 = new SimpleStringProperty(lblTitle.getText());
        lblTitle.textProperty().bind(observable2);
        SettingsViewControler ctrl = fxmlLoader.getController();
        ctrl.initData(observable2);

        stage.setScene(new Scene(root));
        stage.setTitle("Settings Demo");
        stage.centerOnScreen();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(btnSceneSceneCommunication.getScene().getWindow());
        stage.show();
    }

    @FXML
    void btnTableViewOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(new FXMLLoader(this.getClass().getResource("/view/TableViewScene.fxml")).load()));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(btnTableView.getScene().getWindow());
        stage.show();
        stage.centerOnScreen();
        stage.setTitle("Table View Demo");

    }

    public void btnListViewExerciseOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();

        URL url = this.getClass().getResource("/view/ListViewExercise.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        AnchorPane root = fxmlLoader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("List View Exercise");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(btnListView.getScene().getWindow());
        stage.show();
        stage.setMaximized(true);
//        stage.setResizable(false);
        stage.centerOnScreen();
    }
}
