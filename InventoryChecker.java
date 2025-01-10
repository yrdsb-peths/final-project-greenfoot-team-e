import java.util.ArrayList;
import java.util.List;

import greenfoot.*;

public class InventoryChecker {
    private ScannerClass inventory = new ScannerClass("Inventory.txt");
    private List<String> wordList;

    public InventoryChecker() {
        wordList = inventory.getWordList();
        System.out.println(wordList);
    }

    public void EquipGear() {
        if (wordList.contains("SwdT1")) {
            CombatManager.swordType=1;
        } else {
            System.out.println("Does not have SwdT1");
        }
    }
}
