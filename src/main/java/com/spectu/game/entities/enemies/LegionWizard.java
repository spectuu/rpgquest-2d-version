package com.spectu.game.entities.enemies;

import com.spectu.game.locations.Location;

import java.util.concurrent.ThreadLocalRandom;

public class LegionWizard extends Enemy{

    public LegionWizard() {
        super("Legion Wizard", 75, 75,40, "LegionWizard.gif");
    }

    @Override
    public void chanceEnemy(){
        int p = ThreadLocalRandom.current().nextInt(1, (1 + 100));
        if(p == 100){
            Location.enemy = new LegionWizard();
            System.out.println(Location.enemy);
        }
    }
}
