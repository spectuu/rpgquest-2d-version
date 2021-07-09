package com.spectu.game.entities.enemies;

import com.spectu.game.locations.Location;

import java.util.concurrent.ThreadLocalRandom;

public class VictoriousPaladin extends Enemy{

    public VictoriousPaladin() {
        super("Victorious Paladin", 120, 23, "VictoriousPaladin.png");
    }

    @Override
    public void chanceEnemy(){
        if(p == 24) {
            Location.enemy = new VictoriousPaladin();
            System.out.println(Location.enemy.name);
        }
    }
}
