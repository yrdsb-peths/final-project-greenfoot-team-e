import greenfoot.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
public class TreasureChest extends Actor {
    private static final int TILE_WIDTH = 31;  
    private static final int TILE_HEIGHT = 32;
    public static int randomNum; 
    private boolean isLooted = false;
    InventoryChecker checkInventory=new InventoryChecker();
    public void act() {
        loot(Player.class);

    }
    public TreasureChest(World world)
    {   
        //sets the treasure chest type
        if(!GameStateManager.chestLooted){
            if(GameStateManager.treasureTypeClosed==null){
            randomNum = Greenfoot.getRandomNumber(50);
            if (randomNum == 21 || randomNum == 24) {
                setImage("images/ChestLeC.png");
                GameStateManager.treasureTypeClosed="images/ChestLeC.png";
                GameStateManager.treasureTypeOpen="images/ChestLeO.png";
            } else if (randomNum >= 30 && randomNum <= 40) {
                setImage("images/ChestRaC.png");
                GameStateManager.treasureTypeClosed="images/ChestRaC.png";
                GameStateManager.treasureTypeOpen="images/ChestRaO.png";
            } else if (randomNum >= 0 && randomNum <= 50) {
                setImage("images/ChestCoC.png");
                GameStateManager.treasureTypeClosed="images/ChestCoC.png";
                GameStateManager.treasureTypeOpen="images/ChestCoO.png";
            } 
            }else{
                setImage(GameStateManager.treasureTypeClosed);
            }
        }else{
            setImage(GameStateManager.treasureTypeOpen);
        }
    }
    //spawns in treasure chest
    public static boolean spawnIn(World world, String[][] grid, int xOffset, int yOffset) 
    {
        Random random = new Random();
        int gridWidth = grid[0].length;
        int gridHeight = grid.length;

        if (random.nextInt(100) < 50) { 
        }

        for (int i = 0; i < 10; i++) { 
            int x = random.nextInt(gridWidth);
            int y = random.nextInt(gridHeight);

            if (!"Wall".equals(grid[y][x]) && !"Chest".equals(grid[y][x])) {
                grid[y][x] = "Chest"; 

                int pixelX = xOffset + x * TILE_WIDTH;
                int pixelY = yOffset + y * TILE_HEIGHT;

                TreasureChest chest = new TreasureChest(world);


                if (chest.getImage() != null) { 
                    if(GameStateManager.treasureExists){
                        world.addObject(chest, GameStateManager.treasureChestX, GameStateManager.treasureChestY);
                        return true;
                    }else{
                        world.addObject(chest, pixelX, pixelY);
                        GameStateManager.treasureChestX=pixelX;
                        GameStateManager.treasureChestY=pixelY;
                        GameStateManager.treasureExists=true;
                        return true; 
                    }
                }
            }
        }
        return false; 
    }


    //Loot for treasure chest
    public void loot(Class<?> Player) {
        Random random = new Random();
        ScannerClass inventory = new ScannerClass("Inventory.txt");
        ScannerClass items = new ScannerClass("Items.txt");
        ScannerClass itemsHealth = new ScannerClass("ItemsHealthPots.txt");
    
        if (!GameStateManager.chestLooted && this.isTouching(Player)) {
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
                    GameScreen.text.setValue("Player looted: " + lootItem);
                    setImage(GameStateManager.treasureTypeOpen);
                    GameStateManager.chestLooted = true;
                    isLooted = true;
                }
            }
        }
    }
    
    
}




