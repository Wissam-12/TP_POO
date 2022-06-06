package com.example.tp;

public class caseDefinition extends caseQuestion {
    private String question;
    private String bonneRep;
    // private static int nombreDeCase = 0;
    public caseDefinition (int i){
        this.couleur = Couleur.Bleue;
        this.numCase = i;
        this.visited = false;
        // this.nombreDeCase += 1;
    }

    @Override
    public void actionAssocie(Joueur J) {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Définition : "+ this.question);
        // this.reponse = sc.nextLine();
        // if (reponse.equalsIgnoreCase(bonneRep)) gagner(J);
        // else perdu(J);
    }

    public String getQuestion(){
        return this.question;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public void setBonneRep(String answer){
        this.bonneRep = answer;
    }

    public String getBonneRep(){
        return this.bonneRep;
    }

    public void gagner(Joueur J){
        J.setScoreActuel(J.getScoreActuel() + 20);
        J.setPosition(J.getPosition() + 4);
    }
    public void perdu(Joueur J){
        J.setScoreActuel(J.getScoreActuel() - 10);
    }
    @Override
    public void changerQuestion(Joueur J) {
        Definition def = J.getPartieCourante().getListDefs();
        this.question = def.getTableauDefinitions()[def.getLastVisitedIndex()+1][0];
        this.bonneRep = def.getTableauDefinitions()[def.getLastVisitedIndex()+1][1];
    }

    @Override
    public void setVisited(boolean i ) {
        this.visited = i ;
    }

    public void test(){
        System.out.println("Cases def");
    }
}
