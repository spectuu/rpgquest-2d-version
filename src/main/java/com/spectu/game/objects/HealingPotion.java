package com.spectu.game.objects;

import com.spectu.game.Main;
import com.spectu.game.scenes.CreateCharacter;
import com.spectu.game.scenes.Statistics;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HealingPotion extends Item {

    public HealingPotion() { super("Healing Potion", 5, "HealingPotion.png"); }

    public void heal() {
        if (amount > 0) {
            CreateCharacter.playerHeal = CreateCharacter.playerHeal + 20;
            if (CreateCharacter.playerHeal > 100) {
                CreateCharacter.playerHeal = 100;
            } else {
                amount = amount - 1;
            }
        }
        Statistics.playerHeal.setText("Player heal: " + CreateCharacter.playerHeal + "/100");
    }

    @Override
    public void onClick() {

    }

    public ImageView getImageHealingPotion(){
        Image image = Main.getImage("HealingPotion.png");
        ImageView imageHealingPotion = new ImageView(image);
        return imageHealingPotion;
    }

}
