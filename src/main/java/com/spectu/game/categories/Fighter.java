package com.spectu.game.categories;

import com.spectu.game.Main;
import com.spectu.game.scenes.CreateCharacter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Fighter {

    public static ImageView imageFighter(){

       Image fighter = Main.getImage("Fighter.png");
       ImageView fighterImageView = new ImageView(fighter);


       return fighterImageView;
    }

    public static ImageView imageWeaponFighter(){

        Image weapon = Main.getImage("SpecialWeaponFighter.png");
        ImageView weaponImageView = new ImageView(weapon);

        return weaponImageView;
    }

}
