package lk.ijse.dep10.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        URL url = new URL(this.getClass().getResource("/view/MainScene.fxml").toString());
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        AnchorPane root = fxmlLoader.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Concurrency");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
