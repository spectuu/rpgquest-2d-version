package com.spectu.game.scenes;

import com.spectu.game.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.concurrent.ThreadLocalRandom;

public class Booty implements RPGScene{

    AnchorPane rootBooty;
    Scene sceneBooty;

    Label titleBooty;
    Label mythrilObtained;
    Label spectralObtained;
    Label healingPotionObtained;
    Label escapePotionObtained;
    Label enchantedKnifeObtained;

    ImageView mythrilImageView;
    ImageView spectralImageView;
    ImageView escapePotionImageView;
    ImageView healingPotionImageView;
    ImageView enchantedKnifeImageView;
    Button continueGameMenu;

    @Override
    public Scene create(Stage stage) {

        titleBooty = new Label("Booty: ");
        titleBooty.setFont(new Font(20));
        titleBooty.setLayoutX(50);
        titleBooty.setLayoutY(40);

        rootBooty = new AnchorPane();
        sceneBooty = new Scene(rootBooty, 1024, 530);

        if(World.locationBooty.equals("Cliff Mine")) {
           mythrilObtained = CreateCharacter.player.inventory.getMythril().booty();
           mythrilObtained.setLayoutX(50);
           mythrilObtained.setLayoutY(95);

           mythrilImageView = CreateCharacter.player.inventory.getMythril().imageItem();
           mythrilImageView.setLayoutX(205);
           mythrilImageView.setLayoutY(95);

           spectralObtained = CreateCharacter.player.inventory.getSpectral().booty();
           spectralObtained.setLayoutX(50);
           spectralObtained.setLayoutY(150);

           spectralImageView = CreateCharacter.player.inventory.getSpectral().imageItem();
           spectralImageView.setLayoutX(205);
           spectralImageView.setLayoutY(150);

            rootBooty.getChildren().add(mythrilObtained);
            rootBooty.getChildren().add(spectralObtained);
            rootBooty.getChildren().add(mythrilImageView);
            rootBooty.getChildren().add(spectralImageView);

        }else if(World.locationBooty.equals("Dungeon")){

            healingPotionObtained = CreateCharacter.player.inventory.getHealingPotion().booty();
            healingPotionObtained.setLayoutX(50);
            healingPotionObtained.setLayoutY(95);

            healingPotionImageView = CreateCharacter.player.inventory.getHealingPotion().imageItem();
            healingPotionImageView.setLayoutX(250);
            healingPotionImageView.setLayoutY(95);

            escapePotionObtained = CreateCharacter.player.inventory.getEscapePotion().booty();
            escapePotionObtained.setLayoutX(50);
            escapePotionObtained.setLayoutY(150);

            escapePotionImageView = CreateCharacter.player.inventory.getEscapePotion().imageItem();
            escapePotionImageView.setLayoutX(250);
            escapePotionImageView.setLayoutY(150);

            enchantedKnifeObtained = CreateCharacter.player.inventory.getEnchantedKnife().booty();
            enchantedKnifeObtained.setLayoutX(50);
            enchantedKnifeObtained.setLayoutY(200);

            enchantedKnifeImageView = CreateCharacter.player.inventory.getEnchantedKnife().imageItem();
            enchantedKnifeImageView.setLayoutX(250);
            enchantedKnifeImageView.setLayoutY(200);

            rootBooty.getChildren().add(healingPotionObtained);
            rootBooty.getChildren().add(healingPotionImageView);
            rootBooty.getChildren().add(escapePotionObtained);
            rootBooty.getChildren().add(escapePotionImageView);
            rootBooty.getChildren().add(enchantedKnifeObtained);
            rootBooty.getChildren().add(enchantedKnifeImageView);
        }

        continueGameMenu = new Button("Continue");
        continueGameMenu.setFont(new Font(14));
        continueGameMenu.setLayoutX(50);
        continueGameMenu.setLayoutY(350);
        continueGameMenu.setOnAction((e) -> {
            Main.show(GameMenu.class);
        });

        rootBooty.getChildren().add(titleBooty);
        rootBooty.getChildren().add(continueGameMenu);

        stage.setScene(sceneBooty);
        return sceneBooty;
    }
}
