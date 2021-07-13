package com.spectu.game.objects;

import com.spectu.game.scenes.Battle;
import com.spectu.game.scenes.CreateCharacter;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Mythril extends Item {

    public Mythril() { super("Mythril", 10, 50,"Mythril.png"); }

    @Override
    public void onClick(){
        if(CreateCharacter.player.inventory.sceneChecker == Battle.sceneBattle){
            Label label3 = CreateCharacter.player.inventory.getLabel(this);
            label3.setVisible(false);
            ImageView imageView3 = CreateCharacter.player.inventory.getImageView(this);
            imageView3.setVisible(false);
        }
        if(amount > 0) {
            imageViewItem.setOnMouseClicked((e) -> {
                CreateCharacter.player.inventory.getMythrilSword().durability += 15;
                if(CreateCharacter.player.inventory.getMythrilSword().durability > 100){
                    CreateCharacter.player.inventory.getMythrilSword().durability = 100;
                }else {
                    amount -= 1;
                }
                Label label = CreateCharacter.player.inventory.getLabel(this);
                label.setText(this.name + " " + this.amount + "/50");
                Label label2 = CreateCharacter.player.inventory.getLabel(CreateCharacter.player.inventory.getMythrilSword());
                label2.setText(CreateCharacter.player.inventory.getMythrilSword().name + "\n Damage: " +CreateCharacter.player.inventory.getMythrilSword().damage + "\n Durability: " + CreateCharacter.player.inventory.getMythrilSword().durability);
            });
        }
    }
}
