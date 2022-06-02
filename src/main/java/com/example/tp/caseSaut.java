package com.example.tp;

import java.util.Random;
public class caseSaut extends Cases {
    // private static int nombreDeCase = 0 ;
    public caseSaut (int i){
        this.couleur= Couleur.Orange;
        this.numCase = i;
        // this.nombreDeCase += 1;
    }
    @Override
    public void actionAssocie(Joueur J) {
        Random rand = new Random();
        J.setPosition (rand.nextInt(100));
    }

    // public static int getNombreDeCase() {
    //     return nombreDeCase;
    // }

    public void test(){
        System.out.println("Case saut");
    }
}
