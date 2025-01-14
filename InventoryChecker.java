import java.util.ArrayList;
import java.util.List;

import greenfoot.*;

public class InventoryChecker {
    private ScannerClass inventory = new ScannerClass("Inventory.txt");
    private List<String> wordList;

    public InventoryChecker() {
        wordList = inventory.getWordList();
        System.out.println(wordList);
        EquipGear();
    }

    public void EquipGear() {
        if (wordList.contains("SwdT3")) {
            CombatManager.swordType=3;
        } else if(wordList.contains("SwdT2")){
            CombatManager.swordType=2;
        } else if(wordList.contains("SwdT1")){
            CombatManager.swordType=1;
        } else{
            CombatManager.swordType=0;
        }
        if (wordList.contains("ArmT3")) {
            CombatManager.armorType=3;
            CombatManager.playerHPMax=16;
            CombatManager.playerHP=16;
        } else if(wordList.contains("ArmT2")){
            CombatManager.armorType=2;
            CombatManager.playerHPMax=14;
            CombatManager.playerHP=14;
        } else if(wordList.contains("ArmT1")){
            CombatManager.armorType=1;
            CombatManager.playerHPMax=12;
            CombatManager.playerHP=12;
        } else{
            CombatManager.armorType=0;
        }
        System.out.println(CombatManager.swordType);
        System.out.println(CombatManager.armorType);
    }
}
