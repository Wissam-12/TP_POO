package com.example.tp;

import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MenuController {
    
    @FXML
    Label userScore;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void jouer(ActionEvent e) throws IOException {
        System.out.println("yesss");
        root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void desconnect (ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("acceuil-view.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void displayScore(Joueur joueur){
        userScore.setText(Integer.toString(joueur.getScoreActuel()));
    }
}
