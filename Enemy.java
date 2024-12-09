import java.util.List;

import greenfoot.*;

public class Enemy extends Actor implements Lifeform {
    private boolean keyHeld = false;
    private boolean defeated=false;
    String key = Greenfoot.getKey();
    boolean isPlayerMoved = key != null;

    public Enemy(){

    }
    public void act() {

        List<Enemy> enemies = getWorld().getObjects(Enemy.class);
    

        for (Enemy enemy : enemies) {
            movement(enemy, keyHeld, isPlayerMoved);  
            encounter(enemy);  
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
    public void encounter(Enemy enemy){
        if(!defeated&&this.isTouching(Player.class)){
            System.out.println("FIGHT STARTED");
            defeated=true;
        }
    }
}
