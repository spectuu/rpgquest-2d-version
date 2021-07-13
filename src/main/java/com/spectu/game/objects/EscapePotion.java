package com.spectu.game.objects;

import com.spectu.game.Main;
import com.spectu.game.scenes.CreateCharacter;
import com.spectu.game.scenes.GameMenu;
import javafx.scene.control.Label;


public class EscapePotion extends Item {

    public EscapePotion() {
        super("Escape Potion", 2, 50, "EscapePotion.png");
    }

    @Override
    public void onClick(){
        if(amount > 0){
        imageViewItem.setOnMouseClicked((e) -> {
                Main.show(GameMenu.class);
                amount -= 1;
                Label label = CreateCharacter.player.inventory.getLabel(this);
                label.setText(this.name + " " + this.amount + "/50");
            });
        }
    }
}