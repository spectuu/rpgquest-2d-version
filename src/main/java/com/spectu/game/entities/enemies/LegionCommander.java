package com.spectu.game.entities.enemies;

public class LegionCommander extends Enemy{

    public LegionCommander() {
        super("Legion Commander", 250, 32);
    }

    public void LastBreath(){
        if(heal < 35){
            damage += 12;
        }
    }
}
