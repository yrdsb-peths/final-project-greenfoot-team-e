import java.util.HashMap;
import java.util.Map;

public class GameStateManager {
    public static int playerX;
    public static int playerY;
    public static int currentLevel = 1;
    public static boolean treasureChest;
    public static String treasureType;
    public static Map<Integer, Long> levelSeeds = new HashMap<>();
}
