package com.example.tp;

public class caseMalus extends Cases {
    // private static int nombreDeCase = 0 ;
    caseMalus (int i){
        this.couleur = Couleur.Rouge;
        this.numCase = i;
        // this.nombreDeCase += 1;
    }

    @Override
    public void actionAssocie(Joueur J) {
        J.setScoreActuel (J.getScoreActuel() -10);
        J.setPosition (J.getPosition()-2);
    }

    // public static int getNombreDeCase() {
    //     return nombreDeCase;
    // }

    public void test(){
        System.out.println("Case malus");
    }
}
