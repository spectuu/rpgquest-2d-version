package com.spectu.game.objects.weapons;

import com.spectu.game.scenes.CreateCharacter;
import javafx.scene.control.Label;

public class SpectralHoz extends Weapon{

    public SpectralHoz() {
        super("Spectral Hoz", 1, 50, 100,"BasicHoz.png", 1);
    }

    @Override
    public void weaponLabelInventory(){
        Label label = CreateCharacter.player.inventory.getLabel(this);
        label.setText(this.name);
    }
}
