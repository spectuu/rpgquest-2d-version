package com.spectu.game.scenes;

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

        title = new Label("Welcome to Game Menu select one option...");
        title.setFont(new Font(20));
        title.setLayoutX(20);
        title.setLayoutY(0);


        rootGameMenu = new AnchorPane();
        sceneGameMenu = new Scene(rootGameMenu, 1024, 530);
        stage.setResizable(false);

        rootGameMenu.getChildren().add(title);

        stage.setScene(sceneGameMenu);
        stage.show();

        return sceneGameMenu;
    }
}
