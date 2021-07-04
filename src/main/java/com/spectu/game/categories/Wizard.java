package com.spectu.game.categories;

import com.spectu.game.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Wizard {

    public static ImageView imageWizard() {

        Image wizard = Main.getImage("Wizard.png");
        ImageView wizardImageView = new ImageView(wizard);

        return wizardImageView;

    }

    public static ImageView imageWeaponWizard() {

        Image weapon = Main.getImage("SpecialWeaponWizard.png");
        ImageView weaponImageView = new ImageView(weapon);

        return weaponImageView;
    }


}
