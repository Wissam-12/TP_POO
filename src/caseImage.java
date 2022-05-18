public class caseImage extends caseQuestion{
    private int image1,image2,image3,image4;
    private String mot;
    private int rep;
    private int bonneRep;
    private static int nombreDeCase = 0 ;
    public caseImage(int i){
        this.couleur = Couleur.Rose;
        this.numCase = i;
        this.visited = false;
        this.nombreDeCase +=1;
    }

    @Override
    public void actionAssocie(Joueur J) {
        System.out.println(this.mot);
        if (rep == bonneRep) gagner(J);
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

    public static int getNombreDeCase() {
        return nombreDeCase;
    }
}
