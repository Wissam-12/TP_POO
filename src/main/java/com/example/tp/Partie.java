package com.example.tp;

public class Partie {
    private Definition listDefs;
    private Plateau plateau;
    private boolean partieTermine;

    public Partie(Plateau plat){
        this.listDefs = new Definition();
        this.plateau = plat;
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

    public void setPlateau(Plateau plat){
        this.plateau = plat;
    }
}
