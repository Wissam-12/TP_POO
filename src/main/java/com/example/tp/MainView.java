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

    public void getPartie(Partie p ){
        this.partie = p;
        this.joueur = p.getJoueur();
        this.plateau=p.getPlateau().getPlateau();
    }
    @FXML
    private Circle b1;

    @FXML
    private Circle b10;

    @FXML
    private Circle b11;

    @FXML
    private Circle b12;

    @FXML
    private Circle b13;

    @FXML
    private Circle b14;

    @FXML
    private Circle b15;

    @FXML
    private Circle b16;

    @FXML
    private Circle b17;

    @FXML
    private Circle b18;

    @FXML
    private Circle b19;

    @FXML
    private Circle b2;

    @FXML
    private Circle b20;

    @FXML
    private Circle b21;

    @FXML
    private Circle b22;

    @FXML
    private Circle b23;

    @FXML
    private Circle b24;

    @FXML
    private Circle b25;

    @FXML
    private Circle b26;

    @FXML
    private Circle b27;

    @FXML
    private Circle b28;

    @FXML
    private Circle b29;

    @FXML
    private Circle b3;

    @FXML
    private Circle b30;

    @FXML
    private Circle b31;

    @FXML
    private Circle b32;

    @FXML
    private Circle b33;

    @FXML
    private Circle b34;

    @FXML
    private Circle b35;

    @FXML
    private Circle b36;

    @FXML
    private Circle b37;

    @FXML
    private Circle b38;

    @FXML
    private Circle b39;

    @FXML
    private Circle b4;

    @FXML
    private Circle b40;

    @FXML
    private Circle b41;

    @FXML
    private Circle b42;

    @FXML
    private Circle b43;

    @FXML
    private Circle b44;

    @FXML
    private Circle b45;

    @FXML
    private Circle b46;

    @FXML
    private Circle b47;

    @FXML
    private Circle b48;

    @FXML
    private Circle b49;

    @FXML
    private Circle b5;

    @FXML
    private Circle b50;

    @FXML
    private Circle b51;

    @FXML
    private Circle b52;

    @FXML
    private Circle b53;

    @FXML
    private Circle b54;

    @FXML
    private Circle b55;

    @FXML
    private Circle b56;

    @FXML
    private Circle b57;

    @FXML
    private Circle b58;

    @FXML
    private Circle b59;

    @FXML
    private Circle b6;

    @FXML
    private Circle b60;

    @FXML
    private Circle b61;

    @FXML
    private Circle b62;

    @FXML
    private Circle b63;

    @FXML
    private Circle b64;

    @FXML
    private Circle b65;

    @FXML
    private Circle b66;

    @FXML
    private Circle b67;

    @FXML
    private Circle b68;

    @FXML
    private Circle b69;

    @FXML
    private Circle b7;

    @FXML
    private Circle b70;

    @FXML
    private Circle b71;

    @FXML
    private Circle b72;

    @FXML
    private Circle b73;

    @FXML
    private Circle b74;

    @FXML
    private Circle b75;

    @FXML
    private Circle b76;

    @FXML
    private Circle b77;

    @FXML
    private Circle b78;

    @FXML
    private Circle b79;

    @FXML
    private Circle b8;

    @FXML
    private Circle b80;

    @FXML
    private Circle b81;

    @FXML
    private Circle b82;

    @FXML
    private Circle b83;

    @FXML
    private Circle b84;

    @FXML
    private Circle b85;

    @FXML
    private Circle b86;

    @FXML
    private Circle b87;

    @FXML
    private Circle b88;

    @FXML
    private Circle b89;

    @FXML
    private Circle b9;

    @FXML
    private Circle b90;

    @FXML
    private Circle b91;

    @FXML
    private Circle b92;

    @FXML
    private Circle b93;

    @FXML
    private Circle b94;

    @FXML
    private Circle b95;

    @FXML
    private Circle b96;

    @FXML
    private Circle b97;

    @FXML
    private Circle b98;

    @FXML
    private Button b99;
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
                try {
                    joueur.setPosition(joueur.getPosition()+deplacement);
                }
                catch (ArrayIndexOutOfBoundsException e){
                    joueur.setPosition(99);
                }
                if (joueur.getPosition()==99){
                    pion.setLayoutX(((Button)scene.lookup("#c" + 99)).getLayoutX()-14);
                    pion.setLayoutY(((Button)scene.lookup("#c" + 99)).getLayoutY()-22);
                }
                else {
                    pion.setLayoutX(((Circle)scene.lookup("#c" + joueur.getPosition())).getLayoutX()-14);
                    pion.setLayoutY(((Circle)scene.lookup("#c" + joueur.getPosition())).getLayoutY()-22);
                }
                if (plateau[joueur.getPosition()].couleur==Couleur.Orange){
                    plateau[joueur.getPosition()].actionAssocie(joueur);
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
       /* Circle b = (Circle)event.getTarget();
        String s = b.getId();
        int id = Integer.parseInt(s.substring(1));
        if ((id <= posVirtuel)&(id != joueur.getPosition())){
            joueur.setPosition(id);
            pion.setLayoutX(b.getLayoutX()-14);
            pion.setLayoutY(b.getLayoutY()-22);
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
