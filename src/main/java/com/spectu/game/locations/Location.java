package com.spectu.game.locations;

import com.spectu.game.Main;
import com.spectu.game.entities.enemies.Enemy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Location {

    public String name;
    public String danger;
    public String iconLocation;
    ImageView iconLocationImageView;
    public static Enemy enemy;

    public Location(String name, String danger, String iconLocation){
        this.name = name;
        this.danger = danger;
        this.iconLocation = iconLocation;
    }

    public void toExplore(){

    }

    public ImageView iconLocation(){
        Image image = Main.getImage(iconLocation);
        iconLocationImageView = new ImageView(image);
        return iconLocationImageView;
    }
}

