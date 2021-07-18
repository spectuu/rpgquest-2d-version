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
    public static Weapon specialWeapon;

    public Player(String name, String playerClass) {
        super(name, 100);
        this.playerClass = playerClass;
        this.inventory = new Inventory(new HealingPotion(), new EscapePotion(), new EnchantedKnife(), new SpectralHoz(), new MythrilSword(), specialWeapon(), new Mythril(), new Spectral());
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setHeal(int heal){
       super.heal = heal;
    }

    public ImageView getPlayerCharacterImageView(){
        if(playerClass.equals("Fighter")){
            ImageView imageView = new ImageView(Main.getImage("Fighter.png"));
            return imageView;
        }else if(playerClass.equals("Assassin")){
            ImageView imageView = new ImageView(Main.getImage("Assassin.png"));
            return imageView;
        }else if(playerClass.equals("Wizard")){
            ImageView imageView = new ImageView(Main.getImage("Wizard.png"));
            return imageView;
        }
        throw new RuntimeException("the character class could not be determined");
    }

    public ImageView getPlayerCharacterSpecialWeaponImageView(){
        if(playerClass.equals("Fighter")){
            ImageView imageView = new ImageView(Main.getImage("SpecialWeaponFighter.png"));
            return imageView;
        }else if(playerClass.equals("Assassin")){
            ImageView imageView = new ImageView(Main.getImage("SpecialWeaponAssassin.png"));
            return imageView;
        }else if(playerClass.equals("Wizard")){
            ImageView imageView = new ImageView(Main.getImage("SpecialWeaponWizard.png"));
            return imageView;
        }
        throw new RuntimeException("the character Special Weapon Image View could not be determined");
    }

    public String getPlayerCharacterAbilityDescription(){
        if(playerClass.equals("Fighter")) {
            return "Ability: \n The Fighter has a 25% chance to Deal 35 additional damage and has a 15% change to recovery of 10 heal.";
        }else if(playerClass.equals("Assassin")) {
            return "Ability: \n the assassin executes the enemy if he is at 15 health or less.";
        }if(playerClass.equals("Wizard")) {
            return "The wizard has a 60% chance to add 2 health potions and 1 escape potion.";
        }
        throw new RuntimeException("the character ability could not be determined");
    }

    public String getPlayerCharacterSpecialWeaponDescription(){
        if(playerClass.equals("Fighter")) {
            return "Weapon: \n Golden spear: \n Base Damage: 25.";
        }else if(playerClass.equals("Assassin")) {
            return "Weapon: \n Enchanted Ice Sword: \n Base Damage: 40.";
        }if(playerClass.equals("Wizard")) {
            return "Weapon: \n Diabolical code: \n Base Damage: 60.";
        }
        throw new RuntimeException("the character special Weapon could not be determined");
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

    public Weapon specialWeapon(){
        if(this.playerClass.equals("Fighter")){
            specialWeapon = new GoldenSpear();
            return specialWeapon;
        }else if(this.playerClass.equals("Assassin")){
            specialWeapon = new EnchantedIceSword();
            return specialWeapon;
        }else if(this.playerClass.equals("Wizard")){
            specialWeapon = new DiabolicCode();
            return specialWeapon;
        }
        throw new RuntimeException("The weapon cant be determinate.");
    }
}
