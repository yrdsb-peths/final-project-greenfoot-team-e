import greenfoot.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class TileWorld extends world 
{
    private static final int TILE_WIDTH = 31;  // Tile width in Greenfoot
    private static final int TILE_HEIGHT = 32; // Tile height in Greenfoot
    private static final int ROOM_WIDTH = 400; // Room width in pixels
    private static final int ROOM_HEIGHT = 400; // Room height in pixels
    private FogOfWar fogOfWar;

    private int gridWidth;  // Number of horizontal tiles
    private int gridHeight; // Number of vertical tiles
    private String[][] grid; // Tracks the room layout

    public TileWorld() 
    {
        gridWidth = ROOM_WIDTH / TILE_WIDTH; // Calculate number of tiles horizontally
        gridHeight = ROOM_HEIGHT / TILE_HEIGHT; // Calculate number of tiles vertically
        grid = new String[gridHeight][gridWidth];
    }

    public void generateRoomIn(World world) 
    {
        Random random = new Random();

        // Calculate offsets to center the room and shift it down by 10 pixels
        int worldWidth = world.getWidth(); // Total world width in pixels
        int worldHeight = world.getHeight(); // Total world height in pixels
        int xOffset = (worldWidth - ROOM_WIDTH) / 2 +30; // Horizontal offset
        int yOffset = ((worldHeight - ROOM_HEIGHT) / 2) -80; // Vertical offset (shifted down)

        // Generate floor tiles first
        for (int y = 0; y < gridHeight; y++) 
        {
            for (int x = 0; x < gridWidth; x++) 
            {
                grid[y][x] = "Floor"; // Mark the entire grid as floor initially
                world.addObject(new Floor("FloorN" + random.nextInt(4) + ".png"), xOffset + x * TILE_WIDTH, yOffset + y * TILE_HEIGHT);
            }
        }

        // Generate walls
        for (int y = 0; y < gridHeight; y++) 
        {
            for (int x = 0; x < gridWidth; x++) 
            {
                Actor actor = null;

                if (y == 0) { // Top wall
                    if (x == 0) {
                        actor = new Wall("CornerTL.png");
                    } else if (x == gridWidth - 1) {
                        actor = new Wall("CornerTR.png");
                    } else {
                        actor = new Wall("WallT" + random.nextInt(8) + ".png");
                    }
                    grid[y][x] = "Wall";
                } else if (y == gridHeight - 1) { // Bottom wall
                    if (x == 0 || x == gridWidth - 1) {
                        actor = new Wall("WallT" + random.nextInt(8) + ".png"); // Extend bottom corners
                    } else {
                        actor = new Wall("WallT" + random.nextInt(8) + ".png");
                    }
                    grid[y][x] = "Wall";
                } else if (x == 0) { // Left wall
                    actor = new Wall("WallL" + random.nextInt(3) + ".png");
                    grid[y][x] = "Wall";
                } else if (x == gridWidth - 1) { // Right wall
                    actor = new Wall("WallR" + random.nextInt(3) + ".png");
                    grid[y][x] = "Wall";
                }

                if (actor != null) {
                    world.addObject(actor, xOffset + x * TILE_WIDTH, yOffset + y * TILE_HEIGHT);
                }
            }
        }

        placeDoorsWithGap(world, xOffset, yOffset);
        TreasureChest.spawnIn(world, grid, xOffset, yOffset);
        FogOfWar fogOfWar = new FogOfWar(grid, xOffset, yOffset);
        fogOfWar.initializeFog(getWorld());

        Player player = new Player(new Enemy(), fogOfWar);
        addObject(player, 200, 200);

    }

    private void placeDoorsWithGap(World world, int xOffset, int yOffset) {
        Random random = new Random();
        List<Integer> doorPositions = new ArrayList<>();
        boolean placedTop = false;
        boolean placedBottom = false;

        // Decide where to place the doors: both top, both bottom, or one on top and one on bottom
        int doorChoice = random.nextInt(3); // 0 = top and bottom, 1 = both top, 2 = both bottom

        // Handle door placement based on choice
        if (doorChoice == 0 || doorChoice == 1) { // Doors on the top wall
            // Place two doors on top wall with a gap
            placedTop = placeDoorOnWall(world, doorPositions, xOffset, yOffset, 0);
        }

        if (doorChoice == 0 || doorChoice == 2) { // Doors on the bottom wall
            // Place two doors on bottom wall with a gap
            placedBottom = placeDoorOnWall(world, doorPositions, xOffset, yOffset + (gridHeight - 1) * TILE_HEIGHT, gridHeight - 1);
        }
    }

    private boolean placeDoorOnWall(World world, List<Integer> doorPositions, int xOffset, int yOffset, int wallYPosition) {
        Random random = new Random();
        boolean placed = false;
        
        // Try to place two doors with a gap of at least 2 wall tiles between them
        while (doorPositions.size() < 2) {
            int x = random.nextInt(gridWidth - 2) + 1; // Prevent placing doors in corners
            // Ensure there's a gap of at least 2 tiles between doors
            if (x > 1 && !doorPositions.contains(x) && !doorPositions.contains(x - 1) && !doorPositions.contains(x + 1)) {
                doorPositions.add(x);
                if (wallYPosition == 0) {
                    world.addObject(new Door("WallDTC.png"), xOffset + x * TILE_WIDTH, yOffset); // Top door
                } else {
                    world.addObject(new Door("WallDBC.png"), xOffset + x * TILE_WIDTH, yOffset); // Bottom door
                }
                placed = true;
            }
        }

        return placed;
    }
}






