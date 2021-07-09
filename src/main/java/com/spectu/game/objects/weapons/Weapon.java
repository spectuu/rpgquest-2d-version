package com.spectu.game.objects.weapons;

import com.spectu.game.objects.Item;

public class Weapon extends Item {

    public int damage;
    public int durability;

    public Weapon(String name, int amount, int damage, int durability ,String imageItem, int amountMax) {
        super(name, amount, amountMax ,imageItem);
        this.damage = damage;
        this.durability = durability;
    }

    public void attackEnemy(){

    }

    public void weaponLabelInventory(){

    }
}
