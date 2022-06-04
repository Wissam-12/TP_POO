package com.example.tp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

    public class AcceuilView {
    private Stage stage;
    private Scene scene;
    private Parent root;

   public void goTo (ActionEvent e) throws IOException {
       root = new FXMLLoader(getClass().getResource("main-view.fxml")).load();
       stage = (Stage)((Node)e.getSource()).getScene().getWindow();
       scene = new Scene(root);
       Plateau Plateau = new Plateau();
       Cases[] plateau = Plateau.getPlateau();
       for (int i = 1; i < 99; i++) {
           if (plateau[i].couleur == Couleur.Rose) {
               ((Circle)scene.lookup("#c" + i)).setStyle("-fx-fill : pink ;");
           }
           if (plateau[i].couleur == Couleur.Vert) {
               ((Circle)scene.lookup("#c" + i)).setStyle("-fx-fill : green ;");
           }
           if (plateau[i].couleur == Couleur.gris) {
               ((Circle)scene.lookup("#c" + i)).setStyle("-fx-fill : grey ;");
           }
           if (plateau[i].couleur == Couleur.Bleue) {
               ((Circle)scene.lookup("#c" + i)).setStyle("-fx-fill : blue ;");
           }
           if (plateau[i].couleur == Couleur.Jaune) {
               ((Circle)scene.lookup("#c" + i)).setStyle("-fx-fill : yellow ;");
           }
           if (plateau[i].couleur == Couleur.Orange) {
               ((Circle)scene.lookup("#c" + i)).setStyle("-fx-fill : orange ;");
           }
           if (plateau[i].couleur == Couleur.Rouge) {
               ((Circle)scene.lookup("#c" + i)).setStyle("-fx-fill : red ;");
           }
       }
       stage.setScene(scene);
       stage.show();
       }
}
