package com.spectu.game.entities.enemies;

import com.spectu.game.locations.Location;
import com.spectu.game.scenes.CreateCharacter;

import java.util.concurrent.ThreadLocalRandom;

public class DarkGhost extends Enemy{

    public DarkGhost() {
        super("Dark Ghost", 60, 60,45, "DarkGhost.gif");
    }

    public void curse(){
        if(CreateCharacter.player.heal < 15){
            CreateCharacter.player.heal = 0;
        }
    }

    @Override
    public void attackPlayer(){
        CreateCharacter.player.heal -= damage;
        curse();
    }

    @Override
    public void chanceEnemy(){
        int p = ThreadLocalRandom.current().nextInt(1, (1 + 100));
        if(p == 15){
            Location.enemy = new DarkGhost();
            System.out.println(Location.enemy.name);
        }
    }
}
