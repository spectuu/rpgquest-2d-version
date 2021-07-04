package com.spectu.game.objects;

import com.spectu.game.Main;
import com.spectu.game.scenes.CreateCharacter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class EnchantedKnife extends Object {

    public EnchantedKnife() {
        super("Enchanted Knife", 0);
    }

    public void sacrifice() {
        if (amount > 0) {
            CreateCharacter.playerHeal = CreateCharacter.playerHeal - 5;

        }else{

        }
    }

    public ImageView getImageEnchantedKnife(){
        Image image = Main.getImage("EnchantedKnife.png");
        ImageView imageEnchantedKnife = new ImageView(image);
        return imageEnchantedKnife;
    }

}