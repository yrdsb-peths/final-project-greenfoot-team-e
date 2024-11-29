import greenfoot.*;

public class GameScreen extends World {
    public GameScreen() {
        super(400, 600, 1); 
        TileWorld tileWorld = new TileWorld();
        tileWorld.generateRoomIn(this);
        Player player=new Player();
        addObject(player,300,200);
        Enemy enemy=new Enemy();
        addObject(enemy, 300,200);
    }
}

