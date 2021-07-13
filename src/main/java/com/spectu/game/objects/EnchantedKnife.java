package com.spectu.game.objects;

import com.spectu.game.Main;
import com.spectu.game.locations.Location;
import com.spectu.game.scenes.Battle;
import com.spectu.game.scenes.Booty;
import com.spectu.game.scenes.CreateCharacter;
import com.spectu.game.scenes.DeathScene;
import javafx.scene.control.Label;

public class EnchantedKnife extends Item {

    public EnchantedKnife() {
        super("Enchanted Knife", 50, 50,"EnchantedKnife.png");
    }

    public void sacrifice() {
        if (amount > 0) {
            CreateCharacter.player.heal -= 5;
            Location.enemy.heal -= 10;
            amount -= 1;
        }
    }

    @Override
    public void onClick(){
        if (amount > 0) {
            imageViewItem.setOnMouseClicked((e) -> {
            sacrifice();
            Label label = CreateCharacter.player.inventory.getLabel(this);
            label.setText(this.name + " " + this.amount + "/50");
            Battle.playerHeal.setText(CreateCharacter.player.name + " " + CreateCharacter.player.heal + "/100");
            Battle.enemyHeal.setText(Location.enemy.name + " " + Location.enemy.heal + "/" + Location.enemy.healMax);

            if(CreateCharacter.player.heal <= 0){
                    CreateCharacter.player.heal = 0;
                    Main.show(DeathScene.class);

                }else if(Location.enemy.heal <= 0){
                    Location.enemy.heal = 0;
                    Main.show(Booty.class);
                }
          });
        }
    }
}