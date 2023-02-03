package lk.ijse.dep10;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage stage = new Stage();
        stage.setTitle("My first FX application");
        stage.setHeight(500);
        stage.setWidth(500);
        stage.show();
        stage.centerOnScreen();
    }
}
