package com.spectu.game.entities.enemies;

import com.spectu.game.locations.Location;

import java.util.concurrent.ThreadLocalRandom;

public class Devil extends Enemy{

    public Devil() {
        super("Devil", 50, 50,14, "Devil.gif");
    }

    @Override
    public void chanceEnemy(){
        int p = ThreadLocalRandom.current().nextInt(1,  (1 + 100));
        if(p == 70){
            Location.enemy = new Devil();
            System.out.println(Location.enemy.name);
        }
    }
}
