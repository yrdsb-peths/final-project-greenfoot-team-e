import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import greenfoot.Greenfoot;
public class GameStateManager {
    //stores all temporary data such as amount of enemies, player position, chest position, if chest has been looted, etc.
    public static int playerX;
    public static int playerY;
    public static int currentLevel = 1;
    public static int treasureChestX;
    public static int treasureChestY;
    public static boolean treasureExists=false;
    public static String treasureTypeOpen;
    public static String treasureTypeClosed;
    public static boolean chestLooted=false;
    public static int traderX;
    public static int traderY;
    public static boolean traderExists=false;
    public static int entranceX;
    public static int entranceY;
    public static Map<Integer, Long> levelSeeds = new HashMap<>();
    public static List<Map<String, Object>> enemyData = new ArrayList<>();
    public static int currentEnemy;
    public static int totalEnemiesKilled=0;
}
