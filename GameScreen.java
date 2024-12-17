import java.io.IOException;
import java.util.Random;

import greenfoot.*;

public class GameScreen extends World {
    private static final int NUM_ENEMIES = 1;
    private Random random= new Random();
    private long seed1= random.nextLong();
    private long seed2= random.nextLong();
    private long seed3= random.nextLong();

    public static int level=1;
    public GameScreen() {
        super(400, 600, 1); 
        level=1;
        if(level==1){ 
            TileWorld tileWorld = new TileWorld(seed1);
            tileWorld.generateRoomIn(this);
            try {
                ScannerClass.clearFile("Inventory.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else if(level==2){
            TileWorld tileWorld = new TileWorld(seed2);
            tileWorld.generateRoomIn(this);

        }else if(level==3){
            TileWorld tileWorld = new TileWorld(seed3);
            tileWorld.generateRoomIn(this);
        }else{

        }
        createRandomEnemies(NUM_ENEMIES);
        Player player = new Player();
        addObject(player, 200, 200);
    }

    // Method to create enemies at random positions
    public void createRandomEnemies(int numEnemies) {
        for (int i = 0; i < numEnemies; i++) {
            int x = Greenfoot.getRandomNumber(370); // Random x within world width
            int y = Greenfoot.getRandomNumber(370); // Random y within world height
            
            Enemy enemy = new Enemy(); // Create a new enemy instance
            addObject(enemy, x, y); // Add the enemy to the world at the random position
        }
    }
}
