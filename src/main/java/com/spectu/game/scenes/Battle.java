package com.spectu.game.scenes;

import com.spectu.game.Main;
import com.spectu.game.locations.Location;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Battle implements RPGScene{

   public static AnchorPane rootBattle;
   public static Scene sceneBattle;
   public static Label playerHeal;
   public static Label enemyHeal;

    Image backgroundImage;
    ImageView backgroundImageView;
    ImageView playerCharacter;
    ImageView enemyCharacter;

    @Override
    public Scene create(Stage stage) {

        rootBattle = new AnchorPane();
        sceneBattle = new Scene(rootBattle, 1200, 530);

        playerHeal = new Label(CreateCharacter.player.name + " " + CreateCharacter.player.heal + "/100");
        playerHeal.setFont(new Font(15));
        playerHeal.setTextFill(Color.web("#ff2200"));
        playerHeal.setStyle("-fx-font-weight: bold");
        playerHeal.setLayoutX(300);
        playerHeal.setLayoutY(150);

        enemyHeal = new Label(Location.enemy.name + " " + Location.enemy.heal + "/" + Location.enemy.healMax);
        enemyHeal.setFont(new Font(15));
        enemyHeal.setTextFill(Color.web("#ff2200"));
        enemyHeal.setStyle("-fx-font-weight: bold");
        enemyHeal.setLayoutX(700);
        enemyHeal.setLayoutY(150);

        playerCharacter = CreateCharacter.player.getPlayerCharacter();
        playerCharacter.setLayoutX(300);
        playerCharacter.setLayoutY(200);
        playerCharacter.setFitWidth(120);
        playerCharacter.setFitHeight(120);

        enemyCharacter = Location.enemy.enemyImage();
        enemyCharacter.setLayoutX(700);
        enemyCharacter.setLayoutY(200);
        enemyCharacter.setFitWidth(120);
        enemyCharacter.setFitHeight(120);

        if(World.locationBooty.equals("Cliff Mine")){
            backgroundImage = Main.getImage("BattleCliffMine.png");
            backgroundImageView = new ImageView(backgroundImage);

            backgroundImageView.setFitWidth(1200);
            backgroundImageView.setFitHeight(530);
        }else if(World.locationBooty.equals("Dungeon")){
            backgroundImage = Main.getImage("BattleDungeon.jpg");
            backgroundImageView = new ImageView(backgroundImage);

            playerHeal = new Label(CreateCharacter.player.name + " " + CreateCharacter.player.heal + "/100");
            playerHeal.setFont(new Font(15));
            playerHeal.setTextFill(Color.web("#ff2200"));
            playerHeal.setStyle("-fx-font-weight: bold");
            playerHeal.setLayoutX(300);
            playerHeal.setLayoutY(250);

            enemyHeal = new Label(Location.enemy.name + " " + Location.enemy.heal + "/" + Location.enemy.healMax);
            enemyHeal.setFont(new Font(15));
            enemyHeal.setTextFill(Color.web("#ff2200"));
            enemyHeal.setStyle("-fx-font-weight: bold");
            enemyHeal.setLayoutX(700);
            enemyHeal.setLayoutY(250);

            playerCharacter = CreateCharacter.player.getPlayerCharacter();
            playerCharacter.setLayoutX(300);
            playerCharacter.setLayoutY(315);
            playerCharacter.setFitWidth(120);
            playerCharacter.setFitHeight(120);

            enemyCharacter = Location.enemy.enemyImage();
            enemyCharacter.setLayoutX(700);
            enemyCharacter.setLayoutY(315);
            enemyCharacter.setFitWidth(120);
            enemyCharacter.setFitHeight(120);

            backgroundImageView.setFitWidth(1200);
            backgroundImageView.setFitHeight(530);
        }
        CreateCharacter.player.inventory.sceneChecker = Battle.sceneBattle;
        rootBattle.getChildren().add(backgroundImageView);
        rootBattle.getChildren().add(playerCharacter);
        rootBattle.getChildren().add(enemyCharacter);
        rootBattle.getChildren().add(playerHeal);
        rootBattle.getChildren().add(enemyHeal);
        CreateCharacter.player.inventory.showInventory();
        CreateCharacter.player.inventory.getHealingPotion().onClick();
        CreateCharacter.player.inventory.getEnchantedKnife().onClick();
        CreateCharacter.player.inventory.getEscapePotion().onClick();
        CreateCharacter.player.inventory.getMythril().onClick();
        CreateCharacter.player.inventory.getSpectral().onClick();
        CreateCharacter.player.inventory.getMythrilSword().weaponLabelInventory();
        CreateCharacter.player.inventory.getSpectralHoz().weaponLabelInventory();
        CreateCharacter.player.inventory.getMythrilSword().attackEnemy();
        CreateCharacter.player.inventory.getSpectralHoz().attackEnemy();
        stage.setScene(sceneBattle);

        return sceneBattle;
    }
}
