package com.example.tp;

public class Partie {
    private Joueur joueur;
    private Definition listDefs;
    private Plateau plateau;
    private boolean partieTermine;
    public Partie(Joueur j){
        this.joueur = j;
        this.listDefs = new Definition();
        this.plateau = new Plateau();
        this.partieTermine = false;
    }

    public void setPartieTermine(boolean partieTermine) {
        this.partieTermine = partieTermine;
    }

    public Definition getListDefs() {
        return listDefs;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public Joueur getJoueur() {
        return joueur;
    }
}
