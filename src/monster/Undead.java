package monster;

import java.util.Random;

public class Undead extends SuperMonster {

    Random randomGenerator = new Random();

    public Undead(){

        name = "Undead";
        hp = 800;
        damage = randomGenerator.nextInt(15);
    }

}
