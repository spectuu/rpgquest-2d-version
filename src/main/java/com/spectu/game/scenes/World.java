package com.spectu.game.scenes;

import com.spectu.game.Main;
import com.spectu.game.locations.CliffMine;
import com.spectu.game.locations.Dungeon;
import com.spectu.game.locations.Location;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class World implements RPGScene{

    public static String locationBooty;

   public static CliffMine cliffMine;
   public static Dungeon dungeon;

    AnchorPane rootWorld;
    Scene sceneWorld;

    Button back;

    Label cliffMineName;
    Label dungeonName;

    Image map;
    ImageView mapImageView;
    ImageView iconCliffMine;
    ImageView iconDungeon;

    @Override
    public Scene create(Stage stage) {

        cliffMine = new CliffMine();
        dungeon = new Dungeon();

        iconCliffMine = cliffMine.iconLocation();
        iconCliffMine.setLayoutX(800);
        iconCliffMine.setLayoutY(400);
        iconCliffMine.setFitWidth(65);
        iconCliffMine.setFitHeight(50);
        iconCliffMine.setOnMouseClicked((e) -> {
            locationBooty = "Cliff Mine";
            cliffMine.toExplore();
        });

        cliffMineName = new Label(cliffMine.name + "\n" + "Danger: " + cliffMine.danger);
        cliffMineName.setFont(new Font(15));
        cliffMineName.setTextFill(Color.web("#ff2200"));
        cliffMineName.setStyle("-fx-font-weight: bold");
        cliffMineName.setLayoutX(800);
        cliffMineName.setLayoutY(360);

        iconDungeon= dungeon.iconLocation();
        iconDungeon.setLayoutX(200);
        iconDungeon.setLayoutY(100);
        iconDungeon.setFitWidth(75);
        iconDungeon.setFitHeight(50);
        iconDungeon.setOnMouseClicked((e) -> {
            locationBooty = "Dungeon";
            dungeon.toExplore();
        });

        dungeonName = new Label(dungeon.name + "\n" + "Danger: " + dungeon.danger);
        dungeonName.setFont(new Font(15));
        dungeonName.setTextFill(Color.web("#ff2200"));
        dungeonName.setStyle("-fx-font-weight: bold");
        dungeonName.setLayoutX(200);
        dungeonName.setLayoutY(60);

        map = Main.getImage("map.jpg");
        mapImageView = new ImageView(map);
        mapImageView.setLayoutX(0);
        mapImageView.setLayoutY(0);
        mapImageView.setFitWidth(1024);
        mapImageView.setFitHeight(530);

        back = new Button("Back");
        back.setFont(new Font(15));
        back.setLayoutX(20);
        back.setLayoutY(490);
        back.setOnAction((e) -> {
          Main.show(GameMenu.class);
        });

        rootWorld = new AnchorPane();
        sceneWorld = new Scene(rootWorld, 1024, 530);

        rootWorld.getChildren().add(mapImageView);
        rootWorld.getChildren().add(iconCliffMine);
        rootWorld.getChildren().add(cliffMineName);
        rootWorld.getChildren().add(dungeonName);
        rootWorld.getChildren().add(iconDungeon);
        rootWorld.getChildren().add(back);

        stage.setScene(sceneWorld);
        return sceneWorld;
    }
}
