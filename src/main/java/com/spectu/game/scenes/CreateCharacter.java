package com.spectu.game.scenes;

import com.spectu.game.Main;
import com.spectu.game.categories.Assassin;
import com.spectu.game.categories.Fighter;
import com.spectu.game.categories.Wizard;
import com.spectu.game.entities.Player;
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

    TextField playerName;
    AnchorPane rootCreateCharacter;
    Scene sceneCreateCharacter;
    Label characterName;
    Label characterClassText;
    Label character;
    Label specialWeapon;
    Label habilityFighter;
    Label habilityAssassin;
    Label habilityWizard;
    Label descriptionWeaponFighter;
    Label descriptionWeaponAssassin;
    Label descriptionWeaponWizard;
    ComboBox characterClass;
    Button createCharacter;
    ImageView fighter;
    ImageView fighterSpecialWeapon;
    ImageView assassin;
    ImageView assassinSpecialWeapon;
    ImageView wizard;
    ImageView wizardSpecialWeapon;
    Player player;

    @Override
    public Scene create(Stage stage) {

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

        playerName = new TextField();
        playerName.setFont(new Font(15));
        playerName.setLayoutX(30);
        playerName.setLayoutY(80);

        player = new Player(playerName.getText());

        fighter = Fighter.imageFighter();
        fighter.setVisible(false);
        fighter.setLayoutX(30);
        fighter.setLayoutY(320);

        habilityFighter = new Label("Ability: \n The Fighter has a 25% chance to Deal 35 additional damage and has a 15% change to recovery of 10 heal.");
        habilityFighter.setFont(new Font(12));
        habilityFighter.setVisible(false);
        habilityFighter.setLayoutX(20);
        habilityFighter.setLayoutY(210);

        descriptionWeaponFighter = new Label("Weapon: \n Golden spear: \n Base Damage: 25.");
        descriptionWeaponFighter.setFont(new Font(12));
        descriptionWeaponFighter.setVisible(false);
        descriptionWeaponFighter.setLayoutX(20);
        descriptionWeaponFighter.setLayoutY(250);

        fighterSpecialWeapon = Fighter.imageWeaponFighter();
        fighterSpecialWeapon.setVisible(false);
        fighterSpecialWeapon.setLayoutX(160);
        fighterSpecialWeapon.setLayoutY(320);

        assassin = Assassin.imageAssassin();
        assassin.setVisible(false);
        assassin.setLayoutX(30);
        assassin.setLayoutY(320);

        habilityAssassin = new Label("Ability: \n The Assassin executes the enemy if he is just within 15 life.");
        habilityAssassin.setFont(new Font(12));
        habilityAssassin.setVisible(false);
        habilityAssassin.setLayoutX(20);
        habilityAssassin.setLayoutY(210);

        descriptionWeaponAssassin = new Label("Weapon: \n Enchanted Ice Sword: \n Base Damage: 40.");
        descriptionWeaponAssassin.setFont(new Font(12));
        descriptionWeaponAssassin.setVisible(false);
        descriptionWeaponAssassin.setLayoutX(20);
        descriptionWeaponAssassin.setLayoutY(250);

        assassinSpecialWeapon = Assassin.imageWeaponAssassin();
        assassinSpecialWeapon.setVisible(false);
        assassinSpecialWeapon.setLayoutX(160);
        assassinSpecialWeapon.setLayoutY(320);

        wizard = Wizard.imageWizard();
        wizard.setVisible(false);
        wizard.setLayoutX(30);
        wizard.setLayoutY(320);

        habilityWizard = new Label("Ability: \n The Wizard Summons a destructive beam that deals 30 damage.");
        habilityWizard.setFont(new Font(12));
        habilityWizard.setVisible(false);
        habilityWizard.setLayoutX(20);
        habilityWizard.setLayoutY(210);

        descriptionWeaponWizard = new Label("Weapon: \n Diabolical code: \n Base Damage: 60.");
        descriptionWeaponWizard.setFont(new Font(12));
        descriptionWeaponWizard.setVisible(false);
        descriptionWeaponWizard.setLayoutX(20);
        descriptionWeaponWizard.setLayoutY(250);

        wizardSpecialWeapon = Wizard.imageWeaponWizard();
        wizardSpecialWeapon.setVisible(false);
        wizardSpecialWeapon.setLayoutX(180);
        wizardSpecialWeapon.setLayoutY(330);

        characterClass = new ComboBox();
        characterClass.resizeRelocate(20, 170, 200, 20);
        characterClass.getItems().add("Fighter");
        characterClass.getItems().add("Assassin");
        characterClass.getItems().add("Wizard");
        characterClass.setOnAction ((e) -> {

            Object selectedItem = characterClass.getSelectionModel (). getSelectedItem ();

            if(selectedItem.equals("Fighter")) {
                player.playerClass = "Fighter";

                character.setVisible(true);
                specialWeapon.setVisible(true);

                fighter.setVisible(true);
                habilityFighter.setVisible(true);
                fighterSpecialWeapon.setVisible(true);
                descriptionWeaponFighter.setVisible(true);

                assassin.setVisible(false);
                habilityAssassin.setVisible(false);
                assassinSpecialWeapon.setVisible(false);
                descriptionWeaponAssassin.setVisible(false);

                wizard.setVisible(false);
                habilityWizard.setVisible(false);
                wizardSpecialWeapon.setVisible(false);
                descriptionWeaponWizard.setVisible(false);
                return;
            }
            if(selectedItem.equals("Assassin")){
                player.playerClass = "Assassin";

                character.setVisible(true);
                specialWeapon.setVisible(true);

                assassin.setVisible(true);
                habilityAssassin.setVisible(true);
                assassinSpecialWeapon.setVisible(true);
                descriptionWeaponAssassin.setVisible(true);

                fighter.setVisible(false);
                habilityFighter.setVisible(false);
                fighterSpecialWeapon.setVisible(false);
                descriptionWeaponFighter.setVisible(false);

                wizard.setVisible(false);
                habilityWizard.setVisible(false);
                wizardSpecialWeapon.setVisible(false);
                descriptionWeaponWizard.setVisible(false);
                return;
            }
            if(selectedItem.equals("Wizard")){
                player.playerClass = "Wizard";

                character.setVisible(true);
                specialWeapon.setVisible(true);

                wizard.setVisible(true);
                habilityWizard.setVisible(true);
                wizardSpecialWeapon.setVisible(true);
                descriptionWeaponWizard.setVisible(true);

                fighter.setVisible(false);
                habilityFighter.setVisible(false);
                fighterSpecialWeapon.setVisible(false);
                descriptionWeaponFighter.setVisible(false);

                assassin.setVisible(false);
                habilityAssassin.setVisible(false);
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
            player.setName(playerName.getText());
            Main.show(GameMenu.class);
        });

        rootCreateCharacter = new AnchorPane();
        sceneCreateCharacter = new Scene(rootCreateCharacter, 1024, 530);
        stage.setResizable(false);

        rootCreateCharacter.getChildren().add(characterClassText);
        rootCreateCharacter.getChildren().add(characterName);
        rootCreateCharacter.getChildren().add(playerName);
        rootCreateCharacter.getChildren().add(characterClass);
        rootCreateCharacter.getChildren().add(createCharacter);
        rootCreateCharacter.getChildren().add(fighter);
        rootCreateCharacter.getChildren().add(habilityFighter);
        rootCreateCharacter.getChildren().add(fighterSpecialWeapon);
        rootCreateCharacter.getChildren().add(descriptionWeaponFighter);
        rootCreateCharacter.getChildren().add(assassin);
        rootCreateCharacter.getChildren().add(habilityAssassin);
        rootCreateCharacter.getChildren().add(assassinSpecialWeapon);
        rootCreateCharacter.getChildren().add(descriptionWeaponAssassin);
        rootCreateCharacter.getChildren().add(wizard);
        rootCreateCharacter.getChildren().add(habilityWizard);
        rootCreateCharacter.getChildren().add(wizardSpecialWeapon);
        rootCreateCharacter.getChildren().add(descriptionWeaponWizard);
        rootCreateCharacter.getChildren().add(character);
        rootCreateCharacter.getChildren().add(specialWeapon);

        stage.setScene(sceneCreateCharacter);
        stage.show();

        return sceneCreateCharacter;
    }
}
