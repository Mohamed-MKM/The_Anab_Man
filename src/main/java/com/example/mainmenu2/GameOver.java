package com.example.mainmenu2;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Objects;

public class GameOver extends Application {
    private int currentIndex = 0;
    private String gameOverText = "Game Over";
    private Text text;
    @Override
    public void start(Stage primaryStage) {
        // Creating the root node (a StackPane)
        StackPane root = new StackPane();
        // Setting the background color to maroon
        root.setStyle("-fx-background-color: #480607;"); // Using hexadecimal color value for maroon
        // Adding earthquake effect
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.05), root);
        translateTransition.setByX(5);
        translateTransition.setByY(5);
        translateTransition.setAutoReverse(true);
        translateTransition.setCycleCount(1);
        translateTransition.play();
        // Creating the text object
        text = new Text();
        text.setFont(Font.font("Verdana", 150));
        text.setFill(Color.WHITE);
        // Applying dark shadow effect
        DropShadow glow = new DropShadow();
        glow.setColor(Color.BLACK);
        glow.setWidth(100); // Increased width for a more visible shadow
        glow.setHeight(100); // Increased height for a more visible shadow
        // Applying dark glow effect
        DropShadow darkGlow = new DropShadow();
        darkGlow.setColor(Color.rgb(0, 0, 0, 0.5)); // Dark color with some transparency
        darkGlow.setWidth(30);
        darkGlow.setHeight(30);
        darkGlow.setSpread(0.5); // Adjust spread for glow effect
        // Combining both effects
        text.setEffect(glow);
        text.setEffect(darkGlow);
        root.getChildren().add(text);
        // Setting up the animation timeline for text fade-in
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), text);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        // Setting up the animation timeline for text slide-in
        TranslateTransition slideTransition = new TranslateTransition(Duration.seconds(2), text);
        slideTransition.setFromY(-200);
        slideTransition.setToY(0);
        slideTransition.play();
        // Setting up the text distortion animation (scaling)
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), text);
        scaleTransition.setByX(1.2);
        scaleTransition.setByY(1.2);
        scaleTransition.setCycleCount(Animation.INDEFINITE);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
        // Setting up the background animation (color change)
        Timeline backgroundTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(root.backgroundProperty(),
                        new Background(new BackgroundFill(Color.rgb(72, 6, 7), CornerRadii.EMPTY, Insets.EMPTY)))),
                new KeyFrame(Duration.seconds(3), new KeyValue(root.backgroundProperty(),
                        new Background(new BackgroundFill(Color.rgb(7, 6, 72), CornerRadii.EMPTY, Insets.EMPTY))))
        );
        backgroundTimeline.setCycleCount(1);
        backgroundTimeline.setAutoReverse(true);
        backgroundTimeline.play();
        // Setting up the animation timeline for text appearance
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.3), event -> showNextLetter())
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        // Getting screen dimensions
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        // Creating the scene with fullscreen dimensions
        Scene scene = new Scene(root, screenBounds.getWidth(), screenBounds.getHeight());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game Over Animation");
        primaryStage.setFullScreen(true);
        primaryStage.show();
        Button mainMenuButton = new Button("Main Menu");
        mainMenuButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 40px;");
        mainMenuButton.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("main.png")))));
        mainMenuButton.setStyle("-fx-background-color: transparent;");
        mainMenuButton.setOnAction(event -> {
            // Handle button action here
            HelloApplication application = new HelloApplication();
            application.start(primaryStage);
        });
        // Add button to a VBox to center it at the bottom
        VBox bottomBox = new VBox(mainMenuButton);
        bottomBox.setAlignment(Pos.BOTTOM_CENTER);
        bottomBox.setPadding(new Insets(30));
        StackPane.setAlignment(bottomBox, Pos.BOTTOM_CENTER);
        root.getChildren().add(bottomBox);
    }
    private void showNextLetter() {
        if (currentIndex < gameOverText.length()) {
            // Append the next letter to the text
            text.setText(text.getText() + gameOverText.charAt(currentIndex));
            currentIndex++;
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
