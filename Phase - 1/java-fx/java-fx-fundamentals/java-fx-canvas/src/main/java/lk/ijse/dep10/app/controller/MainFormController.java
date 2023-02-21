package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.net.CookieHandler;

public class MainFormController {
    double startX;
    double startY;
    double endX;
    double endY;
    double currentX;
    double currentY;
    double currentStartX = startX;
    double currentStartY = startY;

    @FXML
    private Canvas cnvMain;

    public void initialized() {
        GraphicsContext gc = cnvMain.getGraphicsContext2D();

//        gc.setFill(Color.BLUE);
//        gc.fillRect(50,50,200,150);  // x Coordinate, y Coordinate, width, height

//        gc.setFill(Color.RED);
//        gc.fillRoundRect(300,50,200,150,20,20);  // x Coordinate, y Coordinate, width, height, X radius, Y radius

        gc.setStroke(Color.RED);
        gc.strokeRect(50, 50, 150, 150);
        gc.clearRect(50,50,151,151);

        gc.setStroke(Color.BLUE);
        gc.strokeRoundRect(250, 50, 150, 150, 20, 20);

        gc.setFont(new Font(16));
        gc.setFill(Color.GREEN);
        gc.fillText("IJSE", 450, 75);

        gc.setFill(Color.DARKBLUE);
        gc.strokeText("IJSE", 450, 150);

        gc.setFill(Color.ORANGE);
        gc.fillOval(100,300,400,300);
    }

    public void cvnMainOnMousePressed(MouseEvent mouseEvent) {
        startX = mouseEvent.getX();
        startY = mouseEvent.getY();
    }

    public void cvnMainOnMouseReleased(MouseEvent mouseEvent) {
//        endX = mouseEvent.getX();
//        endY = mouseEvent.getY();
//        double temp;
//        if (startX > endX) {
//            temp = startX;
//            startX = endX;
//            endX = temp;
//        }
//        if (startY > endY) {
//            temp = startY;
//            startY = endY;
//            endY = temp;
//        }
//
//        GraphicsContext gc = cnvMain.getGraphicsContext2D();
//
//        gc.setFill(Color.BLUE);
//        gc.fillRect(startX,startY,(endX-startX),(endY-startY));  // x Coordinate, y Coordinate, width, height
    }

    public void cvnMainOnMouseDraggeded(MouseEvent mouseEvent) {
//        currentX = mouseEvent.getX();
//        currentY = mouseEvent.getY();
//
//        currentStartX = startX;
//        currentStartY = startY;
//
//        double temp;
//        if (currentStartX > currentX) {
//            temp = currentStartX;
//            currentStartX = currentX;
//            currentX = temp;
//        }
//        if (currentStartY > currentY) {
//            temp = currentStartY;
//            currentStartY = currentY;
//            currentY = temp;
//        }
//
//        GraphicsContext gc = cnvMain.getGraphicsContext2D();
//
//        gc.setFill(Color.LIGHTGRAY);
//        gc.fillRect(startX,startY,(currentX-startX),(currentY-startY));

        currentX = mouseEvent.getX();
        currentY = mouseEvent.getY();

        currentStartX = startX;
        currentStartY = startY;

        double temp;
        if (currentStartX > currentX) {
            temp = currentStartX;
            currentStartX = currentX;
            currentX = temp;
        }
        if (currentStartY > currentY) {
            temp = currentStartY;
            currentStartY = currentY;
            currentY = temp;
        }

        GraphicsContext gc = cnvMain.getGraphicsContext2D();

        gc.setStroke(Color.BLUE);
        gc.clearRect(0,0,cnvMain.getWidth(),cnvMain.getHeight());


        gc.strokeRect(currentStartX,currentStartY,(currentX-currentStartX),(currentY-currentStartY));

    }

    public void cvnMainOnMouseDragged(MouseEvent mouseEvent) {
        double[] array = getStartEnd(startX, startY, mouseEvent.getX(), mouseEvent.getY());
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        gc.clearRect(0,0,cnvMain.getWidth(),cnvMain.getHeight());
        gc.strokeRect(array[0], array[1], array[2]-array[0], array[3]-array[1]);
    }

    public double[] getStartEnd(double startX, double startY, double endX, double endY) {
        double temp;

        if (startX > endX) {
            temp = startX;
            startX = endX;
            endX = temp;
        }

        if (startY > endY) {
            temp = startY;
            startY = endY;
            endY = temp;
        }

        return new double[]{startX, startY, endX, endY};
    }



    public void clrStrokeOnAction(ActionEvent actionEvent) {
        GraphicsContext gs = cnvMain.getGraphicsContext2D();

    }

    public void clrFillOnAction(ActionEvent actionEvent) {
    }
}
