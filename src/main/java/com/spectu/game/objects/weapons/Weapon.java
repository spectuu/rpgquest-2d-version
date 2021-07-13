package com.spectu.game.objects.weapons;

import com.spectu.game.Main;
import com.spectu.game.locations.Location;
import com.spectu.game.objects.Item;
import com.spectu.game.scenes.Battle;
import com.spectu.game.scenes.Booty;
import com.spectu.game.scenes.CreateCharacter;
import com.spectu.game.scenes.DeathScene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Weapon extends Item {

    public int damage;
    public int durability;

    public Weapon(String name, int amount, int damage, int durability ,String imageItem, int amountMax) {
        super(name, amount, amountMax ,imageItem);
        this.damage = damage;
        this.durability = durability;
    }

    public void attackEnemy(){
        imageViewItem.setOnMouseClicked((e) -> {
            if(durability <= 0){
                durability = 0;
                Location.enemy.heal -= 0;
                Battle.enemyHeal.setText(Location.enemy.name + " " + Location.enemy.heal + "/" + Location.enemy.healMax);
                Location.enemy.attackPlayer();
                Battle.playerHeal.setText(CreateCharacter.player.name + " " + CreateCharacter.player.heal + "/100");

                if(CreateCharacter.player.heal <= 0){
                    CreateCharacter.player.heal = 0;
                    Main.show(DeathScene.class);

                }
            }
            if(durability > 0){
                Location.enemy.heal -= damage;
                durability -= 15;
                CreateCharacter.player.abilityCharacter();
                CreateCharacter.player.inventory.getMythrilSword().weaponLabelInventory();
                CreateCharacter.player.inventory.getSpectralHoz().weaponLabelInventory();
                Battle.enemyHeal.setText(Location.enemy.name + " " + Location.enemy.heal + "/" + Location.enemy.healMax);
                Location.enemy.attackPlayer();
                Battle.playerHeal.setText(CreateCharacter.player.name + " " + CreateCharacter.player.heal + "/100");

                if(CreateCharacter.player.heal <= 0){
                    CreateCharacter.player.heal = 0;
                    Main.show(DeathScene.class);

                }else if(Location.enemy.heal <= 0){
                    Location.enemy.heal = 0;
                    Main.show(Booty.class);
                }
            }
        });
    }

    public void weaponLabelInventory(){
        if(durability < 0){
            durability = 0;
        }
        Label label = CreateCharacter.player.inventory.getLabel(this);
        label.setText(this.name + "\n Damage: " + this.damage + "\n Durability: " + this.durability);
    }

    public void hideLabelAndImage(){
        Label label = CreateCharacter.player.inventory.getLabel(this);
        label.setVisible(false);

        ImageView imageView = CreateCharacter.player.inventory.getImageView(this);
        imageView.setVisible(false);
    }
}
