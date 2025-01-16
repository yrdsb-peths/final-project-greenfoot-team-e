import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.GreenfootSound;
import greenfoot.World;

public class GameScreen extends World 
{   
    private static final int NUM_ENEMIES = 2;
    private Player player;
    private TileWorld tileWorld;
    private static final Random random = new Random();
    private List<Heart> hearts = new ArrayList<>();
    static Label exitText=new Label(" ",20);
    static Label text=new Label(" ", 20);
    GreenfootSound backgroudMusic = new GreenfootSound("backgroundMusic.mp3");
    public GameScreen() 
    {
        super(400, 600, 1);
        setBackground("background.png");
        backgroudMusic.playLoop();
        if (GameStateManager.levelSeeds.isEmpty()) 
        {
            initializeSeeds();
        }
        initializeLevel();
        initializeHearts();
        addObject(exitText, 150, 425);
        addObject(text, 150, 425);
        addObject(new Button(this::itemList, "Items-button.png",  150, 100), 300, 500);
        
    }
    private void itemList(){
        text.setValue("You have "+CombatManager.playerHealthPot+" Health Potions");
    }
    private void initializeSeeds() 
    {
        Random random = new Random();
        GameStateManager.levelSeeds.put(1, random.nextLong());
        GameStateManager.levelSeeds.put(2, random.nextLong());
        GameStateManager.levelSeeds.put(3, random.nextLong());
        GameStateManager.levelSeeds.put(4, random.nextLong());
    }

    private void initializeLevel() 
    {
        if (GameStateManager.currentLevel == 0) {
            GameStateManager.currentLevel = 1; // Default to level 1
        }

        // Create the player
        player = new Player();

        // Load the current level
        loadLevel(GameStateManager.currentLevel);

        // Place the player at the correct position
        if (GameStateManager.playerX > 0 && GameStateManager.playerY > 0) 
        {
            addObject(player, GameStateManager.playerX, GameStateManager.playerY);
        } else 
        {
            if(GameStateManager.entranceY<200)
            {
                addObject(player, GameStateManager.entranceX,GameStateManager.entranceY+32);
            }else{
                addObject(player, GameStateManager.entranceX,GameStateManager.entranceY-32);
            }
        }
    }
    // Load the current level
    private void loadLevel(int levelToLoad) 
    {
        Long seed = GameStateManager.levelSeeds.get(levelToLoad);
        if (seed == null) 
        {
            System.err.println("Level not found: " + levelToLoad);
            return;
        }

        removeObjects(getObjects(null));
        tileWorld = new TileWorld(seed); // Initialize tileWorld
        tileWorld.generateRoomIn(this);
        if(GameStateManager.currentLevel==4){
            int enemyType = 3;
            Enemy enemy = createEnemyByType(enemyType, false);
            if (enemy != null) {
                enemy.gameScreen(this);
                addObject(enemy, 200, 200);
    
                Map<String, Object> data = new HashMap<>();
                data.put("x", 200);
                data.put("y", 200);
                data.put("type", enemyType);
                data.put("defeated", false);
                GameStateManager.enemyData.add(data);
            }
        }else{
            if (GameStateManager.enemyData.isEmpty()) {
                createRandomEnemies(NUM_ENEMIES);
            } else {
                reloadEnemies();
            }
        }
    }
    //change level
    public void changeLevel(int newLevel) 
    {
        if (GameStateManager.levelSeeds.containsKey(newLevel)) 
        {
            saveGameState();
            GameStateManager.currentLevel = newLevel;
            loadLevel(newLevel);
        }
    }
    //saves gamescreen so player can return after combat
    public void saveGameState() 
    {
        GameStateManager.playerX = player.getX();
        GameStateManager.playerY = player.getY();
        saveEnemyData();
    }
    //saves enemy data
    private void saveEnemyData() 
    {
        GameStateManager.enemyData.clear();
        for (Enemy enemy : getObjects(Enemy.class)) {
            Map<String, Object> data = new HashMap<>();
            data.put("x", enemy.getX());
            data.put("y", enemy.getY());
            data.put("type", enemy.getType());
            data.put("defeated", enemy.isDefeated());
            GameStateManager.enemyData.add(data);
        }
    }
    //reloads data to stop enemies from infinitely respawning after every combat

    private void reloadEnemies() 
    {
        for (Map<String, Object> data : GameStateManager.enemyData) {
            int x = (int) data.get("x");
            int y = (int) data.get("y");
            boolean defeated = (boolean) data.get("defeated");
            int enemyType = (int) data.get("type");
    
            if (!defeated) {
                Enemy enemy = createEnemyByType(enemyType, defeated);
                if (enemy != null) {
                    enemy.gameScreen(this);
                    addObject(enemy, x, y);
                } else {
                    System.err.println("Unknown enemy type: " + enemyType);
                }
            }
        }
    }
    //creates random amount of new enemies
    public void createRandomEnemies(int numEnemies) 
    {
        int tileRows = 11;
        int tileCols = 11;
        int tileWidth = 31;
        int tileHeight = 32;
    
        for (int i = 0; i < numEnemies; i++) {
            int randomRow = Greenfoot.getRandomNumber(tileRows);
            int randomCol = Greenfoot.getRandomNumber(tileCols);
    
            int x = (randomCol * tileWidth) + (tileWidth / 2);
            int y = (randomRow * tileHeight) + (tileHeight / 2);
    
            int enemyType = random.nextInt(3);
            Enemy enemy = createEnemyByType(enemyType, false);
            if (enemy != null) 
            {
                enemy.gameScreen(this);
                addObject(enemy, x, y);
    
                Map<String, Object> data = new HashMap<>();
                data.put("x", x);
                data.put("y", y);
                data.put("type", enemyType);
                data.put("defeated", false);
                GameStateManager.enemyData.add(data);
            }
        }
        
    }
    //chooses what type of enemies
    private Enemy createEnemyByType(int enemyType, boolean defeated) 
    {
        switch (enemyType) 
        {
            case 0:
                return new Skeleton(defeated);
            case 1:
                return new Slime(defeated);
            case 2:
            default:
                return new Zombie(defeated);
            case 3:
                return new DeathKnight(defeated);
        }
    }
    //creates the hearts for the player so player can keep track out of combat
    private void initializeHearts() 
    {
        int heartsCount = (int) Math.ceil(CombatManager.playerHPMax / 2.0); // Total hearts needed
        for (int i = 0; i < heartsCount; i++) 
        {
            Heart heart = new Heart();
            if (i < CombatManager.playerHP / 2) 
            {
                heart.setFull(); // Full heart
            } else if (i == CombatManager.playerHP / 2 && CombatManager.playerHP % 2 != 0) 
            {
                heart.setHalf(); // Half heart
            } 
            else 
            {
                heart.setEmpty(); // Empty heart
            }
            hearts.add(heart);
            addObject(heart, 375 - (i * 20), 420); // Adjust positions as needed
        }
    }
}

