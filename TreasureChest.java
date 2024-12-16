import greenfoot.*;

import java.util.List;
import java.util.Random;

public class TreasureChest extends Actor 
{
    private static final int TILE_WIDTH = 31;  
    private static final int TILE_HEIGHT = 32;
    private int randomNum; 
    private boolean isLooted = false;
    public void act() {
        loot(Player.class);
    }
    public TreasureChest()
    {
        randomNum = Greenfoot.getRandomNumber(100);
        if(randomNum >= 40 && randomNum <= 60)
        {
            setImage("images/ChestCoC.png");
        }
        else if(randomNum >= 1 && randomNum <= 11)
        {
            setImage("images/ChestRaC.png");
        }
        else if(randomNum == 20 || randomNum == 24)
        {
            setImage("images/ChestLeC.png");
        }
        else
        {
            setImage((GreenfootImage)null);
        }
    }

    public static void spawnIn(World world, String[][] grid, int xOffset, int yOffset) 
    {
        Random random = new Random();
        int gridWidth = grid[0].length;
        int gridHeight = grid.length;

        boolean chestPlaced = false;

        while (!chestPlaced) 
        {
            int x = random.nextInt(gridWidth); 
            int y = random.nextInt(gridHeight);

            
            if (!"Wall".equals(grid[y][x]))
            {
                
                grid[y][x] = "Chest";


                int pixelX = xOffset + x * TILE_WIDTH;
                int pixelY = yOffset + y * TILE_HEIGHT;

                world.addObject(new TreasureChest(), pixelX, pixelY);

                chestPlaced = true;
            }
        }
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
                isLooted = true; // Mark as looted
            }
        }
    }

}

