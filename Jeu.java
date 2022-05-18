public class Jeu {
    public static void main(String[] args) {
        Definition def = new Definition();
        for(int i = 0; i < 3; i++){
            System.out.println("La Question : " + (def.getTableauDefinitions())[i][0]);
            System.out.println("La Réponse : " + (def.getTableauDefinitions())[i][1]);
        }
    }
}
