package monster;

import java.util.Random;

public class Alchemist extends SuperMonster {

    Random randomGenerator = new Random();

    public Alchemist(){

        name = "Alchemist";
        hp = 2500;
        poisonDart = randomGenerator.nextInt(30)+1;
        diseaseSpell = randomGenerator.nextInt(50)+5;

    }

}