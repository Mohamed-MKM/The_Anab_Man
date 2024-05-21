package com.example.mainmenu2;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import static com.example.mainmenu2.Shots.PlayerHits;
import static com.example.mainmenu2.VillianCharacter.*;
import static com.example.mainmenu2.mainCharacter.*;

public class healthBars extends Pane {
    private static healthBars healthBars = new healthBars();
    public  ImageView[] playerHearts = new ImageView[3];
    public  ImageView[] playerBack = new ImageView[3];
    public  ImageView[] villianHearts = new ImageView[9];
    private double IV_1_4_X = 70;
    private double IVY = 55;
    private double IVX_Boss = 1190;
    private double IVY_Boss = 0;
    private double IVW_Boss = 500;
    private double IVH_Boss = 300;
    public static int counter = 0;
    public static boolean GameVictory = false;

    public static boolean gameOverShown = false;
   // private static int d = 1;

    public healthBars() {
        Image[] playerHeartImages = {
                new Image("heart.png"),
                new Image("heart.png"),
                new Image("heart.png")
        };

        Image[] playerHeartBack = {
                new Image("heart background.png"),
                new Image("heart background.png"),
                new Image("heart background.png")
        };
        double playerHeartSpacing = 45;
        for (int i = 0; i < playerHearts.length; i++) {
            playerBack[i] = new ImageView(playerHeartBack[i]);
            playerBack[i].setFitWidth(40);
            playerBack[i].setFitHeight(50);
            playerBack[i].setX(IV_1_4_X + i * playerHeartSpacing);
            playerBack[i].setY(IVY);
            playerHearts[i] = new ImageView(playerHeartImages[i]);
            playerHearts[i].setFitWidth(40);
            playerHearts[i].setFitHeight(50);
            playerHearts[i].setX(IV_1_4_X + i * playerHeartSpacing);
            playerHearts[i].setY(IVY);
            getChildren().addAll(playerBack[i],playerHearts[i]);
        }
        String[] villainHeartPaths = {
                "00.png", "10.png", "20.png", "30.png", "40.png",
                "50.png", "60.png", "70.png", "80.png"
        };
        for (int i = 0; i < villianHearts.length; i++) {
            Image villainHeartImage = new Image(villainHeartPaths[i]);
            villianHearts[i] = new ImageView(villainHeartImage);
            villianHearts[i].setFitWidth(IVW_Boss);
            villianHearts[i].setFitHeight(IVH_Boss);
            villianHearts[i].setX(IVX_Boss );
            villianHearts[i].setY(IVY_Boss);
            getChildren().add(villianHearts[i]);
        }
    }
    public void updatePlayerShootPosition() {
        // Loop over all hits to move them and check for collision
        // this way you can have as many hit objects as you want!!
        for (Rectangle hit : PlayerHits) {
            if (R2.getX() < R1.getX())
                hit.setX(hit.getX() - ShootSpeed);
            if (R2.getX() > R1.getX())
                hit.setX(hit.getX() + ShootSpeed);
            try {
                if (hit.getBoundsInParent().intersects(R2.getBoundsInParent())) {
                    Shots.shoot3nabCounter++;
                }
                if (Shots.shoot3nabCounter == 10 ) {
                    ((Pane) R1.getParent()).getChildren().remove(villianHearts[8]);
                }
                if (Shots.shoot3nabCounter == 20) {
                    ((Pane) R1.getParent()).getChildren().remove(villianHearts[7]);
                }
                if (Shots.shoot3nabCounter == 30) {
                    ((Pane) R1.getParent()).getChildren().remove(villianHearts[6]);
                }
                if (Shots.shoot3nabCounter == 40) {
                    ((Pane) R1.getParent()).getChildren().remove(villianHearts[5]);
                }
                if (Shots.shoot3nabCounter == 50) {
                    ((Pane) R1.getParent()).getChildren().remove(villianHearts[4]);
                }
                if (Shots.shoot3nabCounter == 60) {
                    ((Pane) R1.getParent()).getChildren().remove(villianHearts[3]);
                }
                if (Shots.shoot3nabCounter == 70) {
                    ((Pane) R1.getParent()).getChildren().remove(villianHearts[2]);
                }
                if (Shots.shoot3nabCounter == 80) {
                    Sounds.after_villan_die();
                    ((Pane) R1.getParent()).getChildren().remove(R2);
                    ((Pane) R1.getParent()).getChildren().remove(villianHearts[1]);
                    GameVictory = true;
                    //Lv_Load2();
                }
                if (hit.getBoundsInParent().intersects(R2.getBoundsInParent()) /*|| Move_L*/ ) {
                    ((Pane) R2.getParent()).getChildren().remove(hit);
                    // Remove hit from arraylist to save memory!
                    PlayerHits.remove(hit);
                }
            } catch (NullPointerException e) {
                System.out.println("Null Pointer Exception: " + e.getMessage());
            }
        }
    }
    public void updateVillainShootPosition() {
        // Loop over all hits to move them and check for collision
        // this way you can have as many hit objects as you want!!
        for (Rectangle hit : VillianHits) {
            if (R1.getX() < R2.getX())
                hit.setX(hit.getX() - ShootSpeed);
            if (R1.getX() > R2.getX())
                hit.setX(hit.getX() + ShootSpeed);
            try {
                if (hit.getBoundsInParent().intersects(R1.getBoundsInParent())) {
                    shootVillainCounter++;
                }
                if (shootVillainCounter == 20) {
                    (( Pane) R2.getParent()).getChildren().remove(playerHearts[2]);
                }
                if (shootVillainCounter == 40) {


                    ((Pane) R2.getParent()).getChildren().remove(playerHearts[1]);
                    // Last Heart Animation
                    FadeTransition ft = new FadeTransition(Duration.millis(500), playerHearts[0]);
                    ft.setFromValue(1);
                    ft.setToValue(0.1);
                    ft.setByValue(0.2);
                    ft.setCycleCount(Animation.INDEFINITE);
                    ft.play();

                }
                if (shootVillainCounter == 80 ) {
                    Sounds.sound_3nab_loss3Heart();
                    ((Pane) R2.getParent()).getChildren().remove(playerHearts[0]);
                    ((Pane) R2.getParent()).getChildren().remove(R1);
//                    GameOverAnimation();

                    gameOverShown = true;




                    ///////////////////////Control scene //////////////////////////


                }
//                gameOverShown = false;

                if (hit.getBoundsInParent().intersects(R1.getBoundsInParent())|| !((Pane) R2.getParent()).getChildren().contains(R1)) {
                    ((Pane) R2.getParent()).getChildren().remove(hit);
                    // Remove hit from arraylist to save memory!
                    VillianHits.remove(hit);
                }
            } catch (NullPointerException e) {
                System.out.println("Null Pointer Exception: " + e.getMessage());
            }
        }
    }
/*    public void GameOverAnimation(){
        GameOver gameOver = new GameOver();
        Stage gameOverStage = new Stage();

        gameOver.start(gameOverStage);
    }*/

   /* public void Lv_Load2(){


        Loading2 loading2 = new Loading2();
        Stage LoadingStage2 = new Stage();

        try{
            loading2.start(LoadingStage2);//1st loading screen
        }catch (Exception e){
            e.printStackTrace();
        }
        LoadingStage2.show();

        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(5.5));
        pauseTransition.setOnFinished(e->{
            LoadingStage2.close();

            LVL2 lvl2 = new LVL2();

            Stage lvl2Stage = new Stage();
            try {
                lvl2.start(lvl2Stage);//lvl 2 gameplay
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            lvl2Stage.show();

        });
        pauseTransition.play();

    }*/
   public static void GameOverAnimation(){
       GameOver gameOver = new GameOver();
       Stage gameOverStage = new Stage();

       gameOver.start(gameOverStage);
   }

    public static void victoryAnimate(){
        Victory victory3 = new Victory();
        Stage victoryStage = new Stage();

        victory3.start(victoryStage);
    }

    public static healthBars getHealthBars() {
        return healthBars;
    }
}
