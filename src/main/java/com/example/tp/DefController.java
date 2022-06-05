package com.example.tp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DefController {

    @FXML
    Label question;
    @FXML
    TextField answer;
    @FXML
    Button submitButton;
    
    public void displayQuestion(caseDefinition def){
        question.setLayoutX(350- (def.getQuestion().length()*18));
        question.setText(def.getQuestion());
        answer.setPrefWidth(def.getBonneRep().length() * 36);
        answer.setLayoutX(350 - (def.getBonneRep().length() * 18));
        String ans = "_";
        for(int i = 1; i< (def.getBonneRep().length()); i++){
            ans = ans + " _";
        }
        answer.setText(ans);

        answer.textProperty().addListener((observable, oldText, newText)->{
            String text = "";
            if(newText.length() > (def.getBonneRep().length() * 2 - 1)){
                text = text + newText.charAt(0);
                int i = 1;
                while(text.length() != (def.getBonneRep().length() * 2 - 1)){
                    if(newText.charAt(i) != ' '){
                        text = text + " " + newText.charAt(i);
                    }
                    i++;
                }
                i = 0;
                while((i < text.length()) && (text.charAt(i) != '_')){
                    i++;
                }
                String right = "";
                for(int y = 2; y < i; y++){
                    right = right + text.charAt(y);
                }
                if(i != text.length()){
                    right = right +  text.charAt(0);
                    right = right + " ";
                    for(int y = right.length(); y < text.length(); y++){
                        right = right + text.charAt(y);
                    }
                }
                else{
                    right = right + " " + text.charAt(0);
                }

                answer.setText(right);
            }
        });
    }

    public void displayAnswer(caseDefinition def){
        
    }

    public void submitAnswer(){
        String reponse = "";
        int i = 0;
        while(i < answer.getText().length()){
            if(answer.getText().charAt(i) != ' '){
                reponse = reponse + answer.getText().charAt(i);
            }
            i++;
        }
        System.out.println("reponse : " + reponse);
        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.close();
    }
    
}
