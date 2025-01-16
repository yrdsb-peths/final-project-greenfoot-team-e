import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import greenfoot.*;
public class CombatScreen extends World {
    GreenfootSound hitSound = new GreenfootSound("hitSound.wav");
    GreenfootSound combatMusic = new GreenfootSound("combatMusic.wav");
    private boolean defeated=true;
    private List<Heart> hearts = new ArrayList<>();
    private List<Heart> enemyHearts = new ArrayList<>();
    private static final Random random = new Random();
    InventoryChecker checkInventory=new InventoryChecker();
    Label combatText;
    Label enemyText=new Label(" ", 20);
    public CombatScreen(){  
        super(400,600,1);
<<<<<<< HEAD
        setBackground("background.png");
=======
        setBackground("Background.png");
        combatMusic.playLoop();
>>>>>>> origin/add-music
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
            case 3:
                CombatManager.currentEnemyHP=CombatManager.deathKnightHP;
                CombatManager.currentEnemyMaxHP=CombatManager.deathKnightHP;
                CombatManager.currentEnemySPD=CombatManager.deathKnightSPD;
                CombatManager.currentEnemyATK=CombatManager.deathKnightATK;
                CombatManager.currentEnemyACC=CombatManager.deathKnightACC;
                
        }
        switch (GameStateManager.currentEnemy){
            case 0:
                combatText=new Label("a Skeleton has appeared!", 20);
                break;
            case 1:
                combatText=new Label("a Slime has appeared!", 20);
                break;
            case 2:
                combatText=new Label("a Zombie has appeared!", 20);
                break;
            case 3:
                combatText=new Label("Valerius the Death knight challenges you", 20);
                break;
        }
        EnemyCombatSprite enemy=new EnemyCombatSprite();
        addObject(combatText, 125, 425);
        addObject(enemyText, 125, 450);
        addObject(enemy,200,300);
        addObject(new Button(this::attack, "Attack-button.png",150, 100), 100, 500);
        addObject(new Button(this::healthPotion, "heatlth-button.png",  150, 100), 300, 500  );
        initializeHearts();
        initializeEnemyHearts();
    }
    public void endSequences(){
        if(CombatManager.currentEnemyHP<=0){
            combatText.setValue("You defeated the enemy!");
            GameStateManager.totalEnemiesKilled++;
            loot();
            for (Button btn : getObjects(Button.class)) {
                removeObject(btn);
            }
            addObject(new Button(this::returnToGameScreen, "Continue.png",  150, 100), 100, 500);
        }
    }
    public void returnToGameScreen(){
        Greenfoot.setWorld(new GameScreen());
    }
    public void attack(){
        int playerACC = Greenfoot.getRandomNumber(99);
        int enemyACC = Greenfoot.getRandomNumber(99);
        if(playerACC<CombatManager.playerACC){
            CombatManager.currentEnemyHP-=CombatManager.playerATK+CombatManager.swordType;
            int totalDamage=CombatManager.playerATK+CombatManager.swordType;
<<<<<<< HEAD
            combatText.setValue("You dealt "+totalDamage+" damage");
=======
            hitSound.play();
            System.out.println("You dealt "+totalDamage+" damage");
>>>>>>> origin/add-music
        }else{
            combatText.setValue("You missed!");
        }
        endSequences();
        if(!(CombatManager.currentEnemyHP<=0)){
            if(enemyACC<CombatManager.currentEnemyACC){
                CombatManager.playerHP-=Math.max(CombatManager.currentEnemyATK-CombatManager.armorType, 1);
                int totalDamage=Math.max(CombatManager.currentEnemyATK-CombatManager.armorType, 1);
                    enemyText.setValue("The enemy dealt "+totalDamage+" damage");
            }else{
                enemyText.setValue("Enemy missed!");
            }
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

    private void healthPotion() 
    {
        if(CombatManager.playerHealthPot > 0)
        {
            CombatManager.playerHP += 5;
            initializeHearts();
            CombatManager.playerHealthPot-=1;
        }
        else 
        {
            combatText.setValue("you have no health potions");
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
                        CombatManager.playerHealthPot+=1;
                        lootAdded = true;
                    }
                }
    
                if (lootItem != null) {
                    enemyText.setValue("Player looted: " + lootItem);
                }
            }
        }
    }

}

