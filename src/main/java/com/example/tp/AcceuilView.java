package com.example.tp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    private Joueur joueur;
   public void submit(ActionEvent event) throws IOException {
        userName = userNameField.getText();
        joueur = new Joueur(userName);
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
                    line = br.readLine();
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
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("src/main/java/com/example/tp/listJoueurs.txt", true));
            myWriter.write(joueur.getNom());
            myWriter.newLine();
            myWriter.write("0");
            myWriter.newLine();
            myWriter.write("0");
            myWriter.newLine();
            myWriter.write("0");
            myWriter.newLine();
            myWriter.write("false");
            myWriter.newLine();
            myWriter.close();
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        root = loader.load();
        MenuController menu = loader.getController();
        menu.getJoueur(joueur);
        menu.displayScore(joueur);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
