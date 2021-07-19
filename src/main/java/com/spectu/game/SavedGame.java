package com.spectu.game;

import com.spectu.game.entities.Player;
import com.spectu.game.objects.Item;
import com.spectu.game.objects.weapons.DiabolicCode;
import com.spectu.game.objects.weapons.EnchantedIceSword;
import com.spectu.game.objects.weapons.GoldenSpear;
import com.spectu.game.scenes.CreateCharacter;
import com.spectu.game.scenes.GameMenu;
import com.spectu.game.scenes.Statistics;

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
            FileManagement.addInformation(fileName, "Durability Weapons:");
            FileManagement.addInformation(fileName, "Mythril Sword:" + CreateCharacter.player.inventory.getMythrilSword().durability);
            FileManagement.addInformation(fileName, "Spectral Hoz:" + CreateCharacter.player.inventory.getSpectralHoz().durability);
    }

    public static void savedGame(){
        String fileName = "savedGame.txt";

        Player player = new Player("PlayerName", "Fighter");

        boolean isReadingInventory = false;
        boolean isReadingWeaponsDurability = false;

        for(String line : FileManagement.readFile(fileName)){
            if(line.startsWith("Player Name:")){
                String playerName = line.replaceFirst("Player Name:", "");
                player.setName(playerName);
                continue;
            }
            if(line.startsWith("Player Heal:")){
                String playerHeal = line.replaceFirst("Player Heal:", "");
                int playerHealConverter = Integer.parseInt(playerHeal);
                player.setHeal(playerHealConverter);
                continue;
            }
            if(line.startsWith("Player Class:")){
                String playerClass = line.replaceFirst("Player Class:", "");
                player.setPlayerClass(playerClass);
                System.out.println(player.playerClass);
                continue;
            }
            if(line.startsWith("Inventory And Weapons:")){
                isReadingInventory = true;
                continue;
            }
            if(line.startsWith("Healing Potion:") && isReadingInventory){
                String healingPotionAmount = line.replaceFirst("Healing Potion:", "");
                int healingPotionAmountConverter = Integer.parseInt(healingPotionAmount);
                player.inventory.getHealingPotion().amount = healingPotionAmountConverter;
                continue;
            }
            if(line.startsWith("Escape Potion:")){
                String escapePotionAmount = line.replaceFirst("Escape Potion:", "");
                int escapePotionAmountConverter = Integer.parseInt(escapePotionAmount);
                player.inventory.getEscapePotion().amount = escapePotionAmountConverter;
                continue;
            }
            if(line.startsWith("Enchanted Knife:")){
                String enchantedKnifeAmount = line.replaceFirst("Enchanted Knife:", "");
                int enchantedKnifeAmountConverter = Integer.parseInt(enchantedKnifeAmount);
                player.inventory.getEnchantedKnife().amount = enchantedKnifeAmountConverter;
                continue;
            }
            if(line.startsWith("Mythril:")){
                String mythrilAmount = line.replaceFirst("Mythril:", "");
                int mythrilAmountConverter = Integer.parseInt(mythrilAmount);
                player.inventory.getMythril().amount = mythrilAmountConverter;
                continue;
            }
            if(line.startsWith("Spectral:")){
                String spectralAmount = line.replaceFirst("Spectral:", "");
                int spectralAmountConverter = Integer.parseInt(spectralAmount);
                player.inventory.getSpectral().amount = spectralAmountConverter;
                isReadingInventory = false;
                continue;
            }
            if(line.startsWith("Durability Weapons:")){
                isReadingWeaponsDurability = true;
                continue;
            }
            if(line.startsWith("Mythril Sword:") && isReadingWeaponsDurability){
                String mythrilSwordDurability = line.replaceFirst("Mythril Sword:", "");
                int mythrilSwordDurabilityConverter = Integer.parseInt(mythrilSwordDurability);
                player.inventory.getMythrilSword().amount = mythrilSwordDurabilityConverter;
                System.out.println(mythrilSwordDurabilityConverter);
                continue;
            }
            if(line.startsWith("Spectral Hoz:")){
                String spectralHozDurability = line.replaceFirst("Spectral Hoz:", "");
                int spectralHozDurabilityConverter = Integer.parseInt(spectralHozDurability);
                player.inventory.getSpectralHoz().amount = spectralHozDurabilityConverter;
                System.out.println(spectralHozDurabilityConverter);
                continue;
            }
            if(line.startsWith("Special Weapon:")){
               if(player.playerClass.equals("Fighter")){
                   player.specialWeapon = new GoldenSpear();
               }else if(player.playerClass.equals("Assassin")){
                   player.specialWeapon = new EnchantedIceSword();
               }else if(player.playerClass.equals("Wizard")){
                   player.specialWeapon = new DiabolicCode();
               }
                isReadingWeaponsDurability = false;
                continue;
            }
            CreateCharacter.player = player;
            Main.show(GameMenu.class);
        }
    }
}
