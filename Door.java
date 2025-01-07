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
        System.out.println(doorX+","+doorY);
    }

    public void act() {
        if (!interacted && isPlayerAtDoor()) {
            if (doorType == 1) {
                handleExit();
            } else {
                handleEntrance();
            }
        }
    }

    private boolean isPlayerAtDoor() {
        if(doorY>200){
            return (doorX) == GameStateManager.playerX && (doorY + TILE_SIZE) == GameStateManager.playerY;
        }else{
            return (doorX) == GameStateManager.playerX && (doorY - TILE_SIZE) == GameStateManager.playerY;
        }
    }

    private void handleExit() {
        System.out.println("Exit");
        interacted = true;
        GameStateManager.currentLevel++;
        Greenfoot.setWorld(new GameScreen());
    }

    private void handleEntrance() {
        System.out.println("Entrance");
        interacted = true;
    }
}
