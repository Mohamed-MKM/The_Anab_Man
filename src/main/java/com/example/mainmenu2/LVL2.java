package com.example.mainmenu2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

import static com.example.mainmenu2.Shots2.*;
import static com.example.mainmenu2.VillianCharacter2.*;
import static com.example.mainmenu2.healthBars.GameOverAnimation;
import static com.example.mainmenu2.healthBars.victoryAnimate;
import static com.example.mainmenu2.healthBars2.*;
import static com.example.mainmenu2.mainCharacter.*;

public class LVL2 extends Application {
    Stage window2;
    Scene scene2;
    public boolean gameOverShown2 = false;
    private boolean GameVictory2 = false;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        window2 = primaryStage;
        mainCharacter Anab = mainCharacter.getAnab();
        VillianCharacter2 Villian2 = VillianCharacter2.getvillian2();
        Clouds clouds = Clouds.getClouds();
        healthBars2 health_Bars = new healthBars2();
        Shots2 shots2 = new Shots2();
        ///////////////// Main Pane /////////////////
        StackPane backGround = new StackPane();
        backGround.setStyle("-fx-background-image: url('Lvl2.png');" +
                "-fx-background-size: Contain ");
        Group p1=new Group();
        health_Bars.getChildren().addAll(R1,R2);
        Pane pane = new Pane
                (health_Bars,clouds,p1);
        backGround.getChildren().addAll(pane);
        scene2 = new Scene(backGround , 600, 400);
        pane.setPadding(new Insets(50));
        primaryStage.setScene(scene2);
        primaryStage.show();
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("The Amazing 3nab Man");

        ///////////////// Main Character Movement /////////////////

        scene2.setOnKeyPressed(e -> {
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
        scene2.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.D) {
                Move_R = false;
                R1.setFill(new ImagePattern(frameStandRight));
            } else if (e.getCode() == KeyCode.A) {
                Move_L = false;
                R1.setFill(new ImagePattern(frameStandRight));
            }
            if (gameOverShown2){
                GameOverAnimation();

                gameOverShown2=false;
            }
            if(GameVictory2){
                victoryAnimate();
                GameVictory2=false;

            }
        });
        ///////////////// Main Character Movement /////////////////
        scene2.setOnMousePressed(mouseEvent -> {
            if (mouseEvent.isPrimaryButtonDown()) {
                shots2.playerShoot();
                if (health_Bars.gameOverShown2){
                    GameOverAnimation();
                    gameOverShown2 =false;
                    // PauseTransition pt = new PauseTransition(Duration.millis(10000));

                }
                if(healthBars2.GameVictory2){
                    victoryAnimate();
                    GameVictory2=false;
                }
            }
        });
        scene2.setOnMouseReleased(mouseEvent -> {
            if (mouseEvent.isPrimaryButtonDown()) {
                if (health_Bars.gameOverShown2){
                    GameOverAnimation();
                    gameOverShown2 =false;
                    // PauseTransition pt = new PauseTransition(Duration.millis(10000));

                }
                if(healthBars2.GameVictory2){
                    victoryAnimate();
                    GameVictory2=false;
                }
            }
        });
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
                Villian2.VillianMovement();
                Villian2.Villian_Jump();
                health_Bars.updateVillainShootPosition();
                ///////////////// Villain Animation Shoots /////////////////
                // execute every half a second
                if (iteration == 30 || iteration == 60) {
                    shots2.villianShoot();
                }
            }
        };
        T1.start();
    }
}