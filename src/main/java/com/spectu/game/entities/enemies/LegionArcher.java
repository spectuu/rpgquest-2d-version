package com.spectu.game.entities.enemies;

import com.spectu.game.locations.Location;

import java.util.concurrent.ThreadLocalRandom;

public class LegionArcher extends Enemy{

    public LegionArcher() {
        super("Legion Archer", 50, 50,25, "LegionArcher.png");
    }

    @Override
    public void chanceEnemy(){
        int p = ThreadLocalRandom.current().nextInt(1,  (1 + 100));
        if(p == 45){
            Location.enemy = new LegionArcher();
            System.out.println(Location.enemy);
        }
    }
}
