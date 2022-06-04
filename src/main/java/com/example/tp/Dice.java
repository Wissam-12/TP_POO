package com.example.tp;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.Random;

public class Dice {
    public int rollDice (ImageView d1, ImageView d2) {
        Random random = new Random();
        int j1 = 0;
        int j2 = 0;
        try {
            for (int i = 0; i < 15; i++) {
                j1 = random.nextInt(6) + 1;
                File file = new File("C:\\Users\\pc\\OneDrive\\Bureau\\TP\\src\\main\\resources\\com\\example\\tp\\dice/dice" + j1 + ".png");
                d1.setImage(new Image(file.toURI().toString()));
                j2 = random.nextInt(6) + 1;
                file = new File("C:\\Users\\pc\\OneDrive\\Bureau\\TP\\src\\main\\resources\\com\\example\\tp\\dice/dice" + j2 + ".png");
                d2.setImage(new Image(file.toURI().toString()));
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return j1+j2;
    }

    private void setImage(Image image) {
    }
}
