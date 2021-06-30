package com.spectu.game;

import com.spectu.game.scenes.CreateCharacter;
import com.spectu.game.scenes.GameMenu;
import com.spectu.game.scenes.MainMenu;
import com.spectu.game.scenes.RPGScene;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main extends Application {

    public static Map<String, RPGScene> scenes = new HashMap<>();

    public static Stage mainStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        mainStage = primaryStage;

        scenes.put(MainMenu.class.getSimpleName(), new MainMenu());
        scenes.put(CreateCharacter.class.getSimpleName(), new CreateCharacter());
        scenes.put(GameMenu.class.getSimpleName(), new GameMenu());

        show(MainMenu.class);

    }

    public static void show(RPGScene rpgScene) {
        rpgScene.create(mainStage);
    }

    public static void show(Class<? extends RPGScene> clazz) {
        Optional<RPGScene> sceneOptional = Optional.of(scenes.get(clazz.getSimpleName()));
        if (sceneOptional.isPresent())
            show(sceneOptional.get());
    }
}
