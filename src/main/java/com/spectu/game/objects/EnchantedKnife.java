package com.spectu.game.objects;

import com.spectu.game.scenes.CreateCharacter;

public class EnchantedKnife extends Item {

    public EnchantedKnife() {
        super("Enchanted Knife", 50, "EnchantedKnife.png");
    }

    public void sacrifice() {
        if (amount > 0) {
            CreateCharacter.player.heal = CreateCharacter.player.heal - 5;

        }else{

        }
    }
}