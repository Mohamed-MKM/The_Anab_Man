package com.example.mainmenu2;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Clouds extends Pane {


    private static Clouds clouds;
    /////////////Clouds  ////////////////
    private Image IM90;
    private ImageView IV90;

    //////////Cloud Rectangles///////////////
    private Rectangle R3;
    private Rectangle R4;
    private Rectangle R5;
    private Rectangle R6;
    private Rectangle R7;
    private Rectangle R8;
    private double R3_W = 120;
    private double R3_H = 90;
    //////////////////Clouds and bushes ///////////////
    public Clouds() {
        IM90 = new Image("90.png");
        IV90 = new ImageView(IM90);
        IV90.setFitWidth(130);
        IV90.setFitHeight(90);
        IV90.setX(688);
        IV90.setY(20);
        //Added
        cloudsMove();
        clouds= this;
        clouds.getChildren().addAll(R3,R4,R5,R6,R7,R8);



    }
    public void cloudsMove()  {
        ////////Animation for Small Cloud////////////

        R3= new Rectangle(R3_W,R3_H);
        R3.setFill(Color.TRANSPARENT);
        R4 = new Rectangle(R3_W,R3_H);
        R4.setFill(Color.TRANSPARENT);
        R5 = new Rectangle(R3_W,R3_H);
        R5.setFill(Color.TRANSPARENT);
        R6 = new Rectangle(R3_W,R3_H);
        R6.setFill(Color.TRANSPARENT);
        R7 = new Rectangle(R3_W,R3_H);
        R7.setFill(Color.TRANSPARENT);
        R8 = new Rectangle(R3_W,R3_H);
        R8.setFill(Color.TRANSPARENT);
        R3.setFill(new ImagePattern(IM90));
        R4.setFill(new ImagePattern(IM90));
        R5.setFill(new ImagePattern(IM90));
        R6.setFill(new ImagePattern(IM90));
        R7.setFill(new ImagePattern(IM90));
        R8.setFill(new ImagePattern(IM90));
        Line l1 = new Line(-60,120,1600,170);
        l1.setFill(Color.TRANSPARENT);
        PathTransition pt1 = new PathTransition(Duration.millis(10000), l1,R3);
        PathTransition pt2 = new PathTransition(Duration.millis(10000), l1,R4);
        PathTransition pt3 = new PathTransition(Duration.millis(10000), l1,R5);
        PathTransition pt4 = new PathTransition(Duration.millis(10000), l1,R6);
        PathTransition pt5 = new PathTransition(Duration.millis(10000), l1,R7);
        PathTransition pt6 = new PathTransition(Duration.millis(10000), l1,R8);
        pt1.setCycleCount(Animation.INDEFINITE);
        pt1.setAutoReverse(false);
        pt2.setCycleCount(Animation.INDEFINITE);
        pt2.setAutoReverse(true);
        pt2.setDelay(Duration.millis(2000));
        pt3.setCycleCount(Animation.INDEFINITE);
        pt3.setAutoReverse(false);
        pt3.setDelay(Duration.millis(2000));
        pt4.setCycleCount(Animation.INDEFINITE);
        pt4.setAutoReverse(true);
        pt4.setDelay(Duration.millis(4000));

        pt5.setCycleCount(Animation.INDEFINITE);
        pt5.setAutoReverse(false);
        pt5.setDelay(Duration.millis(4000));

        pt6.setCycleCount(Animation.INDEFINITE);
        pt6.setAutoReverse(true);
        pt6.setDelay(Duration.millis(6000));

        ParallelTransition pt = new ParallelTransition(pt1, pt2, pt3, pt4, pt5, pt6);
        pt.play();


    }

    public static Clouds getClouds() {
        if (clouds == null) {
            clouds = new Clouds();
        }
        return  clouds;
    }
}
