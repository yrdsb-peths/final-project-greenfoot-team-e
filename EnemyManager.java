import greenfoot.*;
import java.util.Random;

public class EnemyManager {
    private static final Random random = new Random();

    public static Enemy createRandomEnemy() {
        int enemyType = random.nextInt(3); // Generates 0, 1, or 2

        switch (enemyType) {
            case 0:
                return new Skeleton();
            case 1:
                return new Slime();
            case 2:
            default:
                return new Zombie();
        }
    }
}
