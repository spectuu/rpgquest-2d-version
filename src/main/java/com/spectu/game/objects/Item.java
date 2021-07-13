package com.spectu.game.objects;

import com.spectu.game.Main;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

import java.util.concurrent.ThreadLocalRandom;

public class Item {

    public String name;
    public int amount;
    public int amountMax;
    public String imageItem;
    public ImageView imageViewItem;

    public Item(String name, int amount, int amountMax, String imageItem) {
        this.name = name;
        this.amount = amount;
        this.amountMax = amountMax;
        this.imageItem = imageItem;
    }

    public void onClick() {
        if(amount < 0){
            amount = 0;
        }
    }

    public Label booty(){
        int p = ThreadLocalRandom.current().nextInt((1 + 1) + (1 + 15));

        amount += p;
        if(amount > 50){
            amount = 50;
        }
        Label label = new Label(name + " Obtained: " + p);
        label.setFont(new Font(15));
        return label;
    }

    public ImageView imageItem(){
     Image image = Main.getImage(imageItem);
     imageViewItem = new ImageView(image);
        return imageViewItem;
    }
}