import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import greenfoot.Greenfoot;
import greenfoot.World;

public class GameScreen extends World {
    private static final int NUM_ENEMIES = 2;
    private Player player;
    private TileWorld tileWorld; // Field for reuse across methods
    private List<Map<String, Object>> enemyData = new ArrayList<>(); // Store enemy data

    public GameScreen() {
        super(400, 600, 1);

        if (GameStateManager.levelSeeds.isEmpty()) {
            initializeSeeds();
        }

        initializeLevel();
    }

    private void initializeSeeds() {
        Random random = new Random();
        GameStateManager.levelSeeds.put(1, random.nextLong());
        GameStateManager.levelSeeds.put(2, random.nextLong());
        GameStateManager.levelSeeds.put(3, random.nextLong());
    }

    private void initializeLevel() {
        if (GameStateManager.currentLevel == 0) {
            GameStateManager.currentLevel = 1; // Default to level 1
        }

        // Create the player
        player = new Player();

        // Load the current level
        loadLevel(GameStateManager.currentLevel);

        // Place the player at the correct position
        if (GameStateManager.playerX == 0 && GameStateManager.playerY == 0) {
            int[] door1 = tileWorld.getDoor1Position();
            if (door1 != null) {
                if (door1[1] == 0) {
                    addObject(player, door1[0] + 30, door1[1] + 24);
                } else {
                    addObject(player, door1[0] + 30, door1[1] + 21);
                }
            } else {
                addObject(player, 30, 52); // Fallback to center
            }
        } else {
            addObject(player, GameStateManager.playerX, GameStateManager.playerY);
        }
    }

    private void loadLevel(int levelToLoad) {
        Long seed = GameStateManager.levelSeeds.get(levelToLoad);
        if (seed == null) {
            System.err.println("Level not found: " + levelToLoad);
            return;
        }

        removeObjects(getObjects(null));
        tileWorld = new TileWorld(seed); // Initialize tileWorld
        tileWorld.generateRoomIn(this);

        if (enemyData.isEmpty()) {
            createRandomEnemies(NUM_ENEMIES);
        } else {
            reloadEnemies();
        }
    }

    public void changeLevel(int newLevel) {
        if (GameStateManager.levelSeeds.containsKey(newLevel)) {
            saveGameState();
            GameStateManager.currentLevel = newLevel;
            loadLevel(newLevel);
        }
    }

    private void saveGameState() {
        GameStateManager.playerX = player.getX();
        GameStateManager.playerY = player.getY();
        saveEnemyData();
    }

    private void saveEnemyData() {
        enemyData.clear();
        for (Enemy enemy : getObjects(Enemy.class)) {
            Map<String, Object> data = new HashMap<>();
            data.put("x", enemy.getX());
            data.put("y", enemy.getY());
            data.put("active", enemy.isActive()); // Assuming Enemy class has an `isActive` method
            enemyData.add(data);
        }
    }

    private void reloadEnemies() {
        for (Map<String, Object> data : enemyData) {
            int x = (int) data.get("x");
            int y = (int) data.get("y");
            boolean active = (boolean) data.get("active");

            if (active) {
                Enemy enemy = new Enemy();
                addObject(enemy, x, y);
            }
        }
    }

    public void createRandomEnemies(int numEnemies) {
        int tileRows = 11; // Number of rows in the tile grid
        int tileCols = 11; // Number of columns in the tile grid
        int tileWidth = 31; // Width of a single tile
        int tileHeight = 32; // Height of a single tile
    
        for (int i = 0; i < numEnemies; i++) {
            int randomRow = Greenfoot.getRandomNumber(tileRows);
            int randomCol = Greenfoot.getRandomNumber(tileCols);
    
            // Calculate the pixel coordinates for the center of the tile
            int x = (randomCol * tileWidth) + (tileWidth / 2);
            int y = (randomRow * tileHeight) + (tileHeight / 2);
    
            Enemy enemy = new Enemy();
            addObject(enemy, x, y);

            Map<String, Object> data = new HashMap<>();
            data.put("x", x);
            data.put("y", y);
            data.put("active", true); // New enemies start as active
            enemyData.add(data);
        }
    }
}
