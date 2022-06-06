package com.example.tp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

    public void getPartie(Joueur j ){
        this.joueur = j;
        this.partie = j.getPartieCourante();
        this.plateau= this.partie.getPlateau().getPlateau();
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

    private int deplacement;
    private int posVirtuel;

   public void rollDice(ActionEvent event)  {
        roll.setDisable(true);
        Dice d = new Dice();
        Thread thread = new Thread() {
            public void run() {
                deplacement = d.rollDice(dice1, dice2);
                posVirtuel = joueur.getPosition()+deplacement;
                joueur.setPosition(joueur.getPosition()+deplacement);
                    if(joueur.getPosition()>99){
                            int difference = joueur.getPosition() - 99;
                            joueur.setPosition(99-difference);
                        pion.setLayoutX(((Button)scene.lookup("#c" + joueur.getPosition())).getLayoutX()-5);
                        pion.setLayoutY(((Button)scene.lookup("#c" + joueur.getPosition())).getLayoutY()-2);
                    }
                if (plateau[joueur.getPosition()].couleur==Couleur.Orange){
                    plateau[joueur.getPosition()].actionAssocie(joueur);
                    pion.setLayoutX(((Button)scene.lookup("#c" + joueur.getPosition())).getLayoutX()-5);
                    pion.setLayoutY(((Button)scene.lookup("#c" + joueur.getPosition())).getLayoutY()-2);
                }
                if (plateau[joueur.getPosition()].couleur==Couleur.Vert){
                    plateau[joueur.getPosition()].actionAssocie(joueur);
                    pion.setLayoutX(((Button)scene.lookup("#c" + joueur.getPosition())).getLayoutX()-5);
                    pion.setLayoutY(((Button)scene.lookup("#c" + joueur.getPosition())).getLayoutY()-2);
                }
                if (plateau[joueur.getPosition()].couleur==Couleur.Rouge){
                    plateau[joueur.getPosition()].actionAssocie(joueur);
                    pion.setLayoutX(((Button)scene.lookup("#c" + joueur.getPosition())).getLayoutX()-5);
                    pion.setLayoutY(((Button)scene.lookup("#c" + joueur.getPosition())).getLayoutY()-2);
                }
                else {
                    plateau[joueur.getPosition()].actionAssocie(joueur);
                    pion.setLayoutX(((Button)scene.lookup("#c" + joueur.getPosition())).getLayoutX()-5);
                    pion.setLayoutY(((Button)scene.lookup("#c" + joueur.getPosition())).getLayoutY()-2);
                }
                score.setText(Integer.toString(joueur.getScoreActuel()));
                if (joueur.getScoreActuel()> joueur.getMeilleurScore()){
                    joueur.setMeilleurScore(joueur.getScoreActuel());
                    record.setText("Record : "+Integer.toString(joueur.getMeilleurScore()));
                }
                roll.setDisable(false);
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
        record.setText("Record : "+ Integer.toString(joueur.getMeilleurScore()));
    }
    Alert alert = new Alert(Alert.AlertType.ERROR);

    @FXML
    void clickCase(ActionEvent event){
        /*Button b = (Button) event.getTarget();
        String s = b.getId();
        int id = Integer.parseInt(s.substring(1));
        if ((id <= posVirtuel)&(id != joueur.getPosition())){
            joueur.setPosition(id);
            pion.setLayoutX(b.getLayoutX()-4);
            pion.setLayoutY(b.getLayoutY()-2);
            plateau[joueur.getPosition()].actionAssocie(joueur);
            score.setText(Integer.toString(joueur.getScoreActuel()));
            if (joueur.getScoreActuel()> joueur.getMeilleurScore()){
                joueur.setMeilleurScore(joueur.getScoreActuel());
                record.setText("Record : "+Integer.toString(joueur.getMeilleurScore()));
            }
            roll.setDisable(false);
        }
        else {
            alert.setTitle("Wrong destination");
            alert.setContentText("Your new position should be the position number "+posVirtuel);
        }*/


    }

}
