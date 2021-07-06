package com.spectu.game.objects.weapons;

import com.spectu.game.objects.Item;

public class Weapon extends Item {

    public int damage;

    public Weapon(String name, int amount, int damage,String imageItem) {
        super(name, amount, imageItem);
        this.damage = damage;
    }

    public void attackEnemy(){

    }
}
