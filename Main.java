package com.me;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
        JFrame window;
        Container con;
        JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
        JLabel titleNameLabel, hpLabel, hpLabelNumber, spellLabel, spellLabelName, charmLabel, charmLabelNumber, weaponLabel, weaponLabelName;
        Font titleFont = new Font("Baskerville", Font.ITALIC, 70);
        Font normalFont = new Font("Courier", Font.PLAIN, 20);
        JButton startButton, choice1, choice2, choice3, choice4;
        JTextArea mainTextArea;

        int playerHP, fireballs, barricadeHP , doorHP, undeadHP, alchemistHP, magicRing;
        String weapon, charm, position;


        TitleScreenHandler tsHandler = new TitleScreenHandler();
        ChoiceHandler choiceHandler = new ChoiceHandler();
        Random randomGenerator = new Random();


        public static void main(String[] args) {
            new Main();
        }
        public Main(){

            window = new JFrame();
            window.setSize(1100, 600);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.getContentPane().setBackground(Color.BLACK);
            window.setLayout(null);
            window.setVisible(true);
            con = window.getContentPane();

            titleNamePanel = new JPanel();
            titleNamePanel.setBounds(100, 100, 920, 150);
            titleNamePanel.setBackground(Color.red);

            titleNameLabel = new JLabel("THE ALCHEMIST'S LAIR");
            titleNameLabel.setForeground(Color.white);
            titleNameLabel.setFont(titleFont);

            startButtonPanel = new JPanel();
            startButtonPanel.setBounds(480, 400, 200, 100);
            startButtonPanel.setBackground(Color.black);

            startButton = new JButton("START");
            startButton.setBackground(Color.black);
            startButton.setForeground(Color.black);
            startButton.setFont(normalFont);
            startButton.addActionListener(tsHandler);
            startButton.setFocusPainted(false);

            titleNamePanel.add(titleNameLabel);
            startButtonPanel.add(startButton);
            con.add(titleNamePanel);
            con.add(startButtonPanel);


        }
       public void createGameScreen(){

            titleNamePanel.setVisible(false);
            startButtonPanel.setVisible(false);

            mainTextPanel = new JPanel();
            mainTextPanel.setBounds(100, 100, 900, 250);
            mainTextPanel.setBackground(Color.black);
            con.add(mainTextPanel);

            mainTextArea = new JTextArea();
            mainTextArea.setBounds(100, 100,900,250);
            mainTextArea.setBackground(Color.black);
            mainTextArea.setForeground(Color.white);
            mainTextArea.setFont(normalFont);
            mainTextArea.setLineWrap(true);
            mainTextPanel.add(mainTextArea);

            choiceButtonPanel = new JPanel();
            choiceButtonPanel.setBounds(400, 400, 300, 150);
            choiceButtonPanel.setBackground(Color.black);
            choiceButtonPanel.setLayout(new GridLayout(4,1));
            con.add(choiceButtonPanel);

            choice1 = new JButton();
            choice1.setBackground(Color.BLACK);
            choice1.setBorder(null);
            choice1.setForeground(Color.orange);
            choice1.setFont(normalFont);
            choice1.setFocusPainted(false);
            choice1.addActionListener(choiceHandler);
            choice1.setActionCommand("c1");
            choiceButtonPanel.add(choice1);

            choice2 = new JButton();
            choice2.setBackground(Color.black);
            choice2.setForeground(Color.orange);
            choice2.setFont(normalFont);
            choice2.setFocusPainted(false);
            choice2.addActionListener(choiceHandler);
            choice2.setActionCommand("c2");
            choiceButtonPanel.add(choice2);

           choice3 = new JButton();
           choice3.setBackground(Color.black);
           choice3.setForeground(Color.orange);
           choice3.setFont(normalFont);
           choice3.setFocusPainted(false);
           choice3.addActionListener(choiceHandler);
           choice3.setActionCommand("c3");
           choiceButtonPanel.add(choice3);

           choice4 = new JButton();
           choice4.setBackground(Color.black);
           choice4.setForeground(Color.orange);
           choice4.setFont(normalFont);
           choice4.setFocusPainted(false);
           choice4.addActionListener(choiceHandler);
           choice4.setActionCommand("c4");
           choiceButtonPanel.add(choice4);

            playerPanel = new JPanel();
            playerPanel.setBounds(100, 15, 900, 50);
            playerPanel.setBackground(Color.magenta);
            playerPanel.setLayout(new GridLayout(2,4));
            con.add(playerPanel);
            hpLabel = new JLabel("Life :");
            hpLabel.setFont(normalFont);
            hpLabel.setForeground(Color.black);
            playerPanel.add(hpLabel);
            hpLabelNumber = new JLabel();
            hpLabelNumber.setFont(normalFont);
            hpLabelNumber.setForeground(Color.black);
            playerPanel.add(hpLabelNumber);
            spellLabel = new JLabel("Fireballs :");
            spellLabel.setFont(normalFont);
            spellLabel.setForeground(Color.black);
            playerPanel.add(spellLabel);
            spellLabelName = new JLabel();
            spellLabelName.setFont(normalFont);
            spellLabelName.setForeground(Color.black);
            playerPanel.add(spellLabelName);
            charmLabel = new JLabel("Charm :");
            charmLabel.setFont(normalFont);
            charmLabel.setForeground(Color.black);
            playerPanel.add(charmLabel);
            charmLabelNumber = new JLabel();
            charmLabelNumber.setFont(normalFont);
            charmLabelNumber.setForeground(Color.black);
            playerPanel.add(charmLabelNumber);
            weaponLabel = new JLabel("Weapon :");
            weaponLabel.setFont(normalFont);
            weaponLabel.setForeground(Color.black);
            playerPanel.add(weaponLabel);
            weaponLabelName = new JLabel();
            weaponLabelName.setFont(normalFont);
            weaponLabelName.setForeground(Color.black);
            playerPanel.add(weaponLabelName);

            playerSetup();

       }
       public void playerSetup(){
          playerHP = 150;
          barricadeHP = 50;
          undeadHP = 800;
          doorHP = 3000;
          alchemistHP = 1000;
          fireballs = 10;
          charm = "Feather";
          weapon = "Dagger";
          weaponLabelName.setText(weapon);
          spellLabelName.setText("" + fireballs);
          hpLabelNumber.setText("" + playerHP);
          charmLabelNumber.setText(charm);
            road();
       }
        public void stayOnRoad(){
        position = "stayOnRoad";
        mainTextArea.setText("Location : On the road.\nYou stay on the road, but it's gonna rain.");
        choice1.setText("Go to castle.");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);

        }
       public void road() {
             position = "road";
             mainTextArea.setText("Location : On the road.\nYou are to retrieve a very important magic artifact from\nthe big city of Dungaria.\nOn your way you pass by the entrance of an old,\ndeserted castle.");
             choice1.setText("Explore !");
             choice2.setText("Keep Walking.");
             choice3.setText("");
             choice4.setText("");
             choice3.setVisible(false);
             choice4.setVisible(false);

       }
       public void enterCastle() {
            position = "enterCastle";
            mainTextArea.setText("Location : Alley Way.\nAs you walk in the alley way, you feel yourself surrounded\nby a wave of fear.\nA grim atmosphere now envelops the surroundings.\nYou face a huge wooden door, will you open it ?");
            choice1.setText("Yes !");
            choice2.setText("No...");
            choice3.setText("");
            choice4.setText("");
            choice3.setVisible(false);
            choice4.setVisible(false);

       }

       public void atDoor() {
           position = "atDoor";
           mainTextArea.setText("Location : At the main door.\nYou press your body against the heavy door, as it slowly open\nyou feel intoxicated by a " +
                   "disgusting smell, your head spins,\nyou almost faint. You are injured and loose 25 year of life");
           playerHP = playerHP - 25;
           hpLabelNumber.setText("" + playerHP);
           choice1.setText("Go left");
           choice2.setText("Go right");

       }
       public void goLeft(){
            position = "goLeft";
            mainTextArea.setText("Location : Left side of the castle.\nYou realize there is an open window on the left of the entrance.\nIt looks a bit high but you like a challenge...");
            choice1.setText("Climb");
            choice2.setText("return to door");

       }
       public void goRight() {
           position = "goRight";
           mainTextArea.setText("Location : Right side of the castle.\nHmmm there's nothing on this side.");
           choice1.setText("Go back");
           choice2.setText("");

       }
       public void hWindow(){
            position = "hWindow";
           mainTextArea.setText("Location : Under the window.\nThe window is actually higher than you thought, this is going to be" +
                   "\na tricky one.\nAs the magician that you are, you decide to use a lifting charm on\nyour own body." +
                   "\n***********************************************************************" +
                   "\nCharms are magic scrolls with formula written on them. After you cast one it becomes useless." +
                   "\nAlso, they don't always work very well, and the result can be...\n...problematic. let's see, let's cast it !" +
                   "\n***********************************************************************");
           choice1.setText("Cast charm !");
           choice2.setText("Go back");

       }
       public void tryCharm(){
            position = "tryCharm";
            int castRoll = randomGenerator.nextInt(3);
            if(castRoll == 1 || castRoll == 2) {
                mainTextArea.setText("Pfiouuuu BANG ! Your body becomes as light as a feather and you start to slowly ascend !" +
                        "\nYou manage to climb to the window before the spell wears off");
                choice1.setText("Get inside !");
                choice2.setText("");
                choice2.setVisible(false);
            }else{ mainTextArea.setText("Pshiiit FFFRRRRHH the parchment burns and sets fire to your clothes, you run in vain and are severely injured." +
                    "you loose 100 years of life");
                    playerHP = playerHP - 100;
                    hpLabelNumber.setText("" + playerHP);
                    choice1.setText("");
                    choice1.setVisible(false);
                    choice2.setText("Keep walking");
            }
           charm = "none";
           charmLabelNumber.setText("none");
       }
       public void insideCastle(){
            position = "insideCastle";
            mainTextArea.setText("Location : Study room.\nYou are now inside the castle, on the first floor. " +
                    "The room is dark and filled with antiques. You go and open a door that leads you to a corridor." +
                    "You hear a weird noise coming from the other end of the corridor." +
                    "\nOH NO ! It's a disgusting undead creature, and it's running towards you !");
            choice1.setText("Fight !");
            choice1.setVisible(true);
            choice2.setText("Flee !");
            choice2.setVisible(true);

       }
       public void outsideCastle(){
            position = "outsideCastle";
            mainTextArea.setText("You keep walking along the castle and notice a ladder leading up to a balcony.\nYou climb up and face a barricaded window\nyou have to break through !\nUse your dagger !" +
                    " A 50 Km/h hit should do the trick.\nBarricade resistance : " + barricadeHP);
            choice1.setText("Hit !");
            choice1.setVisible(true);
            choice2.setText("");
            choice2.setVisible(false);
       }
       public void bashingWindow(){
            position = "bashingWindow";
            int strikespeed = randomGenerator.nextInt(60);
            strikespeed+=10;
            if(strikespeed >= 50) {
                mainTextArea.setText("Good Lord ! A " + strikespeed + " Km/h hit ! The barricade falls in pieces.\nBarricade resistance : " + (barricadeHP-strikespeed));
                choice1.setText("Get inside");
                choice1.setVisible(true);
                choice2.setText("");
                choice2.setVisible(false);
            } else { mainTextArea.setText("Only a " + strikespeed + " Km/h hit ! Keep trying.\nBarricade resistance : " + (barricadeHP-strikespeed));
            choice1.setText("");
            choice1.setVisible(false);
            choice2.setText("Hit again");
            choice2.setVisible(true);
            }
       }
       public void fightUndead(){
           position = "fightUndead";
           mainTextArea.setText("Okay so you're in for a fight ! You'll use a fireball spell, that will teach him !");
           choice1.setText("Cast fireball");
           choice1.setVisible(true);
           choice2.setText("");
           choice2.setVisible(false);

       }
       public void fleeUndead(){
            position = "fleeUndead";
            mainTextArea.setText("You are cornered, there is no escape, fighting is inevitable !");
            choice1.setText("Fight");
            choice2.setText("");
            choice1.setVisible(true);
            choice2.setVisible(false);
       }
       public void firstSpell(){
            position = "firstSpell";
            mainTextArea.setText("Unfortunately you're not the best wizard there is, and you're also a bit rusty, to win this fight you will need to reach at least 800°C !" +
                    "You gather all your energy, your hands start to glow. You aim at the poor creature and prepare to unleash your anger !" +
                    "\nHow hot is your fireball, is it enough ?\nUndead resistance : " + undeadHP);
            choice1.setText("Continue");
            choice1.setVisible(true);
            choice2.setText("");
            choice2.setVisible(false);
       }
       public void deadOrAlive(){
            position = "deadOrAlive";
           fireballs = fireballs - 1;
           spellLabelName.setText("" + fireballs);
           int fireTemp = randomGenerator.nextInt(1000);
           fireTemp+=400;
           if(fireTemp >= 800) {
               mainTextArea.setText("Whoa ! A " + fireTemp + "°C fireball ! Well done Wizard ! That undead scum is burnt to a crisp !" +
               "\nThe undead is...well, dead.");
               choice1.setText("");
               choice1.setVisible(false);
               choice2.setText("Leave room");
               choice2.setVisible(true);
           }else{ mainTextArea.setText("Aaah ! A " + fireTemp + "°C fireball... That's not enough, the enemy still lives ! Let's try again !" +
                   "\nUndead resistance :" + (undeadHP - fireTemp));
           choice1.setText("Shoot again");
           choice1.setVisible(true);
           choice2.setText("");
           choice2.setVisible(false);
           }


       }
       public void corridor(){
            position = "corridor";
            mainTextArea.setText("You arrive in a corridor, all the portraits on the wall look at you angrily. A heartwarming ray of sunlight emerge" +
                    "from a room at the end of the corridor, on the left side. This vision is rather reassuring. On the other side darkness embalms everything");
            choice1.setText("Go left");
            choice1.setVisible(true);
            choice2.setText("Go right");
            choice2.setVisible(true);

       }
       public void greenHouse(){
            position = "greenHouse";
            mainTextArea.setText("Location : Greenhouse.\nYou enter in what seems to be a greenhouse. Hundreds of plants are quietly sunbathing, covered in a kaleidoscopic" +
                    " collection of flowers. You barely have the time to enjoy this marvellous atmosphere and start suffocating. You quickly escape." +
                    "and find a Poison Dagger on the floor.\nThe toxic pollen has entered your system and weakens you, you loose 50 years of life !" +
                    "\n Poison Dagger added to you inventory.");
           playerHP = playerHP - 50;
           hpLabelNumber.setText("" + playerHP);
           weapon = "Poison Dagger";
           weaponLabelName.setText(weapon);

           choice1.setText("Escape !");
           choice2.setText("Stay");
       }
       public void darkCorner(){
            position = "darkCorner";
            mainTextArea.setText("\nLocation : Corridor right.\nAfter long seconds your eyes finally adjust to the obscurity. You notice an  glowing iron cell door." +
                    " Behind it, is a stone staircase leading up to a tower. Let's melt that door so we can keep going. To do that, " +
                    "cast several fireballs and see if it melts the iron, you need to reach 3000°C.\nIron resistance : " + doorHP);
            choice1.setText("Fireballs !");
            choice2.setText("Go back");
       }
       public void ironDoor() {
           position = "ironDoor";
           int fireballNum = randomGenerator.nextInt(3);
           fireballNum += 1;
           fireballs = fireballs - (fireballNum+=1);
           spellLabelName.setText("" + fireballs);
           int fireTemp2 = randomGenerator.nextInt(1000);
           fireTemp2 += 500;
           int playerDamage = fireballNum*fireTemp2;
           if (doorHP-(fireballNum*fireTemp2) <= 0) {
               mainTextArea.setText("You casted " + fireballNum + " fireballs, at " + fireTemp2 + "°C each !" +
                       "\nThe door melts under those hellish " + playerDamage + " °C !");
               choice1.setText("Cross door");
               choice1.setVisible(true);
               choice2.setText("");
               choice2.setVisible(false);
           } else {
               mainTextArea.setText("You casted " + fireballNum + " fireballs, at " + fireTemp2 + "°C each !\nIron resistance : " + (doorHP- playerDamage) +
                       "\nThe door still stands, " + playerDamage + " °C is not enough to melt that iron...");
               choice1.setText("");
               choice1.setVisible(false);
               choice2.setText("Try again");
               choice2.setVisible(true);
           }
       }
       public void towerStairs() {
            position = "towerStairs";

            if(weapon.equals("Poison Dagger")) {
                mainTextArea.setText("You climb the stairs and notice a piece of paper trapped between a vine and the stonewall. You use your Poison Dagger " +
                        "to cut through the vine and manage to collect the mysterious artifact...\nCongratulation you found a healing charm !" +
                        "\nHealing Charm added to your inventory. ");
                charm = "Heal";
                charmLabelNumber.setText("Heal");
                choice1.setText("Go upstairs");
                choice1.setVisible(true);
                choice2.setText("");
                choice2.setVisible(false);
            } else {
                mainTextArea.setText("You climb the stairs and notice a piece of paper trapped between a vine and the stonewall but your" +
                        " Dagger cannot cut through the plant...the scroll remains blocked");
                choice1.setText("Go upstairs");
                choice2.setText("Go back");
                choice2.setVisible(true);
                choice1.setVisible(true);
            }
       }
       public void towerTop() {
            position = "towerTop";
            mainTextArea.setText("You reached the Alchemist's Lair ! Bravo ! Here lies all the secrets of the Alchemist" +
                    " enough to make you make you the greatest wizard in the world !\nBut wait...Something is not right, you can feel a presence..." +
                    "\nOH NO ! It's the Alchemist !\nAlchemist : You fool ! You interrupted my transmutation, I was almost\n" +
                    "in the making of a true philosopher's stone ! You deserve DEATH !");
            choice1.setText("Enter fight");
            choice2.setText("Escape !");
            choice1.setVisible(true);
            choice2.setVisible(true);

       }
       public void escape(){
            position = "escape";
            mainTextArea.setText("The Alchemist locked the tower, there is no escape.");
            choice1.setText("Enter fight");
            choice2.setText("");
            choice1.setVisible(true);
            choice2.setVisible(false);
       }
       public void alchemistFight(){
            position = "alchemistFight";
            mainTextArea.setText("Alchemist's defense : " + alchemistHP + "\nAttack him to save yourself !");
            choice1.setText("Hit");
           if (fireballs >= 1) {
               choice2.setText("Spell");
               choice2.setVisible(true);

           } else {
               choice2.setText("");
               choice2.setVisible(false);
           }
           if(charm == "Heal") {
               choice3.setText("Use charm");
               choice3.setVisible(true);
           } else {choice3.setVisible(false);}
       }
       public void playerHit(){
            position = "playerHit";
            int playerDamage = 0;
            if(weapon.equals("Poison Dagger")){
                playerDamage = new java.util.Random().nextInt(200)+ 100;
            } else if(weapon.equals("Dagger")){
                playerDamage = new java.util.Random().nextInt(100) + 50;
            }
            mainTextArea.setText("You hit the Alchemist at " + playerDamage + " Km/h !");
            alchemistHP = alchemistHP - playerDamage;
            choice1.setText(">>>");
            choice2.setText("");
            choice2.setVisible(false);
            choice3.setText("");
            choice3.setVisible(false);
       }
       public void playerSpell(){
            position = "playerSpell";
           fireballs = fireballs - 1;
           spellLabelName.setText("" + fireballs);
           int spellDamage;
           spellDamage = new Random().nextInt(400) + 100;
           mainTextArea.setText("Your fireball burns the Alchemist at " + spellDamage + " °C !");
           alchemistHP = alchemistHP - spellDamage;
           choice1.setText(">>>");
           choice2.setText("");
           choice3.setText("");
       }
       public void useCharm(){
            position = "useCharm";
            int castRoll = randomGenerator.nextInt(3);
            if(castRoll == 1 || castRoll == 2) {
                mainTextArea.setText("Lucky you ! The charm worked, you gain 30 years of life !");
                playerHP = playerHP + 30;
                hpLabelNumber.setText("" + playerHP);
            } else { mainTextArea.setText("Argh ! The charm failed and disintegrate in your hands.");
            }
            charm = "none";
            charmLabelNumber.setText("none");

            choice1.setText(">>>");
            choice2.setText("");
            choice3.setText("");
            choice2.setVisible(false);
            choice3.setVisible(false);
       }
       public void alchemistAttack(){
            position = "alchemistAttack";
           int attackRoll = randomGenerator.nextInt(2);
           if(attackRoll == 0) {
               int alchemistDamage = 10;
               alchemistDamage = new java.util.Random().nextInt(30);
               mainTextArea.setText("The Alchemist attacked you with a poison dart, you loose " + alchemistDamage + " years of life");
               playerHP = playerHP - alchemistDamage;
               hpLabelNumber.setText("" + playerHP);
           } else {
               int alchemistDamage = 25;
               alchemistDamage = new java.util.Random().nextInt(50);
               mainTextArea.setText("The Alchemist casted a disease spell on you, you loose " + alchemistDamage + " years of life");
               playerHP = playerHP - alchemistDamage;
               hpLabelNumber.setText("" + playerHP);
           }
           choice1.setText(">>>");
           choice2.setText("");
           choice3.setText("");

       }
       public void win(){
            position = "win";
            mainTextArea.setText("CONGRATULATION wizard ! You killed the Alchemist, on his body you retrieve a 'Fire Sword', a" +
                    " Magic Ring and a life charm ! You pick one potion from the shelf and drink it.\nYour health is restored as well as you magic abilities." +
                    "\n THE END.");

            weapon = "Fire Sword";
           weaponLabelName.setText(weapon);
           charm = "Heal";
           charmLabelNumber.setText("Heal");
           playerHP = 150;
           hpLabelNumber.setText(("" +playerHP));
           magicRing = 1;
           fireballs = 10;
           spellLabelName.setText("fireballs");


           choice1.setText("Restart");
           choice1.setVisible(true);
           choice2.setText("Quit");
           choice2.setVisible(true);


       }
       public void lose(){
            position = "lose";

            mainTextArea.setText("You died.\nYour corpse rots in the castle for eternity, everyone forgets about you.\n<GAME OVER>");
            choice1.setText("Restart");
            choice2.setText("Quit");
       }
       public void quitGame(){
            position = "quitGame";
            System.exit(0);

       }


       public class TitleScreenHandler implements ActionListener{
           @Override
           public void actionPerformed(ActionEvent event) {
               createGameScreen();

           }

       }
       public class ChoiceHandler implements ActionListener{
            public void actionPerformed(ActionEvent event) {
                String yourChoice = event.getActionCommand();

                switch (position) {
                    case "road":
                        switch (yourChoice) {
                            case "c1":
                                enterCastle();
                                break;
                            case "c2":
                                stayOnRoad();
                                break;
                            case "c3":
                                break;
                            case "c4":
                                break;
                        }
                        break;
                    case "stayOnRoad":
                        switch (yourChoice) {
                            case "c1":
                                enterCastle();
                                break;
                        }
                        break;
                    case "enterCastle":
                        switch (yourChoice) {
                            case "c1":
                                atDoor();
                                break;
                            case "c2":
                                goLeft();
                                break;
                        }
                        break;
                    case "atDoor":
                        switch (yourChoice) {
                            case "c1":
                                if (playerHP < 1) {
                                    lose();
                                } else {
                                    goLeft();
                                }
                                break;

                            case "c2":
                                if (playerHP < 1) {
                                    lose();
                                } else {
                                    goRight();
                                }
                                break;
                        }
                        break;
                    case "goRight":
                        switch (yourChoice) {
                            case "c1":
                                atDoor();
                                break;
                        }
                        break;
                    case "goLeft":
                        switch (yourChoice) {
                            case "c1":
                                hWindow();
                                break;
                            case "c2":
                                atDoor();
                                break;
                        }
                        break;
                    case "hWindow":
                        switch (yourChoice) {
                            case "c1":
                                tryCharm();
                                break;
                            case "c2":
                                atDoor();
                                break;
                        }
                        break;
                    case "tryCharm":
                        switch (yourChoice) {
                            case "c1":
                                insideCastle();
                                break;
                            case "c2":
                                if (playerHP < 1) {
                                    lose();
                                } else {
                                    outsideCastle();
                                }
                                break;
                        }
                        break;
                    case "outsideCastle":
                        switch (yourChoice) {
                            case "c1":
                                bashingWindow();
                                break;
                        }
                        break;
                    case "bashingWindow":
                        switch (yourChoice) {
                            case "c1":
                                insideCastle();
                                break;
                            case "c2":
                                bashingWindow();
                                break;
                        }
                        break;
                    case "insideCastle":
                        switch (yourChoice) {
                            case "c1":
                                fightUndead();
                                break;
                            case "c2":
                                fleeUndead();
                                break;
                        }
                        break;
                    case "fleeUndead":
                        switch (yourChoice) {
                            case "c1":
                                fightUndead();
                                break;
                        }
                        break;
                    case "fightUndead":
                        switch (yourChoice) {
                            case "c1":
                                firstSpell();
                                break;
                        }
                        break;
                    case "firstSpell":
                        switch (yourChoice) {
                            case "c1":
                                deadOrAlive();
                                break;
                        }
                        break;
                    case "deadOrAlive":
                        switch (yourChoice) {
                            case "c1":
                                deadOrAlive();
                                break;
                            case "c2":
                                corridor();
                                break;
                        }
                        break;
                    case "corridor":
                        switch (yourChoice) {
                            case "c1":
                                greenHouse();
                                break;
                            case "c2":
                                darkCorner();
                                break;
                        }
                        break;
                    case "greenHouse":
                        switch (yourChoice) {
                            case "c1":
                                if (playerHP < 1) {
                                    lose();
                                } else {
                                    corridor();
                                }
                                break;

                            case "c2":
                                if (playerHP < 1) {
                                    lose();
                                } else {
                                    greenHouse();
                                }
                                break;
                        }
                        break;
                    case "darkCorner":
                        switch (yourChoice) {
                            case "c1":
                                ironDoor();
                                break;
                            case "c2":
                                corridor();
                                break;
                        }
                        break;
                    case "ironDoor":
                        switch (yourChoice) {
                            case "c1":
                                towerStairs();
                                break;
                            case "c2":
                                ironDoor();
                                break;
                        }
                        break;
                    case "towerStairs":
                        switch (yourChoice) {
                            case "c1":
                                towerTop();
                                break;
                            case "c2":
                                corridor();
                                break;
                        }
                        break;
                    case "towerTop":
                        switch (yourChoice) {
                            case "c1":
                                alchemistFight();
                                break;
                            case "c2":
                                escape();
                                break;
                        }
                        break;
                    case "escape":
                        switch (yourChoice) {
                            case "c1":
                                alchemistFight();
                                break;

                        }
                        break;
                    case "alchemistFight":
                        switch (yourChoice) {
                            case "c1":
                                playerHit();
                                break;
                            case "c2":
                                playerSpell();
                                break;
                            case "c3":
                                useCharm();
                                break;
                        }
                        break;
                    case "playerHit":
                    case "playerSpell":
                        switch (yourChoice) {
                            case "c1":
                                if(alchemistHP<1){
                                    win();
                                }
                                else {
                                    alchemistAttack();
                                }
                                break;
                        }
                        break;
                    case "useCharm" :
                        switch (yourChoice){
                            case "c1" : alchemistAttack(); break;
                        }
                        break;
                    case "alchemistAttack":
                        switch (yourChoice) {
                           case "c1" :
                               if(playerHP<1){
                                   lose();
                               }
                               else {
                                   alchemistFight();
                               }
                               break;
                        }
                        break;
                    case "lose" :
                    case "win" :
                        switch (yourChoice){
                            case "c1" : playerSetup(); break;
                            case "c2" : quitGame(); break;
                        }
                        break;


                }







                }

            }
       }


