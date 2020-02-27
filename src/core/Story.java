package core;

import charms.Heal_Charm;
import charms.No_Charm;
import monster.*;
import objects.Copper_Ring;
import objects.No_Object;
import weapons.Weapon_Dagger;
import weapons.Weapon_FireSword;
import weapons.Weapon_PoisonDagger;
import spells.Fire_Spell;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

public class Story {

    Game game;
    UI ui;
    VisibilityManager vm;
    Player player = new Player();
    SuperMonster monster;

    String text;
    int i = 0;
    int soundCue = 0;

    SoundEffect se = new SoundEffect();
    Random randomGenerator = new Random();


    public Story(Game g, UI userInterface, VisibilityManager vManager){

        game = g;
        ui = userInterface;
        vm = vManager;

    }

    public void defaultSetup(){

        player.hp = 150;
        ui.hpLabelNumber.setText("" + player.hp);

        player.fireballs = 10;
        ui.spellLabelName.setText("" + player.fireballs);

        player.charm = "Feather";
        ui.charmLabelNumber.setText(player.charm);

        player.gold = 0;
        ui.goldLabelName.setText("" + player.gold);

        player.location = "Road";
        ui.locationLabelName.setText(player.location);


        player.currentWeapon = new Weapon_Dagger();
        ui.weaponLabelName.setText(player.currentWeapon.name);

        player.currentSpell = new Fire_Spell();
        ui.spellLabel.setText(player.currentSpell.name + " :");


        player.currentCharm = new Heal_Charm();
        ui.charmLabelNumber.setText(player.currentCharm.name);

        player.currentObject = new No_Object();
        ui.inventoryLabelName.setText(player.currentObject.name);

        }





    public void selectPosition(String nextPosition){
        switch (nextPosition){
            case "stayOnRoad" : stayOnRoad(); break;
            case "road" : road(); break;
            case "enterCastle" : enterCastle(); break;
            case "atDoor" : atDoor(); break;
            case "goLeft" : goLeft(); break;
            case "goRight" : goRight(); break;
            case "hWindow" : hWindow(); break;
            case "tryCharm" : tryCharm(); break;
            case "insideCastle" : insideCastle(); break;
            case "outsideCastle" : outsideCastle(); break;
            case "bashingWindow" : bashingWindow(); break;
            case "fightUndead" : fightUndead(); break;
            case "fleeUndead" : fleeUndead(); break;
            case "firstSpell" : firstSpell(); break;
            case "playerAttack" : playerAttack(); break;
            case "monsterAttack" : monsterAttack(); break;
            case "corridor" : corridor(); break;
            case "greenHouse" : greenHouse(); break;
            case "darkCorner" : darkCorner(); break;
            case "ironDoor" : ironDoor(); break;
            case "towerStairs" : towerStairs(); break;
            case "towerTop" : towerTop(); break;
            case "escape" : escape(); break;
            case "alchemistFight" : alchemistFight(); break;
            case "playerHit" : playerHit(); break;
            case "playerSpell" : playerSpell(); break;
            case "useCharm" : useCharm(); break;
            case "alchemistAttack" : alchemistAttack(); break;
            case "win" : win(); break;
            case "lose" : lose(); break;
            case "quitGame" : quitGame(); break;
            case "toTitle" : toTitle(); break;



        }

    }

    Timer timer = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            char character[] = text.toCharArray();
            int arrayNumber = character.length;

            String addedCharacter = "";
            String blank = "";

            addedCharacter = blank + character[i];
            ui.mainTextArea.append(addedCharacter);

            i++;
            soundCue++;

            if(soundCue==5) {
                se.setFile(ui.typeSound);
                se.play();
                soundCue=0;
            }

            if(i == arrayNumber){
                i=0;
                timer.stop();
            }

        }
    });

    public void prepareText(){
        i = 0;
        ui.mainTextArea.setText("");
        timer.start();
    }

    public void stayOnRoad() {
        ui.locationLabelName.setText("Road");
        text="You stay on the road, but it's gonna rain.";
        prepareText();
        ui.choice1.setText("Go to castle.");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);

        game.nextPosition1 = "enterCastle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void road(){
        ui.locationLabelName.setText("Road");
        text ="You are to retrieve a very important magic artifact from the big city of Dungaria.\nOn your way you pass by the entrance of an old, deserted castle.";
        prepareText();
        ui.choice1.setText("Explore !");
        ui.choice2.setText("Keep Walking.");
        ui.choice3.setText("");
        ui.choice4.setText("");
        ui.choice1.setVisible(true);
        ui.choice2.setVisible(true);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);

        game.nextPosition1 = "enterCastle";
        game.nextPosition2 = "stayOnRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void enterCastle() {

        ui.locationLabelName.setText("Alley Way.");
        text="As you walk in the alley way, you feel yourself surrounded\nby a wave of fear.\nA grim atmosphere now envelops the surroundings.\nYou face a huge wooden door, will you open it ?";
        prepareText();
        ui.choice1.setText("Yes !");
        ui.choice2.setText("No...");
        ui.choice3.setText("");
        ui.choice4.setText("");
        ui.choice1.setVisible(true);
        ui.choice2.setVisible(true);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);

        game.nextPosition1 = "atDoor";
        game.nextPosition2 = "goLeft";
        game.nextPosition3 = "";
        game.nextPosition4 = "";


    }

    public void atDoor() {
        ui.locationLabelName.setText("Main Door");
        text="You press your body against the heavy door, as it slowly open\nyou feel intoxicated by a " +
                "disgusting smell, your head spins,\nyou almost faint. You are injured and loose 25 year of life";
        prepareText();
        player.hp = player.hp - 25;
        ui.hpLabelNumber.setText("" + player.hp);
        ui.choice1.setText("Go left");
        ui.choice2.setText("Go right");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "goLeft";
        game.nextPosition2 = "goRight";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }
    public void goLeft(){
        ui.locationLabelName.setText("Left side.");
        text="You realize there is an open window on the left of the entrance.\nIt looks a bit high but you like a challenge...";
        prepareText();
        ui.choice1.setText("Climb");
        ui.choice2.setText("return to door");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "hWindow";
        game.nextPosition2 = "atDoor";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }
    public void goRight() {
        ui.locationLabelName.setText("Right side.");
        text="Hmmm there's nothing on this side.";
        prepareText();
        ui.choice1.setText("Go back");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "atDoor";


    }
    public void hWindow(){
        ui.locationLabelName.setText("By the Window");
        ui.mainTextArea.setText("The window is actually higher than you thought, this is going to be" +
                " a tricky one. As the magician that you are, you decide to use a lifting charm on your own body." +
                "\n***********************************************************************" +
                "\nCharms are magic scrolls with formula written on them. After you cast one it becomes useless." +
                "\nAlso, they don't always work very well, and the result can be...problematic. let's see, let's cast it !");
        ui.choice1.setText("Cast charm !");
        ui.choice2.setText("Go back");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "tryCharm";
        game.nextPosition2 = "atDoor";

    }
    public void tryCharm(){
        ui.locationLabelName.setText("By the window.");
        int castRoll = player.currentCharm.effect;
        if(castRoll == 1 || castRoll == 2) {
            ui.mainTextArea.setText("Pfiouuuu BANG ! Your body becomes as light as a feather and you start to slowly ascend !" +
                    "\nYou manage to climb to the window before the spell wears off");

            ui.choice1.setText("Get inside !");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
            ui.choice2.setVisible(false);
            game.nextPosition1 = "insideCastle";

        }else{ ui.mainTextArea.setText("Pshiiit FFFRRRRHH the parchment burns and sets fire to your clothes, you run in vain and are severely injured." +
                "you loose 100 years of life");
            player.hp = player.hp - 100;
            ui.hpLabelNumber.setText("" + player.hp);
            ui.choice1.setText("");
            ui.choice1.setVisible(false);
            ui.choice2.setText("Keep walking");
            ui.choice2.setVisible(true);
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition2 = "outsideCastle";
        }
        player.currentCharm = new No_Charm();
        ui.charmLabelNumber.setText(player.currentCharm.name);
    }
    public void insideCastle(){
        ui.locationLabelName.setText("Study Room");
        monster = new Undead();
        ui.mainTextArea.setText("You are now inside the castle, on the first floor. " +
                "The room is dark and filled with antiques. You go and open a door that leads you to a corridor." +
                "You hear a weird noise coming from the other end of the corridor." +
                "\nOH NO ! It's a disgusting " + monster.name + " creature, and it's running towards you !");
        ui.choice1.setText("Fight !");
        ui.choice1.setVisible(true);
        ui.choice2.setText("Flee !");
        ui.choice2.setVisible(true);
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "fightUndead";
        game.nextPosition2 = "fleeUndead";

    }
    public void outsideCastle() {
        ui.locationLabelName.setText("Behind castle.");
        monster = new Barricade();
        ui.enemyLabelName.setText("Barricade");
        ui.mainTextArea.setText("You keep walking along the castle and notice a ladder leading up to a balcony.\nYou climb up and face a barricaded window\nyou have to break through !\nUse your dagger !" +
                " A 50 Km/h hit should do the trick.\nBarricade resistance : " + monster.hp);
        ui.choice1.setText("Hit !");
        ui.choice1.setVisible(true);
        ui.choice2.setText("");
        ui.choice2.setVisible(false);
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "bashingWindow";
    }

    public void bashingWindow(){
        ui.locationLabelName.setText("Balcony.");
        int strikespeed = randomGenerator.nextInt(60)+10;
        monster.hp = monster.hp - strikespeed;

        if(monster.hp < 1) {
            ui.mainTextArea.setText("Good Lord ! A " + strikespeed + " Km/h hit ! The barricade falls in pieces.");
            ui.choice1.setText("Get inside");
            ui.choice1.setVisible(true);
            ui.choice2.setText("");
            ui.choice2.setVisible(false);
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "insideCastle";
        } else { ui.mainTextArea.setText("Only a " + strikespeed + " Km/h hit ! Keep trying.\nBarricade resistance : " + monster.hp);
            ui.choice1.setText("");
            ui.choice1.setVisible(false);
            ui.choice2.setText("Hit again");
            ui.choice2.setVisible(true);
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition2 = "bashingWindow";
        }
    }
    public void fightUndead(){
        ui.locationLabelName.setText("Study Room");
        monster = new Undead();
        ui.enemyLabelName.setText("Undead.");
        ui.mainTextArea.setText("Okay so you're in for a fight ! You'll use a fireball spell, that will teach him !");
        ui.choice1.setText("Cast fireball");
        ui.choice1.setVisible(true);
        ui.choice2.setText("");
        ui.choice2.setVisible(false);
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "firstSpell";

    }
    public void fleeUndead(){
        ui.locationLabelName.setText("Study room.");
        ui.enemyLabelName.setText("Undead.");
        ui.mainTextArea.setText("You are cornered, there is no escape, fighting is inevitable !");
        ui.choice1.setText("Fight");
        ui.choice2.setText("");
        ui.choice1.setVisible(true);
        ui.choice2.setVisible(false);
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "firstSpell";
    }
    public void firstSpell(){
        ui.locationLabelName.setText("Study room");
        ui.enemyLabelName.setText(monster.name);
        ui.mainTextArea.setText("To win this fight you will need to reach a certain temperature !" +
                "You gather all your energy, your hands start to glow. You aim at the poor creature and prepare to unleash your anger !" +
                "\nHow hot is your fireball, is it enough ?" + "\n" + monster.name + " resistance is 800°C");
        ui.choice1.setText("Continue");
        ui.choice1.setVisible(true);
        ui.choice2.setText("");
        ui.choice2.setVisible(false);
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "playerAttack";
    }
    public void playerAttack(){
        ui.locationLabelName.setText("Study room");
        ui.enemyLabelName.setText(monster.name);
        player.fireballs = player.fireballs - 1;
        ui.spellLabelName.setText("" + player.fireballs);
        int playerDamage = randomGenerator.nextInt(player.currentSpell.damage)+200;
        monster.hp = monster.hp - playerDamage;
        if(monster.hp <= 0) {
            ui.mainTextArea.setText("Whoa ! A " + playerDamage + "°C fireball ! Well done Wizard ! That undead scum is burnt to a crisp !" +
                    "\nThe undead is...well, dead. You find 30 gold coins on his body.");
            ui.choice1.setText("");
            ui.choice1.setVisible(false);
            ui.choice2.setText("Leave room");
            ui.choice2.setVisible(true);
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition2 = "corridor";
        } else {
            ui.mainTextArea.setText("Aaah ! A " + playerDamage + "°C fireball... That's not enough, the enemy still lives ! Let's try again !" +
                "\nUndead resistance : " + monster.hp);
            ui.choice1.setText(">>");
            ui.choice1.setVisible(true);
            ui.choice2.setText("");
            ui.choice2.setVisible(false);
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "monsterAttack";
        }
    }

    public void monsterAttack(){
        ui.locationLabelName.setText("Study room.");
        ui.enemyLabelName.setText("Undead.");
        int monsterDamage = monster.damage;
        player.hp = player.hp - monsterDamage;
        ui.hpLabelNumber.setText("" + player.hp);
        ui.mainTextArea.setText("The undead fights back ! You lose " + monsterDamage + " years of life...");
        if(player.hp > 0) {
            ui.choice1.setText("Shoot again");
            ui.choice1.setVisible(true);
            ui.choice2.setText("");
            ui.choice2.setVisible(false);
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "playerAttack";
        }
        else {
            ui.choice1.setText(">>");
            ui.choice1.setVisible(true);
            ui.choice2.setText("");
            ui.choice2.setVisible(false);
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "lose";
        }

    }
    public void corridor(){
        ui.enemyLabelName.setText("");
        ui.locationLabelName.setText("Corridor.");
        player.gold = player.gold + 30;
        ui.goldLabelName.setText("" + player.gold);
        ui.mainTextArea.setText("You arrive in a corridor, all the portraits on the wall look at you angrily. A heartwarming ray of sunlight emerge" +
                "from a room at the end of the corridor, on the left side. This vision is rather reassuring. On the other side darkness embalms everything");
        ui.choice1.setText("Go left");
        ui.choice1.setVisible(true);
        ui.choice2.setText("Go right");
        ui.choice2.setVisible(true);
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "greenHouse";
        game.nextPosition2 = "darkCorner";

    }
    public void greenHouse(){
        ui.enemyLabelName.setText("");
        ui.locationLabelName.setText("Greenhouse.");
        ui.mainTextArea.setText("Location : Greenhouse.\nYou enter in what seems to be a greenhouse. Hundreds of plants are quietly sunbathing, covered in a kaleidoscopic" +
                " collection of flowers. You barely have the time to enjoy this marvellous atmosphere and start suffocating. You quickly escape." +
                "and find a Poison Dagger on the floor.\nThe toxic pollen has entered your system and weakens you, you loose 50 years of life !" +
                "\n Poison Dagger added to you inventory.");
        player.hp = player.hp - 50;
        ui.hpLabelNumber.setText("" + player.hp);
        player.currentWeapon = new Weapon_PoisonDagger();
        ui.weaponLabelName.setText(player.currentWeapon.name);

        ui.choice1.setText("Escape !");
        ui.choice2.setText("Stay");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "corridor";
        game.nextPosition2 = "greenHouse";
    }
    public void darkCorner(){
        monster = new IronDoor();
        ui.enemyLabelName.setText("");
        ui.locationLabelName.setText("Corridor, right.");
        ui.mainTextArea.setText("After long seconds your eyes finally adjust to the obscurity. You notice an  glowing iron cell door." +
                " Behind it, is a stone staircase leading up to a tower. Let's melt that door so we can keep going. To do that, " +
                "cast several fireballs and see if it melts the iron, you need to reach 2000°C.\nIron resistance : " + monster.hp);
        ui.choice1.setText("Fireballs !");
        ui.choice2.setText("Go back");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "ironDoor";
        game.nextPosition2 = "corridor";
    }
    public void ironDoor() {
        monster = new IronDoor();
        ui.enemyLabelName.setText("Iron door");
        ui.locationLabelName.setText(monster.name);
        int fireNum = randomGenerator.nextInt(3)+1;
        int playerDamage1 = (randomGenerator.nextInt(player.currentSpell.damage)+500);
        int playerDamage2 = playerDamage1 * fireNum;
        player.fireballs = player.fireballs - fireNum ;
        ui.spellLabelName.setText("" + player.fireballs);
        monster.hp = monster.hp - playerDamage2;

        if (monster.hp < 1) {
            ui.mainTextArea.setText("You casted " + fireNum + " fireballs, at " + playerDamage1 + "°C each !" +
                    "\nThe door melts under those hellish " + playerDamage2 + " °C ! \nYou found 50 gold coins behind the door ! ");
            ui.choice1.setText("Cross door");
            ui.choice1.setVisible(true);
            ui.choice2.setText("");
            ui.choice2.setVisible(false);
            game.nextPosition1 = "towerStairs";

        } else {
            ui.mainTextArea.setText("You casted " + fireNum + " fireballs, at " + playerDamage1 + "°C each !" +
                    "\nIron door resistance : " + monster.hp +
                    "\nThe door still stands, " + playerDamage2 + " °C is not enough to melt that iron...Iron is getting cold again.");
            ui.choice1.setText("");
            ui.choice1.setVisible(false);
            ui.choice2.setText("Try again");
            ui.choice2.setVisible(true);
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition2 = "ironDoor";
        }
    }
    public void towerStairs() {
        ui.enemyLabelName.setText("");
        ui.locationLabelName.setText("Stairs");
        player.gold = player.gold + 50;
        ui.goldLabelName.setText("" + player.gold);

        if(player.currentWeapon.name.equals("Poison Dagger")){
            ui.mainTextArea.setText("You climb the stairs and notice a piece of paper trapped between a vine and the stonewall. You use your Poison Dagger " +
                    "to cut through the vine and manage to collect the mysterious artifact...\nCongratulation you found a healing charm !" +
                    "\nHealing Charm added to your inventory. ");
            player.currentCharm = new Heal_Charm();
            ui.charmLabelNumber.setText(player.currentCharm.name);
            ui.choice1.setText("Go upstairs");
            ui.choice1.setVisible(true);
            ui.choice2.setText("");
            ui.choice2.setVisible(false);
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "towerTop";
        } else {
            ui.mainTextArea.setText("You climb the stairs and notice a piece of paper trapped between a vine and the stonewall but your" +
                    " Dagger cannot cut through the plant...the scroll remains blocked");
            ui.choice1.setText("Go upstairs");
            ui.choice2.setText("Go back");
            ui.choice2.setVisible(true);
            ui.choice1.setVisible(true);
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "towerTop";
            game.nextPosition2 = "corridor";
        }
    }
    public void towerTop() {
        monster = new Alchemist();
        ui.enemyLabelName.setText(monster.name);
        ui.locationLabelName.setText("Tower.");
        ui.mainTextArea.setText("You reached the Alchemist's Lair ! Bravo ! Here lies all the secrets of the Alchemist" +
                " enough to make you make you the greatest wizard in the world !\nBut wait...Something is not right, you can feel a presence..." +
                "\nOH NO ! It's the Alchemist !\nAlchemist : You fool ! You interrupted my transmutation, I was almost\n" +
                "in the making of a true philosopher's stone ! You deserve DEATH !");
        ui.choice1.setText("Enter fight");
        ui.choice2.setText("Escape !");
        ui.choice1.setVisible(true);
        ui.choice2.setVisible(true);
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "alchemistFight";
        game.nextPosition2 = "escape";
    }

    public void escape(){

        ui.enemyLabelName.setText(monster.name);
        ui.locationLabelName.setText("Tower.");
        ui.mainTextArea.setText("The " + monster.name + " locked the tower, there is no escape.");
        ui.choice1.setText("Enter fight");
        ui.choice2.setText("");
        ui.choice1.setVisible(true);
        ui.choice2.setVisible(false);
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "alchemistFight";
    }

    public void alchemistFight(){

        ui.enemyLabelName.setText(monster.name);
        ui.locationLabelName.setText("Tower.");
        ui.mainTextArea.setText(monster.name + "'s defense : " + monster.hp + "\nAttack him to save yourself !");

        if (player.fireballs >= 1) {
            ui.choice1.setText("Hit");
            ui.choice2.setText("Spell");
            ui.choice2.setVisible(true);
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "playerHit";
            game.nextPosition2 = "playerSpell";

        } else {
            ui.choice1.setText("Hit");
            ui.choice2.setText("");
            ui.choice2.setVisible(false);
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "playerHit";

        }
        if(player.currentCharm.name.equals("Heal")){
            ui.choice3.setText("Use charm");
            ui.choice3.setVisible(true);
            game.nextPosition3 = "useCharm";

        } else {
            ui.choice3.setVisible(false);}
    }
    public void playerHit(){

        ui.enemyLabelName.setText(monster.name);
        ui.locationLabelName.setText("Tower.");
        int playerDamage = (randomGenerator.nextInt(player.currentWeapon.damage)+50);

        ui.mainTextArea.setText("You hit the Alchemist at " + playerDamage + " Km/h !");
        monster.hp = monster.hp - playerDamage;

        ui.choice1.setText(">>>");
        ui.choice2.setText("");
        ui.choice2.setVisible(false);
        ui.choice3.setText("");
        ui.choice3.setVisible(false);
        ui.choice3.setText("");
        ui.choice4.setText("");

        if(monster.hp > 0) {
            ui.choice1.setText(">>>");
            game.nextPosition1 = "alchemistAttack";
        } else {
            ui.choice1.setText(">>>");
            game.nextPosition1 = "win";}
    }
    public void playerSpell(){

        ui.enemyLabelName.setText(monster.name);
        ui.locationLabelName.setText("Tower.");
        player.fireballs = player.fireballs - 1;
        ui.spellLabelName.setText("" + player.fireballs);
        int spellDamage = (randomGenerator.nextInt(player.currentSpell.damage)+200);
        ui.mainTextArea.setText("Your fireball burns the " + monster.name + " at " + spellDamage + " °C !");
        monster.hp = monster.hp - spellDamage;

        ui.choice1.setText(">>>");
        ui.choice2.setText("");
        ui.choice2.setVisible(false);
        ui.choice3.setText("");
        ui.choice3.setVisible(false);
        ui.choice4.setText("");

        if(monster.hp > 0) {
            ui.choice1.setText(">>>");
            game.nextPosition1 = "alchemistFight";
        } else {
            ui.choice1.setText(">>>");
            game.nextPosition1 = "win";}
    }
    public void useCharm(){
        ui.enemyLabelName.setText(monster.name);
        ui.locationLabelName.setText("Tower.");
        int castRoll = randomGenerator.nextInt(3)+1;
        if(castRoll == 1 || castRoll == 2) {
            ui.mainTextArea.setText("Lucky you ! The charm worked, you gain 30 years of life !");
            player.hp = player.hp + 30;
            ui.hpLabelNumber.setText("" + player.hp);
        } else { ui.mainTextArea.setText("Argh ! The charm failed and disintegrate in your hands.");
        }
        player.currentCharm = new No_Charm();
        ui.charmLabelNumber.setText(player.currentCharm.name);

        ui.choice1.setText(">>>");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);

        game.nextPosition1 = "alchemistAttack";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }
    public void alchemistAttack(){

        ui.enemyLabelName.setText(monster.name);
        ui.locationLabelName.setText("Tower.");
        int attackRoll = randomGenerator.nextInt(2);
        if(attackRoll == 0) {
            int alchemistDamage = monster.poisonDart;
            ui.mainTextArea.setText("The Alchemist attacked you with a poison dart, you loose " + alchemistDamage + " years of life");
            player.hp = player.hp - alchemistDamage;
            ui.hpLabelNumber.setText("" + player.hp);
        } else {
            int alchemistDamage = monster.diseaseSpell;
            ui.mainTextArea.setText("The Alchemist casted a disease spell on you, you loose " + alchemistDamage + " years of life");
            player.hp = player.hp - alchemistDamage;
            ui.hpLabelNumber.setText("" + player.hp);
        }
        ui.choice1.setText(">>>");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

        if(player.hp > 0) {
            ui.choice1.setText(">>>");
            game.nextPosition1 = "alchemistFight";
        } else {
            ui.choice1.setText(">>>");
            game.nextPosition1 = "lose";}

    }
    public void win(){
        ui.enemyLabelName.setText("");
        ui.locationLabelName.setText("Tower.");
        ui.mainTextArea.setText("CONGRATULATION wizard ! You killed the Alchemist, on his body you retrieve a 'Fire Sword', a" +
                " Magic Ring and a life charm ! You pick one potion from the shelf and drink it.\nYour health is restored as well as you magic abilities." +
                "\n THE END.");
        player.currentWeapon = new Weapon_FireSword();
        ui.weaponLabelName.setText(player.currentWeapon.name);
        player.currentCharm = new Heal_Charm();
        ui.charmLabelNumber.setText(player.currentCharm.name);
        player.hp = 150;
        ui.hpLabelNumber.setText(("" +player.hp));
        player.currentObject = new Copper_Ring();
        ui.inventoryLabelName.setText(player.currentObject.name);
        player.fireballs = 10;
        ui.spellLabelName.setText("" + player.fireballs);


        ui.choice1.setText("Restart");
        ui.choice1.setVisible(true);
        ui.choice2.setText("Quit");
        ui.choice2.setVisible(true);
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "quitGame";
        game.nextPosition3 = "";
        game.nextPosition4 = "";


    }
    public void lose(){
        ui.enemyLabelName.setText("");
        ui.mainTextArea.setText("You died.\nYour corpse rots in the castle for eternity, everyone forgets about you.\n\n<GAME OVER>");
        ui.choice1.setText("Restart");
        ui.choice2.setText("Quit");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "quitGame";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void toTitle(){
        defaultSetup();
        vm.showTitleScreen();
    }
    public void quitGame(){
        System.exit(0);

    }


    }


