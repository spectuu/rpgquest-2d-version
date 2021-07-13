package com.spectu.game.entities.enemies;

import com.spectu.game.locations.Location;
import com.spectu.game.scenes.CreateCharacter;
import javafx.scene.control.Label;

import java.util.concurrent.ThreadLocalRandom;

public class ShadowStalker extends Enemy{

    public ShadowStalker() {
        super("Shadow Stalker", 300, 300,35, "ShadowStalker.png");
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
    public void attackPlayer(){
        CreateCharacter.player.heal -= damage;
        ShadowHook();
        Label label = CreateCharacter.player.inventory.getLabel(CreateCharacter.player.inventory.getEscapePotion());
        label.setText(CreateCharacter.player.inventory.getEscapePotion().name + " " + CreateCharacter.player.inventory.getEscapePotion().amount + "/50");
    }

    @Override
    public void chanceEnemy(){
        p = ThreadLocalRandom.current().nextInt(1, (1 + 100));
        if(p == 1){
            Location.enemy = new ShadowStalker();
            System.out.println(Location.enemy);
        }
    }
}
