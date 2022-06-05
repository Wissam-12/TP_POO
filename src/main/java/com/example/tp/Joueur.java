package com.example.tp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Joueur {
    private String nom;
    private int meilleurScore, scoreActuel;
    private int position;
    private Partie partieCourante;
    public Joueur(String nom){
        this.nom = nom;
    }

    public int getMeilleurScore(){
        return this.meilleurScore;
    }

    public int getScoreActuel(){
        return this.scoreActuel;
    }

    public String getNom(){
        return this.nom;
    }

    public void setMeilleurScore(int meilleurScore){
        this.meilleurScore = meilleurScore;
    }

    public void gagne(int points){
        this.scoreActuel = this.scoreActuel + points;
    }

    public void avancer(int p ){
        setPosition(this.position+p);
    }

    public void reculer(int p){
        setPosition(this.position-p);
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setScoreActuel(int scoreActuel) {
        this.scoreActuel = scoreActuel;
    }

    public Partie getPartieCourante() {
        return partieCourante;
    }

    public int checkExistence(){
        BufferedReader br;
        int ln = 0;
        boolean exist = false;
        try {
            br = new BufferedReader(new FileReader("src/main/java/com/example/tp/listJoueurs.txt"));
            String line = "%start%";
            try {
                while (line != null && !exist) {
                    if ((this.nom).equals(line)) {
                        exist = true;
                    } else {
                        line = br.readLine();
                        ln++;
                    }
                }
            } catch (IOException a) {
                a.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Une erreur a été rencontrée !");
            e.printStackTrace();
        }
        if(exist){
            return ln;
        }
        else{
            return 0;
        }
    }

}

