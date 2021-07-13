package com.spectu.game.categories;

import com.spectu.game.Main;
import com.spectu.game.scenes.CreateCharacter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.concurrent.ThreadLocalRandom;


public class Category {

    public String characterImage;
    public String weaponImage;
    public ImageView characterImageView;
    public ImageView weaponImageView;

    public Category(String characterImage, String weaponImage){
        this.characterImage = characterImage;
        this.weaponImage = weaponImage;
    }

    public ImageView getCharacterImage(){
        Image image = Main.getImage(characterImage);
        characterImageView = new ImageView(image);
        return characterImageView;
    }

    public ImageView getWeaponImage(){
        Image image = Main.getImage(weaponImage);
        weaponImageView = new ImageView(image);
        return weaponImageView;
    }
}
