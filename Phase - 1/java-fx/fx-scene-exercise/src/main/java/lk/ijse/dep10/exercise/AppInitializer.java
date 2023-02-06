package lk.ijse.dep10.exercise;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

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
                app(stage);
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
