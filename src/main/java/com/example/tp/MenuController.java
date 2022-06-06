package com.example.tp;

import java.io.IOException;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MenuController {
    
    @FXML
    Label userScore;
    @FXML
    Button jouerButton;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Partie partie;
    private Joueur joueur ;
    private List<Joueur> listJoueurs;

    public void getJoueur (Joueur joueur ){
        this.joueur =joueur ;
    }

    public void getListJoueurs(List<Joueur> listJoueurs){
        this.listJoueurs = listJoueurs;
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
        Plateau plat = new Plateau();
        if(!joueur.getStarted()){
            plat.newPlateau();
        }
        else{
            plat.setPlateau(joueur.getPartieCourante().getPlateau().getPlateau());
        }
        partie = new Partie(plat);
        Cases[] plateau = partie.getPlateau().getPlateau();
        joueur.setPartieCourrante(partie);
        for (int i = 1; i < 99; i++) {
            if (plateau[i].couleur == Couleur.Rose) {
                ((Button)scene.lookup("#c" + i)).setStyle("-fx-background-color : pink ;-fx-background-radius: 100 ;");
            }
            if (plateau[i].couleur == Couleur.Vert) {
                ((Button)scene.lookup("#c" + i)).setStyle("-fx-background-color : green ;-fx-background-radius: 100 ;");
            }
            if (plateau[i].couleur == Couleur.gris) {
                ((Button)scene.lookup("#c" + i)).setStyle("-fx-background-color : grey ;-fx-background-radius: 100 ;");
            }
            if (plateau[i].couleur == Couleur.Bleue) {
                ((Button)scene.lookup("#c" + i)).setStyle("-fx-background-color : blue ;-fx-background-radius: 100 ;");
            }
            if (plateau[i].couleur == Couleur.Jaune) {
                ((Button)scene.lookup("#c" + i)).setStyle("-fx-background-color : yellow ;-fx-background-radius: 100 ;");
            }
            if (plateau[i].couleur == Couleur.Orange) {
                ((Button)scene.lookup("#c" + i)).setStyle("-fx-background-color : orange ;-fx-background-radius: 100 ;");
            }
            if (plateau[i].couleur == Couleur.Rouge) {
                ((Button)scene.lookup("#c" + i)).setStyle("-fx-background-color : red ; -fx-background-radius: 100 ;");
            }
        }
        joueur.setStarted(true);
        mainView.getPartie(this.joueur);
        mainView.setListJrs(this.listJoueurs);
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

    public void classement (ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("classement.fxml"));
        root = loader.load();
        ClassementController menu = loader.getController();
        menu.displayBestUser(joueur);
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void displayScore(Joueur joueur){
        userScore.setText(Integer.toString(joueur.getScoreActuel()));
    }

    public void displayLabel(boolean bool){
        if(bool){
            jouerButton.setText("Continuez");
        }
        else{
            jouerButton.setText("Jouer");
        }
    }

    public void definition(){
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("images.fxml"));
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("definition.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
        // DefController defQ = loader.getController();
        // defQ.displayQuestion(def);
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
