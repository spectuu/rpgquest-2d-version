package com.spectu.game.objects;

import com.spectu.game.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Item {

    public String name;
    public int amount;
    public String imageItem;

    public Item(String name, int amount, String imageItem) {
        this.name = name;
        this.amount = amount;
        this.imageItem = imageItem;
    }

    public void onClick() {

    }

    public void itemAttack(){

    }

    public ImageView imageItem(){
     Image image = Main.getImage(imageItem);
     ImageView imageViewItem = new ImageView(image);
        return imageViewItem;
    }
}