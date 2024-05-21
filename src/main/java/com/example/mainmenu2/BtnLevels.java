package com.example.mainmenu2;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Objects;

public class BtnLevels extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creating buttons
        Button button1 = new Button();
        button1.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 40px;");
        button1.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("Easy.png")))));
        button1.setStyle("-fx-background-color: transparent;");
        button1.setOnAction(event -> {
            Sounds.GameBeganningSound();
            // Handle button action here
            Loading1 loading1 = new Loading1();
            Stage looadingStage = new Stage();
            try{
                loading1.start(looadingStage);
            }catch (Exception e){
                e.printStackTrace();
            }
            looadingStage.show();

            PauseTransition pauseTransition = new PauseTransition(Duration.seconds(5.5));
            pauseTransition.setOnFinished(e->{
                looadingStage.close();
                LVL1 lvl1 = new LVL1();

                Stage lvl1Stage = new Stage();
                try {
                    lvl1.start(lvl1Stage);
                }catch (Exception ex){
                    ex.printStackTrace();
                }

                lvl1Stage.show();

            });
            pauseTransition.play();
        });




        Button button2 = new Button();
        button2.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 40px;");
        button2.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("Hard.png")))));
        button2.setStyle("-fx-background-color: transparent;");
        button2.setOnAction(event -> {
            Sounds.GameBeganningSound();
            // Handle button action here
            // Handle button action here

            Loading2 loading2 = new Loading2();
            Stage looadingStage2 = new Stage();
            try{
                loading2.start(looadingStage2);
            }catch (Exception e){
                e.printStackTrace();
            }
            looadingStage2.show();

            PauseTransition pauseTransition = new PauseTransition(Duration.seconds(5.5));
            pauseTransition.setOnFinished(e->{
                looadingStage2.close();
                LVL2 lvl2 = new LVL2();

                Stage lvl2Stage = new Stage();
                try {
                    lvl2.start(lvl2Stage);
                }catch (Exception ex){
                    ex.printStackTrace();
                }

                lvl2Stage.show();

            });
            pauseTransition.play();
        });


        // Creating images
        Image image1 = new Image("lvl1.png");
        Image image2 = new Image("Lvl2.png");

        // Creating image views
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);

        // Setting size for image views
        imageView1.setFitWidth(420);
        imageView1.setFitHeight(420);
        imageView2.setFitWidth(420);
        imageView2.setFitHeight(420);

        // Creating HBox for each button and image
        HBox hbox1 = new HBox(150);
        HBox hbox2 = new HBox(250);
        hbox1.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);

        // Adding image and button to the HBox
        hbox1.getChildren().addAll(imageView1, imageView2);
        hbox2.getChildren().addAll(button1, button2);

        // Setting spacing between image and button

        StackPane p2 = new StackPane();

        // Creating VBox to hold the HBoxes
        VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox1, hbox2);

        p2.getChildren().addAll(vbox);

        // Setting spacing between HBoxes
        vbox.setSpacing(90);

        // Setting padding
        vbox.setPadding(new Insets(80, 80, 80, 80));

        // Creating scene
        primaryStage.setTitle("Pick A Level");

        // Set background image
        Image backgroundImage = new Image("Background.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(1600, 900, false, false, false, false);
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        Background background = new Background(backgroundImg);
        p2.setBackground(background);

        Scene s1 = new Scene(p2); // Set the size of the scene

        // Adding scene to the stage
        primaryStage.setScene(s1);
        primaryStage.show();
        primaryStage.setFullScreen(true);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
