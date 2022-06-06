package com.example.tp;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class MainView {
    private Partie partie;
    private Joueur joueur;
    private Cases[] plateau;
    private Scene scene;
    private List<Joueur> listJoueurs;
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
                /*joueur.setPosition(joueur.getPosition()+deplacement);
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
                roll.setDisable(false);*/
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

    public void setListJrs(List<Joueur> listJoueurs){
        this.listJoueurs = listJoueurs;
    }
    Alert alert = new Alert(Alert.AlertType.ERROR);

    @FXML
    void clickCase(ActionEvent event){
        Button b = (Button) event.getTarget();
        String s = b.getId();
        int id = Integer.parseInt(s.substring(1));
        if ((id <= posVirtuel)&(id != joueur.getPosition())){
           joueur.setPosition(id);
                    if((posVirtuel>99)&(joueur.getPosition()>99)){
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
        }
        else {
            alert.setTitle("Wrong destination");
            alert.setContentText("Your new position should be the position number "+posVirtuel);
        }


    }

    public void save(ActionEvent event){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Veuillez confirmer !");
        alert.setContentText("Voulez vous sauvegareder cette partie ?");
        Optional<ButtonType> result = alert.showAndWait();
        if((result.isPresent()) && (result.get() == ButtonType.OK)){
            listJoueurs.set(this.joueur.getNum(), this.joueur);
            try {
                BufferedWriter myWriter = new BufferedWriter(new FileWriter("src/main/java/com/example/tp/listJoueurs.txt"));
                int i = 0;
                while(i < listJoueurs.size()){
                    myWriter.write(listJoueurs.get(i).getNom());
                    myWriter.newLine();
                    myWriter.write(Integer.toString(listJoueurs.get(i).getMeilleurScore()));
                    myWriter.newLine();
                    myWriter.write(Integer.toString(listJoueurs.get(i).getScoreActuel()));
                    myWriter.newLine();
                    myWriter.write(Integer.toString(listJoueurs.get(i).getPosition()));
                    myWriter.newLine();
                    myWriter.write(Boolean.toString(listJoueurs.get(i).getStarted()));
                    myWriter.newLine();
                    if(listJoueurs.get(i).getStarted()){
                        int y = 1;
                        // caseBonus bonus = new caseBonus(0);
                        // caseDefinition def = new caseDefinition(0);
                        // caseImage img = new caseImage(0);
                        // caseParcours par = new caseParcours(0);
                        // caseMalus mal = new caseMalus(0);
                        // caseSaut saut = new caseSaut(0);

                        while(y < 99){
                            if(joueur.getPartieCourante().getPlateau().getPlateau()[y].getClass() == caseBonus.class){
                                myWriter.write("Bonus");
                                myWriter.newLine();
                            }
                            if(joueur.getPartieCourante().getPlateau().getPlateau()[y].getClass() == caseDefinition.class){
                                myWriter.write("Definition");
                                myWriter.newLine();
                            }
                            if(joueur.getPartieCourante().getPlateau().getPlateau()[y].getClass() == caseImage.class){
                                myWriter.write("Image");
                                myWriter.newLine();
                            }
                            if(joueur.getPartieCourante().getPlateau().getPlateau()[y].getClass() == caseMalus.class){
                                myWriter.write("Malus");
                                myWriter.newLine();
                            }
                            if(joueur.getPartieCourante().getPlateau().getPlateau()[y].getClass() == caseSaut.class){
                                myWriter.write("Saut");
                                myWriter.newLine();
                            }
                            if(joueur.getPartieCourante().getPlateau().getPlateau()[y].getClass() == caseParcours.class){
                                myWriter.write("Parcours");
                                myWriter.newLine();
                            }
                            y++;
                        }
                    }
                    i++;
                }
                myWriter.close();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
                Parent root = loader.load();
                MenuController menu = loader.getController();
                menu.getJoueur(joueur);
                menu.getListJoueurs(this.listJoueurs);
                menu.displayScore(this.joueur);
                menu.displayLabel(joueur.getStarted());
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
            Parent root;
            joueur.setStarted(false);
            try {
                root = loader.load();
                MenuController menu = loader.getController();
                menu.getJoueur(joueur);
                menu.getListJoueurs(this.listJoueurs);
                menu.displayScore(this.joueur);
                menu.displayLabel(joueur.getStarted());
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
