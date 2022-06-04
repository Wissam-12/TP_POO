package com.example.tp;

import java.util.*;

public class Plateau {
    private Cases[] plateau = new Cases[100];
    public Plateau(){
        Random rand = new Random();
        int pos;
        List<Integer> cases = new ArrayList<Integer>(100);
        this.plateau[0] = new caseDebut();
        this.plateau[99] = new caseFin();
        for(int i = 1; i < 99; i ++){
            cases.add(i);
        }
        Boolean testIt;
        for(int i = 0; i < 5; i++){
            pos = 0;
            testIt = true;
            while(testIt){
                pos = rand.nextInt(98 - i);
                if (pos != 98){
                    testIt = false;
                }
            }
            this.plateau[cases.get(pos)] = new caseBonus(cases.get(pos));
            cases.remove(pos);
        }

        for(int i = 0; i < 5; i++){
            pos = 0;
            testIt = true;
            while(testIt){
                pos = rand.nextInt(93 - i);
                if (pos != 98){
                    testIt = false;
                }
            }
            this.plateau[cases.get(pos)] = new caseImage(cases.get(pos));
            cases.remove(pos);
        }

        for(int i = 0; i < 5; i++){
            pos = rand.nextInt(88 - i);
            this.plateau[cases.get(pos)] = new caseSaut(cases.get(pos));
            cases.remove(pos);
        }

        for(int i = 0; i < 5; i++){
            pos = 0;
            testIt = true;
            while(testIt){
                pos = rand.nextInt(83 - i);
                if(cases.contains(cases.get(pos) - 2) == false){
                    if ((plateau[cases.get(pos) - 2].couleur != Couleur.Vert) & (plateau[cases.get(pos) - 2].couleur != Couleur.Rose)){
                        testIt = false;
                    }
                }
                else{
                    testIt = false;
                }
            }
            this.plateau[cases.get(pos)] = new caseMalus(cases.get(pos));
            cases.remove(pos);
        }

        for(int i = 0; i < 5; i++){
            pos = 0;
            testIt = true;
            while(testIt){
                pos = rand.nextInt(78 - i);
                if ( (pos != 97)){
                    testIt = false;
                }
            }
            this.plateau[cases.get(pos)] = new caseDefinition(cases.get(pos));
            cases.remove(pos);
        }

        while(cases.isEmpty() == false){
            plateau[cases.get(0)] = new caseParcours(cases.get(0));
            cases.remove(0);
        }
    }

    public Cases[] getPlateau(){
        return this.plateau;
    }
}
