package com.spectu.game.scenes;

import com.spectu.game.Main;
import com.spectu.game.entity.Player;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CreateCharacter implements RPGScene {
    String name;
    TextField playerName;
    Player player = new Player(name);
    AnchorPane rootCreateCharacter;
    Scene sceneCreateCharacter;
    Label characterName;
    Label characterClassText;
    Button classAssassin;
    Button classBerserker;
    Button classFighter;
    Button classWizard;
    Button createCharacter;
    @Override
    public Scene create(Stage stage) {
        characterName = new Label();
        characterName.setFont(new Font(15));
        characterName.setText("Enter your character's name:");
        characterName.setLayoutX(0);
        characterName.setLayoutY(40);

        characterClassText = new Label();
        characterClassText.setFont(new Font(15));
        characterClassText.setText("Select your class:");
        characterClassText.setLayoutX(0);
        characterClassText.setLayoutY(140);


        playerName = new TextField();
        playerName.setFont(new Font(15));
        playerName.setLayoutX(0);
        playerName.setLayoutY(60);

        classFighter = new Button("Fighter");
        classFighter.setFont(new Font(15));
        classFighter.setLayoutX(0);
        classFighter.setLayoutY(180);
        classFighter.setOnAction((e) -> {
            player.playerClass = "Fighter";
        });

        classBerserker = new Button("Berserker");
        classBerserker.setFont(new Font(15));
        classBerserker.setLayoutX(0);
        classBerserker.setLayoutY(230);
        classBerserker.setOnAction((e) -> {
            player.playerClass = "Berserker";
        });

        classAssassin = new Button("Assassin");
        classAssassin.setFont(new Font(15));
        classAssassin.setLayoutX(0);
        classAssassin.setLayoutY(280);
        classAssassin.setOnAction((e) -> {
            player.playerClass = "Assassin";
        });

        classWizard = new Button("Wizard");
        classWizard.setFont(new Font(15));
        classWizard.setLayoutX(0);
        classWizard.setLayoutY(330);
        classWizard.setOnAction((e) -> {
            player.playerClass = "Wizard";
        });

        createCharacter = new Button("CreateCharacter!");
        createCharacter.setFont(new Font(15));
        createCharacter.setLayoutX(0);
        createCharacter.setLayoutY(380);
        createCharacter.setOnAction((e) -> {
            System.out.println(player.name);
            System.out.println(player.heal);
            System.out.println(player.playerClass);
            Main.show(GameMenu.class);
        });

        rootCreateCharacter = new AnchorPane();
        sceneCreateCharacter = new Scene(rootCreateCharacter, 720, 720);

        rootCreateCharacter.getChildren().add(characterClassText);
        rootCreateCharacter.getChildren().add(classBerserker);
        rootCreateCharacter.getChildren().add(characterName);
        rootCreateCharacter.getChildren().add(classFighter);
        rootCreateCharacter.getChildren().add(classAssassin);
        rootCreateCharacter.getChildren().add(classWizard);
        rootCreateCharacter.getChildren().add(playerName);
        rootCreateCharacter.getChildren().add(createCharacter);
        stage.setScene(sceneCreateCharacter);
        stage.show();

        return sceneCreateCharacter;
    }
}
