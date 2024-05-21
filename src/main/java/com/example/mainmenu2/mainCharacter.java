package com.example.mainmenu2;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
public class
mainCharacter extends Pane {

    ///////////////// FULL Screen Scene /////////////////
    public static double X = 1465;
    public static double Y = 745;
    ///////////////// Ground Level /////////////////
    public static double Ground = 630;
    ///////////////// 3nab Character /////////////////
    private static mainCharacter Anab ;
    public static Rectangle R1;
    private double R1_W = 180;
    private double R1_H = 260;
    public static double R1_X = 70;
    public static double R1_Y = Y - 160;
    public static boolean Move_R = false;
    public static boolean Move_L = false;
    public static boolean jump = false;
    public static double jump_Velocity = 0;
    ///////////////// Hero Photos /////////////////
    private Image heroim;
    public static Image frameRight  = new Image("HeroRight.gif");;
    public static Image frameStandRight = new Image("mea.png");;
    public static int iteration = 0;
    //////////////////Hero positions/////////////////

    public mainCharacter() {
        // Initialize rectangle_1 properties
        R1 = new Rectangle(R1_X, R1_Y, R1_W, R1_H);
        R1.setFill(Color.TRANSPARENT);
        heroim = new Image("mea.png");
        R1.setFill(new ImagePattern(heroim));
        Moving_Right();
        Moving_Left();
        Jumping();
        Gravity();
        Anab = this;
        Anab.getChildren().add(R1);
        Shots.ShootSpeed = 20; // for both
        ArrayList<Rectangle> PlayerHits = new ArrayList<Rectangle>();
        Shots.shoot3nabCounter = 0;
    }
    //////////// 3nab Move Methods ///////////
    public void Moving_Right() {
        if (Move_R && R1.getX() < (X / 2) - 140) {
            R1.setX(R1.getX() + 5);
        }
    }

    public void Moving_Left() {
        if (Move_L && R1.getX() > 20) {
            R1.setX(R1.getX() - 5);
        }
    }

    //////////// 3nab Jump Method ///////////
    public void Jumping() {
        if (jump) {
            jump_Velocity = 9;
            jump = false;
        }
    }

    //////////// 3nab Gravity Method ///////////
    public void Gravity() {
        jump_Velocity -= 0.3;

        R1.setY(R1.getY() - jump_Velocity);
        if (R1.getY() >= R1_Y) {
            R1.setY(R1_Y);
            //jump_Velocity = 0;
        }
        if (R1.getY() > Ground || R1.getY() <= 368) {
            jump_Velocity -= 0.7;
        }

    }
    public static mainCharacter getAnab() {
        if (Anab == null) {
            Anab = new mainCharacter();
        }
        return Anab;
    }
}
