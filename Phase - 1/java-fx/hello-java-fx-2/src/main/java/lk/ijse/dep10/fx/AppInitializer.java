package lk.ijse.dep10.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {

        System.out.println("Before the JavaFX runtime environment");

        launch(args);

        System.out.println("After the JavaFX runtime environment");

    }

    @Override
    public void start(Stage primaryStage) {

        System.out.println("In the JavaFX runtime environment");

        Platform.exit();

    }
}
