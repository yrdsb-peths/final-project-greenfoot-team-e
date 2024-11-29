import greenfoot.*;

public class Enemy extends Actor implements Lifeform {
    private int x=300;
    private int y=200;
    private boolean keyHeld=false;
    public void act() {
        movement(x, y, keyHeld); 
        setLocation(x, y); 
    }
}
