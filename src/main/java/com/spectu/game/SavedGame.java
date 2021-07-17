package com.spectu.game;

import com.spectu.game.FileManagement;
import com.spectu.game.objects.Item;
import com.spectu.game.scenes.CreateCharacter;

import java.io.File;

public class SavedGame {

    public static void saveGame(){
        String fileName = "savedGame.txt";
        FileManagement.createFile(fileName);
        FileManagement.addInformation(fileName, "Player Name:" + CreateCharacter.player.name);
        FileManagement.addInformation(fileName, "Player Heal:" + CreateCharacter.player.heal);
        FileManagement.addInformation(fileName, "Player Class:" + CreateCharacter.player.playerClass);

        FileManagement.addInformation(fileName, "Inventory And Weapons:");
        for(int i = 0; i < CreateCharacter.player.inventory.items.length; i++){
            Item item = CreateCharacter.player.inventory.items[i];
            FileManagement.addInformation(fileName, item.name + ":" + item.amount);
        }
    }

    public static void savedGame(){

    }

}
