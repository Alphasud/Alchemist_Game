package charms;

import java.util.Random;

public class Feather_Charm extends Super_Charms {

    Random randomGenerator = new Random();

    public Feather_Charm(){
        name = "Feather";
        effect = randomGenerator.nextInt(3);

    }

}
