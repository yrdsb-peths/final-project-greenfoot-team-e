import greenfoot.*;

public class FogOfWar 
{
    private Actor[][] fogGrid;
    private int gridWidth, gridHeight;
    private int xOffset, yOffset;
    private int tileWidth = 31; 
    private int tileHeight = 32; 

    public FogOfWar(String[][] grid, int xOffset, int yOffset) 
    {
        this.gridWidth = grid.length;
        this.gridHeight = grid[0].length;
        this.xOffset = xOffset;
        this.yOffset = yOffset;

        fogGrid = new Actor[gridWidth][gridHeight];
    }

    public void initializeFog(World world) 
    {
        for (int x = 0; x < gridWidth; x++) 
        {
            for (int y = 0; y < gridHeight; y++) 
            {
                Actor fog = new Actor() 
                {
                    { setImage("images/FOW-Tile.png"); }
                };
                world.addObject(fog, xOffset + x * tileWidth, yOffset + y * tileHeight);
                fogGrid[x][y] = fog;
            }
        }
    }

    public void updateFog(int playerX, int playerY) {
        int gridX = (playerX - xOffset) / tileWidth;
        int gridY = (playerY - yOffset) / tileHeight;

        for (int x = Math.max(0, gridX - 2); x <= Math.min(gridWidth - 1, gridX + 2); x++) {
            for (int y = Math.max(0, gridY - 2); y <= Math.min(gridHeight - 1, gridY + 2); y++) {
                if (fogGrid[x][y] != null) {
                    World world = fogGrid[x][y].getWorld();
                    if (world != null) {
                        world.removeObject(fogGrid[x][y]);
                        fogGrid[x][y] = null;
                    }
                }
            }
        }
    }
}
