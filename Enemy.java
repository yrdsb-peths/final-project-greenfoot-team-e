import greenfoot.*;

public class Enemy extends Actor implements Lifeform {
    private boolean keyHeld = false;
    public void act() {
        
    }

    public void moveRandomly() {
        movement(this, keyHeld); 
    }

    @Override
    public void updatePosition(int newX, int newY) {
        setLocation(newX, newY);
    }

    @Override
    public int getXPosition() {
        return getX();
    }

    @Override
    public int getYPosition() {
        return getY();
    }
}
