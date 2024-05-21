package com.example.mainmenu2;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import static com.example.mainmenu2.VillianCharacter.R2;
import static com.example.mainmenu2.mainCharacter.R1;


public class HelloController {
    @FXML
    public Button Settings;
    @FXML
    private Button Quit2;
    @FXML
    private Button BackToMenu;
    @FXML
    private Button Play;
    private StackPane stackPane;
    @FXML
    private MediaView mediaView;
    private HelloApplication helloApplication;
    @FXML
    private ImageView sandClockView;
    @FXML
    private ImageView sandClockImage;
    @FXML
    private Media media;
    private MediaPlayer mediaPlayer;
    @FXML
    private Slider volumeSlider;
/*
    @FXML
    private Button Easy;
    @FXML
    private Button Hard;
*/






    public void setHelloApplication(HelloApplication helloApplication) {
        this.helloApplication = helloApplication;
    }
    /////////////////////////Sounds////////////////////////
    @FXML
    static AudioClip button_click_sound = new AudioClip(Objects.requireNonNull(HelloApplication.class.getResource("/Sounds/multi-pop-2-188167.mp3")).toExternalForm());

    @FXML
    private void SoundOfClickButton(){
        button_click_sound .setCycleCount(1);
        button_click_sound .play();
    }


    @FXML
    private void play(ActionEvent event) throws IOException  {

        Sounds.SoundOfVideo();
        Stage stage = (Stage) Play.getScene().getWindow();
        VideoPlayer VP1 = new VideoPlayer();
        Stage VPStage = new Stage();
        try{
            VP1.start(VPStage);
        }catch (Exception e){
            e.printStackTrace();
        }
        VPStage.show();

        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(7));
        pauseTransition.setOnFinished(e->{
            VPStage.close();
            BtnLevels BT1 = new BtnLevels();

            Stage bTstage = new Stage();
            try {
                BT1.start(bTstage);
            }catch (Exception ex){
                ex.printStackTrace();
            }

            bTstage.show();

        });
        pauseTransition.play();


        stage.close();


    }


    public static void gameover(){
        GameOver gameOver = new GameOver();
        Stage GameOverStage = new Stage();
        try {
            gameOver.start(GameOverStage);//1st loading screen
        } catch (Exception e2x) {
            e2x.printStackTrace();
        }
        GameOverStage.show();

        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(5.5));
        pauseTransition.setOnFinished(e -> GameOverStage.close());
        pauseTransition.play();
    }

    @FXML
    private void QuitF(ActionEvent event) {
        SoundOfClickButton();
        Stage stage = (Stage) Quit2.getScene().getWindow();
        stage.close();
    }
/*    @FXML
    private void HardBtn(ActionEvent event) {

    }
    @FXML
    private void EasyBtn(ActionEvent event) {

    }*/

    @FXML
    private void OpeningSettings(ActionEvent event) {
        SoundOfClickButton();
        try {
            // Get the stage of the current FXML file
            Stage currentStage = (Stage) Settings.getScene().getWindow();

            // Load the new FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SettingMenu.fxml"));
            Parent root = fxmlLoader.load();

            // Create a fade transition for smoother transition
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();

            // Set the scene for the new FXML file
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.show();

            // Close the stage of the current FXML file
            currentStage.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void BacktoMenu(ActionEvent event) {
        SoundOfClickButton();
        try {
            // Get the stage of the current FXML file
            Stage currentStage = (Stage) Settings.getScene().getWindow();

            // Load the new FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ButtonQuit(5).fxml"));
            Parent root = fxmlLoader.load();

            // Create a fade transition for smoother transition
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();

            // Set the scene for the new FXML file
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.show();

            // Close the stage of the current FXML file
            currentStage.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}



// Event handler method for adding GIF to the project













