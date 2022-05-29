public class caseParcours extends Cases{
    public caseParcours (int i){
        this.couleur = Couleur.Blanc;
        this.numCase = i;
    }
    @Override
    public void actionAssocie(Joueur J) {

    }

    public void test(){
        System.out.println("Case parcours");
    }
}
