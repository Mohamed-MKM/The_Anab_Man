package com.example.mainmenu2;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import java.io.IOException;

public class HelloApplication extends Application {

    private Stage stage;

    private String[] fxmlFiles = {"Opening.fxml", "Title(2).fxml", "Button1(3).fxml", "Button2(4).fxml", "ButtonQuit(5).fxml"};
    private int currentIndex = 0;

    @Override
    public void start(Stage primaryStage) {
         stage = primaryStage;
        loadNextFXML();


    }




    private void loadNextFXML() {
        if (currentIndex < fxmlFiles.length) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(fxmlFiles[currentIndex]));
                stage.setScene(new Scene(root));

                stage.show();
                currentIndex++;

                // Schedule loading the next FXML after a delay of 2 seconds
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> loadNextFXML()));
                timeline.play();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // All FXML files loaded
            System.out.println("All FXML files loaded.");
        }


    }

    public static void main(String[] args) {
        launch(args);
    }}


