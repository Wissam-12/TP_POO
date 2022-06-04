package com.example.tp;

import java.io.*;
import java.util.Scanner;

public class Definition {
    private int lastVisitedIndex;
    private String[][] tableauDefinitions = new String[20][3];

    public Definition(){
        this.lastVisitedIndex = -1;
        File definitions = new File("com/example/tp/definitions.txt");
        try {
            Scanner reader = new Scanner(definitions);
            for(int i = 0 ; i < 20; i++){
                if(reader.hasNextLine()){
                    this.tableauDefinitions[i][0] = reader.nextLine();
                }
                if(reader.hasNextLine()){
                    tableauDefinitions[i][1] = reader.nextLine();
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Une erreur a été rencontrée !");
            e.printStackTrace();
        }
    }

    public String[][] getTableauDefinitions(){
        return this.tableauDefinitions;
    }

    public int getLastVisitedIndex(){
        return this.lastVisitedIndex;
    }

    public void setLastVisitedIndex(int index){
        this.lastVisitedIndex = index;
    }
}
