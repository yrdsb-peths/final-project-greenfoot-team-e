import greenfoot.*;

public class GameScreen extends World {
    public GameScreen() {
        super(600, 400, 1); // Adjust dimensions as needed
        TileWorld tileWorld = new TileWorld();
        tileWorld.generateRoomIn(this);
    }
}

