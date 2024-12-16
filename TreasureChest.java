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
        randomNum = Greenfoot.getRandomNumber(100);
        if (randomNum >= 1 && randomNum <= 60) {
            setImage("images/ChestCoC.png");
        } else if (randomNum >= 61 && randomNum <= 90) {
            setImage("images/ChestLeC.png");
        } else if (randomNum == 6 || randomNum == 24) {
            setImage("images/ChestRaC.png");
        } else {
            world.removeObject(this); 
        }
    }


    public static boolean spawnIn(World world, String[][] grid, int xOffset, int yOffset) 
    {
        Random random = new Random();
        int gridWidth = grid[0].length;
        int gridHeight = grid.length;
        int maxChests = 1; 
        int placedChests = 0;

        while (placedChests < maxChests) {
            int x = random.nextInt(gridWidth);
            int y = random.nextInt(gridHeight);

            if (!"Wall".equals(grid[y][x]) && !"Chest".equals(grid[y][x])) {
                grid[y][x] = "Chest"; 

                int pixelX = xOffset + x * TILE_WIDTH;
                int pixelY = yOffset + y * TILE_HEIGHT;

                world.addObject(new TreasureChest(world), pixelX, pixelY);

                placedChests++;
                return true; 
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


