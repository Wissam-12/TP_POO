package com.example.tp;

import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;

public class MenuController {
    
    @FXML
    Label userScore;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Partie partie;
    private Joueur joueur ;
     public void getJoueur (Joueur joueur ){
         this.joueur =joueur ;
     }
    public void jouer(ActionEvent e) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
       root = loader.load();
       MainView mainView = loader.getController();
        mainView.displayUserName(joueur);
        mainView.displayScore(joueur);
        mainView.displayRecord(joueur);
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        partie = new Partie(joueur);
        Cases[] plateau = partie.getPlateau().getPlateau();
        for (int i = 1; i < 99; i++) {
            if (plateau[i].couleur == Couleur.Rose) {
                ((Circle)scene.lookup("#c" + i)).setStyle("-fx-fill : pink ;");
            }
            if (plateau[i].couleur == Couleur.Vert) {
                ((Circle)scene.lookup("#c" + i)).setStyle("-fx-fill : green ;");
            }
            if (plateau[i].couleur == Couleur.gris) {
                ((Circle)scene.lookup("#c" + i)).setStyle("-fx-fill : grey ;");
            }
            if (plateau[i].couleur == Couleur.Bleue) {
                ((Circle)scene.lookup("#c" + i)).setStyle("-fx-fill : blue ;");
            }
            if (plateau[i].couleur == Couleur.Jaune) {
                ((Circle)scene.lookup("#c" + i)).setStyle("-fx-fill : yellow ;");
            }
            if (plateau[i].couleur == Couleur.Orange) {
                ((Circle)scene.lookup("#c" + i)).setStyle("-fx-fill : orange ;");
            }
            if (plateau[i].couleur == Couleur.Rouge) {
                ((Circle)scene.lookup("#c" + i)).setStyle("-fx-fill : red ;");
            }
        }
        mainView.getPartie(partie);
        mainView.setScene(scene);
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
