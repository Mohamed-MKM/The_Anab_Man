package com.example.mainmenu2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

import static com.example.mainmenu2.VillianCharacter.*;

public class Shots extends mainCharacter {
    public static double ShootSpeed;
    public static int shoot3nabCounter;
    public static Image heroshootim;
    public static ImageView heroshootiv;
    public static ArrayList<Rectangle> PlayerHits = new ArrayList<Rectangle>();

    public void playerShoot() {
        Sounds.shoot_Sound();
        try {
            Rectangle hit = new Rectangle(70, 60);
            hit.setFill(Color.TRANSPARENT);
            // Load the image you want to use to fill R1
            heroshootim = new Image("meena-harry-persx-blue-spirit-enemy.png");
            heroshootiv = new ImageView(heroshootim);
            //coordinates of the bullet
            hit.setY(R1.getY() + (R1.getHeight() * (0.35)));
            hit.setX(R1.getX() + R1.getWidth() / 2);
            // Use ImagePattern to fill R2 with the loaded image
            hit.setFill(new ImagePattern(heroshootim));
            // Add hit to arraylist
            PlayerHits.add(hit);
            ((Pane) R1.getParent()).getChildren().add(hit);
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception: " + e.getMessage());
        }
    }
    public void villianShoot() {

        try {
            Rectangle hit = new Rectangle(160, 80);
            hit.setFill(Color.TRANSPARENT);
            // Load the image you want to use to fill R2
            villianshootim = new Image("Hit.png");
            villianshootiv = new ImageView(villianshootim);
            //coordinates of the bullet
            hit.setY(R2.getY() + (R2.getHeight() * (0.012)));
            hit.setX(R2.getX() - hit.getWidth()/2);
            // Use ImagePattern to fill R2 with the loaded image
            hit.setFill(new ImagePattern(villianshootim));
            // Add hit to arraylist
            VillianHits.add(hit);
            ((Pane) R2.getParent()).getChildren().add(hit);
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception: " + e.getMessage());
        }
    }
}
