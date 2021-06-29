package com.spectu.game.scenes;

import com.spectu.game.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CreateCharacter implements RPGScene {


    AnchorPane rootCreateCharacter;
    TextField playerName;
    Scene sceneCreateCharacter;
    Label text;

    @Override
    public Scene create(Stage stage) {

        playerName = new TextField();
        rootCreateCharacter = new AnchorPane();
        sceneCreateCharacter = new Scene(rootCreateCharacter, 720, 720);

        Button test = new Button("Switch");
        test.setOnAction((e) -> {
            Main.show(CreateCharacter.class);
        });

        test.setLayoutX(0);
        test.setLayoutY(70);



        rootCreateCharacter.getChildren().add(test);
        stage.setScene(sceneCreateCharacter);
        stage.show();

        return  sceneCreateCharacter;
    }
}
