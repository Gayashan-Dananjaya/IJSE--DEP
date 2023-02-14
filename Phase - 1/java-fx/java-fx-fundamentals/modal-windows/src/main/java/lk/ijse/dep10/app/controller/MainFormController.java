package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainFormController {

    public Button btnModalWindow2;
    public Button btnModalWindow1;
    public Button btnOpenFileDialog;
    public Button btnSaveFileDialog;
    public Button btnDirectoryChooser;
    @FXML
    private Button btnNormalWindow;


    @FXML
    void btnNormalWindowOnAction(ActionEvent event) throws IOException {
        Stage window = new Stage();

        URL fxmlFile = this.getClass().getResource("/view/MainForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile);
        AnchorPane root = fxmlLoader.load();

        Scene scene = new Scene(root);
        window.setScene(scene);
        window.setTitle("Normal Window");
        window.show();
        window.centerOnScreen();
    }

    public void btnModalWindow1OnAction(ActionEvent actionEvent) throws IOException {
        Stage window = new Stage();

        URL fxmlFile = this.getClass().getResource("/view/EmptyForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile);
        AnchorPane root = fxmlLoader.load();

        Scene scene = new Scene(root);
        window.setScene(scene);

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Modal Window - 1");
        window.show();
        window.centerOnScreen();
    }

    public void btnModalWindow2OnAction(ActionEvent actionEvent) throws IOException {
        Stage window = new Stage();

        URL fxmlFile = this.getClass().getResource("/view/EmptyForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile);
        AnchorPane root = fxmlLoader.load();

        Scene scene = new Scene(root);
        window.setScene(scene);

        window.initModality(Modality.WINDOW_MODAL);
        window.initOwner(btnModalWindow2.getScene().getWindow());
        window.setTitle("Modal Window - 2");
        window.show();
        window.centerOnScreen();
    }


    public void btnOpenFileDialogOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open a Dialog");
        fileChooser.showOpenDialog(btnOpenFileDialog.getScene().getWindow());   // Model Window (Window Model)
    }

    public void btnSaveFileDialogOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save a file");
        File file = fileChooser.showSaveDialog(btnSaveFileDialog.getScene().getWindow()); // Model Window (Window Model)
        System.out.println(file);
    }

    public void btnDirectoryChooserOnAction(ActionEvent actionEvent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select a directory");
        File selectDir = directoryChooser.showDialog(btnDirectoryChooser.getScene().getWindow()); //Modal Window (Window Model)
        System.out.println("Selected directory" + selectDir);

    }

}
