package com.spectu.game.objects;

import com.spectu.game.objects.weapons.*;
import com.spectu.game.scenes.Battle;
import com.spectu.game.scenes.CreateCharacter;
import com.spectu.game.scenes.Statistics;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;


public class Inventory {

    public Item[] items;
    public Weapon[] weapons;
    public Label itemsNameAndAmount;
    public ImageView itemsImageView;
    public Scene sceneChecker;

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
                    itemsImageView = item.imageItem();

                    itemsNameAndAmount = new Label(item.name + " " + item.amount + "/50");

                    if(sceneChecker == Statistics.sceneStatistics){

                        itemsImageView.setLayoutX(e);
                        itemsImageView.setLayoutY(400);

                        itemsNameAndAmount.setFont(new Font(15));
                        itemsNameAndAmount.setLayoutX(a);
                        itemsNameAndAmount.setLayoutY(460);

                        e += 170;
                        a += 170;
                        Statistics.rootStatistics.getChildren().addAll(itemsImageView, itemsNameAndAmount);

                    }else if(sceneChecker == Battle.sceneBattle){

                        itemsImageView.setLayoutX(e);
                        itemsImageView.setLayoutY(400);

                        itemsNameAndAmount.setFont(new Font(15));
                        itemsNameAndAmount.setTextFill(Color.web("#ff2200"));
                        itemsNameAndAmount.setStyle("-fx-font-weight: bold");
                        itemsNameAndAmount.setLayoutX(a);
                        itemsNameAndAmount.setLayoutY(450);

                        e += 170;
                        a += 170;
                        Battle.rootBattle.getChildren().addAll(itemsImageView, itemsNameAndAmount);
                    }
                    Pair<ImageView, Label> pair = new Pair<>(itemsImageView, itemsNameAndAmount);
                    map.put(item, pair);
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

    public GoldenSpear getGoldenSpear(){
        return (GoldenSpear) getByName("Golden Spear");
    }

    public EnchantedIceSword getEnchantedIceSword(){
        return (EnchantedIceSword) getByName("Enchanted Ice Sword");
    }

    public DiabolicCode getDiabolicCode(){
        return (DiabolicCode) getByName("Diabolic Code");
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
