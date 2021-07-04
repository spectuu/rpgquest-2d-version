package com.spectu.game.objects;

import com.spectu.game.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Inventory {

    public Object[] objects;

    public Inventory(Object... objects) {
        this.objects = objects;
    }

    public void showInventory() {
        for (int i = 0; i < objects.length; i++) {
            Object object = objects[i];
            if (object.amount > 0) {
                System.out.println("[" + object.amount + "] " + object.name);
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

    public Object getByName(String name) {
        for (Object object : objects) {
            if (object.name.equals(name) && object.amount > 0) {
                return object;
            }
        }
        return null;
    }
}
