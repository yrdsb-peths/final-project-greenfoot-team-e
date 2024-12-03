import greenfoot.*;

public class GameScreen extends World {
    public GameScreen() {
        super(400, 600, 1); 
        ScannerClass inventory = new ScannerClass("Inventory.txt");
        TileWorld tileWorld = new TileWorld();
        tileWorld.generateRoomIn(this);

        Enemy enemy = new Enemy();
        Player player = new Player(enemy);

        addObject(player, 200, 200);
        addObject(enemy, Greenfoot.getRandomNumber(400), Greenfoot.getRandomNumber(400));

        if (!inventory.getWordList().isEmpty()) {
            System.out.println(inventory.getWordList().get(0));
        } else {
            System.out.println("Inventory is empty.");
        }


        inventory.addWord("Apple");
    }
}
