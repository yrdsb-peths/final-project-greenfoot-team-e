import greenfoot.*;

public class Door extends Actor {
    private int doorType; // 0 for entrance, 1 for exit
    private boolean interacted = false;

    public Door(String imageFile, int type) {
        setImage(imageFile);
        this.doorType = type; // Set type via constructor
    }

    public void act() {
        if (!interacted) {
            if (doorType == 1) {
                Exit(Player.class);
            } else {
                Entrance(Player.class);
            }
        }
    }

    public void Exit(Class<?> playerClass) {
        if (this.isTouching(playerClass)) {
            System.out.println("Exit");
            interacted = true;

            // Update game state and load the next level
            GameStateManager.currentLevel++;
            Greenfoot.setWorld(new GameScreen());
        }
    }

    public void Entrance(Class<?> playerClass) {
        if (this.isTouching(playerClass)) {
            System.out.println("Entrance");
            interacted = true;

            // Define behavior for entrances if needed
        }
    }
}
