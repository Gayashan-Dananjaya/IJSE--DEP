package lk.ijse.dep10.app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AppInitializer extends Application {

    double x = 0;
    double y = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        /*Controls*/
        Image image = new Image(this.getClass().getResource("/img/background.png").toString());
        ImageView imageView = new ImageView(image);
        Button btnClose = new Button("X");
        Button btnMinimize = new Button("-");
        Slider slider = new Slider(0, 100, 0);

        /*Fonts*/
        Font fonBtnClose = Font.font("", FontWeight.BOLD, 25);
        Font fonBtnMinimize = Font.font("", FontWeight.BOLD, 35);

        /*btnClose styles*/
        btnClose.setTranslateY(35);
        btnClose.setTranslateX(650);
        btnClose.setBackground(Background.fill(Color.TRANSPARENT));
        btnClose.setFont(fonBtnClose);
        btnClose.setTextFill(Color.GRAY);

        /*btnMinimize styles*/
        btnMinimize.setTranslateY(22);
        btnMinimize.setTranslateX(610);
        btnMinimize.setBackground(Background.fill(Color.TRANSPARENT));
        btnMinimize.setFont(fonBtnMinimize);
        btnMinimize.setTextFill(Color.GRAY);

        /*Pane Creation*/
        AnchorPane root = new AnchorPane();
        root.getChildren().add(imageView);
        root.getChildren().add(btnClose);
        root.getChildren().add(btnMinimize);
        root.getChildren().add(slider);

        AnchorPane.setRightAnchor(imageView, 0.0);
        AnchorPane.setLeftAnchor(imageView, 0.0);
        AnchorPane.setTopAnchor(imageView, 0.0);
        AnchorPane.setBottomAnchor(imageView, 0.0);

        root.setBackground(Background.fill(Color.TRANSPARENT));
//        imageView.setOpacity(0.5);
        slider.setTranslateX(200);
        slider.setTranslateY(200);
        slider.blockIncrementProperty();
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(10);
        slider.setPrefWidth(400);

        /*Scene creation*/
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);

        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Undecorated Window");
        primaryStage.setWidth(800);
//        primaryStage.setHeight(900);
        primaryStage.setHeight(860);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.centerOnScreen();

        /*Event Listeners*/
        btnClose.setOnMouseClicked(actionEvent -> primaryStage.close());
        btnClose.setOnMouseEntered(mouseEvent -> btnClose.setTextFill(Color.RED));
        btnClose.setOnMouseExited(mouseEvent -> btnClose.setTextFill(Color.GRAY));

        btnMinimize.setOnMouseClicked(mouseEvent -> primaryStage.setIconified(true));
        btnMinimize.setOnMouseEntered(mouseEvent -> btnMinimize.setTextFill(Color.RED));
        btnMinimize.setOnMouseExited(mouseEvent -> btnMinimize.setTextFill(Color.GRAY));

        root.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getX();
            y = mouseEvent.getY();
        });

        root.setOnMouseReleased(mouseEvent -> {
            root.setCursor(Cursor.DEFAULT);
        });

        root.setOnMouseDragged(mouseEvent -> {
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                primaryStage.setX(mouseEvent.getScreenX() - x);
                primaryStage.setY(mouseEvent.getScreenY() - y);
                root.setCursor(Cursor.MOVE);
            }
        });

        slider.valueProperty().addListener((observableValue, number, t1) -> {
            System.out.println(t1);
        });
    }
}
