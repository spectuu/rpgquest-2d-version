package com.spectu.game.objects;

import com.spectu.game.objects.weapons.SpectralHoz;
import com.spectu.game.scenes.Battle;
import com.spectu.game.scenes.CreateCharacter;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Spectral extends Item {

    public Spectral() {
        super("Spectral", 2, 50, "Spectral.png");
    }

    @Override
    public void onClick () {
        if(CreateCharacter.player.inventory.sceneChecker == Battle.sceneBattle){
            Label label3 = CreateCharacter.player.inventory.getLabel(this);
            label3.setVisible(false);
            ImageView imageView3 = CreateCharacter.player.inventory.getImageView(this);
            imageView3.setVisible(false);
        }
        if(amount > 0) {
        imageViewItem.setOnMouseClicked((e) -> {
                CreateCharacter.player.inventory.getSpectralHoz().durability += 15;
                if(CreateCharacter.player.inventory.getSpectralHoz().durability > 100){
                    CreateCharacter.player.inventory.getSpectralHoz().durability = 100;
                }else {
                    amount -= 1;
                }
                Label label = CreateCharacter.player.inventory.getLabel(this);
                label.setText(this.name + " " + this.amount + "/50");
                Label label2 = CreateCharacter.player.inventory.getLabel(CreateCharacter.player.inventory.getSpectralHoz());
                label2.setText(CreateCharacter.player.inventory.getSpectralHoz().name + "\n Damage: " +CreateCharacter.player.inventory.getSpectralHoz().damage + "\n Durability: " + CreateCharacter.player.inventory.getSpectralHoz().durability);
             });
        }
    }
}