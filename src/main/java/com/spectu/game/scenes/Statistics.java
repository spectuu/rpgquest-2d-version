package com.spectu.game.scenes;

import com.spectu.game.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class Statistics implements RPGScene {

    public static Label playerHeal;

    public static AnchorPane rootStatistics;
    public static Scene sceneStatistics;
    public static StackPane inventoryStackPane;
    public static ScrollPane inventoryScrollPane;
    public static HBox inventory;

    Button back;

    Label playerName;
    Label playerClass;
    Label character;
    Label specialWeapon;
    Label playerAbility;
    Label playerSpecialWeaponDescription;
    Label Equipment;

    ImageView playerCharacter;
    ImageView playerSpecialWeapon;

    @Override
    public Scene create(Stage stage) {

        playerName = new Label("Player name: " + CreateCharacter.player.name);
        playerName.setFont(new Font(15));
        playerName.setLayoutX(20);
        playerName.setLayoutY(30);

        playerHeal = new Label("Player heal: " + CreateCharacter.player.heal + "/100");
        playerHeal.setFont(new Font(15));
        playerHeal.setLayoutX(20);
        playerHeal.setLayoutY(60);

        playerClass = new Label("Player class: " + CreateCharacter.player.playerClass);
        playerClass.setFont(new Font(15));
        playerClass.setLayoutX(20);
        playerClass.setLayoutY(90);

        character = new Label("Character: ");
        character.setFont(new Font(15));
        character.setLayoutX(20);
        character.setLayoutY(120);

        playerCharacter = CreateCharacter.playerCharacter;
        playerCharacter.setLayoutX(30);
        playerCharacter.setLayoutY(140);
        playerCharacter.setFitWidth(30);
        playerCharacter.setFitHeight(46);

        specialWeapon = new Label("Special Weapon: ");
        specialWeapon.setFont(new Font(15));
        specialWeapon.setLayoutX(120);
        specialWeapon.setLayoutY(120);

        playerSpecialWeaponDescription = new Label(CreateCharacter.playerSpecialWeaponDescription);
        playerSpecialWeaponDescription.setFont(new Font(15));
        playerSpecialWeaponDescription.setLayoutX(30);
        playerSpecialWeaponDescription.setLayoutY(210);

        playerAbility = new Label(CreateCharacter.playerAbility);
        playerAbility.setFont(new Font(15));
        playerAbility.setLayoutX(30);
        playerAbility.setLayoutY(300);

        Equipment = new Label("Objects and basic Weapons: ");
        Equipment.setFont(new Font(15));
        Equipment.setLayoutX(30);
        Equipment.setLayoutY(360);

        playerSpecialWeapon = CreateCharacter.playerSpecialWeapon;
        playerSpecialWeapon.setLayoutX(155);
        playerSpecialWeapon.setLayoutY(150);

        inventoryStackPane = new StackPane();
        inventoryStackPane.setLayoutX(10);
        inventoryStackPane.setLayoutY(430);

        inventoryScrollPane = new ScrollPane();
        inventoryScrollPane.setLayoutX(10);
        inventoryScrollPane.setLayoutY(430);

        inventory = new HBox();
        inventory.setLayoutX(10);
        inventory.setLayoutY(420);

        back = new Button("Back");
        back.setFont(new Font(15));
        back.setLayoutX(20);
        back.setLayoutY(500);
        back.setOnAction((e) -> {
            Main.show(GameMenu.class);
        });

        rootStatistics = new AnchorPane();
        sceneStatistics = new Scene(rootStatistics, 1200, 530);
        CreateCharacter.player.inventory.sceneChecker = Statistics.sceneStatistics;
        CreateCharacter.player.inventory.showInventory();
        CreateCharacter.player.inventory.getHealingPotion().onClick();
        CreateCharacter.player.inventory.getMythril().onClick();
        CreateCharacter.player.inventory.getSpectral().onClick();
        CreateCharacter.player.inventory.getSpecialWeapon().specialWeaponLabel();
        CreateCharacter.player.inventory.getMythrilSword().weaponLabelInventory();
        CreateCharacter.player.inventory.getSpectralHoz().weaponLabelInventory();
        inventoryStackPane.getChildren().add(inventoryScrollPane);
        inventoryStackPane.getChildren().add(inventory);
        rootStatistics.getChildren().add(inventoryStackPane);
        rootStatistics.getChildren().add(playerName);
        rootStatistics.getChildren().add(playerHeal);
        rootStatistics.getChildren().add(playerClass);
        rootStatistics.getChildren().add(playerAbility);
        rootStatistics.getChildren().add(Equipment);
        rootStatistics.getChildren().add(back);
        rootStatistics.getChildren().add(playerCharacter);
        rootStatistics.getChildren().add(character);
        rootStatistics.getChildren().add(playerSpecialWeapon);
        rootStatistics.getChildren().add(specialWeapon);
        rootStatistics.getChildren().add(playerSpecialWeaponDescription);
        stage.setScene(sceneStatistics);

        return sceneStatistics;
    }
}
