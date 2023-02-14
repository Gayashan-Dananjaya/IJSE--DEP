package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainFormController {

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
    void btnComboBoxOnAction(ActionEvent event) {

    }

    @FXML
    void btnSceneSceneCommunicationOnAction(ActionEvent event) {

    }

    @FXML
    void btnTableViewOnAction(ActionEvent event) {

    }

}
