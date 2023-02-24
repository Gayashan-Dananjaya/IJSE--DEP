package lk.ijse.dep10.app.controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class MainSceneController {

    @FXML
    private Button btnRun;

    @FXML
    private Label lbl;

    @FXML
    private ProgressBar prg;

    @FXML
    void btnRunOnAction(ActionEvent event) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                for (int i = 0; i < 40; i++) {
                    System.out.println(i);
                    double progress = i / 40.0;
                    updateProgress(i,40.0);
                    updateMessage((i * 100 / 40) + "% completed");
                }

                return null;
            }
        };
        new Thread(task).start();
        prg.progressProperty().bind(task.progressProperty());
        lbl.textProperty().bind(task.messageProperty());
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");



//            lbl.setText(progress + "% complete");
//            prg.setProgress(progress);
    }

}
