package com.spectu.game.objects;

import com.spectu.game.objects.weapons.MythrilSword;
import com.spectu.game.objects.weapons.SpectralHoz;
import com.spectu.game.scenes.Statistics;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;


public class Inventory {

    public Item[] items;
    public Label itemsNameAndAmount;
    public ImageView itemsImageView;

    public Map<Item, Pair<ImageView, Label>> map;

    Item item;

    public Inventory(Item...items) {
        this.items = items;
        this.map = new HashMap<>();
    }

    public void showInventory() {
        int e = 70;
        int a = 50;
        for (int i = 0; i < items.length; i++) {
                item = items[i];
                if (item.amount > 0) {

                    itemsImageView = item.imageItem();
                    itemsImageView.setLayoutX(e);
                    itemsImageView.setLayoutY(400);

                    itemsNameAndAmount = new Label(item.name + " " + item.amount + "/50");
                    itemsNameAndAmount.setFont(new Font(15));
                    itemsNameAndAmount.setLayoutX(a);
                    itemsNameAndAmount.setLayoutY(460);


                    e += 170;
                    a += 170;
                    Statistics.rootStatistics.getChildren().addAll(itemsImageView, itemsNameAndAmount);

                    Pair<ImageView, Label> pair = new Pair<>(itemsImageView, itemsNameAndAmount);
                    map.put(item, pair);

                }
        }
    }

    public Label getLabel(Item itemToFind) {
        Pair<ImageView, Label> pair = getPair(itemToFind);
        return pair.getValue();
    }

    public ImageView getImageView(Item itemToFind) {
        Pair<ImageView, Label> pair = getPair(itemToFind);
        return pair.getKey();
    }

    public Pair<ImageView, Label> getPair(Item itemToFind) {
        for(Item item : map.keySet()) {
            if(item.name == itemToFind.name) {
                return map.get(item);
            }
        }
        throw new RuntimeException("The item cannot be found");
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

    public MythrilSword getMythrilSword(){
        return (MythrilSword) getByName("Mythril Sword");
    }

    public SpectralHoz getSpectralHoz(){
        return (SpectralHoz) getByName("Spectral Hoz");
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
