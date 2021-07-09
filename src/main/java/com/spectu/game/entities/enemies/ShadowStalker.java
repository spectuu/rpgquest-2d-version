package com.spectu.game.entities.enemies;

import com.spectu.game.scenes.CreateCharacter;

import java.util.concurrent.ThreadLocalRandom;

public class ShadowStalker extends Enemy{

    public ShadowStalker() {
        super("Shadow Stalker", 300, 35, "ShadowStalker.png");
    }

    public void ShadowHook(){
        int p = ThreadLocalRandom.current().nextInt(1, (1 + 100));
        if(p == 13){
            int ShadowChest;
            ShadowChest = CreateCharacter.player.inventory.getEscapePotion().amount;
            CreateCharacter.player.inventory.getEscapePotion().amount = 0;
        }
    }

    @Override
    public void chanceEnemy(){

    }
}
