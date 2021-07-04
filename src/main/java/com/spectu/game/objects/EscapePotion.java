package com.spectu.game.objects;

import com.spectu.game.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EscapePotion extends Object {

    public EscapePotion() { super("Escape Potion", 0); }

    public ImageView getImageEscapePotion(){
        Image image = Main.getImage("EscapePotion.png");
        ImageView imageEscapePotion = new ImageView(image);
        return imageEscapePotion;
    }
}