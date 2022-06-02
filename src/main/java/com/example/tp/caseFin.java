package com.example.tp;

public class caseFin extends Cases {
    public caseFin(){
        this.couleur = Couleur.Noire;
        this.numCase = 99;
    }
    @Override
    public void actionAssocie(Joueur J) {
        if (J.getPosition() == 99 ) {
            J.getPartieCourante().setPartieTermine(true);
            System.out.println("Partie Terminé, vous avez gagné");
        }
        else {
            if (J.getPosition() > 99 ){
                int différence = 99 - J.getPosition();
                J.setPosition (99 - différence);
            }
        }
    }

    public void test(){
        System.out.println("fin");
    }
}