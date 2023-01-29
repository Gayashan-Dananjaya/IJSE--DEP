package lk.ijse.dep10.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class
AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage stage = new Stage();

        AnchorPane anchorPane = new AnchorPane();
        Button btnClckMe = new Button("Click Me");

        anchorPane.getChildren().add(btnClckMe);
        btnClckMe.setLayoutX(225);
        btnClckMe.setLayoutY(225);


        Scene mainScene = new Scene(anchorPane);
        stage.setScene(mainScene);


        stage.setTitle("My First JAVA App");
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();

        Stage stage2 = new Stage();
        stage2.setTitle("My Second JAVA App");
        stage2.show();

    }
}
