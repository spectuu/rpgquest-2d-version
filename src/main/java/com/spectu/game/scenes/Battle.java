package com.spectu.game.scenes;

import com.spectu.game.Main;
import com.spectu.game.locations.Location;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Battle implements RPGScene{

    AnchorPane rootBattle;
    Scene sceneBattle;

    Image backgroundImage;
    ImageView backgroundImageView;
    ImageView playerCharacter;

    @Override
    public Scene create(Stage stage) {

        rootBattle = new AnchorPane();
        sceneBattle = new Scene(rootBattle, 1200, 530);

        if(World.locationBooty.equals("Cliff Mine")){
            backgroundImage = Main.getImage("BattleCliffMine.png");
            backgroundImageView = new ImageView(backgroundImage);

            backgroundImageView.setFitWidth(1200);
            backgroundImageView.setFitHeight(530);

            rootBattle.getChildren().add(backgroundImageView);
        }else if(World.locationBooty.equals("Dungeon")){

            backgroundImage = Main.getImage("BattleDungeon.png");
            backgroundImageView = new ImageView(backgroundImage);

            backgroundImageView.setFitWidth(1200);
            backgroundImageView.setFitHeight(530);

            rootBattle.getChildren().add(backgroundImageView);
        }

        playerCharacter = CreateCharacter.player.getPlayerCharacter();
        playerCharacter.setLayoutX(300);
        playerCharacter.setLayoutY(300);
        playerCharacter.setFitWidth(120);
        playerCharacter.setFitHeight(120);

        rootBattle.getChildren().add(playerCharacter);
        stage.setScene(sceneBattle);
        return sceneBattle;
    }
}
