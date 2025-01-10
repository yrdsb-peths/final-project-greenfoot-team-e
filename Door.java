import greenfoot.*;

public class Door extends Actor {
    private int doorType; // 0 for entrance, 1 for exit
    private boolean interacted = false;
    private int doorX;
    private int doorY;
    private static final int TILE_SIZE = 32;

    public Door(String imageFile, int type) {
        setImage(imageFile);
        this.doorType = type;
    }

    public void addedToWorld(World world) {
        doorX = getX();
        doorY = getY();
        if(doorType==0){
            GameStateManager.entranceX=doorX;
            GameStateManager.entranceY=doorY;
        }
        System.out.println(doorX+","+doorY);
    }

    public void act() {
        if (!interacted && isPlayerNearDoor()) {
            if (doorType == 1) {
                handleExit();
            } else {
                handleEntrance();
            }
        }
    }

    private boolean isPlayerNearDoor() {
        int range = TILE_SIZE; // Define how close is considered "near" (e.g., one tile)
        int dx = GameStateManager.playerX - doorX; // Horizontal distance
        int dy = Math.abs(GameStateManager.playerY - doorY); // Vertical distance
        return (Math.abs(dx) <= range/2 && dy == -TILE_SIZE) || // Above the door
        (Math.abs(dx) <= range/2 && dy == TILE_SIZE);
    }

    private void handleExit() {
        if (!interacted) {
            interacted = true; // Mark as executed
            System.out.println("Exit");
            GameStateManager.currentLevel++;
            GameStateManager.enemyData.clear();
            GameStateManager.chestLooted=false;
            Greenfoot.setWorld(new GameScreen());
        }
    }

    private void handleEntrance() {
        System.out.println("Entrance");
        interacted = true;
    }
}
