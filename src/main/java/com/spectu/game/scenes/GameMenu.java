package com.spectu.game.scenes;

import com.spectu.game.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameMenu implements RPGScene {

    Scene sceneGameMenu;
    AnchorPane rootGameMenu;
    Button statistics;
    Button inventory;
    Button explore;
    Label title;

    @Override
    public Scene create(Stage stage) {

        title = new Label("Hello adventurer these are your actions select one to interact:");
        title.setFont(new Font(20));
        title.setLayoutX(20);
        title.setLayoutY(30);

        statistics = new Button("Show Statistics and Inventory.");
        statistics.setFont(new Font(15));
        statistics.setLayoutX(20);
        statistics.setLayoutY(80);
        statistics.setOnAction((e) -> {
            Main.show(Statistics.class);
        });


        rootGameMenu = new AnchorPane();
        sceneGameMenu = new Scene(rootGameMenu, 1024, 530);
        rootGameMenu.getChildren().add(title);
        rootGameMenu.getChildren().add(statistics);
        stage.setScene(sceneGameMenu);
        stage.show();

        return sceneGameMenu;
    }
}
