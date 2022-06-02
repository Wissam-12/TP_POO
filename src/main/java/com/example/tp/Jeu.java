package com.example.tp;

public class Jeu {
    public static void main(String[] args) {
        // Definition def = new Definition();
        // for(int i = 0; i < 3; i++){
        //     System.out.println("La Question : " + (def.getTableauDefinitions())[i][0]);
        //     System.out.println("La Réponse : " + (def.getTableauDefinitions())[i][1]);
        // }
        Plateau pl = new Plateau();
        for(int i = 0; i < 100; i++){
            pl.getPlateau()[i].test();
        }
    }
}

// import javafx.application.Application;
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.layout.StackPane;
// import javafx.stage.Stage;

// public class Jeu extends Application {
//     @Override
//     public void start(Stage primaryStage) {
//         Button btn = new Button();
//         btn.setText("Say 'Hello World'");
//         btn.setOnAction(new EventHandler<ActionEvent>() {

//             @Override
//             public void handle(ActionEvent event) {
//                 System.out.println("Hello World!");
//             }
//         });

//         StackPane root = new StackPane();
//         root.getChildren().add(btn);

//   /*
//   Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
//   Scene scene = new Scene(root);
//   */

//   Scene scene = new Scene(root, 300, 250);

//   primaryStage.setTitle("Hello World!");
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//  public static void main(String[] args) {
//         launch(args);
//     }
// }

