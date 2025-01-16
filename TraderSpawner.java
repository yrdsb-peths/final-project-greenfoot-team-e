import greenfoot.*;

public class TraderSpawner
 {
    private World world;
    private int roomWidth;
    private int roomHeight;
    private int xOffset;
    private int yOffset;
    private int tileWidth = 31;
    private int tileHeight = 32;
    //Trader Spawner
    public TraderSpawner(World world, int roomWidth, int roomHeight, int xOffset, int yOffset) {
        this.world = world;
        this.roomWidth = roomWidth;
        this.roomHeight = roomHeight;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void spawnTrader() {
        int spawnChance = 10; // 1 in 20 if chest present, 1 in 10 otherwise

        // Determine if the trader should spawn
        if (Greenfoot.getRandomNumber(100) < spawnChance) {
            boolean traderPlaced = false;

            while (!traderPlaced) {
                int traderX = Greenfoot.getRandomNumber(roomWidth);
                int traderY = Greenfoot.getRandomNumber(roomHeight);

                // Convert grid coordinates to world coordinates
                int worldX = xOffset + traderX * tileWidth;
                int worldY = yOffset + traderY * tileHeight;

                // Check for valid placement (no walls or chest in the same location)
                if (world.getObjectsAt(worldX, worldY, Wall.class).isEmpty() &&
                    world.getObjectsAt(worldX, worldY, TreasureChest.class).isEmpty()) {
                        if(GameStateManager.traderExists){
                            world.addObject(new Trader(), GameStateManager.traderX, GameStateManager.traderY);
                            traderPlaced = true;
                        }else{
                            world.addObject(new Trader(), worldX, worldY);
                            GameStateManager.traderX=worldX;
                            GameStateManager.traderY=worldY;
                            GameStateManager.traderExists=true;
                            traderPlaced = true;
                        }
                }
            }
        }
    }
}

