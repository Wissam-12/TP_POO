public class Partie {
   private Definition listDefs;
   private Plateau plateau;
   private boolean partieTermine;

    public Partie (){
        this.listDefs = new Definition();
        this.plateau = new Plateau();
        plateau = new Plateau();
        this.partieTermine = false;
    }

    public void setPartieTermine(boolean partieTermine) {
        this.partieTermine = partieTermine;
    }

    public Definition getListDefs() {
        return listDefs;
    }
}
