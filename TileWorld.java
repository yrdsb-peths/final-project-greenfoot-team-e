import greenfoot.*;
import java.util.Random;

public class TileWorld {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 8;
    private String[][] grid;

    public TileWorld() {
        grid = new String[HEIGHT][WIDTH];
    }

    public void generateRoomIn(World world) {
        Random random = new Random();

        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                Actor actor = null;

                if (y == 0) { // Top wall
                    if (x == 0) {
                        actor = new Wall("CornerTL.png");
                    } else if (x == WIDTH - 1) {
                        actor = new Wall("CornerTR.png");
                    } else {
                        actor = new Wall("WallT" + random.nextInt(8) + ".png");
                    }
                } else if (y == HEIGHT - 1) { // Bottom wall
                    if (x != 0 && x != WIDTH - 1) {
                        actor = new Wall("WallT" + random.nextInt(8) + ".png");
                    }
                } else if (x == 0) { // Left wall
                    actor = new Wall("WallL" + random.nextInt(3) + ".png");
                } else if (x == WIDTH - 1) { // Right wall
                    actor = new Wall("WallR" + random.nextInt(3) + ".png");
                } else {
                    grid[y][x] = "Floor";
                }

                if (actor != null) {
                    world.addObject(actor, x, y);
                    grid[y][x] = "Wall";
                }
            }
        }

        // Add doors
        for (int i = 0; i < 2; i++) {
            placeDoorIn(world, random);
        }

        // Add floors
        for (int y = 1; y < HEIGHT - 1; y++) {
            for (int x = 1; x < WIDTH - 1; x++) {
                if ("Floor".equals(grid[y][x])) {
                    String tile = determineFloorTile(x, y);
                    world.addObject(new Floor(tile), x, y);
                }
            }
        }
    }

    private void placeDoorIn(World world, Random random) {
        while (true) {
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);

            if ("Wall".equals(grid[y][x])) {
                String doorImage = null;

                if (y == 0) {
                    doorImage = "WallDTO.png";
                } else if (y == HEIGHT - 1) {
                    doorImage = "WallDBC.png";
                } else if (x == 0) {
                    doorImage = "WallDLC.png";
                } else if (x == WIDTH - 1) {
                    doorImage = "WallDRC.png";
                }

                if (doorImage != null) {
                    world.addObject(new Door(doorImage), x, y);
                    grid[y][x] = "Door";
                    break;
                }
            }
        }
    }

    private String determineFloorTile(int x, int y) {
        boolean top = "Wall".equals(grid[y - 1][x]);
        boolean bottom = "Wall".equals(grid[y + 1][x]);
        boolean left = "Wall".equals(grid[y][x - 1]);
        boolean right = "Wall".equals(grid[y][x + 1]);

        if (top && bottom && left && right)
        {
            return "FloorTOBO.png";
        }
        if (top && bottom && left)
        {
            return "FloorLO.png";
        }
        if (top && bottom && right)
        {
            return "FloorRO.png";
        }
        if (top && bottom) 
        {
            return "FloorROLO.png";
        }
        if (top && left) 
        {
            return "FloorTLS.png";
        }
        if (top && right)
        {
            return "FloorTRS.png";
        }
        if (top) 
        {
            return "FloorTS.png";
        }
        if (bottom && left) 
        {
            return "FloorBLS.png";
        }
        if (bottom && right) 
        {
            return "FloorBRS.png";
        }
        if (bottom) 
        {
            return "FloorBS.png";
        }
        if (left && right) 
        {
            return "FloorTO.png";
        }
        if (left)
        {
            return "FloorLS.png";
        }
        if (right) 
        {
            return "FloorRS.png";
        }

        return "FloorN" + Greenfoot.getRandomNumber(4) + ".png";
    }
}
