package lk.ijse.dep10.app.controller;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.*;

public class MainSceneController {

    @FXML
    private Button btnCopy;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnFrom;

    @FXML
    private Button btnMove;

    @FXML
    private Button btnTo;

    @FXML
    private ProgressBar prg;

    @FXML
    private TextField txtFrom;

    @FXML
    private TextField txtTo;
    File fileFrom;
    File fileTo;

    @FXML
    void btnFromOnAction(ActionEvent event) {
//        JFileChooser chooser = new JFileChooser();
//        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//        chooser.showOpenDialog(null);
//        fileFrom = chooser.getSelectedFile();

//        DirectoryChooser dirChooser = new DirectoryChooser();
//        fileFrom = dirChooser.showDialog(btnFrom.getScene().getWindow());

        FileChooser fileChooser = new FileChooser();
        fileFrom = fileChooser.showOpenDialog(btnFrom.getScene().getWindow());

        if (fileFrom == null) {
            txtFrom.setText("");
        } else {
            txtFrom.setText(fileFrom.getAbsolutePath());
        }
    }

    @FXML
    void btnToOnAction(ActionEvent event) {
        DirectoryChooser dirChooser = new DirectoryChooser();
        fileTo = dirChooser.showDialog(btnTo.getScene().getWindow());

        if (txtTo == null) {
            txtTo.setText("");
        } else {
            txtTo.setText(fileTo.getAbsolutePath());
        }
    }

    @FXML
    void btnCopyOnAction(ActionEvent event) {
        if (fileFrom == null || fileTo == null) {
            return;
        }

        if (fileFrom.isFile()) {
            fileTo = new File(fileTo, fileFrom.getName());

            Task<Void> task = new Task<>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        double readSize = fileFrom.length();
                        double writeSize = 0;
                        FileInputStream fis = new FileInputStream(fileFrom);
                        FileOutputStream fos = new FileOutputStream(fileTo,true);



                        while (true) {
                            byte[] bytes = new byte[1024];
                            int read = fis.read(bytes);

                            if (read == -1) {
                                break;
                            } else {
                                fos.write(bytes,0,read);
                                writeSize += read;
                                updateProgress(writeSize/readSize,1);
                            }
                        }

                        System.out.println("Write finished");
                        fis.close();
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    return null;
                }
            };

            new Thread(task).start();
            prg.progressProperty().bind(task.progressProperty());



        }

    }

    @FXML
    void btnMoveOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

}
