import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import greenfoot.*;
public class CombatScreen extends World {
    private boolean defeated=true;
    private List<Heart> hearts = new ArrayList<>();
    private List<Heart> enemyHearts = new ArrayList<>();
    private static final Random random = new Random();
    InventoryChecker checkInventory=new InventoryChecker();
    public CombatScreen(){   
        super(400,600,1);
        setBackground("background.png");
        switch (GameStateManager.currentEnemy) {
            case 0:
                CombatManager.currentEnemyHP=CombatManager.skeletonHP;
                CombatManager.currentEnemyMaxHP=CombatManager.skeletonHP;
                CombatManager.currentEnemySPD=CombatManager.skeletonSPD;
                CombatManager.currentEnemyATK=CombatManager.skeletonATK;
                CombatManager.currentEnemyACC=CombatManager.skeletonACC;
                break;
            case 1:
                CombatManager.currentEnemyHP=CombatManager.slimeHP;
                CombatManager.currentEnemyMaxHP=CombatManager.slimeHP;
                CombatManager.currentEnemySPD=CombatManager.slimeSPD;
                CombatManager.currentEnemyATK=CombatManager.slimeATK;
                CombatManager.currentEnemyACC=CombatManager.slimeACC;
                break;
            case 2:
            default:
                CombatManager.currentEnemyHP=CombatManager.zombieHP;
                CombatManager.currentEnemyMaxHP=CombatManager.zombieHP;
                CombatManager.currentEnemySPD=CombatManager.zombieSPD;
                CombatManager.currentEnemyATK=CombatManager.zombieATK;
                CombatManager.currentEnemyACC=CombatManager.zombieACC;
                break;
                
        }

        EnemyCombatSprite enemy=new EnemyCombatSprite();
        addObject(enemy,200,300);
        addObject(new Button(this::attack, "Attack-button.png",150, 100), 100, 500);
        initializeHearts();
        initializeEnemyHearts();
    }
    public void returnGameScreen(){
        if(CombatManager.currentEnemyHP<=0){
            System.out.println("You defeated the enemy!");
            loot();
            Greenfoot.setWorld(new GameScreen());
        }
    }
    public void attack(){
        int playerACC = Greenfoot.getRandomNumber(99);
        int enemyACC = Greenfoot.getRandomNumber(99);
        if(playerACC<CombatManager.playerACC){
            CombatManager.currentEnemyHP-=CombatManager.playerATK+CombatManager.swordType;
            int totalDamage=CombatManager.playerATK+CombatManager.swordType;
            System.out.println("You dealt "+totalDamage+" damage");
        }else{
            System.out.println("You missed!");
        }
        returnGameScreen();
        if(!(CombatManager.currentEnemyHP<=0)&&enemyACC<CombatManager.currentEnemyACC){
            CombatManager.playerHP-=Math.max(CombatManager.currentEnemyATK-CombatManager.armorType, 0);
            int totalDamage=CombatManager.currentEnemyATK-CombatManager.armorType;
            if(totalDamage<=0){
                System.out.println("Your armor negates all damage");
            }else{
                System.out.println("The enemy dealt "+CombatManager.currentEnemyATK+" damage");
            }
        }else{
            System.out.println("Enemy missed!");
        }
        if(CombatManager.playerHP<=0){
            handleGameOver();
        }
        initializeHearts();
        initializeEnemyHearts();
    }
    private void initializeEnemyHearts() {
        enemyHearts.clear();
        int heartsCount = (int) Math.ceil(CombatManager.currentEnemyMaxHP / 2.0); // Total hearts needed
        for (int i = 0; i < heartsCount; i++) {
            Heart heart = new Heart();
            if (i < CombatManager.currentEnemyHP / 2) {
                heart.setFull(); // Full heart
            } else if (i == CombatManager.currentEnemyHP / 2 && CombatManager.currentEnemyHP % 2 != 0) {
                heart.setHalf(); // Half heart
            } else {
                heart.setEmpty(); // Empty heart
            }
            enemyHearts.add(heart);
            addObject(heart, 375 - (i * 20), 200); // Adjust positions as needed
        }
    }
    private void initializeHearts() {
        int heartsCount = (int) Math.ceil(CombatManager.playerHPMax / 2.0); // Total hearts needed
        for (int i = 0; i < heartsCount; i++) {
            Heart heart = new Heart();
            if (i < CombatManager.playerHP / 2) {
                heart.setFull(); // Full heart
            } else if (i == CombatManager.playerHP / 2 && CombatManager.playerHP % 2 != 0) {
                heart.setHalf(); // Half heart
            } else {
                heart.setEmpty(); // Empty heart
            }
            hearts.add(heart);
            addObject(heart, 375 - (i * 20), 420); // Adjust positions as needed
        }
    }
    private void handleGameOver() {
        System.out.println("Game Over!");
        Greenfoot.stop(); // Stop the game
    }
    public void loot() {
        Random random = new Random();
        ScannerClass inventory = new ScannerClass("Inventory.txt");
        ScannerClass items = new ScannerClass("Items.txt");
        ScannerClass itemsHealth = new ScannerClass("ItemsHealthPots.txt");
    
        if (defeated) {
            List<String> itemList = items.getWordList();
            List<String> itemHealthList = itemsHealth.getWordList();
            List<String> inventoryList = inventory.getWordList();
    
            if (!itemList.isEmpty() || !itemHealthList.isEmpty()) {
                String lootItem = null;
                boolean lootAdded = false;
    
                while (!lootAdded) {
                    int listType = random.nextInt(2);
                    if (listType == 0 && !itemList.isEmpty()) {
                        List<String> availableItems = itemList.stream()
                            .filter(item -> !inventoryList.contains(item))
                            .toList();
    
                        if (!availableItems.isEmpty()) {
                            int lootGen = random.nextInt(availableItems.size());
                            lootItem = availableItems.get(lootGen);
                            inventory.addWord(lootItem);
                            lootAdded = true;
                        } else {
                            itemList.clear(); // Prevent unnecessary retries
                        }
                    } else if (listType == 1 && !itemHealthList.isEmpty()) {
                        int lootGen = random.nextInt(itemHealthList.size());
                        lootItem = itemHealthList.get(lootGen);
                        inventory.addWord(lootItem);
                        lootAdded = true;
                    }
                }
    
                if (lootItem != null) {
                    System.out.println("Player looted: " + lootItem);
                }
            }
        }
    }

}

