package lk.ijse.dep10.Execise;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    Label header = new Label("User Details");
    Label userName = new Label("Username : ");
    Label password = new Label("Password  : ");
    Button btnExit = new Button("Exit");
    Button btnClose = new Button("Close");
    Button btnSave = new Button("Save");
    Font font1 = Font.font("", FontWeight.BLACK, 25);
    Font font2 = Font.font("", FontWeight.THIN, 20);

    TextField txt1 = new TextField();
    TextField txt2 = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mainMenu();
    }

    private void mainMenu() {
        Label header = new Label("FX Controls");
        header.setFont(Font.font(25));
        Font font1 = Font.font("", FontWeight.BOLD, 35);
        header.setFont(font1);
        header.setUnderline(true);
//        Button btn1 = new Button("Anchor Pane");
//        Button btn2 = new Button("Flow Pane");
//        Button btn3 = new Button("Tile Pane");
//        Button btn4 = new Button("Stack Pane");
//        Button btn5 = new Button("Border Pane");
//        Button btn6 = new Button("HBox");
//        Button btn7 = new Button("VBox");
//        Button btn8 = new Button("Grid Pane");

        Button[] buttonArray = new Button[8];
        Node[] nodeArray = new Node[9];
        String[] buttonNames = {"Anchor Pane", "Flow Pane", "Tile Pane", "Stack Pane", "Border Pane", "HBox", "VBox", "Grid Pane"};
        nodeArray[0] = header;

        for (int i = 1; i < 9; i++) {
            nodeArray[i] = new Button(buttonNames[i-1]);
            Font font2 = Font.font(buttonNames[i-1], FontWeight.SEMI_BOLD, 25);
            ((Button)nodeArray[i]).setFont(font2);
            ((Button) nodeArray[i]).setPrefSize(300,40);
        }

//        Button[] btnArray = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8};
//        for (Button button : btnArray) {
//            button.setPrefSize(300,60);
//        }
//
//        Font font = Font.font("Anchor Pan", FontWeight.SEMI_BOLD, 36);
//        btn1.setFont(font);

        VBox container = new VBox(nodeArray);
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(12));
        container.setSpacing(10);

        Scene scene = new Scene(container);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("FX Controls");
        stage.sizeToScene();
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();

        ((Button)nodeArray[1]).setOnAction(event -> anchorPane());
        ((Button)nodeArray[2]).setOnAction(event -> flowPane());
        ((Button)nodeArray[3]).setOnAction(event -> tilePane());
        ((Button)nodeArray[4]).setOnAction(event -> stackPane());
        ((Button)nodeArray[5]).setOnAction(event -> borderPane());
        ((Button)nodeArray[6]).setOnAction(event -> hBox());
        ((Button)nodeArray[7]).setOnAction(event -> vBox());
        ((Button)nodeArray[8]).setOnAction(event -> gridPane());
    }

    private void anchorPane(){
        header.setFont(font1);
        userName.setFont(font2);
        password.setFont(font2);

        AnchorPane container = new AnchorPane(header, userName, txt1, password, txt2, btnExit, btnClose);
        container.getChildren().add(btnSave);
        container.setPadding(new Insets(20,20,20,20));

        header.setLayoutX(90);
        header.setLayoutY(20);
        userName.setLayoutX(20);
        userName.setLayoutY(70);
        txt1.setLayoutX(150);
        txt1.setLayoutY(70);
        password.setLayoutX(20);
        password.setLayoutY(110);
        txt2.setLayoutX(150);
        txt2.setLayoutY(110);
        btnExit.setLayoutX(20);
        btnExit.setLayoutY(155);
        btnClose.setLayoutX(145);
        btnClose.setLayoutY(155);
        btnSave.setLayoutX(270);
        btnSave.setLayoutY(155);

        Scene scene = new Scene(container);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();

        btnExit.setOnAction(event -> {
            exit();
        });

        btnClose.setOnAction(event -> {
            close(stage);
        });

        btnSave.setOnAction(event -> {
            save(stage);
        });
    }
    private void flowPane() {
        header.setFont(font1);
        userName.setFont(font2);
        password.setFont(font2);

        FlowPane container = new FlowPane(header, userName, txt1, password, txt2, btnExit, btnClose, btnSave);

        Scene scene = new Scene(container);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Flow Pane");
//        stage.setResizable(false);
        stage.show();

        btnExit.setOnAction(event -> {
            exit();
        });

        btnClose.setOnAction(event -> {
            close(stage);
        });

        btnSave.setOnAction(event -> {
            save(stage);
        });
    }
    private void tilePane() {
        header.setFont(font1);
        userName.setFont(font2);
        password.setFont(font2);

        TilePane container = new TilePane(header, userName, txt1, password, txt2, btnExit, btnClose, btnSave);

        Scene scene = new Scene(container);
        Stage stage = new Stage();
        stage.setTitle("Tile Pane");
        stage.setScene(scene);
        stage.show();

        btnExit.setOnAction(event -> {
            exit();
        });

        btnClose.setOnAction(event -> {
            close(stage);
        });

        btnSave.setOnAction(event -> {
            save(stage);
        });
    }
    private void stackPane() {
        header.setFont(font1);
        userName.setFont(font2);
        password.setFont(font2);

        StackPane container = new StackPane(header, userName, txt1, password, txt2, btnExit, btnClose, btnSave);
        container.setPrefHeight(150);
        container.setPrefWidth(600);
        txt1.setMaxWidth(200);
        txt2.setMaxWidth(200);

        StackPane.setAlignment(header,Pos.TOP_LEFT);
        StackPane.setAlignment(userName,Pos.TOP_CENTER);
        StackPane.setAlignment(txt1,Pos.TOP_RIGHT);
        StackPane.setAlignment(password,Pos.CENTER);
        StackPane.setAlignment(txt2,Pos.CENTER_RIGHT);
        StackPane.setAlignment(btnExit,Pos.BOTTOM_LEFT);
        StackPane.setAlignment(btnClose,Pos.BOTTOM_CENTER);
        StackPane.setAlignment(btnSave,Pos.BOTTOM_RIGHT);
        container.setPadding(new Insets(20));

        Scene scene = new Scene(container);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();



        btnExit.setOnAction(event -> {
            exit();
        });

        btnClose.setOnAction(event -> {
            close(stage);
        });

        btnSave.setOnAction(event -> {
            save(stage);
        });
    }
    private void borderPane() {
        header.setFont(font1);
        userName.setFont(font2);
        password.setFont(font2);

        BorderPane container = new BorderPane();
        container.setPrefHeight(200);
        container.setPrefWidth(700);

        container.setTop(header);
        BorderPane.setAlignment(header, Pos.TOP_CENTER);
        container.setLeft(userName);
        BorderPane.setAlignment(userName,Pos.CENTER);
        container.setRight(password);
        BorderPane.setAlignment(password,Pos.CENTER);
        container.setCenter(txt1);
        BorderPane.setAlignment(txt1,Pos.CENTER);
        container.setBottom(txt2);
        BorderPane.setAlignment(txt2,Pos.CENTER);

        Scene scene = new Scene(container);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    private void hBox() {
        header.setFont(font1);
        userName.setFont(font2);
        password.setFont(font2);

        HBox container = new HBox(header, userName, txt1, password, txt2, btnExit, btnClose, btnSave);

        Scene scene = new Scene(container);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        btnExit.setOnAction(event -> {
            exit();
        });

        btnClose.setOnAction(event -> {
            close(stage);
        });

        btnSave.setOnAction(event -> {
            save(stage);
        });
    }
    private void vBox() {
        header.setFont(font1);
        userName.setFont(font2);
        password.setFont(font2);

        VBox container = new VBox(header, userName, txt1, password, txt2, btnExit, btnClose, btnSave);

        Scene scene = new Scene(container);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        btnExit.setOnAction(event -> {
            exit();
        });

        btnClose.setOnAction(event -> {
            close(stage);
        });

        btnSave.setOnAction(event -> {
            save(stage);
        });
    }
    private void gridPane() {
        header.setFont(font1);
        userName.setFont(font2);
        password.setFont(font2);
//        userName.setPrefWidth(200);

        GridPane container = new GridPane();
        ColumnConstraints columnConstraints = new ColumnConstraints(200);
        container.getColumnConstraints().addAll(new ColumnConstraints(130), columnConstraints, columnConstraints);

        container.add(header, 0, 0, 3, 1);
        container.add(userName, 0, 1);
        container.add(txt1, 1, 1, 2, 1);
        container.add(password, 0, 2);
        container.add(txt2, 1, 2, 2, 1);
        container.add(btnExit, 0, 3);
        container.add(btnClose, 1, 3);
        container.add(btnSave, 2, 3);
        container.setPadding(new Insets(20));
        GridPane.setHalignment(header, HPos.CENTER);
        GridPane.setHalignment(btnExit,HPos.CENTER);
        GridPane.setHalignment(btnClose,HPos.CENTER);
        GridPane.setHalignment(btnSave,HPos.CENTER);

        container.setVgap(20);
        container.setHgap(20);

//        container.setGridLinesVisible(true);

        Scene scene = new Scene(container);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        btnExit.setOnAction(event -> {
            exit();
        });

        btnClose.setOnAction(event -> {
            close(stage);
        });

        btnSave.setOnAction(event -> {
            save(stage);
        });
    }
    private void exit() {
        Platform.exit();
    }
    private void close(Stage stage) {
        stage.close();

    }
    private void save(Stage stagOld) {
        Label lbl = new Label("Successfully saved!");
        Button btnExit = new Button("Exit");
        Button btnClose = new Button("Close");
        AnchorPane anchorPane = new AnchorPane(lbl,btnExit, btnClose);
        Font font = Font.font("", FontWeight.THIN, 30);
        lbl.setFont(font);
        lbl.setLayoutX(80);
        lbl.setLayoutY(50);
        btnExit.setLayoutX(130);
        btnExit.setLayoutY(150);
        btnClose.setLayoutX(280);
        btnClose.setLayoutY(150);

        anchorPane.setPadding(new Insets(60,60,0,0));

        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        btnExit.setOnAction(event -> {
            exit();
        });

        btnClose.setOnAction(event -> {
            close(stage);
            close(stagOld);
        });
    }

}
