import greenfoot.*;

public class GameScreen extends World {
    private TileWorld tileWorld;

    public GameScreen() {
        super(10, 8, 32); // Adjust to match the room dimensions
        tileWorld = new TileWorld(); // Initialize the tile world logic
        tileWorld.generateRoomIn(this); // Populate this world with tiles
    }
}
