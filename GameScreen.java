import greenfoot.*;

public class GameScreen extends World {
    public GameScreen() {
        super(400, 600, 1); 
        TileWorld tileWorld = new TileWorld();
        tileWorld.generateRoomIn(this);
        Enemy enemy = new Enemy();
        Player player = new Player(enemy);

        addObject(player, 200, 200);
        addObject(enemy, Greenfoot.getRandomNumber(370), Greenfoot.getRandomNumber(370));
    }
}

