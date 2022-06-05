package com.example.tp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;

public class MenuController {
    
    @FXML
    Label userScore;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void jouer(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        Plateau Plateau = new Plateau();
        Cases[] plateau = Plateau.getPlateau();
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
        String nom = "user";
        String best;
        int score = 0;
        int bestScore = 0;
        BufferedReader br;
        Joueur joueur;
        try {
            br = new BufferedReader(new FileReader("src/main/java/com/example/tp/listJoueurs.txt"));
            String line;
            try {
                line = br.readLine();
                nom = line;
                while(line != null){
                    line = br.readLine();
                }
            } catch (IOException a) {
                a.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Une erreur a été rencontrée !");
            ex.printStackTrace();
        }
        joueur = new Joueur(nom);
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

    public void definition(){
        caseDefinition def = new caseDefinition(1);
        def.setQuestion("What is my name");
        def.setBonneRep("Wissam");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("images.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        caseImage img = new caseImage(2);
        img.setImage0("images/apple.jpg");
        img.setImage1("images/banana.jpg");
        img.setImage2("images/carrot.jpg");
        img.setImage3("images/lemon.jpg");
        img.setQuestion("Find the Apple");
        ImagesController questionImg = loader.getController();
        questionImg.displayImage(img);
        // DefController defQ = loader.getController();
        // defQ.displayQuestion(def);
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
