package com.spectu.game.entities.enemies;

import com.spectu.game.locations.Location;
import com.spectu.game.scenes.CreateCharacter;

import java.util.concurrent.ThreadLocalRandom;

public class CliffGolem extends Enemy{

    public CliffGolem() {
        super("Cliff Golem", 100, 15, "CliffGolem.png");
    }

    @Override
    public void chanceEnemy(){
        int p = 50;
        if(p == 50){
           Location.enemy = new CliffGolem();
            System.out.println(Location.enemy.name);
        }
    }
}
