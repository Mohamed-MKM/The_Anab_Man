package com.example.mainmenu2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class VideoPlayer extends Application {
    public MediaPlayer mediaPlayer;
    public MediaView mediaView;


    public void start(Stage primaryStage) {
        // Path to your MP4 file
        //String videoPath = "File:///D:/Problems-20240505T205501Z-001/Problems/JavaFX/Swapping/src/main/resources/intro.mp4";
        String videoPath = "File:///D:/intro2.mp4";
        // Create a Media object
        Media media = new Media(videoPath);

        // Create a MediaPlayer
        mediaPlayer = new MediaPlayer(media);

        mediaView = new MediaView(mediaPlayer);

        //Fit Screen height and width of the full screen

        mediaView.fitHeightProperty().bind(primaryStage.heightProperty());
        mediaView.fitWidthProperty().bind(primaryStage.widthProperty());
        mediaPlayer.setCycleCount(1);


        StackPane root = new StackPane();
        root.getChildren().add(mediaView);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Video Player");
        mediaPlayer.play();
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}