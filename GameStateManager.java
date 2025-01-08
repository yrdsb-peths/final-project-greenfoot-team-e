import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameStateManager {
    public static int playerX;
    public static int playerY;
    public static int currentLevel = 1;
    public static int treasureChestX;
    public static int treasureChestY;
    public static boolean treasureExists=false;
    public static String treasureType;
    public static boolean chestLooted=false;
    public static int traderX;
    public static int traderY;
    public static boolean traderExists=false;
    public static Map<Integer, Long> levelSeeds = new HashMap<>();
    public static List<Map<String, Object>> enemyData = new ArrayList<>();
    public static int currentEnemyType;
}
