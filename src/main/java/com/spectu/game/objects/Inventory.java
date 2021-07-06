package com.spectu.game.objects;

import com.spectu.game.scenes.Statistics;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;


public class Inventory {

    public Item[] items;

    public Inventory(Item...items) {
        this.items = items;
    }
    public void showInventory() {
        int e = 70;
        int a = 50;
        for (int i = 0; i < items.length; i++) {
                Item item = items[i];

                if (item.amount > 0) {

                    ImageView itemsImageView = item.imageItem();
                    itemsImageView.setLayoutX(e);
                    itemsImageView.setLayoutY(400);

                    Label itemsNameAndAmount = new Label(item.name + " x" + item.amount);
                    itemsNameAndAmount.setFont(new Font(15));
                    itemsNameAndAmount.setLayoutX(a);
                    itemsNameAndAmount.setLayoutY(460);
                    e += 170;
                    a += 170;

                    Statistics.rootStatistics.getChildren().addAll(itemsImageView, itemsNameAndAmount);
                }
        }
    }
    public HealingPotion getHealingPotion() {
        return (HealingPotion) getByName("Healing Potion");
    }

    public EscapePotion getEscapePotion() {
        return (EscapePotion) getByName("Escape Potion");
    }

    public EnchantedKnife getEnchantedKnife() { return (EnchantedKnife) getByName("Enchanted Knife"); }

    public Mythril getMythril(){
        return (Mythril) getByName("Mythril");
    }

    public Spectral getSpectral(){
        return (Spectral) getByName("Spectral");
    }

    public Item getByName(String name) {
        for (Item item : items) {
            if (item.name.equals(name)) {
                return item;
            }
        }
        return null;
    }
}
