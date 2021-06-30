package com.spectu.game.scenes;

import com.spectu.game.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameMenu implements RPGScene{

    Scene sceneGameMenu;
    AnchorPane rootGameMenu;
    Button currentHeal;
    Button changeCharacterName;
    Label title;

    @Override
    public Scene create(Stage stage) {

        title = new Label("Welcome to Game Menu select one option....");
        title.setFont(new Font(30));
        title.setLayoutX(0);
        title.setLayoutY(0);

        currentHeal = new Button("Current Heal.");
        currentHeal.setFont(new Font(15));
        currentHeal.setLayoutX(0);
        currentHeal.setLayoutY(50);
        currentHeal.setOnAction((e) -> {

        });

        changeCharacterName = new Button("Change character name.");
        changeCharacterName.setFont(new Font(15));
        changeCharacterName.setLayoutX(0);
        changeCharacterName.setLayoutY(100);
        changeCharacterName.setOnAction((e) -> {

        });

        rootGameMenu = new AnchorPane();
        sceneGameMenu = new Scene(rootGameMenu, 720, 720);

        rootGameMenu.getChildren().add(title);
        rootGameMenu.getChildren().add(currentHeal);
        rootGameMenu.getChildren().add(changeCharacterName);

        stage.setScene(sceneGameMenu);
        stage.show();

        return sceneGameMenu;
    }
}
