package com.spectu.game.objects;

import com.spectu.game.scenes.Battle;
import com.spectu.game.scenes.CreateCharacter;
import com.spectu.game.scenes.Statistics;
import javafx.scene.control.Label;

public class HealingPotion extends Item {

    public HealingPotion() { super("Healing Potion", 0, 50,"HealingPotion.png"); }

    public void heal() {
        if (amount > 0) {
            CreateCharacter.player.heal = CreateCharacter.player.heal + 20;
            if (CreateCharacter.player.heal > 100) {
                CreateCharacter.player.heal = 100;
            } else {
                amount -= 1;
            }
            if(CreateCharacter.player.inventory.sceneChecker == Statistics.sceneStatistics){
                Statistics.playerHeal.setText("Player heal: " + CreateCharacter.player.heal + "/100");
            }else if(CreateCharacter.player.inventory.sceneChecker == Battle.sceneBattle){
                Battle.playerHeal.setText(CreateCharacter.player.name + " " + CreateCharacter.player.heal + "/100");
            }
        }
    }

    @Override
    public void onClick() {
        if(amount > 0) {
            imageViewItem.setOnMouseClicked((e) -> {
                heal();
                Label label = CreateCharacter.player.inventory.getLabel(this);
                label.setText(this.name + " " + this.amount + "/50");
            });
        }
    }
    //x
}
