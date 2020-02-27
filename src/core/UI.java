package core;

import javax.swing.*;
import java.awt.*;

public class UI {

    JFrame window;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, imagePanel, infoPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, spellLabel, spellLabelName, charmLabel, charmLabelNumber,
            weaponLabel, weaponLabelName, imageLabel, locationLabel, locationLabelName, enemyLabel, enemyLabelName,
            inventoryLabel, inventoryLabelName, goldLabel, goldLabelName;
    Font titleFont = new Font("Baskerville", Font.ITALIC, 60);
    Font normalFont = new Font("Courier", Font.PLAIN, 17);
    Font storyFont = new Font("Georgia", Font.PLAIN, 22);

    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;

    String clickSound, typeSound;


    public void createUI(Game.ChoiceHandler choiceHandler){

        clickSound = ".//resources//click22.wav";
        typeSound = ".//resources//click.wav";


        //WINDOW
        window = new JFrame();
        window.setSize(960, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        //TITLE SCREEN
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(30, 100, 900, 150);
        titleNamePanel.setBackground(Color.red);

        titleNameLabel = new JLabel("THE ALCHEMIST'S LAIR");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(400, 400, 200, 150);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.black);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButtonPanel.add(startButton);
        startButton.addActionListener(choiceHandler);

        window.add(titleNamePanel);
        window.add(startButtonPanel);


        //GAME SCREEN
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(10, 485, 900, 250);
        mainTextPanel.setBackground(Color.black);
        mainTextPanel.setOpaque(false);
        window.add(mainTextPanel);

        mainTextArea = new JTextArea("this is the main text area");
        mainTextArea.setBounds(10, 485,900,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setOpaque(false);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(storyFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(650, 360, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        window.add(choiceButtonPanel);


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

        infoPanel = new JPanel();
        infoPanel.setBounds(650, 115, 300, 200);
        infoPanel.setBackground(Color.cyan);
        infoPanel.setLayout(new GridLayout(4,2));
        window.add(infoPanel);
        locationLabel = new JLabel("Location :");
        locationLabel.setFont(normalFont);
        locationLabel.setForeground(Color.black);
        infoPanel.add(locationLabel);
        locationLabelName = new JLabel();
        locationLabelName.setFont(normalFont);
        locationLabelName.setForeground(Color.black);
        infoPanel.add(locationLabelName);
        goldLabel = new JLabel("Gold :");
        goldLabel.setFont(normalFont);
        goldLabel.setForeground(Color.black);
        infoPanel.add(goldLabel);
        goldLabelName = new JLabel();
        goldLabelName.setFont(normalFont);
        goldLabelName.setForeground(Color.black);
        infoPanel.add(goldLabelName);
        inventoryLabel = new JLabel("Inventory :");
        inventoryLabel.setFont(normalFont);
        inventoryLabel.setForeground(Color.black);
        infoPanel.add(inventoryLabel);
        inventoryLabelName = new JLabel();
        inventoryLabelName.setFont(normalFont);
        inventoryLabelName.setForeground(Color.black);
        infoPanel.add(inventoryLabelName);
        enemyLabel = new JLabel("Enemy :");
        enemyLabel.setFont(normalFont);
        enemyLabel.setForeground(Color.black);
        infoPanel.add(enemyLabel);
        enemyLabelName = new JLabel();
        enemyLabelName.setFont(normalFont);
        enemyLabelName.setForeground(Color.black);
        infoPanel.add(enemyLabelName);


        playerPanel = new JPanel();
        playerPanel.setBounds(650, 5, 300, 100);
        playerPanel.setBackground(Color.magenta);
        playerPanel.setLayout(new GridLayout(4, 2));
        window.add(playerPanel);
        hpLabel = new JLabel("Life :");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.black);
        playerPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.black);
        playerPanel.add(hpLabelNumber);
        spellLabel = new JLabel();
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

        window.setVisible(true);


    }




}













