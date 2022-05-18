import java.util.Scanner;
public class caseDefinition extends caseQuestion{
    private String question;
    private String reponse;
    private String bonneRep;
    private static int nombreDeCase = 0;
    public caseDefinition (int i){
        this.couleur = Couleur.Bleue;
        this.numCase = i;
        this.visited = false;
        this.nombreDeCase += 1;
    }

    @Override
    public void actionAssocie(Joueur J) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Définition : "+ this.question);
       this.reponse = sc.nextLine();
       if (reponse.equalsIgnoreCase(bonneRep)) gagner(J);
       else perdu(J);
    }
    public void gagner(Joueur J){
        J.setScoreActuel(J.getScoreActuel + 20);
        J.setPosition(J.getPosition + 4);
    }
    public void perdu(Joueur J){
        J.setScoreActuel(J.getScoreActuel - 10);
    }
    @Override
    public void changerQuestion() {
        this.question = Definition[Definition.getLastVisitedIndex+1][0];
        this.bonneRep = Definition[Definition.getLastVisitedIndex+1][1];
    }

    @Override
    public void setVisited(boolean i ) {
        this.visited = i ;
    }

    public static int getNombreDeCase() {
        return nombreDeCase;
    }
}