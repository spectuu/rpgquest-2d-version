package com.spectu.game.categories;

import com.spectu.game.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;

public class Assassin {

    public static ImageView imageAssassin() {

        Image assassin = Main.getImage("Assassin.png");
        ImageView assassinImageView = new ImageView(assassin);

        return assassinImageView;
    }

    public static ImageView imageWeaponAssassin() {

        Image weapon = Main.getImage("SpecialWeaponAssassin.png");
        ImageView weaponImageView = new ImageView(weapon);

        return weaponImageView;
    }

}
