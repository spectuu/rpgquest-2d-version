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

    ImageView mythrilImageView;
    ImageView spectralImageView;

    Button continueGameMenu;


    int a = ThreadLocalRandom.current().nextInt(1, (1 + 15));

    @Override
    public Scene create(Stage stage) {

        rootBooty = new AnchorPane();
        sceneBooty = new Scene(rootBooty, 1200, 530);

        titleBooty = new Label("Booty: ");
        titleBooty.setFont(new Font(20));
        titleBooty.setLayoutX(50);
        titleBooty.setLayoutY(40);

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

        }else if(World.locationBooty.equals("Dungeon")){

        }

        continueGameMenu = new Button("Continue");
        continueGameMenu.setFont(new Font(14));
        continueGameMenu.setLayoutX(50);
        continueGameMenu.setLayoutY(195);
        continueGameMenu.setOnAction((e) -> {
            Main.show(GameMenu.class);
        });

        rootBooty.getChildren().add(titleBooty);
        rootBooty.getChildren().add(mythrilObtained);
        rootBooty.getChildren().add(spectralObtained);
        rootBooty.getChildren().add(mythrilImageView);
        rootBooty.getChildren().add(spectralImageView);
        rootBooty.getChildren().add(continueGameMenu);

        stage.setScene(sceneBooty);
        return sceneBooty;
    }
}
