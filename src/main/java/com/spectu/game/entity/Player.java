package com.spectu.game.entity;

public class Player extends Entity{

    public String playerClass;
    public int healMax = 100;

    public Player(String name) {
        super(name, 100);
    }

    public int getCurrentHeal(){

        return heal;

    }

    public String getPlayerName(){

        return name;

    }

    public String getPlayerClass(){

        return playerClass;

    }



}
