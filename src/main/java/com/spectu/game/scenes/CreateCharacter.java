package com.spectu.game.scenes;

import com.spectu.game.Main;
import com.spectu.game.categories.Assassin;
import com.spectu.game.categories.Fighter;
import com.spectu.game.categories.Wizard;
import com.spectu.game.entities.Player;
import com.spectu.game.objects.Item;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CreateCharacter implements RPGScene {

    public static Player player;
    public static Fighter fighterClass;
    public static Assassin assassinClass;
    public static Wizard wizardClass;

    String playerClass;

    AnchorPane rootCreateCharacter;
    Scene sceneCreateCharacter;

    Label characterName;
    Label characterClassText;
    Label character;
    Label specialWeapon;

    Label abilityFighter;
    Label abilityAssassin;
    Label abilityWizard;

    Label descriptionWeaponFighter;
    Label descriptionWeaponAssassin;
    Label descriptionWeaponWizard;
    TextField characterValueName;

    Label nullPlayerName;
    Label nullPlayerClass;

    ComboBox characterClass;
    Button createCharacter;

    ImageView fighter;
    ImageView fighterSpecialWeapon;

    ImageView assassin;
    ImageView assassinSpecialWeapon;

    ImageView wizard;
    ImageView wizardSpecialWeapon;

    @Override
    public Scene create(Stage stage) {

        fighterClass = new Fighter();
        assassinClass = new Assassin();
        wizardClass = new Wizard();

        nullPlayerName = new Label("You have to put a name to be able to advance.");
        nullPlayerName.setVisible(false);
        nullPlayerName.setLayoutX(250);
        nullPlayerName.setLayoutY(80);

        nullPlayerClass = new Label("You have to select a class in order to advance.");
        nullPlayerClass.setVisible(false);
        nullPlayerClass.setLayoutX(250);
        nullPlayerClass.setLayoutY(170);

        characterName = new Label();
        characterName.setFont(new Font(15));
        characterName.setText("Enter your character's name:");
        characterName.setLayoutX(20);
        characterName.setLayoutY(40);

        characterClassText = new Label();
        characterClassText.setFont(new Font(15));
        characterClassText.setText("Select your class:");
        characterClassText.setLayoutX(20);
        characterClassText.setLayoutY(140);

        character = new Label("Character:");
        character.setFont(new Font(15));
        character.setVisible(false);
        character.setLayoutX(20);
        character.setLayoutY(300);

        specialWeapon = new Label("Special Weapon:");
        specialWeapon.setFont(new Font(15));
        specialWeapon.setVisible(false);
        specialWeapon.setLayoutX(140);
        specialWeapon.setLayoutY(300);

        characterValueName = new TextField();
        characterValueName.setFont(new Font(15));
        characterValueName.setLayoutX(30);
        characterValueName.setLayoutY(80);

        fighter = fighterClass.getCharacterImage();
        fighter.setVisible(false);
        fighter.setLayoutX(30);
        fighter.setLayoutY(320);

        abilityFighter = new Label("Ability: \n The Fighter has a 25% chance to Deal 35 additional damage and has a 15% change to recovery of 10 heal.");
        abilityFighter.setFont(new Font(12));
        abilityFighter.setVisible(false);
        abilityFighter.setLayoutX(20);
        abilityFighter.setLayoutY(210);

        descriptionWeaponFighter = new Label("Weapon: \n Golden spear: \n Base Damage: 25.");
        descriptionWeaponFighter.setFont(new Font(12));
        descriptionWeaponFighter.setVisible(false);
        descriptionWeaponFighter.setLayoutX(20);
        descriptionWeaponFighter.setLayoutY(250);

        fighterSpecialWeapon = fighterClass.getWeaponImage();
        fighterSpecialWeapon.setVisible(false);
        fighterSpecialWeapon.setLayoutX(160);
        fighterSpecialWeapon.setLayoutY(320);

        assassin = assassinClass.getCharacterImage();
        assassin.setVisible(false);
        assassin.setLayoutX(30);
        assassin.setLayoutY(320);

        abilityAssassin = new Label("Ability: \n the assassin executes the enemy if he is at 15 health or less.");
        abilityAssassin.setFont(new Font(12));
        abilityAssassin.setVisible(false);
        abilityAssassin.setLayoutX(20);
        abilityAssassin.setLayoutY(210);

        descriptionWeaponAssassin = new Label("Weapon: \n Enchanted Ice Sword: \n Base Damage: 40.");
        descriptionWeaponAssassin.setFont(new Font(12));
        descriptionWeaponAssassin.setVisible(false);
        descriptionWeaponAssassin.setLayoutX(20);
        descriptionWeaponAssassin.setLayoutY(250);

        assassinSpecialWeapon = assassinClass.getWeaponImage();
        assassinSpecialWeapon.setVisible(false);
        assassinSpecialWeapon.setLayoutX(160);
        assassinSpecialWeapon.setLayoutY(320);

        wizard = wizardClass.getCharacterImage();
        wizard.setVisible(false);
        wizard.setLayoutX(30);
        wizard.setLayoutY(320);

        abilityWizard = new Label("Ability: \n The wizard has a 60% chance to add 2 health potions and 1 escape potion.");
        abilityWizard.setFont(new Font(12));
        abilityWizard.setVisible(false);
        abilityWizard.setLayoutX(20);
        abilityWizard.setLayoutY(210);

        descriptionWeaponWizard = new Label("Weapon: \n Diabolical code: \n Base Damage: 60.");
        descriptionWeaponWizard.setFont(new Font(12));
        descriptionWeaponWizard.setVisible(false);
        descriptionWeaponWizard.setLayoutX(20);
        descriptionWeaponWizard.setLayoutY(250);

        wizardSpecialWeapon = wizardClass.getWeaponImage();
        wizardSpecialWeapon.setVisible(false);
        wizardSpecialWeapon.setLayoutX(180);
        wizardSpecialWeapon.setLayoutY(330);

        characterClass = new ComboBox();
        characterClass.resizeRelocate(20, 170, 200, 20);
        characterClass.getItems().add("Fighter");
        characterClass.getItems().add("Assassin");
        characterClass.getItems().add("Wizard");
        characterClass.setOnAction((e) -> {

            Object selectedItem = characterClass.getSelectionModel().getSelectedItem();

            if (selectedItem.equals("Fighter")) {
                playerClass = "Fighter";
                character.setVisible(true);
                specialWeapon.setVisible(true);

                fighter.setVisible(true);
                abilityFighter.setVisible(true);
                fighterSpecialWeapon.setVisible(true);
                descriptionWeaponFighter.setVisible(true);

                assassin.setVisible(false);
                abilityAssassin.setVisible(false);
                assassinSpecialWeapon.setVisible(false);
                descriptionWeaponAssassin.setVisible(false);

                wizard.setVisible(false);
                abilityWizard.setVisible(false);
                wizardSpecialWeapon.setVisible(false);
                descriptionWeaponWizard.setVisible(false);
                return;
            }
            if (selectedItem.equals("Assassin")) {
                playerClass = "Assassin";
                character.setVisible(true);
                specialWeapon.setVisible(true);

                assassin.setVisible(true);
                abilityAssassin.setVisible(true);
                assassinSpecialWeapon.setVisible(true);
                descriptionWeaponAssassin.setVisible(true);

                fighter.setVisible(false);
                abilityFighter.setVisible(false);
                fighterSpecialWeapon.setVisible(false);
                descriptionWeaponFighter.setVisible(false);

                wizard.setVisible(false);
                abilityWizard.setVisible(false);
                wizardSpecialWeapon.setVisible(false);
                descriptionWeaponWizard.setVisible(false);
                return;
            }
            if (selectedItem.equals("Wizard")) {
                playerClass = "Wizard";
                character.setVisible(true);
                specialWeapon.setVisible(true);

                wizard.setVisible(true);
                abilityWizard.setVisible(true);
                wizardSpecialWeapon.setVisible(true);
                descriptionWeaponWizard.setVisible(true);

                fighter.setVisible(false);
                abilityFighter.setVisible(false);
                fighterSpecialWeapon.setVisible(false);
                descriptionWeaponFighter.setVisible(false);

                assassin.setVisible(false);
                abilityAssassin.setVisible(false);
                assassinSpecialWeapon.setVisible(false);
                descriptionWeaponAssassin.setVisible(false);
                return;
            }
        });

        createCharacter = new Button("Create Character!");
        createCharacter.setFont(new Font(15));
        createCharacter.setLayoutX(20);
        createCharacter.setLayoutY(400);
        createCharacter.setOnAction((e) -> {
            player = new Player(characterValueName.getText(), playerClass);

            if (player.name == null || player.name.equals("")) {

                nullPlayerName.setVisible(true);

            } else if (player.playerClass == null || player.playerClass.equals("")) {

                nullPlayerClass.setVisible(true);

            } else {

                Main.show(GameMenu.class);
            }
        });

        rootCreateCharacter = new AnchorPane();
        sceneCreateCharacter = new Scene(rootCreateCharacter, 1024, 530);
        stage.setResizable(false);

        rootCreateCharacter.getChildren().add(nullPlayerName);
        rootCreateCharacter.getChildren().add(nullPlayerClass);
        rootCreateCharacter.getChildren().add(characterClassText);
        rootCreateCharacter.getChildren().add(characterName);
        rootCreateCharacter.getChildren().add(characterValueName);
        rootCreateCharacter.getChildren().add(characterClass);
        rootCreateCharacter.getChildren().add(createCharacter);
        rootCreateCharacter.getChildren().add(fighter);
        rootCreateCharacter.getChildren().add(abilityFighter);
        rootCreateCharacter.getChildren().add(fighterSpecialWeapon);
        rootCreateCharacter.getChildren().add(descriptionWeaponFighter);
        rootCreateCharacter.getChildren().add(assassin);
        rootCreateCharacter.getChildren().add(abilityAssassin);
        rootCreateCharacter.getChildren().add(assassinSpecialWeapon);
        rootCreateCharacter.getChildren().add(descriptionWeaponAssassin);
        rootCreateCharacter.getChildren().add(wizard);
        rootCreateCharacter.getChildren().add(abilityWizard);
        rootCreateCharacter.getChildren().add(wizardSpecialWeapon);
        rootCreateCharacter.getChildren().add(descriptionWeaponWizard);
        rootCreateCharacter.getChildren().add(character);
        rootCreateCharacter.getChildren().add(specialWeapon);

        stage.setScene(sceneCreateCharacter);
        stage.show();

        return sceneCreateCharacter;
    }
}
