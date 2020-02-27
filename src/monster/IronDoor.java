package monster;

import java.util.Random;

public class IronDoor extends SuperMonster {

    Random randomGenerator = new Random();

    public IronDoor(){

        name = "Iron door";
        hp = 2000;
        damage = 0;
    }

}