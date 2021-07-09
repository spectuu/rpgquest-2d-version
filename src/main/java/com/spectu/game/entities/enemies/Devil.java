package com.spectu.game.entities.enemies;

import com.spectu.game.locations.Location;

import java.util.concurrent.ThreadLocalRandom;

public class Devil extends Enemy{

    public Devil() {
        super("Devil", 50, 14, "Devil.png");
    }

    @Override
    public void chanceEnemy(){
        if(p == 70){
            Location.enemy = new Devil();
            System.out.println(Location.enemy.name);
        }
    }
}
