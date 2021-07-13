package com.spectu.game.scenes;

import com.spectu.game.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DeathScene implements RPGScene{

    AnchorPane rootDeathScene;
    Scene deathScene;

    Label title;
    Button button;

    @Override
    public Scene create(Stage stage) {

        rootDeathScene = new AnchorPane();
        deathScene = new Scene(rootDeathScene, 1200, 530);

        title = new Label("You have died click the button below to return to the main menu.");
        title.setFont(new Font(20));
        title.setLayoutX(50);
        title.setLayoutY(40);

        button = new Button("Continue");
        button.setFont(new Font(15));
        button.setLayoutX(50);
        button.setLayoutY(120);
        button.setOnAction((e) -> {
            Main.show(MainMenu.class);
        });

        rootDeathScene.getChildren().add(title);
        rootDeathScene.getChildren().add(button);
        stage.setScene(deathScene);
        return deathScene;
    }
}
