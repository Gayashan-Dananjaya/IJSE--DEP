package lk.ijse.dep10.mediaplayer;

import com.sun.prism.paint.Gradient;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.text.Style;
import java.io.File;

public class AppInitializer extends Application {

    private MediaPlayer mediaPlayer;
    private boolean isSelected = false;
    private boolean isPlaying = false;
    public int count = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btnOpen = new Button("Open Audio File");
//        Label lblSong = new Label("Default");
        TextField txtSong = new TextField();
        ImageView imgPlay = new ImageView();
        ImageView imgPause = new ImageView();
        ImageView imgStop = new ImageView();
        ImageView imgRepeat = new ImageView();
        ImageView imgVolume = new ImageView();
        Slider slider = new Slider(0, 1, 1);

        HBox hBox = new HBox(imgPlay, imgPause, imgStop, imgRepeat, imgVolume, slider);
        VBox vBox = new VBox(btnOpen, txtSong, hBox);

        setStyles(btnOpen, txtSong, imgPlay, imgPause, imgStop, imgRepeat, imgVolume, slider, hBox, vBox);
        assignImages(imgPlay,imgPause,imgStop,imgRepeat,imgVolume);

        primaryStage.setScene(new Scene(vBox));
        primaryStage.setTitle("Audio Player");
        primaryStage.setWidth(900);
        primaryStage.setHeight(300);
        primaryStage.show();
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);


        /*Event Listeners*/
        {
            btnOpen.setOnAction(actionEvent -> {
                FileChooser fileChooser = new FileChooser();

                fileChooser.setTitle("Select an audio file");
                File audioFile = fileChooser.showOpenDialog(null);

                if (audioFile != null) {
                    Media media = new Media(audioFile.toURI().toString());
                    txtSong.setText(audioFile.toURI().toString());
                    mediaPlayer = new MediaPlayer(media);

                    imgPlay.setOpacity(1);
                    isSelected = true;

                } else mediaPlayer = null;
            });
            btnOpen.setOnMouseEntered(mouseEvent -> btnOpen.setOpacity(0.7));
            btnOpen.setOnMouseExited(mouseEvent -> btnOpen.setOpacity(1));
            btnOpen.setOnMousePressed(mouseEvent -> btnOpen.setEffect(new InnerShadow(20,Color.DARKBLUE)));
            btnOpen.setOnMouseReleased(mouseEvent -> btnOpen.setEffect(null));

            imgPlay.setOnMouseEntered(mouseEvent -> {
                if (isSelected && !isPlaying) {
                    imgPlay.setOpacity(0.7);
                    imgPlay.setCursor(Cursor.HAND);
                }
            });
            imgPlay.setOnMouseExited(mouseEvent -> {
                if (isSelected && !isPlaying) {
                    imgPlay.setOpacity(1);
                }
            });
            imgPlay.setOnMousePressed(mouseEvent -> {
                if (isSelected) {
                    imgPlay.setEffect(new InnerShadow(20, Color.BLUE));
                }
            });
            imgPlay.setOnMouseReleased(mouseEvent -> {
                if (isSelected) {
                    imgPlay.setEffect(null);
//                    if (count == 0) {
//                        Image icnVolume = new Image(this.getClass().getResource("/controls/volumeOff").toString());
//                        imgVolume.setImage(icnVolume);
//                        count++;
//                    }



                    if (mediaPlayer != null) {
                        if (count == 0) {
                            Image icnVolume = new Image(this.getClass().getResource("/controls/volumeOn.png").toString());
                            imgVolume.setImage(icnVolume);
                            count = 1;
                        }
                        mediaPlayer.play();
                        isPlaying = true;
                        Image icnPlay = new Image(this.getClass().getResource("/controls/playOn.png").toString());
                        imgPlay.setImage(icnPlay);
                        Image icnPause = new Image(this.getClass().getResource("/controls/pauseOff.png").toString());
                        imgPause.setImage(icnPause);
                        Image icnStop = new Image(this.getClass().getResource("/controls/stopOff.png").toString());
                        imgStop.setImage(icnStop);
                        imgStop.setOpacity(1);
                        imgRepeat.setOpacity(1);
                        imgVolume.setOpacity(1);
                        slider.setOpacity(1);
                        imgPause.setOpacity(1);
                    }
                }
            });

            imgPause.setOnMouseEntered(mouseEvent -> {
                if (isPlaying) {
                    imgPause.setOpacity(0.7);
                    imgPause.setCursor(Cursor.HAND);
                }
            });
            imgPause.setOnMouseExited(mouseEvent -> {
                if (isPlaying) {
                    imgPause.setOpacity(1);
                }
            });
            imgPause.setOnMousePressed(mouseEvent -> {
                if (isSelected) {
                    imgPause.setEffect(new InnerShadow(20, Color.BLUE));
                }
            });
            imgPause.setOnMouseReleased(mouseEvent -> {
                if (isSelected) {
                    imgPause.setEffect(null);
                    if (isPlaying) {
                        isPlaying = false;
                        mediaPlayer.pause();
                        Image icnPause = new Image(this.getClass().getResource("/controls/pauseOn.png").toString());
                        imgPause.setImage(icnPause);
                        Image icnPlay = new Image(this.getClass().getResource("/controls/playOff.png").toString());
                        imgPlay.setImage(icnPlay);
                    }
                }
            });

            imgStop.setOnMouseEntered(mouseEvent -> {
                if (isPlaying) {
                    imgStop.setOpacity(0.7);
                    imgStop.setCursor(Cursor.HAND);
                }
            });
            imgStop.setOnMouseExited(mouseEvent -> {
                if (isPlaying) {
                    imgStop.setOpacity(1);
                }
            });
            imgStop.setOnMousePressed(mouseEvent -> {
                if (isSelected) {
                    imgStop.setEffect(new InnerShadow(20, Color.BLUE));
                }
            });
            imgStop.setOnMouseReleased(mouseEvent -> {
                if (isSelected) {
                    imgStop.setEffect(null);
                    if (isPlaying) {
                        isPlaying = false;
                        mediaPlayer.stop();
                        Image icnStop = new Image(this.getClass().getResource("/controls/stopOn.png").toString());
                        imgStop.setImage(icnStop);
                        Image icnPlay = new Image(this.getClass().getResource("/controls/playOff.png").toString());
                        imgPlay.setImage(icnPlay);
                        Image icnPause = new Image(this.getClass().getResource("/controls/pauseOff.png").toString());
                        imgPause.setImage(icnPause);
                    }
                }
            });

            imgRepeat.setOnMouseEntered(mouseEvent -> {
                if (isSelected) {
                    imgRepeat.setOpacity(0.7);
                    imgRepeat.setCursor(Cursor.HAND);
                }
            });
            imgRepeat.setOnMouseExited(mouseEvent -> {
                if (isSelected) {
                    imgRepeat.setOpacity(1);
                }
            });
            imgRepeat.setOnMousePressed(mouseEvent -> {
                if (isSelected) {
                    imgRepeat.setEffect(new InnerShadow(20, Color.BLUE));
                }
            });
            imgRepeat.setOnMouseReleased(mouseEvent -> {
                if (isSelected) {
                    imgRepeat.setEffect(null);
                    mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
                    Image icnRepeat = new Image(this.getClass().getResource("/controls/repeatOn.png").toString());
                    imgRepeat.setImage(icnRepeat);
                }
            });

            imgVolume.setOnMouseEntered(mouseEvent -> {
                if (isSelected) {
                    imgVolume.setOpacity(0.7);
                    imgVolume.setCursor(Cursor.HAND);
                }
            });
            imgVolume.setOnMouseExited(mouseEvent -> {
                if (isSelected) {
                    imgVolume.setOpacity(1);
                }
            });
            imgVolume.setOnMousePressed(mouseEvent -> {
                if (isSelected) {
                    imgVolume.setEffect(new InnerShadow(20, Color.BLUE));
                }
            });
            imgVolume.setOnMouseReleased(mouseEvent -> {
                if (isSelected) {
                    imgVolume.setEffect(null);
                    if (!(mediaPlayer.isMute())) {
                        mediaPlayer.setMute(true);
                        Image icnVolume = new Image(this.getClass().getResource("/controls/volumeOff.png").toString());
                        imgVolume.setImage(icnVolume);
                    } else {
                        mediaPlayer.setMute(false);
                        Image icnVolume = new Image(this.getClass().getResource("/controls/volumeOn.png").toString());
                        imgVolume.setImage(icnVolume);
                    }
                }
            });

            slider.valueProperty().addListener((observableValue, oldValue, currentValue) -> {
                if (isSelected) mediaPlayer.setVolume(slider.getValue());
            });
        }

    }

    private void setStyles(Button btnOpen, TextField txtSong, ImageView imgPlay, ImageView imgPause, ImageView imgStop, ImageView imgRepeat, ImageView imgVolume, Slider slider, HBox hBox, VBox vBox) {
        Font fontButton = Font.font("", FontWeight.SEMI_BOLD, 20);
        Font fontLabel = Font.font("", FontWeight.THIN, 20);

        txtSong.setFont(fontLabel);
        txtSong.setPromptText("Select a song to play");
//        txtSong.setEditable(false);
//        txtSong.setPrefHeight(8);
        txtSong.setFont(new Font(16));

        btnOpen.setFont(fontButton);
//        btnOpen.setShape(new Rectangle(500,50,Color.BLUE));
        btnOpen.setBackground(Background.fill(Color.LIGHTBLUE));
        btnOpen.setPrefWidth(200);
        btnOpen.setTextFill(Color.DARKBLUE);
        btnOpen.setBorder(Border.stroke(Color.DARKBLUE));
        btnOpen.setDefaultButton(true);
        btnOpen.setStyle("-fx-background-color: #20B2AA; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        btnOpen.setBorder(Border.EMPTY);

//        btnOpen.setTranslateX(-280);

        imgPlay.setFitWidth(60);
        imgPlay.setFitHeight(60);
//        imgPlay.setCursor(Cursor.HAND);
        imgPlay.setOpacity(0.2);

        imgPause.setFitWidth(60);
        imgPause.setFitHeight(60);
//        imgPause.setCursor(Cursor.HAND);
        imgPause.setOpacity(0.2);

        imgStop.setFitWidth(60);
        imgStop.setFitHeight(60);
//        imgStop.setCursor(Cursor.HAND);
        imgStop.setOpacity(0.2);

        imgRepeat.setFitWidth(60);
        imgRepeat.setFitHeight(60);
//        imgRepeat.setCursor(Cursor.HAND);
        imgRepeat.setOpacity(0.2);

        imgVolume.setFitWidth(60);
        imgVolume.setFitHeight(60);
//        imgVolume.setCursor(Cursor.HAND);
        imgVolume.setOpacity(0.2);

//        slider.setCursor(Cursor.HAND);
        slider.setOpacity(0.2);

//        RadialGradient gradient = new RadialGradient();
        LinearGradient gradient = new LinearGradient(
                0, //start X
                0, // start Y
                1, //end X
                1, //end Y
                true,
                CycleMethod.NO_CYCLE,
                new Stop(0.1f, Color.LIGHTSKYBLUE),
                new Stop(1.0f, Color.LIGHTPINK)
        );


        vBox.setPadding(new Insets(30));
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(40);
        vBox.setBackground(Background.fill(gradient));
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(60);
    }

    private void assignImages(ImageView imgPlay, ImageView imgPause, ImageView imgStop, ImageView imgRepeat, ImageView imgVolume) {
        Image icnPlay = new Image(this.getClass().getResource("/controls/playOff.png").toString());
        Image icnPause = new Image(this.getClass().getResource("/controls/pauseOff.png").toString());
        Image icnStop = new Image(this.getClass().getResource("/controls/stopOff.png").toString());
        Image icnRepeat = new Image(this.getClass().getResource("/controls/repeatOff.png").toString());
        Image icnVolume = new Image(this.getClass().getResource("/controls/volumeOff.png").toString());

        imgPlay.setImage(icnPlay);
        imgPause.setImage(icnPause);
        imgStop.setImage(icnStop);
        imgRepeat.setImage(icnRepeat);
        imgVolume.setImage(icnVolume);
    }

}
