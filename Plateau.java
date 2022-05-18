import java.util.*;

public class Plateau {
    private Case[] plateau = new Case[100];
    public void createPlateau(){
        Random rand = new Random();
        int pos;
        List<Integer> cases = new ArrayList<Integer>(100);
        for(int i = 1; i < 100; i ++){
            cases.add(i);
        }
        for(int i = 0; i < 5; i++){
            pos = rand.nextInt(100 - i);
        }

    }
}