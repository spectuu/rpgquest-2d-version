package com.spectu.game.entities.enemies;

import com.spectu.game.locations.Location;
import com.spectu.game.scenes.CreateCharacter;

import java.util.concurrent.ThreadLocalRandom;

public class LegionCommander extends Enemy{

    public LegionCommander() {
        super("Legion Commander", 250, 250,32, "LegionCommander.png");
    }

    public void LastBreath(){
        if(heal < 35){
            damage += 12;
        }
    }

    @Override
    public void attackPlayer(){
        CreateCharacter.player.heal -= damage;
        LastBreath();
    }

    @Override
    public void chanceEnemy(){
        int p = ThreadLocalRandom.current().nextInt(1, (1 + 100));
        if(p == 13){
            Location.enemy = new LegionCommander();
            System.out.println(Location.enemy);
        }
    }
}
