package com.spectu.game.entities.enemies;

import com.spectu.game.scenes.CreateCharacter;

public class DarkGhost extends Enemy{

    public DarkGhost() {
        super("Dark Ghost", 60, 45);
    }

    public void curse(){
        if(CreateCharacter.player.heal < 15){
            CreateCharacter.player.heal = 0;
        }
    }
}
