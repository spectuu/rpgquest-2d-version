package com.spectu.game.entities;
import com.spectu.game.Main;
import com.spectu.game.categories.Assassin;
import com.spectu.game.categories.Fighter;
import com.spectu.game.categories.Wizard;
import com.spectu.game.locations.Location;
import com.spectu.game.objects.*;
import com.spectu.game.objects.weapons.*;
import com.spectu.game.scenes.Booty;
import com.spectu.game.scenes.CreateCharacter;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.concurrent.ThreadLocalRandom;

public class Player extends Entity {

    public Inventory inventory;
    public String playerClass;
    public ImageView playerImageView;
    public Item specialWeapon;

    public Player(String name, String playerClass) {
        super(name, 100);
        this.playerClass = playerClass;
        this.inventory = new Inventory(new HealingPotion(), new EscapePotion(), new EnchantedKnife(), new SpectralHoz(), new MythrilSword(), specialWeapon(), new Mythril(), new Spectral());
    }

    public void setPlayerClass(String playerClass){
        this.playerClass = playerClass;
    }

    public ImageView getPlayerCharacter(){
        if(playerClass.equals("Fighter")){
            playerImageView = CreateCharacter.fighterClass.characterImageView;
            return playerImageView;
        }else if(playerClass.equals("Assassin")){
            playerImageView = CreateCharacter.assassinClass.characterImageView;
            return playerImageView;
        }else if(playerClass.equals("Wizard")){
            playerImageView = CreateCharacter.wizardClass.characterImageView;
            return playerImageView;
        }
        throw new RuntimeException("the character class could not be determined");
    }

    public void abilityCharacter(){
        if(playerClass.equals("Fighter")){
            int p = ThreadLocalRandom.current().nextInt(1, (1 + 50));
            if(p == 25){
                Location.enemy.heal -= 35;
            }else if(p == 15){
                heal += 10;
            }
        }else if(playerClass.equals("Assassin")){
            if(Location.enemy.heal <= 15){
                Location.enemy.heal = 0;
                Main.show(Booty.class);
            }
        }else if(playerClass.equals("Wizard")){
            int p = ThreadLocalRandom.current().nextInt(1, (1 + 70));
            if(p == 60){
                CreateCharacter.player.inventory.getHealingPotion().amount += 2;
                if(CreateCharacter.player.inventory.getHealingPotion().amount > 0){
                  ImageView imageView = CreateCharacter.player.inventory.getImageView(CreateCharacter.player.inventory.getHealingPotion());
                    imageView.setVisible(true);
                  Label label = CreateCharacter.player.inventory.getLabel(CreateCharacter.player.inventory.getHealingPotion());
                  label.setText(CreateCharacter.player.inventory.getHealingPotion().name + " " + CreateCharacter.player.inventory.getHealingPotion().amount + "/50");
                }
                CreateCharacter.player.inventory.getEscapePotion().amount += 1;
                if(CreateCharacter.player.inventory.getEscapePotion().amount > 0){
                    ImageView imageView = CreateCharacter.player.inventory.getImageView(CreateCharacter.player.inventory.getEscapePotion());
                    imageView.setVisible(true);
                    Label label = CreateCharacter.player.inventory.getLabel(CreateCharacter.player.inventory.getEscapePotion());
                    label.setText(CreateCharacter.player.inventory.getEscapePotion().name + " " + CreateCharacter.player.inventory.getEscapePotion().amount + "/50");
                }
            }
            CreateCharacter.player.inventory.getHealingPotion().onClick();
            CreateCharacter.player.inventory.getEscapePotion().onClick();
        }
    }


    public Item specialWeapon(){
        if(this.playerClass.equals("Fighter")){
            return new GoldenSpear();
        }else if(this.playerClass.equals("Assassin")){
            return new EnchantedIceSword();
        }else if(this.playerClass.equals("Wizard")){
            return new DiabolicCode();
        }
        throw new RuntimeException("The weapon cant be determinate.");
    }
}
