package com.example.tp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.util.Random;

public class MainView {
    Random random = new Random();
    @FXML
    TextField userName;
    @FXML
    TextField record;
    @FXML
    TextField score;
    @FXML
    Button roll;
    @FXML
    ImageView dice1;
    @FXML
    ImageView dice2;
    @FXML
    void rollDice(ActionEvent event) {
        roll.setDisable(true);
        Dice d = new Dice();
        Thread thread = new Thread(){
            public void run() {
                System.out.println("Thread Running");
                 int j = d.rollDice(dice1, dice2);
                 roll.setDisable(false);
                 System.out.println(j); //nouvelle position du joueur = position + j (to apply inside the thread)
            }
        };
        thread.start();
    }
    }
