package com.spectu.game.scenes;

import com.spectu.game.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainMenu implements RPGScene {

    public Button startNewGame;
    public Button savedGame;
    public Scene sceneMainMenu;
    AnchorPane rootMainMenu;
    Label title;

    @Override
    public Scene create(Stage stage) {

        System.out.println("The Application has been running");

        stage.setTitle("RPGQUEST2D-VERSION");
        title = new Label();
        title.setText("WElCOME TO RPGQUEST!");
        title.setFont(new Font(30));
        title.setLayoutX(0);
        title.setLayoutY(0);

        rootMainMenu = new AnchorPane();
        sceneMainMenu = new Scene(rootMainMenu, 720, 720);

        startNewGame = new Button("Start a new adventure.");
        startNewGame.setFont(new Font(20));
        startNewGame.setOnAction((e) -> {
            Main.show(CreateCharacter.class);
        });

        startNewGame.setLayoutX(0);
        startNewGame.setLayoutY(50);

        savedGame = new Button("Carry on with a past adventure.");
        savedGame.setFont(new Font(20));


        savedGame.setLayoutX(0);
        savedGame.setLayoutY(100);

        Button test = new Button("Switch");
        test.setOnAction((e) -> {
            Main.show(CreateCharacter.class);
        });

        test.setLayoutX(0);
        test.setLayoutY(5);

        rootMainMenu.getChildren().add(startNewGame);
        rootMainMenu.getChildren().add(savedGame);
        rootMainMenu.getChildren().add(title);
        stage.setScene(sceneMainMenu);
        stage.show();

        return sceneMainMenu;

    }

}
