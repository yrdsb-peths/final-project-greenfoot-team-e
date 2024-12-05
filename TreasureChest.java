import greenfoot.*; 
import java.util.Random;

public class TreasureChest extends Actor {
    private static final int TILE_WIDTH = 31;  
    private static final int TILE_HEIGHT = 32;

    public TreasureChest() {
        int randomNum = Greenfoot.getRandomNumber(100);
        if (randomNum >= 40 && randomNum <= 60) 
        {
            setImage("images/ChestCoC.png");
        } 
        else if (randomNum >= 1 && randomNum <= 11) 
        {
            setImage("images/ChestRaC.png");
        } 
        else if (randomNum == 20 || randomNum == 24)
        {
            setImage("images/ChestLeC.png");
        } 
        else 
        {
            setImage((GreenfootImage)null);
        }
    }

    public static boolean spawnIn(World world, String[][] grid, int xOffset, int yOffset) 
    {
        Random random = new Random();
        int gridWidth = grid[0].length;
        int gridHeight = grid.length;

        if (random.nextInt(2) == 0) 
        {
            for (int i = 0; i < 10; i++) 
            {
                int x = random.nextInt(gridWidth);
                int y = random.nextInt(gridHeight);

                
                if (!"Wall".equals(grid[y][x]) && !"Chest".equals(grid[y][x])) {
                    grid[y][x] = "Chest"; 

                    int pixelX = xOffset + x * TILE_WIDTH;
                    int pixelY = yOffset + y * TILE_HEIGHT;

                    world.addObject(new TreasureChest(), pixelX, pixelY);
                    return true; 
                }
            }
        }

        return false;
    }
}


