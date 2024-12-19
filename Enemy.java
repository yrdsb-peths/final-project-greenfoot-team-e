import java.util.List;

import greenfoot.*;

public class Enemy extends Actor implements Lifeform {
    public boolean keyHeld=Player.keyHeld;

    private boolean defeated; 

    public Enemy() {
        this.defeated = false;
    }
    public void act() {
        keyHeld = Player.keyHeld; 
        encounter(Player.class); 
    
        if (!defeated) {
            eMovement(keyHeld);
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
            String key = Player.key; 
            if ("a".equals(key) || "s".equals(key) || "w".equals(key) || "d".equals(key)) {
                movement(this);
            }
        }
    }
}
