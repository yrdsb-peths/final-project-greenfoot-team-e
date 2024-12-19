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
        int oldX = getX();
        int oldY = getY();

        switch (key) {
            case "a" -> x = Math.max(x - 31, 30);
            case "d" -> x = Math.min(x + 31, 371);
            case "w" -> y = Math.max(y - 32, 20);
            case "s" -> y = Math.min(y + 32, 372);
        }

        updatePosition(x, y);
        
        if(isTouchingWall())
        {
            updatePosition(oldX, oldY);
        }
        
    }
    
    public boolean isTouchingWall() 
    {
        Actor intersectingActor = getOneIntersectingObject(Actor.class);
        if (intersectingActor != null) {
            String imageName = intersectingActor.getImage().toString().toLowerCase();
            return imageName.contains("Wall");
        }
        return false;
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
