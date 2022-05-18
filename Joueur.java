public class Joueur {
    private String nom;
    private long id;
    private int meilleurScore, scoreActuel;
    private Case position;

    public Joueur(String nom, long id){
        this.nom = nom;
        this.id = id;
    }

    public int getMeilleurScore(){
        return this.meilleurScore;
    }

    public int getScoreActuel(){
        return this.scoreActuel;
    }

    public void setMeilleurScore(int meilleurScore){
        this.meilleurScore = meilleurScore;
    }

    public void gagne(int points){
        this.scoreActuel = this.scoreActuel + points;
    }

    public void avancer(int p ){}

    public void reculer(int p){}
}

