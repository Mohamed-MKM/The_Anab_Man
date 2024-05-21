package com.example.mainmenu2;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

import static com.example.mainmenu2.mainCharacter.*;

public class VillianCharacter2 extends Pane {
    private static VillianCharacter2 villan2;
    public static Rectangle R2;
    private double R2_W = 120;
    private double R2_H = 150;
    public static double R2_X = X - 70;;
    public static double R2_Y = Y - 50;
    public static double R2_MoveX = 9;
    public static double R2_MoveY;
    public static ArrayList<Rectangle> VillianHits = new ArrayList<Rectangle>();
    public static int shootVillainCounter = 0;
    public static double ShootSpeed = 40;
    ///////////////// Villianshoot Photos /////////////////
    public static Image villianshootim;
    public static ImageView villianshootiv;
    private static Rectangle hit ;
    protected Image villianim;
    public static Image vframeLeft = new Image("Thanos.gif");
    public static Image vframeRight = new Image("Thanos.gif");

    public VillianCharacter2() {
        R2 = new Rectangle(R2_X, R2_Y, R2_W, R2_H);
        R2.setFill(Color.TRANSPARENT);
        villianim = new Image("Thanos.gif");
        hit = new Rectangle(160, 80);
        hit.setFill(Color.TRANSPARENT);
        villianshootim = new Image("Hit2.png");
        villianshootiv = new ImageView(villianshootim);
        R2.setFill(new ImagePattern(villianim));
        VillianMovement();
        Villian_Jump();
        villan2 = this;
        getChildren().addAll(R2);
    }
    public void VillianMovement() {
        R2_X += R2_MoveX;
        R2_Y += R2_MoveY;

        if (R2.getX() >= (X / 2)) {
            R2.setX(R2.getX() - R2_MoveX);
            if (R2.getX() <= (X / 2)) {
                R2_MoveX *= -1;
                R2.setX(R2.getX() - R2_MoveX);
                R2.setFill(new ImagePattern(vframeRight));
            }
            if (R2.getX() >= X - 70) {
                R2_MoveX *= -1;
                R2.setX(R2.getX() - R2_MoveX);
                R2.setFill(new ImagePattern(vframeLeft));
            }
        }
    }
    public void Villian_Jump() {

        if ((R2.getX() >= 1150  ) && R2.getY() == Ground) {
            R2_MoveY = 11.5;
        }
        R2_MoveY -= 0.27;
        if (R2.getY() > Ground) {
            R2.setY(Ground);
            R2_MoveY = 0;
        }
        R2.setY(R2.getY() - R2_MoveY);
    }
    public static VillianCharacter2 getvillian2() {
        if (villan2 == null) {
            villan2 = new VillianCharacter2();
        }
        return villan2;
    }
}

