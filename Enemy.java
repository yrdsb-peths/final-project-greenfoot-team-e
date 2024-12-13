import java.util.List;

import greenfoot.*;

public class Enemy extends Actor implements Lifeform {
    public boolean keyHeld=Player.keyHeld;

    private boolean defeated; 

    public Enemy() {
        this.defeated = false;
    }
    public void act() {
        //String key = Greenfoot.getKey(); 
        keyHeld = Player.keyHeld; 
        encounter(Player.class); 
    
        if (!defeated) {
            //if (key != null && (key.equals("a") || key.equals("s") || key.equals("w") || key.equals("d"))) {
                eMovement(keyHeld); 
            //}
        }
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
    public void encounter(Class<?> Player) {
        if(!defeated&&this.isTouching(Player.class)){
            System.out.println("FIGHT STARTED");
            defeated=true;
        }
    }
    public void eMovement(boolean keyHeld) {
        if (keyHeld) { 
            //if (key.equals("a") || key.equals("s") || key.equals("w") || key.equals("d")) {
                movement(this); 
            //}
        }
    }
}
