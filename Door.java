import greenfoot.*;

public class Door extends Actor {
    private static int nextDoorType = 0; // Shared counter for all Door instances
    private int doorType;               // Unique type for each Door
    private boolean interacted = false;
    public Door(String imageFile) {
        setImage(imageFile);
        this.doorType = nextDoorType; // Assign the current value of nextDoorType
        nextDoorType++;               // Increment for the next Door
    }

    public void act() {
        if (!interacted) {
            if (doorType == 1) {
                Exit(Player.class); // Exit logic
            } else {
                Entrance(Player.class); // Entrance logic
            }
        }
    }

    public void Exit(Class<?> playerClass) {
        if (this.isTouching(playerClass)) {
            // GameScreen.level++; // Uncomment if GameScreen is implemented
            System.out.println("Exit");
            interacted = true; 
        }
    }
    public void Entrance(Class<?> playerClass) {
        if (this.isTouching(playerClass)) {
            // GameScreen.level++; // Uncomment if GameScreen is implemented
            System.out.println("Entrance");
            interacted = true; 
        }
    }
}
