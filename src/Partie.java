public class Partie {
    Definition listDefs;
    Plateau plateau;

    public void nouvellePartie(){
        this.listDefs = new Definition();
        this.plateau = new Plateau();
        plateau.createPlateau();
    }
}
