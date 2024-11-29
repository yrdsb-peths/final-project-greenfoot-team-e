import greenfoot.*;

public class Player extends Actor implements Lifeform{
    private int x = 10;
    private int y = 10;

    private boolean keyHeld = false;

    public void act() {
        movement(x,y,keyHeld);
        setLocation(x, y);
    }
}
