import java.util.ArrayList;
import java.util.List;

import greenfoot.*;

public class InventoryChecker {
    //automatically changes player's stats according to what they have in their inventory
    private ScannerClass inventory = new ScannerClass("Inventory.txt");
    private List<String> wordList;

    public InventoryChecker() {
        wordList = inventory.getWordList();
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
        } else if(wordList.contains("ArmT2")){
            CombatManager.armorType=2;
        } else if(wordList.contains("ArmT1")){
            CombatManager.armorType=1;
        } else{
            CombatManager.armorType=0;
        }
    }
}
