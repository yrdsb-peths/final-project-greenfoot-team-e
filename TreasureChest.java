import greenfoot.*;

import java.util.List;
import java.util.Random;

public class TreasureChest extends Actor {
    private static final int TILE_WIDTH = 31;  
    private static final int TILE_HEIGHT = 32;
    public static int randomNum; 
    private boolean isLooted = false;
    public void act() {
        loot(Player.class);
    }
    public TreasureChest(World world)
    {   
        if(GameStateManager.treasureType==null){
        randomNum = Greenfoot.getRandomNumber(50);
        if (randomNum == 21 || randomNum == 24) {
            setImage("images/ChestLeC.png");
            GameStateManager.treasureType="images/ChestLeC.png";
        } else if (randomNum >= 30 && randomNum <= 40) {
            setImage("images/ChestRaC.png");
            GameStateManager.treasureType="images/ChestRaC.png";
        } else if (randomNum >= 0 && randomNum <= 50) {
            setImage("images/ChestCoC.png");
            GameStateManager.treasureType="images/ChestCoC.png";
        } 
    }else{
        setImage(GameStateManager.treasureType);
    }
}

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
                    world.addObject(chest, pixelX, pixelY);
                    return true; 
                }
            }
        }
        return false; 
    }



    public void loot(Class<?> Player) {

        Random random = new Random();
        ScannerClass inventory = new ScannerClass("Inventory.txt");
        ScannerClass items = new ScannerClass("Items.txt");

        if (!isLooted&&this.isTouching(Player)) {
            List<String> itemList = items.getWordList();
            if (!itemList.isEmpty()) {
                int lootGen = random.nextInt(itemList.size());
                String lootItem = itemList.get(lootGen);
                inventory.addWord(lootItem);
                System.out.println("Player looted: " + lootItem);
                isLooted = true; 
            }
        }
    }
}




