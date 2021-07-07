package com.spectu.game.entities;

public class Entity {

    public String name;
    public int heal;

    public Entity(String name, int heal) {

        this.name = name;
        this.heal = heal;

    }

    public void setName(String name) {

        this.name = name;

    }

}
