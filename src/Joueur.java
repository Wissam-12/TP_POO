public class Joueur {
    private String nom;
    private String email;
    private int meilleurScore, scoreActuel;
    private int position;
    private Partie partieCourante;
    public Joueur(String nom, String email){
        this.nom = nom;
        this.email = email;
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setScoreActuel(int scoreActuel) {
        this.scoreActuel = scoreActuel;
    }

    public Partie getPartieCourante() {
        return partieCourante;
    }
}

