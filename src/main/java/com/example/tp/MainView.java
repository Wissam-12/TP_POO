package com.example.tp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import static java.lang.invoke.MethodHandles.lookup;

public class MainView {
    private Partie partie;
    private Joueur joueur;
    private Cases[] plateau;
    private Scene scene;
    Random random = new Random();

    public void getPartie(Partie p ){
        this.partie = p;
        this.joueur = p.getJoueur();
        this.plateau=p.getPlateau().getPlateau();
    }
    @FXML
    Text userName;
    @FXML
    Text record;
    @FXML
    Text score;
    @FXML
    Button roll;
    @FXML
    ImageView dice1;
    @FXML
    ImageView dice2;
    @FXML
    ImageView pion;
    @FXML
    public Scene setScene(Scene s){
        return this.scene = s;
    }

   public void rollDice(ActionEvent event)  {
        roll.setDisable(true);
        Dice d = new Dice();
        Thread thread = new Thread() {

            public void run() {
                int j = d.rollDice(dice1, dice2);
                try {
                    joueur.setPosition(joueur.getPosition()+j);
                }
                catch (ArrayIndexOutOfBoundsException e){
                    joueur.setPosition(99);
                }
                pion.setLayoutX(((Circle)scene.lookup("#c" + joueur.getPosition())).getLayoutX()-14);
                pion.setLayoutY(((Circle)scene.lookup("#c" + joueur.getPosition())).getLayoutY()-22);
                if (plateau[joueur.getPosition()].couleur==Couleur.Orange){
                    plateau[joueur.getPosition()].actionAssocie(joueur);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pion.setLayoutX(((Circle)scene.lookup("#c" + joueur.getPosition())).getLayoutX()-14);
                    pion.setLayoutY(((Circle)scene.lookup("#c" + joueur.getPosition())).getLayoutY()-22);
                }
                else {
                    plateau[joueur.getPosition()].actionAssocie(joueur);
                }
                score.setText(Integer.toString(joueur.getScoreActuel()));
                if (joueur.getScoreActuel()> joueur.getMeilleurScore()){
                    joueur.setMeilleurScore(joueur.getScoreActuel());
                    record.setText("Record : "+Integer.toString(joueur.getMeilleurScore()));
                }
                roll.setDisable(false);
                System.out.println(j); //nouvelle position du joueur = position + j (to apply inside the thread)

                System.out.println(joueur.getNom()+"'s new position is : "+Integer.toString(joueur.getPosition()));
            }
        };
        thread.start();
    }
    public void displayScore(Joueur joueur){
        score.setText(Integer.toString(joueur.getScoreActuel()));
    }
    public void displayUserName(Joueur joueur){
        userName.setText("User : "+joueur.getNom());
    }
    public void displayRecord(Joueur joueur){
        record.setText("Record : "+Integer.toString(joueur.getMeilleurScore()));
    }
    @FXML
    void clickCase(ActionEvent event){
    }

}
