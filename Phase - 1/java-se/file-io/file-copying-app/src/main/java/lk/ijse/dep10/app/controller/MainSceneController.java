package lk.ijse.dep10.app.controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.*;
import java.math.BigDecimal;

public class MainSceneController {

    @FXML
    private Button btnCopy;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSelectDirectory;

    @FXML
    private Button btnSelectFile;

    @FXML
    private Label lblDirectory;

    @FXML
    private Label lblFile;

    @FXML
    private Label lblPercentage;

    @FXML
    private ProgressBar prg;

    File fileCopy;
    File filePaste;

    @FXML
    void btnResetOnAction(ActionEvent event) {
        lblFile.setText("No file has been selected yet");
        lblDirectory.setText("No directory has been selected yet");
        btnCopy.setDisable(true);
        btnSelectDirectory.setDisable(true);
        lblPercentage.textProperty().unbind();
        prg.progressProperty().unbind();
        lblPercentage.setText("0%");
        prg.setProgress(0.0);
    }

    @FXML
    void btnSelectFileOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileCopy = fileChooser.showOpenDialog(btnSelectFile.getScene().getWindow());

        if (fileCopy != null) {
            lblFile.setText(fileCopy.getAbsolutePath());
            btnSelectDirectory.setDisable(false);
        }
    }

    @FXML
    void btnSelectDirectoryOnAction(ActionEvent event) {
        btnCopy.setDisable(true);
        DirectoryChooser directoryChooser = new DirectoryChooser();
        filePaste = directoryChooser.showDialog(btnSelectDirectory.getScene().getWindow());

        if (filePaste == null) {
            return;
        }

        filePaste = new File(filePaste, fileCopy.getName());
        lblDirectory.setText(filePaste.getAbsolutePath());

        if (filePaste.exists()) {
            lblDirectory.setText("The file is already exists in the selected directory");
            return;
        }

        btnCopy.setDisable(false);
    }

    @FXML
    void btnCopyOnAction(ActionEvent event) throws IOException {


        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                FileInputStream fileInputStream = new FileInputStream(fileCopy);
                FileOutputStream fileOutputStream = new FileOutputStream(filePaste,true);

                System.out.println("In");
                while (true) {
                    System.out.println("acd");
                    byte[] bytes = new byte[1024];
                    int read = fileInputStream.read(bytes);
                    if (read == 1024) {
                        fileOutputStream.write(bytes);

                        double range = (double) filePaste.length() / (double) fileCopy.length();
                        updateProgress(range, 1.0);
                        updateMessage((int) (range * 100) + " %");

                    } else if (read < 1024 && read > 0) {
                        fileOutputStream.write(bytes, 0, read);
                    } else if (read == -1) {
                        updateMessage("Completed");
                        updateProgress(1.0,1.0);
                        break;
                    } else {
                        System.out.println("Loop else part has been run");
                        System.out.println(read);
                    }
                }

                fileInputStream.close();
                fileOutputStream.close();

                return null;
            }
        };

        new Thread(task).start();
        prg.progressProperty().bind(task.progressProperty());
        lblPercentage.textProperty().bind(task.messageProperty());


    }

}
