package com.spectu.game.objects;

import com.spectu.game.Main;
import com.spectu.game.scenes.CreateCharacter;
import com.spectu.game.scenes.Statistics;

public class HealingPotion extends Item {

    public HealingPotion() { super("Healing Potion", 5, "HealingPotion.png"); }

    public void heal() {
        if (amount > 0) {
            CreateCharacter.player.heal = CreateCharacter.player.heal + 20;
            if (CreateCharacter.player.heal > 100) {
                CreateCharacter.player.heal = 100;
            } else {
                amount = amount - 1;
            }
        }
        Statistics.playerHeal.setText("Player heal: " + CreateCharacter.player.heal + "/100");
    }

    @Override
    public void onClick() {
        imageViewItem.setOnMouseClicked((e) -> {
            heal();
        });
    }
}
