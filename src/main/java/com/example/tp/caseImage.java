package com.example.tp;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class caseImage extends caseQuestion {
    private String image0,image1,image2,image3;
    private String question;
    private int rep;
    private int bonneRep;
    // private int nombreDeCase = 0 ;
    public caseImage(int i){
        this.couleur = Couleur.Rose;
        this.numCase = i;
        this.visited = false;
        // this.nombreDeCase +=1;
    }
    @Override
    public void actionAssocie(Joueur J) {
        // if (rep == bonneRep) gagner(J);
        System.out.println("je suis dans image");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("images.fxml"));
        Parent root;
        caseImage img = new caseImage(2);
        img.setImage0("images/apple.jpg");
        img.setImage1("images/banana.jpg");
        img.setImage2("images/carrot.jpg");
        img.setImage3("images/lemon.jpg");
        img.setQuestion("Find the Apple");
        try {
            root = loader.load();
            ImagesController questionImg = loader.getController();
            questionImg.displayImage(img);
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void gagner(Joueur J){
        J.setScoreActuel(J.getScoreActuel() + 10);
        J.setPosition(J.getPosition() + 2);
    }
    @Override
    public void changerQuestion(Joueur J) {

    }

    @Override
    public void setVisited(boolean i) {
        this.visited = i ;
    }

    public void setImage0(String image){
        this.image0 = image;
    }

    public void setImage1(String image){
        this.image1 = image;
    }

    public void setImage2(String image){
        this.image2 = image;
    }

    public void setImage3(String image){
        this.image3 = image;
    }

    public String getImage0(){
        return this.image0;
    }

    public String getImage1(){
        return this.image1;
    }

    public String getImage2(){
        return this.image2;
    }

    public String getImage3(){
        return this.image3;
    }

    public String getQuestion(){
        return this.question;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public void test(){
        System.out.println("Case image");
    }

    // public int getNombreDeCase() {
    //     return nombreDeCase;
    // }
}
