package charms;

import java.util.Random;

public class Heal_Charm extends Super_Charms {

    Random randomGenerator = new Random();

    public Heal_Charm(){
        name = "Heal";
        effect = randomGenerator.nextInt(3);

    }

}