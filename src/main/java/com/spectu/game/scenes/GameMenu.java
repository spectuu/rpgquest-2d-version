package com.spectu.game.scenes;

import com.spectu.game.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameMenu implements RPGScene{

    Scene sceneGameMenu;
    AnchorPane rootGameMenu;

    @Override
    public Scene create(Stage stage) {

        Button test = new Button("Switch");
        test.setLayoutY(50);
        test.setLayoutX(500);
        test.setOnAction((e) -> {
            Main.show(CreateCharacter.class);
        });

        rootGameMenu = new AnchorPane();
        sceneGameMenu = new Scene(rootGameMenu, 720, 720);

        rootGameMenu.getChildren().add(test);

        stage.setScene(sceneGameMenu);
        stage.show();

        return sceneGameMenu;
    }
}
