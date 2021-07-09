package com.spectu.game.objects.weapons;

import com.spectu.game.scenes.CreateCharacter;
import javafx.scene.control.Label;

public class MythrilSword extends Weapon{

    public MythrilSword() {
        super("Mythril Sword", 1, 35, 100,"BasicSword.png", 1);
    }

    @Override
    public void weaponLabelInventory(){
        Label label = CreateCharacter.player.inventory.getLabel(this);
        label.setText(this.name);
    }

}
