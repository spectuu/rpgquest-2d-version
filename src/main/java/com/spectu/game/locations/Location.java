package com.spectu.game.locations;

import com.spectu.game.Main;
import com.spectu.game.entities.enemies.*;
import com.spectu.game.scenes.Battle;
import com.spectu.game.scenes.Booty;
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
        CliffGolem cliffGolem = new CliffGolem();
        VictoriousPaladin victoriousPaladin = new VictoriousPaladin();
        DarkGhost darkGhost = new DarkGhost();
        Devil devil = new Devil();
        ElementalWizard elementalWizard = new ElementalWizard();
        IncarnationOfTheDesert incarnationOfTheDesert = new IncarnationOfTheDesert();
        LegionArcher legionArcher = new LegionArcher();
        LegionCommander legionCommander = new LegionCommander();
        LegionWizard legionWizard = new LegionWizard();
        ShadowStalker shadowStalker = new ShadowStalker();
        darkGhost.chanceEnemy();
        devil.chanceEnemy();
        elementalWizard.chanceEnemy();
        incarnationOfTheDesert.chanceEnemy();
        legionArcher.chanceEnemy();
        legionCommander.chanceEnemy();
        legionWizard.chanceEnemy();
        shadowStalker.chanceEnemy();
        cliffGolem.chanceEnemy();
        victoriousPaladin.chanceEnemy();
        if(Location.enemy == null){
            Main.show(Booty.class);
        }else{
            Main.show(Battle.class);
        }
    }

    public ImageView iconLocation(){
        Image image = Main.getImage(iconLocation);
        iconLocationImageView = new ImageView(image);
        return iconLocationImageView;
    }
}

