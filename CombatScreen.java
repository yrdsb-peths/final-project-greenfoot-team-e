import greenfoot.*;
public class CombatScreen extends World 
{
    private static final int TILE_WIDTH = 31;
    private static final int TILE_HEIGHT = 32;
    public static final int ROOM_WIDTH = 400;
    public static final int ROOM_HEIGHT = 400;

    private int gridWidth;
    private int gridHeight;
    private String[][] grid;

    public CombatScreen(Object world)
        {
            super(400,600,1);
            
            //generateCombatRoom(world);
    }
        
    private void generateCombatRoom(World world) 
        {
            gridWidth = ROOM_WIDTH / TILE_WIDTH;
            gridHeight = ROOM_HEIGHT / TILE_HEIGHT;
            grid = new String[gridHeight][gridWidth];
            
            int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();
        int xOffset = (worldWidth - ROOM_WIDTH) / 2 + 30;
        int yOffset = ((worldHeight - ROOM_HEIGHT) / 2) - 80;
    }
}

