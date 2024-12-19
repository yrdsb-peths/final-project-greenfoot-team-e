import java.util.Random;

import greenfoot.*;

public class GameScreen extends World {
    GreenfootImage helpImage = new GreenfootImage("Help-Image.png");
    private static final int NUM_ENEMIES = 2;
    private Random random;
    public GameScreen() {
        super(400, 600, 1); 
        long seed = random.nextLong(); 
        TileWorld tileWorld = new TileWorld(seed);
        tileWorld.generateRoomIn(this);
        createRandomEnemies(NUM_ENEMIES);
        Player player = new Player();
        addObject(player, 200, 200);
        addObject(new Button(this::helpButton, "help-button.png",114, 56), 200, 350);
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

    public void helpButton(){
        setImage(helpImage);
    }
}
