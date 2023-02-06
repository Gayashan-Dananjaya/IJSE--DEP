package lk.ijse.dep10.scenes;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
        System.out.println("ABCD");
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Scene Manipulation");
        primaryStage.show();
        mainScene(primaryStage);
        primaryStage.setMinWidth(250);
        primaryStage.setMaxWidth(750);
        primaryStage.setMinHeight(400);
        primaryStage.setMaxHeight(400);
    }

    public void mainScene(Stage stage) {
        Label lblTitle = new Label("Main Scene");
        Paint paint4lbl = new Color(0,0,1,1);
        Background color4lbl = Background.fill(paint4lbl);
        lblTitle.setBackground(color4lbl);
        lblTitle.setTextFill(Color.web("white"));
        Font font4lblTitle = new Font("ubuntu", 20);
//        lblTitle.setFont(font4lblTitle);

        Button btn1 = new Button("Scene 1");
//        btn1.setFont(new Font(15));
        btn1.setPrefWidth(250);
        btn1.setMaxWidth(Double.MAX_VALUE);

        Button btn2 = new Button("Scene 2");
//        btn2.setFont(new Font(15));

        Button btn3 = new Button("Scene 3");
//        btn3.setFont(new Font(15));

        Button btn4 = new Button("Platform Exit");
//        btn4.setFont(new Font(15));

//        Paint paint4btn4 = new Color(1,0,0,1);
//        Paint paint4btn4 = Color.rgb(255,0,0,1);
        Paint paint4btn4 = Color.web("green");
        Background background4btn4 = Background.fill(paint4btn4);
        btn4.setBackground(background4btn4);

        Button btn5 = new Button("System Exit");
//        btn5.setFont(Font.font("System Exit", FontWeight.BOLD,15));

        VBox root = new VBox(lblTitle, btn1, btn2, btn3,btn4,btn5);

        for (Node node : root.getChildren()) {
            if (!(node instanceof Labeled)) continue;   // Button and Label inherited Labeled
            ((Labeled) node).setFont(font4lblTitle);    // Casting a node to Labeled
            ((Labeled) node).setMaxWidth(Double.MAX_VALUE);
        }

        btn4.setOnAction(event -> {
            System.out.println("Platform Exit");
            Platform.exit();
        });

        btn5.setOnAction(event -> {
            System.out.println("System Exit");
            System.exit(0);
        });

        btn1.setOnAction(event -> {
            firstScene(stage);
        });
        btn2.setOnAction(event -> {
            secondScene(stage);
        });
        btn3.setOnAction(event -> {
            thirdScene(stage);
        });


        Paint paint4vbox = Color.rgb(100, 30, 150, 0.35);
        Background background4vbox = Background.fill(paint4vbox);
        root.setBackground(background4vbox);

        root.setSpacing(10);
        root.setPadding(new Insets(10));

        Scene mainScene = new Scene(root);
        stage.setScene(mainScene);
        stage.sizeToScene();
        stage.centerOnScreen();
    }
    private void firstScene(Stage stage) {
        System.out.println("First Scene");

        Label header = new Label("First Scene");
        Font fontHeader = Font.font("", FontWeight.BOLD, 25);
        header.setFont(fontHeader);

        Button btnBack = new Button("Back");

        VBox container = new VBox(header, btnBack);
        container.setMinHeight(400);
        container.setMaxHeight(800);
        container.setMinWidth(400);
        container.setMaxWidth(800);
        container.setPrefSize(700,400);
        container.setAlignment(Pos.TOP_CENTER);
//        container.setAlignment(Pos.CENTER);

        Scene scene = new Scene(container);
        stage.setScene(scene);
        stage.show();

        btnBack.setOnAction(event -> {
            mainScene(stage);
        });
    }
    private void secondScene(Stage stage) {
        System.out.println("Second Scene");

        Label header = new Label("Second Scene");
        Font fontHeader = Font.font("", FontWeight.BOLD, 25);
        header.setFont(fontHeader);

        Button btnBack = new Button("Back");

        VBox container = new VBox(header, btnBack);
        container.setMinHeight(400);
        container.setMaxHeight(800);
        container.setMinWidth(400);
        container.setMaxWidth(800);
        container.setPrefSize(700,400);
        container.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(container);
        stage.setScene(scene);
        stage.show();

        btnBack.setOnAction(event -> {
            mainScene(stage);
        });
    }
    private void thirdScene(Stage stage) {
        System.out.println("Third Scene");

        Label header = new Label("Third Scene");
        Font fontHeader = Font.font("", FontWeight.BOLD, 25);
        header.setFont(fontHeader);

        Button btnBack = new Button("Back");

        VBox container = new VBox(header, btnBack);
        container.setMinHeight(400);
        container.setMaxHeight(800);
        container.setMinWidth(400);
        container.setMaxWidth(800);
        container.setPrefSize(700,400);
        container.setAlignment(Pos.TOP_CENTER);
//        container.setAlignment(Pos.CENTER);

        Scene scene = new Scene(container);
        stage.setScene(scene);
        stage.show();

        btnBack.setOnAction(event -> {
            mainScene(stage);
        });
    }
}
