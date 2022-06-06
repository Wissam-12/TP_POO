package com.example.tp;

public abstract class Cases {
    protected Couleur couleur = Couleur.gris;
    protected int numCase;
    public abstract void actionAssocie (Joueur J);
    public abstract void test();

    public Couleur getCouleur(){
        return this.couleur;
    }
}

