import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.World;

public class CombatScreen extends World 
{
    private static final int TILE_WIDTH = 31;
    private static final int TILE_HEIGHT = 32;
    private static final int ROOM_WIDTH = 5; // 5 tiles wide
    private static final int ROOM_HEIGHT = 7; // 7 tiles tall

    private int gridWidth;
    private int gridHeight;
    private String[][] grid;
    private Enemy enemy;
    private String enemyType;
    
        public CombatScreen(String enemyType, String[][] originalGrid) {
            super(400, 600, 1); // Set world dimensions
            this.enemyType = enemyType; // Store the enemy instance
        this.gridWidth = ROOM_WIDTH;
        this.gridHeight = ROOM_HEIGHT;

        generateBattleRoom(originalGrid);
        spawnEnemyInRoom();
    }

    private void spawnEnemyInRoom() {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        Enemy enemy = createEnemyFromType(enemyType);
        addObject(enemy, centerX, centerY);
    }

    private Enemy createEnemyFromType(String type) {
        switch (type) {
            case "Skeleton":
                return new Skeleton();
            case "Zombie":
                return new Zombie();
            case "Slime":
                return new Slime();
        }
    }

    private void generateBattleRoom(String[][] originalGrid) {
        int xOffset = (getWidth() - (gridWidth * TILE_WIDTH)) / 2;
        int yOffset = (getHeight() - (gridHeight * TILE_HEIGHT)) / 2;

        // Fill the grid with floor and walls
        for (int y = 0; y < gridHeight; y++) {
            for (int x = 0; x < gridWidth; x++) {
                Actor tile;
                if (y == 0 || y == gridHeight - 1 || x == 0 || x == gridWidth - 1) {
                    // Wall tiles
                    tile = new Wall("WallT" + Greenfoot.getRandomNumber(8) + ".png");
                    grid[y][x] = "Wall";
                } else {
                    // Floor tiles
                    tile = new Floor("FloorN" + Greenfoot.getRandomNumber(4) + ".png");
                    grid[y][x] = "Floor";
                }
                addObject(tile, xOffset + x * TILE_WIDTH, yOffset + y * TILE_HEIGHT);
            }
        }
    }


}


