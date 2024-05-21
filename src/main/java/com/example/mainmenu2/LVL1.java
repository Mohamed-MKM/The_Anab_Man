package com.example.mainmenu2;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import javafx.util.Duration;

import static com.example.mainmenu2.VillianCharacter.*;
import static com.example.mainmenu2.healthBars.*;
import static com.example.mainmenu2.mainCharacter.*;


public class LVL1 extends Application {
    Stage window1;
    Scene scene1;
    private static int d = 1;


    private boolean gameOverShown = false;
    private boolean GameVictory = false;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        window1 = primaryStage;

        mainCharacter Anab = mainCharacter.getAnab();
        VillianCharacter Villian = VillianCharacter.getvillian();
        Clouds clouds = Clouds.getClouds();
        healthBars health_Bars = healthBars.getHealthBars();
        Shots shots = new Shots();
        ///////////////// Main Pane /////////////////
        StackPane backGround = new StackPane();
        backGround.setStyle("-fx-background-image: url('lvl1.png');" +
                "-fx-background-size: Contain ");
        Group p1=new Group();
        health_Bars.getChildren().addAll(R1,R2);
        Pane pane = new Pane
                (health_Bars,clouds,p1);
        backGround.getChildren().addAll(pane);
        scene1 = new Scene(backGround , 600, 400);
        pane.setPadding(new Insets(50));
        primaryStage.setScene(scene1);
        primaryStage.show();
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("The Amazing 3nab Man");
        ///////////////// Main Character Movement /////////////////


        scene1.setOnMousePressed(e->{


        });

        scene1.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.D) {
                Move_R = true;
                if(Move_R && !jump){
                    R1.setFill(new ImagePattern(frameRight));
                }
            } else if (e.getCode() == KeyCode.A) {
                Move_L = true;
                if(Move_L && !jump){
                    R1.setFill(new ImagePattern(frameRight));
                }
            } else if (e.getCode() == KeyCode.SPACE && !jump) {

                jump = true;
            }
        });



        scene1.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.D) {
                Move_R = false;
                R1.setFill(new ImagePattern(frameStandRight));
            } else if (e.getCode() == KeyCode.A) {
                Move_L = false;
                R1.setFill(new ImagePattern(frameStandRight));
            }

            if (gameOverShown){
                GameOverAnimation();

                gameOverShown=false;
            }
            if(GameVictory){
                victoryAnimate();
                GameVictory=false;

            }
        });
        ///////////////// Main Character Movement /////////////////
        scene1.setOnMousePressed(mouseEvent -> {
            if (mouseEvent.isPrimaryButtonDown()) {
                shots.playerShoot();
                if (healthBars.gameOverShown){
                    GameOverAnimation();
                    gameOverShown=false;
                   // PauseTransition pt = new PauseTransition(Duration.millis(10000));
                }
                if(healthBars.GameVictory){
                    victoryAnimate();
                    GameVictory=false;
                }




            }

        });
        scene1.setOnMouseReleased(mouseEvent -> {
            if (mouseEvent.isPrimaryButtonDown()) {
                if (health_Bars.gameOverShown){
                    GameOverAnimation();
                    gameOverShown =false;
                    // PauseTransition pt = new PauseTransition(Duration.millis(10000));

                }
                if(healthBars2.GameVictory2){
                    victoryAnimate();
                    GameVictory=false;
                }
            }
        });




        ///////////////////////Control scene //////////////////////////
      /*  if (health_Bars.gameOverShown == true){
            window1.close();
            health_Bars.GameOverAnimation();
            health_Bars.gameOverShown = false;
        }*/
        if (((Pane) R1.getParent()).getChildren().isEmpty() && !gameOverShown) {
            // Show GameOver scene
            health_Bars.GameOverAnimation();
            gameOverShown = true; // Set flag to true to indicate that GameOver scene has been shown
        }
        if (((Pane) R1.getParent()).getChildren().isEmpty() && !GameVictory) {
            // Show GameOver scene
            health_Bars.victoryAnimate();
            GameVictory = true; // Set flag to true to indicate that GameOver scene has been shown
        }

        ///////////////// USE ONLY ONE AnimationTimer /////////////////
        AnimationTimer T1 = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // count how many times a second the loop iterates, normally its 60 times per
                // second

                iteration++;
                if (iteration == 61)
                    iteration = 0;

                ///////////////// 3nab Animation Move /////////////////
                Anab.Moving_Right();
                Anab.Moving_Left();
                Anab.Jumping();
                Anab.Gravity();
                ///////////////// 3nab Animation Shoot /////////////////
                health_Bars.updatePlayerShootPosition();
                ///////////////// Villain Animation Move /////////////////
                Villian.VillianMovement();
                Villian.Villian_Jump();
                health_Bars.updateVillainShootPosition();

                ///////////////// Villain Animation Shoots /////////////////
                // execute every half a second
                if (iteration == 30 || iteration == 60) {
                    shots.villianShoot();
                }


                  //  GameOverAnimation();
                    

            }
        };
        T1.start();
    }
}