package com.spectu.game.entities.enemies;

import com.spectu.game.locations.Location;
import com.spectu.game.scenes.CreateCharacter;

import java.util.concurrent.ThreadLocalRandom;

public class ElementalWizard extends Enemy{

    public ElementalWizard() {
        super("Elemental Wizard", 200, 35, "ElementalWizard.png");
    }

    public void ElementOfFire(){
        int p = ThreadLocalRandom.current().nextInt(1, (1 + 100));
        if(p == 20){
            CreateCharacter.player.heal -= 15;
        }
    }

    public void ElementOfWater(){
        int p = ThreadLocalRandom.current().nextInt(1, (1 + 100));
        if(p == 15){
            heal += 13;
        }
    }

    public void ElementOfShadow(){
        int p = ThreadLocalRandom.current().nextInt(1, (1 + 100));
        if(p == 5){
            damage += 5;
        }
    }

    @Override
    public void attackPlayer(){
        CreateCharacter.player.heal -= damage;
        ElementOfFire();
        ElementOfWater();
        ElementOfShadow();
    }

    @Override
    public void chanceEnemy(){
        if(p == 5){
            Location.enemy = new ElementalWizard();
            System.out.println(Location.enemy.name);
        }
    }
}
