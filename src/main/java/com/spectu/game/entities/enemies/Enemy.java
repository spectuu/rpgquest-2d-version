package com.spectu.game.entities.enemies;

import com.spectu.game.Main;
import com.spectu.game.entities.Entity;
import com.spectu.game.scenes.CreateCharacter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.concurrent.ThreadLocalRandom;

public class Enemy extends Entity{

    public int damage;
    public String enemyImage;
    public int p;

    public Enemy(String name, int heal, int damage, String enemyImage) {
        super(name, heal);
        this.damage = damage;
        this.enemyImage = enemyImage;
    }

    public void attackPlayer(){
        CreateCharacter.player.heal -= damage;
    }

    public ImageView enemyImage(){

        Image image = Main.getImage(enemyImage);
        ImageView enemyImage = new ImageView(image);
        return enemyImage;
    }

    public void chanceEnemy(){
    p = ThreadLocalRandom.current().nextInt(1, (1 + 100));

    }
}
