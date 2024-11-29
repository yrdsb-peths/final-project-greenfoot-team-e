import greenfoot.*;

public class Enemy extends Actor implements Lifeform {
    public void act() {
        
    }

    public void moveRandomly() {
        int x = getX();
        int y = getY();

        int direction = Greenfoot.getRandomNumber(5);
        if (direction == 0) {
            x = Math.max(x - 20, 20);
        } else if (direction == 1) {
            x = Math.min(x + 20, 370);
        } else if (direction == 2) {
            y = Math.max(y - 20, 30);
        } else if (direction == 3) {
            y = Math.min(y + 20, 370);
        }else if(direction==4){
            
        }

        setLocation(x, y);
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
