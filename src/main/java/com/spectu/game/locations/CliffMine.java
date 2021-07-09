package com.spectu.game.locations;

import com.spectu.game.Main;
import com.spectu.game.entities.enemies.CliffGolem;
import com.spectu.game.entities.enemies.VictoriousPaladin;
import com.spectu.game.scenes.Battle;
import com.spectu.game.scenes.Booty;

public class CliffMine extends Location{

    public CliffMine() {
        super("Cliff Mine", "Low", "IconMine.png");
    }

    @Override
    public void toExplore(){
        CliffGolem cliffGolem = new CliffGolem();
        cliffGolem.chanceEnemy();
        VictoriousPaladin victoriousPaladin = new VictoriousPaladin();
        victoriousPaladin.chanceEnemy();
        if(Location.enemy == null){
            Main.show(Booty.class);
        }else{
            Main.show(Battle.class);
        }
    }

}
