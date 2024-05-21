package com.example.mainmenu2;

import javafx.application.Application;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.util.Objects;
import javafx.scene.media.AudioClip;
import java.util.Objects;

public class Sounds extends Application {

    public static void main(String[] args) {
        launch(args);
    }



    static AudioClip sound_3nab_Shoot = new AudioClip(Objects.requireNonNull(Sounds.class.getResource("/Sounds/Bew.mp3")).toExternalForm());

    static Media shocked = new Media(Objects.requireNonNull(Sounds.class.getResource("/Sounds/يا_نهار_ازرق_الرجل_الابنودي_الرجل_العنابmusic+vocals.mp3")).toExternalForm());
    static MediaPlayer shocked_3nab  = new MediaPlayer(shocked);

    static Media loss2Heart= new Media(Objects.requireNonNull(Sounds.class.getResource("/Sounds/براحه_علينا_ياعم_مش_كدا_عليا_النعمه_بلدوزرmusic+vocals.mp3")).toExternalForm());
    static MediaPlayer after_3nab_loss3Heart = new MediaPlayer(loss2Heart);

    static Media villan_die = new Media(Objects.requireNonNull(Sounds.class.getResource("/Sounds/AUDIO-2024-05-12-23-40-11.mp3")).toExternalForm());
    static MediaPlayer after_villan_die = new MediaPlayer(villan_die );

    static Media gameSound = new Media(Objects.requireNonNull(Sounds.class.getResource("/Sounds/risk-136788.mp3")).toExternalForm());
    static MediaPlayer soundOfGame= new MediaPlayer(gameSound);

    static Media loading = new Media(Objects.requireNonNull(Sounds.class.getResource("/Sounds/Tic Tac.mpeg")).toExternalForm());
    static MediaPlayer loading_Sound  = new MediaPlayer(loading);

    static Media victory = new Media(Objects.requireNonNull(Sounds.class.getResource("/Sounds/congratulations-deep-voice-172193.mp3")).toExternalForm());
    static MediaPlayer victorySound  = new MediaPlayer(victory);
    static Media videoSound = new Media(Objects.requireNonNull(Sounds.class.getResource("/Sounds/What1.mp4")).toExternalForm());
    static MediaPlayer video_Sound  = new MediaPlayer(videoSound);


    static Media gameOver = new Media(Objects.requireNonNull(Sounds.class.getResource("/Sounds/game-over-31-179699.mp3")).toExternalForm());
    static MediaPlayer game_Over  = new MediaPlayer(gameOver);

    static void SoundOfVideo(){
        video_Sound.play();
    }
    static void shoot_Sound (){
        sound_3nab_Shoot.setCycleCount(1);
        sound_3nab_Shoot.setVolume(.2);
        sound_3nab_Shoot.play();
    }
    static void sound_3nab_loss3Heart (){
        soundOfGame.stop();
        after_3nab_loss3Heart.setCycleCount(1);
        after_3nab_loss3Heart.setOnEndOfMedia(()->game_Over.play());
        after_3nab_loss3Heart.play();
    }
    static void after_villan_die(){
        soundOfGame.stop();
        after_villan_die .setCycleCount(1);
        after_villan_die .setOnEndOfMedia(()->victorySound.play());
        after_villan_die .play();
    }


    static void GameBeganningSound(){

        shocked_3nab.setCycleCount(1);
        loading_Sound.setOnEndOfMedia(()->shocked_3nab.play());
        shocked_3nab.setOnEndOfMedia(()->soundOfGame.play());
        loading_Sound.play();
    }

    @Override
    public void start(Stage primaryStage) {

    }
}

