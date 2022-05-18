public class caseBonus extends Cases{
    private static int nombreDeCase = 0 ;
    public caseBonus(int i){
        this.couleur = Couleur.Vert;
        this.numCase = i;
        this.nombreDeCase += 1;
    }
    @Override
    public void actionAssocie(Joueur J) {
        J.setScoreActuel (getScoreActuel +=10);
        J.setPosition (getPosition+2);
    }

    public static int getNombreDeCase() {
        return nombreDeCase;
    }
}
