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
        title.setPrefSize(750, 300);
        title.setLayoutX(0.0);
        title.setLayoutY(0.0);

        rootMainMenu = new AnchorPane();
        sceneMainMenu = new Scene(rootMainMenu, 720, 720);

        startNewGame = new Button("Start a new adventure.");

        startNewGame.setLayoutX(0);
        startNewGame.setLayoutY(300);

        savedGame = new Button("Carry on with a past adventure.");

        savedGame.setLayoutX(80);
        savedGame.setLayoutY(80);

        Button test = new Button("Switch");
        test.setOnAction((e) -> {
            Main.show(CreateCharacter.class);
        });

        test.setLayoutX(0);
        test.setLayoutY(5);

        rootMainMenu.getChildren().add(startNewGame);
        rootMainMenu.getChildren().add(savedGame);
        rootMainMenu.getChildren().add(test);
        stage.setScene(sceneMainMenu);
        stage.show();

        return sceneMainMenu;

    }

}
