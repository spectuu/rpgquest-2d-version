package com.spectu.game.entities.enemies;

import com.spectu.game.scenes.CreateCharacter;

import java.util.concurrent.ThreadLocalRandom;

public class IncarnationOfTheDesert extends Enemy{

    public IncarnationOfTheDesert() {
        super("Incarnation of the desert", 170, 30, "IncarnationOfTheDesert.png");
    }

    public void Sandstorm(){
        int p = ThreadLocalRandom.current().nextInt(1, (1 + 100));
        if(p == 15){
            CreateCharacter.player.heal -= 13;
        }
    }

    @Override
    public void chanceEnemy(){

    }
}
