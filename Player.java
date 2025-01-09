import greenfoot.*;


public class Player extends Actor implements Lifeform {
    private int x=200;
    private int y=200;
    public static boolean keyHeld = false;
    public static String key;

    public void act() {
        key = Greenfoot.getKey();
        if (key != null && !keyHeld) {
            keyHeld = true;
            movePlayer(key);
        } else if (key == null) {
            keyHeld = false;
        }
    }

    private void movePlayer(String key) {
        int x = getX();
        int y = getY();

        switch (key) {
            case "a" -> x = Math.max(x - 20, 10);
            case "d" -> x = Math.min(x + 20, 390);
            case "w" -> y = Math.max(y - 20, 10);
            case "s" -> y = Math.min(y + 20, 390);
        }

        updatePosition(x, y);
    }

    @Override
    public void updatePosition(int newX, int newY) {
        x = newX;
        y = newY;
        setLocation(x, y);
    }

    @Override
    public int getXPosition() {
        return x;
    }

    @Override
    public int getYPosition() {
        return y;
    }
}
