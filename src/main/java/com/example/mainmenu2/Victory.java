package com.example.mainmenu2;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Victory extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a StackPane for centering the elements
        StackPane stackPane = new StackPane();
        stackPane.setStyle("-fx-background-color: #f0e1b2;");

        // Create a Canvas for fireworks animation
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        stackPane.getChildren().add(canvas);

        // Create the text node
        Text text = new Text("Victory");
        text.setFont(Font.font("Arial", 140));
        text.setFill(Color.web("#480607")); // SandyBrown color in hex
        Glow glow = new Glow();
        glow.setLevel(0.9);
        text.setEffect(glow);
        stackPane.getChildren().add(text);
        Pane root3 = new Pane();
        stackPane.getChildren().add(root3);

        Text text2 = new Text("انتصر العناب");
        text2.setFont(Font.font("Arial", 220));
        text2.setFill(Color.web("#feae35"));
        text2.setLayoutX(300);
        text2.setLayoutY(300);
        // SandyBrown color in hex
        Glow glow2 = new Glow();
        glow2.setLevel(0.9);
        text2.setEffect(glow2);
        root3.getChildren().add(text2);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);
        text2.setEffect(dropShadow);

        // Set up animation for bouncing text
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), text);
        translateTransition.setByY(100);
        translateTransition.setInterpolator(Interpolator.EASE_BOTH);
        translateTransition.setAutoReverse(true);
        translateTransition.setCycleCount(Animation.INDEFINITE);
        translateTransition.play();

        // Set up the stage
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        primaryStage.setScene(new Scene(stackPane, screenBounds.getWidth(), screenBounds.getHeight()));
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Victory Animation");
        primaryStage.show();
        Image image2 = new Image("3.png");

        Pane root = new Pane();
       ImageView imageView2 = new ImageView(image2);

        // Set initial position outside the frame
        imageView2.setLayoutX(0); // Outside the left side
        imageView2.setLayoutY(0); // Center vertically

        // Create a TranslateTransition for moving the image
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), imageView2);

        // Set the starting and ending X positions
        transition.setFromX(0); // Starting position outside the frame
        transition.setToX(0); // Center horizontally
        transition.setFromY(1000); // Starting position outside the frame
        transition.setToY(350); // Center horizontally

        // Play the transition animation
        transition.play();
        root.getChildren().add(imageView2);
// Add other nodes to the pane if needed

// Add the pane to the stackPane
        stackPane.getChildren().add(root);
        // Check if the image is loaded successfully
        if (image2.isError()) {
            System.err.println("Error loading image: " + image2.getUrl());
            return;
        }
        Pane root2 = new Pane();
        Image image22 = new Image("trophy.png");

        ImageView imageView22 = new ImageView(image22);

        // Set initial position outside the frame
        imageView22.setLayoutX(0); // Outside the left side
        imageView22.setLayoutY(0); // Center vertically
        imageView22.setFitWidth(400);
        imageView22.setFitHeight(400);
        // Create a TranslateTransition for moving the image
        TranslateTransition transition2 = new TranslateTransition(Duration.seconds(1), imageView22);

        // Set the starting and ending X positions
        transition2.setFromX(1000); // Starting position outside the frame
        transition2.setToX(1100); // Center horizontally
        transition2.setFromY(1000); // Starting position outside the frame
        transition2.setToY(450); // Center horizontally

        // Play the transition animation
        transition2.play();
        root2.getChildren().add(imageView22);
// Add other nodes to the pane if needed

// Add the pane to the stackPane
        stackPane.getChildren().add(root2);
        // Check if the image is loaded successfully
        if (image22.isError()) {
            System.err.println("Error loading image: " + image22.getUrl());
            return;
        }

        // Create an ImageView to display the image



        // Set the Scene

        primaryStage.setTitle("Image Travel Animation");
        primaryStage.show();

        // Set the Scene to full screen
        primaryStage.setFullScreen(true);


        // Start fireworks animation
        Fireworks fireworks = new Fireworks(gc);
        fireworks.start();

        // Load the image


        // Create the button
        // Create the button
        Button mainMenuButton = new Button("");
        Image image = new Image("main.png");
        //ImageView imageView = new ImageView(image);


        mainMenuButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 40px;");
        mainMenuButton.setGraphic(new ImageView(new Image(("main.png"))));
        mainMenuButton.setStyle("-fx-background-color: transparent;");
        mainMenuButton.setOnAction(event -> {
            // Handle button action here
            HelloApplication application = new HelloApplication();
            application.start(primaryStage);
        });
// Set the alignment of the Pane to center

        mainMenuButton.setTranslateY(300);
        mainMenuButton.setOnAction(event -> {
            // Handle button action here
            HelloApplication application = new HelloApplication();
            application.start(primaryStage);
        });

// Load the image



// Create a StackPane to overlap the image and the button
        StackPane buttonStackPane = new StackPane();
        buttonStackPane.getChildren().addAll(mainMenuButton/*, imageView*/);
        StackPane.setAlignment(buttonStackPane, Pos.BOTTOM_CENTER);
        StackPane.setMargin(mainMenuButton, new Insets(0, 0, 0, 0)); // Lower the button position slightly

// Set the alignment of the StackPane to center
        stackPane.setAlignment(buttonStackPane, Pos.BOTTOM_CENTER);
        stackPane.getChildren().add(buttonStackPane);
    }
        public static void main(String[] args) {
        launch(args);
    }


    private static class Fireworks {
        private final GraphicsContext gc;
        private final List<Particle> particles;
        private final Random random;

        public Fireworks(GraphicsContext gc) {
            this.gc = gc;
            particles = new ArrayList<>();
            random = new Random();
        }


        public void start() {
            AnimationTimer timer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
                    drawFireworks();
                }
            };
            timer.start();
        }

        private void drawFireworks() {
            if (random.nextInt(10) == 0) {
                double centerX = random.nextDouble() * gc.getCanvas().getWidth();
                double centerY = random.nextDouble() * gc.getCanvas().getHeight();
                double radius = random.nextDouble() * 3 + 2; // Increased size for more visibility
                Color color = Color.rgb(random.nextInt(200) + 55, random.nextInt(200) + 55, random.nextInt(200) + 55); // Brighter colors
                double speed = random.nextDouble() * 3 + 1; // Increased speed for more dynamic movement
                particles.add(new Particle(centerX, centerY, radius, color, speed));
            }

            List<Particle> particlesToRemove = new ArrayList<>();
            for (Particle particle : particles) {
                particle.update();
                particle.draw(gc);
                if (particle.getRadius() <= 0) {
                    particlesToRemove.add(particle);
                }
            }

            particles.removeAll(particlesToRemove);
        }

        private static class Particle {
            private double x;
            private double y;
            private double radius;
            private Color color;
            private double speed;

            public Particle(double x, double y, double radius, Color color, double speed) {
                this.x = x;
                this.y = y;
                this.radius = radius;
                this.color = color;
                this.speed = speed;
            }

            public void update() {
                y -= speed;
                radius -= 0.2; // Decreased shrink rate for longer visibility
            }

            public void draw(GraphicsContext gc) {
                gc.setFill(color);
                gc.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
            }

            public double getRadius() {
                return radius;
            }
        }
    }
}
