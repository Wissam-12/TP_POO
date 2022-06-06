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
import java.util.ArrayList;
import java.util.List;

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
        // joueur = new Joueur(userName);
        List<Joueur> list = new ArrayList<Joueur>(100);
        BufferedReader br;
        int emplacement = -1;
        try{
            br = new BufferedReader(new FileReader("src/main/java/com/example/tp/listJoueurs.txt"));
            String line = br.readLine();
            Joueur j;
            int i = 0;
            while (line != null) {
                if(line.equals(userName)){
                    emplacement = i;
                }
                j = new Joueur(line);
                line = br.readLine();
                j.setMeilleurScore(Integer.parseInt(line));
                line = br.readLine();
                j.setScoreActuel(Integer.parseInt(line));
                line = br.readLine();
                j.setPosition(Integer.parseInt(line));
                line = br.readLine();
                j.setStarted(Boolean.parseBoolean(line));
                j.setNum(i);
                if(j.getStarted()){
                    int y = 1;
                    Cases[] lsCases = new Cases[100];
                    lsCases[0] = new caseDebut();
                    lsCases[99] = new caseFin();
                    while(y < 99){
                        line = br.readLine();
                        if(line.equals("Bonus")){
                            lsCases[y] = new caseBonus(y);
                        }
                        if(line.equals("Definition")){
                            lsCases[y] = new caseDefinition(y);
                        }
                        if(line.equals("Image")){
                            lsCases[y] = new caseImage(y);
                        }
                        if(line.equals("Malus")){
                            lsCases[y] = new caseMalus(y);
                        }
                        if(line.equals("Saut")){
                            lsCases[y] = new caseSaut(y);
                        }
                        if(line.equals("Parcours")){
                            lsCases[y] = new caseParcours(y);
                        }
                        y++;
                    }
                    Plateau plat = new Plateau();
                    plat.setPlateau(lsCases);
                    Partie partie = new Partie(plat);
                    j.setPartieCourrante(partie);
                }
                list.add(j);
                i++;
                line = br.readLine();
            }
        }catch (IOException a) {
            a.printStackTrace();
        }
        if(emplacement == -1){
            joueur = new Joueur(userName);
            joueur.setMeilleurScore(0);
            joueur.setPosition(0);
            joueur.setScoreActuel(0);
            joueur.setStarted(false);
            joueur.setNum(list.size());
            list.add(joueur);
            System.out.println("new");
        }
        else{
            joueur = list.get(emplacement);
            System.out.println("old");
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        root = loader.load();
        MenuController menu = loader.getController();
        menu.getJoueur(joueur);
        menu.getListJoueurs(list);
        menu.displayScore(joueur);
        menu.displayLabel(joueur.getStarted());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
