package com.example.tp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AcceuilView {
    @FXML
    private TextField userNameField;
    private Button userNameSubmission;

    String userName;

    private Stage stage;
    private Scene scene;
    private Parent root;

   public void submit(ActionEvent event) throws IOException {
        userName = userNameField.getText();
        Joueur joueur = new Joueur(userName);
        int userline = joueur.checkExistence();
        if( userline != 0){
            BufferedReader br;
            try {
                br = new BufferedReader(new FileReader("src/main/java/com/example/tp/listJoueurs.txt"));
                String line;
                try {
                    int ln = 0;
                    while (ln != userline) {
                        line = br.readLine();
                        ln++;
                    }
                    line = br.readLine();
                    joueur.setMeilleurScore(Integer.parseInt(line));
                    line = br.readLine();
                    joueur.setScoreActuel(Integer.parseInt(line));
                    line = br.readLine();
                    joueur.setPosition(Integer.parseInt(line));
                } catch (IOException a) {
                    a.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                System.out.println("Une erreur a été rencontrée !");
                e.printStackTrace();
            }
        }
        else{
            joueur.setMeilleurScore(0);
            joueur.setPosition(0);
            joueur.setScoreActuel(0);
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("src/main/java/com/example/tp/listJoueurs.txt"));
            myWriter.write(joueur.getNom());
            myWriter.newLine();
            myWriter.write("0");
            myWriter.newLine();
            myWriter.write("0");
            myWriter.newLine();
            myWriter.write("0");
            myWriter.newLine();
            myWriter.close();
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        root = loader.load();

        MenuController menu = loader.getController();
        menu.displayScore(joueur);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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
}
