package com.example.mainmenu2;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Loading2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the image
        Image image = new Image("thanos.png");

        // Check if the image is loaded successfully
        if (image.isError()) {
            System.err.println("Error loading image: " + image.getUrl());
            return;
        }

        // Create an ImageView to display the image
        ImageView imageView = new ImageView(image);

        // Set initial position outside the frame
        imageView.setLayoutX(0); // Outside the left side
        imageView.setLayoutY(0); // Center vertically

        // Create a TranslateTransition for moving the image
        TranslateTransition transition = new TranslateTransition(Duration.seconds(2), imageView);

        // Set the starting and ending X positions
        transition.setFromX(0); // Starting position outside the frame
        transition.setToX(0); // Center horizontally
        transition.setFromY(1000); // Starting position outside the frame
        transition.setToY(350); // Center horizontally

        // Play the transition animation
        transition.play();

        // Set the Scene to full screen
        primaryStage.setFullScreen(true);

        final String message = "استعد للمرحلة التانية";
        final int[] currentIndex = {0};
        Text text = new Text();
        text.setLayoutX(550);
        text.setLayoutY(400);
        text.setStyle("-fx-font-family: 'Arial'; -fx-font-weight: bold; -fx-fill: #701d25;");
        text.setFont(Font.font(75)); // Set font size

// Ensure the text is visible by setting the opacity to 1
        text.setOpacity(1);

        // Set initial opacity to 0

        // Create a Timeline for the animation
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.2), e -> {
                    // Add the next letter to the text
                    text.setText(message.substring(0, currentIndex[0] + 1));
                    currentIndex[0]++;

                    // Fade in the text
                    text.setOpacity(1);
                })
        );
        timeline.setCycleCount(message.length()); // Run animation for the length of the message
        timeline.play();

        // Create a StackPane to hold the text
        Pane root = new Pane();



        Image image2 = new Image("pixel.png");
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(300); // Set the width
        imageView2.setFitHeight(300); // Set the height
        // Set the position of the ImageView using X and Y coordinates
        imageView2.setLayoutX(1200); // Set X coordinate
        imageView2.setLayoutY(600); // Set Y coordinate


        // Create a RotateTransition to rotate the image
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2), imageView2);
        rotateTransition.setByAngle(360); // Rotate by 360 degrees
        rotateTransition.setCycleCount(Animation.INDEFINITE); // Repeat indefinitely
        rotateTransition.setAutoReverse(true); // Do not reverse the animation

        // Start the rotation animation
        rotateTransition.play();

        // Create a StackPane to hold the ImageView
        root.getChildren().add(imageView);

        // Create a Pane to hold the image

        root.getChildren().add(imageView2);
        root.getChildren().add(text);

        // Create a Scene
        Scene scene = new Scene(root, 800, 600); // Adjust width and height as needed

        // Set background color with hex code
        String hexColor = "#f0e1b2"; // Maroon color
        scene.getRoot().setStyle("-fx-background-color: " + hexColor + ";");

        // Set the Scene
        primaryStage.setScene(scene);
        primaryStage.setTitle("Image Travel Animation");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
