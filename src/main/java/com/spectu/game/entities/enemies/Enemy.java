package com.spectu.game.entities.enemies;

import com.spectu.game.entities.Entity;
import com.spectu.game.scenes.CreateCharacter;

public class Enemy extends Entity{

    public int damage;

    public Enemy(String name, int heal, int damage) {
        super(name, heal);
        this.damage = damage;
    }

    public void attackPlayer(){
        CreateCharacter.player.heal -= damage;
    }
}
