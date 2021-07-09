package com.spectu.game.entities;
import com.spectu.game.Main;
import com.spectu.game.categories.Assassin;
import com.spectu.game.categories.Fighter;
import com.spectu.game.categories.Wizard;
import com.spectu.game.objects.*;
import com.spectu.game.objects.weapons.MythrilSword;
import com.spectu.game.objects.weapons.SpectralHoz;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends Entity {

    public Inventory inventory;
    public String playerClass;
    public Fighter fighter = new Fighter();
    public Assassin assassin = new Assassin();
    public Wizard wizard = new Wizard();
    public ImageView playerImageView;

    public Player(String name) {
        super(name, 50);
        this.inventory = new Inventory(new HealingPotion(), new EscapePotion(), new EnchantedKnife(), new SpectralHoz(), new MythrilSword(), new Mythril(), new Spectral());
    }

    public ImageView getPlayerCharacter(){
        if(playerClass.equals("Fighter")){
            playerImageView = fighter.characterImageView;
            return playerImageView;
        }else if(playerClass.equals("Assassin")){
            playerImageView = assassin.characterImageView;
            return playerImageView;
        }else if(playerClass.equals("Wizard")){
            playerImageView = wizard.characterImageView;
            return playerImageView;
        }
        throw new RuntimeException("the character class could not be determined");
    }
}
