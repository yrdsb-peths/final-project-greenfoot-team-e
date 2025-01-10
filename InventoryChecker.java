import java.util.ArrayList;
import java.util.List;

import greenfoot.*;

public class InventoryChecker {
    private ScannerClass inventory=new ScannerClass("Inventory.txt");
    private List<String> wordList;

    public InventoryChecker() {
        inventory = new ScannerClass("Inventory.txt");
        wordList = inventory.getWordList();
        System.out.println(wordList);
    }
}
