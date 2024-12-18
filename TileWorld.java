import greenfoot.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class TileWorld {
    private static final int TILE_WIDTH = 31;
    private static final int TILE_HEIGHT = 32;
    public static final int ROOM_WIDTH = 400;
    public static final int ROOM_HEIGHT = 400;

    private int gridWidth;
    private int gridHeight;
    private String[][] grid;
    private long seed;
    private Random random;
    private TraderSpawner traderSpawner;

    //door position variables
    private int door1X = -1;
    private int door1Y = -1;
    private int door2X = -1;
    private int door2Y = -1;

    public TileWorld(long seed) {
        this.seed = seed;
        this.random = new Random(seed);
        gridWidth = ROOM_WIDTH / TILE_WIDTH;
        gridHeight = ROOM_HEIGHT / TILE_HEIGHT;
        grid = new String[gridHeight][gridWidth];
    }

    public void generateRoomIn(World world) {
        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();
        int xOffset = (worldWidth - ROOM_WIDTH) / 2 + 30;
        int yOffset = ((worldHeight - ROOM_HEIGHT) / 2) - 80;

        Random random = new Random();

        // Generate floor tiles first
        for (int y = 0; y < gridHeight; y++) {
            for (int x = 0; x < gridWidth; x++) {
                grid[y][x] = "Floor";
                world.addObject(new Floor("FloorN" + random.nextInt(4) + ".png"), xOffset + x * TILE_WIDTH, yOffset + y * TILE_HEIGHT);
            }
        }

        for (int y = 0; y < gridHeight; y++) {
            for (int x = 0; x < gridWidth; x++) {
                Actor actor = null;

                if (y == 0) {
                    if (x == 0) {
                        actor = new Wall("CornerTL.png");
                    } else if (x == gridWidth - 1) {
                        actor = new Wall("CornerTR.png");
                    } else {
                        actor = new Wall("WallT" + random.nextInt(8) + ".png");
                    }
                    grid[y][x] = "Wall";
                } else if (y == gridHeight - 1) {
                    if (x == 0 || x == gridWidth - 1) {
                        actor = new Wall("WallT" + random.nextInt(8) + ".png");
                    } else {
                        actor = new Wall("WallT" + random.nextInt(8) + ".png");
                    }
                    grid[y][x] = "Wall";
                } else if (x == 0) {
                    actor = new Wall("WallL" + random.nextInt(3) + ".png");
                    grid[y][x] = "Wall";
                } else if (x == gridWidth - 1) {
                    actor = new Wall("WallR" + random.nextInt(3) + ".png");
                    grid[y][x] = "Wall";
                }

                if (actor != null) {
                    world.addObject(actor, xOffset + x * TILE_WIDTH, yOffset + y * TILE_HEIGHT);
                }
            }
        }

        placeDoorsWithGap(world, xOffset, yOffset);

        // Spawn chest and trader
        boolean chestPresent = TreasureChest.spawnIn(world, grid, xOffset, yOffset);
        traderSpawner = new TraderSpawner(world, gridWidth, gridHeight, xOffset, yOffset);
        traderSpawner.spawnTrader(chestPresent);
    }

    private void placeDoorsWithGap(World world, int xOffset, int yOffset) {
        List<Integer> doorPositions = new ArrayList<>();

        int doorChoice = random.nextInt(3); // 0 = top and bottom, 1 = both top, 2 = both bottom

        if (doorChoice == 0 || doorChoice == 1) {
            placeDoorOnWall(world, doorPositions, xOffset, yOffset, 0);
        }

        if (doorChoice == 0 || doorChoice == 2) {
            placeDoorOnWall(world, doorPositions, xOffset, yOffset + (gridHeight - 1) * TILE_HEIGHT, gridHeight - 1);
        }
    }

    private boolean placeDoorOnWall(World world, List<Integer> doorPositions, int xOffset, int yOffset, int wallYPosition) {
        boolean placed = false;
    
        while (doorPositions.size() < 2) {
            int x = random.nextInt(gridWidth - 2) + 1;
            if (x > 1 && !doorPositions.contains(x) && !doorPositions.contains(x - 1) && !doorPositions.contains(x + 1)) {
                doorPositions.add(x);
    
                // Calculate the door's exact position
                int doorX = xOffset + x * TILE_WIDTH;
                int doorY = yOffset;
    
                // Remove any existing "Wall" object at this position
                List<Actor> objectsAtLocation = world.getObjectsAt(doorX, doorY, Actor.class);
                for (Actor obj : objectsAtLocation) {
                    if (obj instanceof Wall) {
                        Wall wall = (Wall) obj;
                        if (wall.getImage().toString().toLowerCase().contains("wall")) {
                            world.removeObject(wall);
                        }
                    }
                }
    
                // Add the door object
                if (wallYPosition == 0) {
                    world.addObject(new Door("WallDTC.png"), doorX, doorY);
                    if (door1X == -1) { // First door position
                        door1X = x * 31;
                        door1Y = wallYPosition * 32;
                    } else { // Second door position
                        door2X = x;
                        door2Y = wallYPosition;
                    }
                } else {
                    world.addObject(new Door("WallDBC.png"), doorX, doorY);
                    if (door1X == -1) { // First door position
                        door1X = x;
                        door1Y = wallYPosition;
                    } else { // Second door position
                        door2X = x;
                        door2Y = wallYPosition;
                    }
                }
                placed = true;
            }
        }
    
        return placed;
    }
    

    public int[] getDoor1Position() {
        return new int[]{door1X, door1Y};
    }

    public int[] getDoor2Position() {
        return new int[]{door2X, door2Y};
    }
}
