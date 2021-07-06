package com.spectu.game.entities;
import com.spectu.game.objects.*;
import com.spectu.game.objects.weapons.MythrilSword;
import com.spectu.game.objects.weapons.SpectralHoz;

public class Player extends Entity {

    public Inventory inventory;
    public String playerClass;

    public Player(String name) {
        super(name, 50);

        this.inventory = new Inventory(
                new HealingPotion(), new EscapePotion(), new EnchantedKnife(), new Mythril(), new Spectral(), new SpectralHoz(), new MythrilSword());
    }
}
