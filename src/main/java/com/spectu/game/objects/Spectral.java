package com.spectu.game.objects;

import com.spectu.game.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Spectral extends Object{

    public Spectral() { super("Spectral", 0); }

    public ImageView getImageSpectral(){
        Image image = Main.getImage("Spectral.png");
        ImageView imageSpectral = new ImageView(image);
        return imageSpectral;
    }
}
