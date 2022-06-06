package com.example.tp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ClassementController {
    @FXML
    Label bestUserScore;
    Label bestUser;

    public void displayBestScore(Joueur joueur){
        bestUserScore.setText(Integer.toString(joueur.getMeilleurScore()));
    }

    public void displayBestUser(Joueur joueur){
        bestUser.setText(joueur.getNom());
    }
}
