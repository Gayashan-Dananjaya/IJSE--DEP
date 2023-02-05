package lk.ijse.dep10;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

//        hBoxDemo();
//        vBoxDemo();
        grdPaneDemo();

//        Button btn1 = new Button("Button 1");
//        Button btn2 = new Button("Button 2");
//        Button btn3 = new Button("Button 3");
//        Button btn4 = new Button("Button 4");
//        Button btn5 = new Button("Button 5");
//
//        TextField txt1 = new TextField();
//        TextField txt2 = new TextField();
//        TextField txt3 = new TextField();
//        TextField txt4 = new TextField();
//
//        AnchorPane anchorPane = new AnchorPane(btn1, btn2, btn3, btn4, btn5, txt1, txt2, txt3, txt4);
//        BorderPane container = new BorderPane();
////        container.getChildren().add(btn1);
////        container.getChildren().addAll(btn2, btn3, btn4, btn5, txt1, txt2, txt3, txt4);
////        container.setTop(btn1);
////        container.setLeft(btn2);
////        container.setRight(btn3);
////        container.setBottom(btn4);
////        container.setCenter(btn5);
//
////        btn1.setLayoutX(250);
////        btn1.setLayoutY(250);
////
////        btn2.setLayoutX(100);
////        btn2.setLayoutY(250);
//
//        BorderPane.setAlignment(btn1, Pos.CENTER);
//        BorderPane.setAlignment(btn2, Pos.CENTER);
//        BorderPane.setAlignment(btn3, Pos.CENTER);
//        BorderPane.setAlignment(btn4, Pos.CENTER);
//        BorderPane.setAlignment(btn5, Pos.CENTER);
//
//        Scene mainScene = new Scene(container);
//        primaryStage.setScene(mainScene);
//
//
//        primaryStage.setTitle("My first FX application");
//        primaryStage.setHeight(500);
//        primaryStage.setWidth(500);
//        primaryStage.show();
//        primaryStage.centerOnScreen();
    }

    private void grdPaneDemo() {
        Stage stage = new Stage();

        Label labelTitle = new Label("Customer Details");
        labelTitle.setFont(Font.font(20));
        Label lblId = new Label("Enter ID");
        Label lblName = new Label("Enter Name");
        Label lblAddress = new Label("Enter Address");

        TextField txtId = new TextField();
        TextField txtName = new TextField();
        TextArea txtAddress = new TextArea();

        Button btnSave = new Button("Save");

        btnSave.setOnAction(event -> {
            System.out.println("IJSE");
            hBoxDemo();
        });

        GridPane container = new GridPane();

        container.add(labelTitle, 0, 0, 2, 1);
        container.add(lblId, 0, 1);
        container.add(txtId,1,1);
        container.add(lblName, 0, 2);
        container.add(txtName, 1, 2);
        container.add(lblAddress, 0, 3);
        container.add(txtAddress, 1, 3);
        container.add(btnSave, 1, 4);
        container.setHgap(10);
        container.setVgap(10);
        container.setPadding(new Insets(20));

//        container.setGridLinesVisible(true);

        GridPane.setHalignment(labelTitle, HPos.CENTER);


        Scene scene = new Scene(container);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setTitle("Grid Pane Demo");
        stage.show();
        stage.centerOnScreen();
    }

    private void hBoxDemo() {
        Stage stage = new Stage();

        Button[] buttons = new Button[5];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button("Button " + (i + 1));
        }

        HBox hBox = new HBox(10, buttons);
        Scene scene = new Scene(hBox);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setTitle("HBox Demo");
        stage.show();
        stage.centerOnScreen();
    }

    private void vBoxDemo() {
        Stage stage = new Stage();

        Button[] buttons = new Button[5];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button("Button " + (i + 1));
        }

        VBox vBox = new VBox(10, buttons);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setTitle("VBox Demo");
        stage.show();
        stage.centerOnScreen();
    }


}
