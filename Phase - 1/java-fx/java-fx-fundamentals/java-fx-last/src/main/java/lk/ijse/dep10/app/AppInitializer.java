package lk.ijse.dep10.app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL url = this.getClass().getResource("/view/MainForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        AnchorPane root = fxmlLoader.load();


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Final App");
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
    }
}
