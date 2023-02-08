package lk.ijse.dep10.animation;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AppInitializer extends Application {

    Stage stageTransition;
    Stage stageAnimation;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mainScene(primaryStage);
//        primaryStage.show();
    }

    private void mainScene(Stage stage) {
        Label lblTitle = new Label("JavaFX Animations Module");
//        Label lblTime = new Label(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")).toString());
        Label lblTime = new Label(LocalTime.now().toString());

        KeyFrame key = new KeyFrame(Duration.millis(1), event -> {
//            lblTime.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")).toString());
            lblTime.setText(LocalTime.now().toString());
        });

        Timeline timeline = new Timeline(key);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.playFromStart();

        Font fontTitle = Font.font("", FontWeight.SEMI_BOLD, 25);
//        Font fontTime = Font.font("", FontWeight.BOLD, 40);
        lblTime.setTextFill(Color.GRAY);


        lblTitle.setFont(fontTitle);
        lblTitle.setTextFill(Color.BLUE);
        lblTitle.setMaxWidth(Double.MAX_VALUE);
        lblTitle.setAlignment(Pos.CENTER);
        lblTitle.setPadding(new Insets(0,0,5,0));

        Button btnAnimation = new Button("Animations");
        Button btnTransition = new Button("Transition");
        btnAnimation.setMaxWidth(Double.MAX_VALUE);
        btnTransition.setMaxWidth(Double.MAX_VALUE);

        VBox root = new VBox(lblTitle, btnAnimation, btnTransition,lblTime);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setSpacing(20);

        Scene scene = new Scene(root);
        stage.setTitle("JavaFX Animations Module");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        stage.sizeToScene();

        btnAnimation.setOnAction(event -> {
            animations();
        });
        btnTransition.setOnAction(event -> {
            transitions();
        });
    }

    private void transitions() {
        if (stageTransition != null) return;
        stageTransition = new Stage();
        stageTransition.setOnCloseRequest(event -> {
            stageTransition = null;
            System.out.println("JSHFjhgzdjhfg");
        });

        stageTransition.setMinWidth(700);
        Button btnFadeIn = new Button("Fade In");
        Button btnFadeOut = new Button("Fade Out");
        Button btnScale = new Button("Scale");
        Button btnRotate = new Button("Rotate");
        Button btnTranslateX = new Button("TranslateX");
        Button btnTranslateY = new Button("TranslateY");

        Label lblPreview = new Label("Preview");
        Font fontPreview = Font.font("", FontWeight.BOLD, 50);
        lblPreview.setFont(fontPreview);
        lblPreview.setTextFill(Color.GRAY);
        lblPreview.setMaxHeight(Double.MAX_VALUE);
        lblPreview.setAlignment(Pos.CENTER);


        HBox hBox = new HBox(btnFadeIn, btnFadeOut, btnScale, btnRotate, btnTranslateX, btnTranslateY);
        VBox vBox = new VBox(hBox,lblPreview);
        Scene scene = new Scene(vBox);

        vBox.setSpacing(10);
        vBox.setPadding(new Insets(15));
        vBox.setAlignment(Pos.TOP_CENTER);
        VBox.setVgrow(lblPreview,Priority.ALWAYS);

        hBox.setSpacing(15);

        for (Node child : hBox.getChildren()) {
            Button btn = (Button) child;
            btn.setFont(new Font(16));
            btn.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(btn, Priority.ALWAYS);
        }









        stageTransition.setScene(scene);
        stageTransition.setTitle("Transitions");
        stageTransition.setWidth(500);
        stageTransition.setHeight(500);
        stageTransition.show();
        stageTransition.centerOnScreen();

    }

    private void animations() {
        if (stageAnimation != null) return;
        stageAnimation = new Stage();
        stageAnimation.setOnCloseRequest(event -> {
            stageAnimation = null;
        });

        Button btnPlay = new Button("PLAY");
        Button btnStop = new Button("STOP");
        Label lblPreview = new Label("Preview");

        Font fontButton = new Font(16);
        Font fontPreview = Font.font("", FontWeight.BOLD, 40);
        btnStop.setFont(fontButton);
        btnPlay.setFont(fontButton);
        btnPlay.setMinWidth(150);
        btnStop.setMinWidth(150);
        lblPreview.setFont(fontPreview);
        lblPreview.setTextFill(Color.GRAY);

        VBox vBox = new VBox(btnPlay,btnStop);
        HBox hBox = new HBox(vBox,lblPreview);

        hBox.setSpacing(10);
        hBox.setPadding(new Insets(15));
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(20);
        lblPreview.setMaxWidth(Double.MAX_VALUE);
        lblPreview.setMaxHeight(Double.MAX_VALUE);
        lblPreview.setAlignment(Pos.CENTER);
//        lblPreview.setBorder(Border.stroke(Color.GRAY));
//        lblPreview.setBackground(Background.fill(Color.LIGHTBLUE));
        HBox.setHgrow(lblPreview,Priority.ALWAYS);
        stageAnimation.setMinWidth(700);

        KeyFrame key = new KeyFrame(Duration.millis(250), event -> {
            lblPreview.setTextFill(Color.RED);
        });
        KeyFrame key2 = new KeyFrame(Duration.millis(500), event -> {
            lblPreview.setTextFill(Color.GREEN);
            lblPreview.setTranslateX(100);
            lblPreview.setScaleY(1.5);

        });
        KeyFrame key3 = new KeyFrame(Duration.millis(750), event -> {
            lblPreview.setTextFill(Color.BLUE);
            lblPreview.setTranslateX(-100);

        });
        KeyFrame key4 = new KeyFrame(Duration.millis(1000), event -> {
            lblPreview.setScaleX(1.5);

        });
        KeyFrame key5 = new KeyFrame(Duration.millis(1250), event -> {
            lblPreview.setScaleX(1);
            lblPreview.setScaleY(1);

        });

        Timeline timeline = new Timeline(key, key2, key3, key4, key5);
        timeline.setCycleCount(Animation.INDEFINITE);


        Scene scene = new Scene(hBox);
        stageAnimation.setScene(scene);
        stageAnimation.setTitle("Animations");
        stageAnimation.setWidth(500);
        stageAnimation.setHeight(500);
        stageAnimation.show();
        stageAnimation.centerOnScreen();


        btnPlay.setOnAction(event -> {
            timeline.playFromStart();
        });
        btnStop.setOnAction(event -> {
            timeline.stop();
        });
    }

}
