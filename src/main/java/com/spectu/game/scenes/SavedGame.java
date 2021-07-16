package com.spectu.game.scenes;

import com.spectu.game.FileManagement;

public class SavedGame {

    public void saveGame(){
        String fileName = "savedGame.txt";
        FileManagement.createFile("SavedGame.txt");
        FileManagement.addInformation("SavedGame.txt", "Player Name:" + CreateCharacter.player.name);
        FileManagement.addInformation("SavedGame.txt", "Player Heal:" + CreateCharacter.player.heal);
        FileManagement.addInformation("SavedGame.txt", "Player Class:" + CreateCharacter.player.playerClass);
    }

    public void savedGame(){

    }

}
