package com.spectu.game;

import com.spectu.game.scenes.*;
import com.sun.corba.se.spi.orbutil.threadpool.WorkQueue;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        scenes.put(Statistics.class.getSimpleName(), new Statistics());
        scenes.put(World.class.getSimpleName(), new World());
        scenes.put(Battle.class.getSimpleName(), new Battle());
        scenes.put(Booty.class.getSimpleName(), new Booty());

        show(MainMenu.class);

    }

    public static Image getImage(String name) {
        try {
            return new Image(new FileInputStream("./images/" + name));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
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
