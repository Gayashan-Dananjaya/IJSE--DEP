package lk.ijse.dep10.exercise3;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.management.DynamicMBean;
import java.util.Arrays;

public class AppInitializer extends Application {

    static int i = 0;
    static int j = 0;
    static int k = 0;

    static String txt = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        loginScene(primaryStage);
        primaryStage.show();
        primaryStage.centerOnScreen();
//        String a = "ABCD";
//        System.out.println(a.substring(0, 0));
//        System.out.println("vb");
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
                secondWindow(stage);
            } else {
                invalidPassword.setVisible(true);
                txt.selectAll();
            }
        });
    }

    private void secondWindow(Stage stage) {
        Label lblGreet = new Label("Welcome to the App.!");
        lblGreet.setLayoutX(-500);
        lblGreet.setVisible(false);
        Font fontGreet = Font.font("", FontWeight.BOLD, 30);
//        lblGreet.setBackground(Background.fill(Color.LIGHTBLUE));
        lblGreet.setAlignment(Pos.CENTER);
        lblGreet.setFont(fontGreet);
        lblGreet.setTextFill(Color.GRAY);

        Label lblTxt = new Label();
        String[] array = {"Hello!", "How are you?"};
        Font fontTxt = Font.font("", FontWeight.THIN, 17);
        lblTxt.setAlignment(Pos.CENTER);
        lblTxt.setFont(fontTxt);
        lblTxt.setTextFill(Color.BLUE);
//        lblTxt.setVisible(false);

        AnchorPane root = new AnchorPane(lblGreet, lblTxt);
        AnchorPane.setLeftAnchor(lblGreet, 0.0);
        AnchorPane.setRightAnchor(lblGreet, 0.0);
        AnchorPane.setTopAnchor(lblGreet, 0.0);
        AnchorPane.setBottomAnchor(lblGreet, 0.0);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(1000);
        stage.show();
        stage.centerOnScreen();

        animateText(lblTxt,array);
        animateGreet(-750, 200, 1.7, lblGreet);
        followCursor(lblTxt, root);

    }

    private void animateGreet(int min, int max, double scale, Label lbl) {
        lbl.setLayoutX(-500);
        KeyFrame key1 = new KeyFrame(Duration.millis(500), event -> {
            TranslateTransition transition = new TranslateTransition(Duration.millis(1300), lbl);
            transition.setFromX((double) min);
            transition.setToX((double) max);
            transition.playFromStart();
            lbl.setVisible(true);
        });

        KeyFrame key2 = new KeyFrame(Duration.millis(1800), event -> {
            TranslateTransition transition = new TranslateTransition(Duration.millis(700), lbl);
            transition.setFromX(max);
            transition.setToX(0);
            transition.playFromStart();
        });

        KeyFrame key3 = new KeyFrame(Duration.millis(2500), event -> {
            ScaleTransition transition = new ScaleTransition(Duration.millis(750), lbl);
            transition.setFromX(1);
            transition.setFromY(1);
            transition.setToX(scale);
            transition.setToY(scale);
            transition.playFromStart();
        });

        KeyFrame key4 = new KeyFrame(Duration.millis(3250), event -> {
            ScaleTransition transition = new ScaleTransition(Duration.millis(750), lbl);
            transition.setFromX(scale);
            transition.setFromY(scale);
            transition.setToX(1);
            transition.setToY(1);
            transition.playFromStart();
        });

        Timeline timeline = new Timeline(key1,key2,key3,key4);
        timeline.setCycleCount(1);
        timeline.playFromStart();
    }

    private void followCursor(Label lbl, AnchorPane root) {
        root.setOnMouseEntered(event -> {
            lbl.setVisible(true);
        });
        root.setOnMouseExited(event -> {
            lbl.setVisible(false);
        });
        root.setOnMouseMoved(event -> {
            lbl.setLayoutX(event.getX() + 10);
            lbl.setLayoutY(event.getY() + 10);
        });
    }

    private void animateText(Label lbl, String[] array) {
        KeyFrame[] keyArray = new KeyFrame[0];
        double time = 0;

        KeyFrame key = null;

        for (String str : array) {
            for (char c : str.toCharArray()) {
                key = new KeyFrame(Duration.seconds(time+=0.25), event -> {
                    txt = str.substring(0,++j);
                    lbl.setText(txt);
                    if (j == str.length()) j = 0;
                });
                keyArray = dynamicArray(keyArray, key);
            }
//            System.out.println("ABCDEFGHIJK");
            for (char d : str.toCharArray()) {
                key = new KeyFrame(Duration.seconds(time+=0.25), event -> {
                    txt = str.substring(0, (str.length() -1- k++));
                    lbl.setText(txt);
                    if (k==str.length()) k = 0;
                });
                keyArray = dynamicArray(keyArray, key);
            }
        }
        Timeline timeline = new Timeline(keyArray);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.playFromStart();
    }

    public KeyFrame[] dynamicArray(KeyFrame[] array, KeyFrame key) {
        KeyFrame[] newArray = new KeyFrame[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = key;
        return newArray;
    }


}
