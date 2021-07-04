package com.spectu.game.objects;

import com.spectu.game.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Mythril extends Object{

    public Mythril() { super("Mythril", 0); }

    public ImageView getImageMythril(){
        Image image = Main.getImage("Mythril.png");
        ImageView imageMythril = new ImageView(image);
        return imageMythril;
    }
}
