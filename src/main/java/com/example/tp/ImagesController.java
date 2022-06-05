package com.example.tp;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ImagesController {
    
    @FXML
    Button image0;
    @FXML
    Button image1;
    @FXML
    Button image2;
    @FXML
    Button image3;
    @FXML
    Button submitButton;
    @FXML
    Label question;

    private int selection = 4;

    public void displayImage(caseImage image){
        question.setLayoutX(350- (image.getQuestion().length()*18));
        question.setText(image.getQuestion());

        ImageView view0 = new ImageView(getClass().getResource(image.getImage0()).toExternalForm());
        view0.setFitHeight(120);
        view0.setPreserveRatio(true);
        image0.setGraphic(view0);

        ImageView view1 = new ImageView(getClass().getResource(image.getImage1()).toExternalForm());
        view1.setFitHeight(120);
        view1.setPreserveRatio(true);
        image1.setGraphic(view1);

        ImageView view2 = new ImageView(getClass().getResource(image.getImage2()).toExternalForm());
        view2.setFitHeight(120);
        view2.setPreserveRatio(true);
        image2.setGraphic(view2);

        ImageView view3 = new ImageView(getClass().getResource(image.getImage3()).toExternalForm());
        view3.setFitHeight(120);
        view3.setPreserveRatio(true);
        image3.setGraphic(view3);

    }

    public void select0(){
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(0.5);

        image1.setEffect(colorAdjust);
        image2.setEffect(colorAdjust);
        image3.setEffect(colorAdjust);

        ColorAdjust colorAdj = new ColorAdjust();
        colorAdjust.setBrightness(-0.7);
        image0.setEffect(colorAdj);

        this.selection = 0;
    }

    public void select1(){
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.7);

        image2.setEffect(colorAdjust);
        image3.setEffect(colorAdjust);
        image0.setEffect(colorAdjust);

        ColorAdjust colorAdj = new ColorAdjust();
        colorAdj.setBrightness(0.0);
        image1.setEffect(colorAdj);

        this.selection = 1;

    }

    public void select2(){
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.7);

        image3.setEffect(colorAdjust);
        image0.setEffect(colorAdjust);
        image1.setEffect(colorAdjust);

        ColorAdjust colorAdj = new ColorAdjust();
        colorAdj.setBrightness(0.0);
        image2.setEffect(colorAdj);

        this.selection = 2;

    }

    public void select3(){
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.7);

        image0.setEffect(colorAdjust);
        image1.setEffect(colorAdjust);
        image2.setEffect(colorAdjust);

        ColorAdjust colorAdj = new ColorAdjust();
        colorAdj.setBrightness(0.0);
        image3.setEffect(colorAdj);

        this.selection = 3;

    }

    public void submitAnswer(){
        System.out.println("submitted " + this.selection);
        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.close();
    }
}
