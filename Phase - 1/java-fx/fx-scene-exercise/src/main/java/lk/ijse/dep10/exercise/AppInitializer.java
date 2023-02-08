package lk.ijse.dep10.exercise;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.Time;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        loginScene(primaryStage);
        primaryStage.show();
        primaryStage.centerOnScreen();
    }

    private void tempScene(Stage stage) {
        Label lblGreet = new Label("Welcome to the App.!");
        Font fontGreet = Font.font("", FontWeight.BOLD, 30);
//        lblGreet.setBackground(Background.fill(Color.LIGHTBLUE));
        lblGreet.setAlignment(Pos.CENTER);
        lblGreet.setFont(fontGreet);
        lblGreet.setTextFill(Color.GRAY);

        Label lblTxt = new Label("ABCDEF");
        Font fontTxt = Font.font("", FontWeight.THIN, 17);
        lblTxt.setAlignment(Pos.CENTER);
        lblTxt.setFont(fontTxt);
        lblTxt.setTextFill(Color.BLUE);
        lblTxt.setVisible(false);



        AnchorPane root = new AnchorPane(lblGreet,lblTxt);
        AnchorPane.setLeftAnchor(lblGreet,0.0);
        AnchorPane.setRightAnchor(lblGreet,0.0);
        AnchorPane.setTopAnchor(lblGreet,0.0);
        AnchorPane.setBottomAnchor(lblGreet,0.0);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(1000);
        stage.show();
        stage.centerOnScreen();

//        Greet Animation
        KeyFrame key1 = new KeyFrame(Duration.millis(100), event -> {
            lblGreet.setTranslateX(-600);
        });
        KeyFrame key2 = new KeyFrame(Duration.millis(200), event -> {
            lblGreet.setTranslateX(-450);
        });
        KeyFrame key3 = new KeyFrame(Duration.millis(300), event -> {
            lblGreet.setTranslateX(-300);
        });
        KeyFrame key4 = new KeyFrame(Duration.millis(400), event -> {
            lblGreet.setTranslateX(-150);
        });
        KeyFrame key5 = new KeyFrame(Duration.millis(500), event -> {
            lblGreet.setTranslateX(0);
        });
        KeyFrame key6 = new KeyFrame(Duration.millis(600), event -> {
            lblGreet.setTranslateX(50);
        });
        KeyFrame key7 = new KeyFrame(Duration.millis(700), event -> {
            lblGreet.setTranslateX(100);
        });
        KeyFrame key8 = new KeyFrame(Duration.millis(800), event -> {
            lblGreet.setTranslateX(50);
        });
        KeyFrame key9 = new KeyFrame(Duration.millis(900), event -> {
            lblGreet.setTranslateX(0);
        });
        KeyFrame key10 = new KeyFrame(Duration.millis(1000), event -> {
            lblGreet.setScaleX(1.2);
            lblGreet.setScaleY(1.2);
        });
        KeyFrame key11 = new KeyFrame(Duration.millis(1100), event -> {
            lblGreet.setScaleX(1.4);
            lblGreet.setScaleY(1.4);
        });
        KeyFrame key12 = new KeyFrame(Duration.millis(1200), event -> {
            lblGreet.setScaleX(1.6);
            lblGreet.setScaleY(1.6);
        });
        KeyFrame key13 = new KeyFrame(Duration.millis(1300), event -> {
            lblGreet.setScaleX(1.4);
            lblGreet.setScaleY(1.4);
        });
        KeyFrame key14 = new KeyFrame(Duration.millis(1400), event -> {
            lblGreet.setScaleX(1.2);
            lblGreet.setScaleY(1.2);
        });
        KeyFrame key15 = new KeyFrame(Duration.millis(1500), event -> {
            lblGreet.setScaleX(1.0);
            lblGreet.setScaleY(1.0);
        });
        Timeline timeline = new Timeline(key1,key2,key3,key4,key5,key6,key7,key8,key9,key10,key11,key12,key13,key14,key15);
        timeline.setCycleCount(1);
        timeline.playFromStart();

        root.setOnMouseEntered(event -> {
            lblTxt.setVisible(true);
        });
        root.setOnMouseExited(event -> {
            lblTxt.setVisible(false);
        });
        root.setOnMouseMoved(event -> {
            lblTxt.setLayoutX(event.getX()+15);
            lblTxt.setLayoutY(event.getY()+15);
        });



    }

    private KeyFrame[] getKeyArray(int min, int max, Double scale, Label lbl) {
        KeyFrame[] array = {};
        int duration = 0;
        for (int i = min; i < 0; i++) {
            KeyFrame key = new KeyFrame(Duration.millis(duration+=20), event -> {
                lbl.setTranslateX(min);
            });
            array = dynamicArray(array, key);
            System.out.println(duration);
        }
        for (int i = 0; i < max; i++) {
            KeyFrame key = new KeyFrame(Duration.millis(duration+=20), event -> {
                lbl.setTranslateX(min);
            });
            array = dynamicArray(array, key);
            System.out.println(duration);
        }
        for (int i = max; i >= 0; i--) {
            KeyFrame key = new KeyFrame(Duration.millis(duration+=20), event -> {
                lbl.setTranslateX(min);
            });
            array = dynamicArray(array, key);
            System.out.println(duration);
        }

        return array;
    }

    private KeyFrame[] dynamicArray(KeyFrame[] array, KeyFrame key) {
        KeyFrame[] newArray = new KeyFrame[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = key;
        return newArray;
    }

    private void loginScene(Stage stage) {
        Label login = new Label("LOGIN");
        Font fontLogin = Font.font("", FontWeight.BOLD, 44);
        login.setFont(fontLogin);
        login.setTextFill(Color.web("darkblue"));

        Label username = new Label("Enter username");
        username.setPadding(new Insets(25,0,0,0));

        Label invalidPassword = new Label("Invalid Password!, Try Again.");
        invalidPassword.setPadding(new Insets(0,0,25,0));
        Font fontInvalid = Font.font("", FontWeight.THIN, 15);
        invalidPassword.setFont(fontInvalid);
        invalidPassword.setTextFill(Color.web("red"));
        invalidPassword.setVisible(false);

        PasswordField txt = new PasswordField();
        txt.setMaxWidth(350);

        Button btnLogin = new Button("LOGIN");
        Font fontLoginButton = new Font(16);
        btnLogin.setFont(fontLoginButton);
        btnLogin.setDefaultButton(true);

        VBox root = new VBox(login, username, txt, invalidPassword, btnLogin);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setSpacing(10);
        root.setPrefSize(500, 400);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.sizeToScene();

        btnLogin.setOnAction(event -> {
            if (txt.getText().equals("Admin")) {
                tempScene(stage);
            } else {
                invalidPassword.setVisible(true);
                txt.selectAll();
            }
        });

    }

    private void app(Stage stage) {
        Label label = new Label("HI, WELCOME TO THE APP");
//        Label lbl = new Label("Hi, I am Moving");
        label.setVisible(false);

        Font font = Font.font("", FontWeight.SEMI_BOLD, 30);
        label.setFont(font);
        label.setTextFill(Color.rgb(20,20,200,0.3));
//
//        VBox container = new VBox(label);

        AnchorPane container = new AnchorPane(label);

        container.setOnMouseEntered(event -> {
            label.setVisible(true);
            label.setVisible(true);
        });
        container.setOnMouseExited(event -> {
            label.setVisible(false);
        });
        container.setOnMouseMoved(event -> {
            label.setLayoutX(event.getX() + 10);
            label.setLayoutY(event.getY() + 10);
        });

//        container.setAlignment(Pos.CENTER);
        container.setBackground(Background.fill(Color.BEIGE));
        container.setPrefSize(800,800);

        Scene scene = new Scene(container);
        stage.setScene(scene);
        stage.centerOnScreen();
    }

}
