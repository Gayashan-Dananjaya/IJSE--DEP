package lk.ijse.dep10.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {

        System.out.println("Just before the launching of JavaFX runtime environment");

        /*This "launch args" line will start the JavaFX runtime environment*/
        launch(args);

        System.out.println("Just after the launching of JavaFX runtime environment");

    }

    @Override
    public void start(Stage primaryStage) {
        /*After starting JavaFX runtime environment this "start" method continues to start*/
        System.out.println("Just entered the JFX");

        Platform.exit();
    }
}