package com.spectu.game.entities;

import com.spectu.game.objects.*;

public class Player extends Entity {

    public Inventory inventory;
    public String playerClass;

    public Player(String name) {
        super(name, 50);

        this.inventory = new Inventory(
                new HealingPotion(), new EscapePotion(), new EnchantedKnife(), new Mythril(), new Spectral()
        );
    }


    public int getCurrentHeal() {

        return heal;

    }

    public String getPlayerName() {

        return name;

    }

    public String getPlayerClass() {

        return playerClass;

    }


}
