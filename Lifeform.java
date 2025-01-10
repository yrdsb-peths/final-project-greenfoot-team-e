
import java.util.List;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.World;

public interface Lifeform {
    default void Movement(Lifeform enemy) {
        if (!(enemy instanceof Actor actor)) {
            return;
        }
    
        World world = actor.getWorld();
        if (world == null) {
            return;
        }
    
        int enemyX = enemy.getXPosition();
        int enemyY = enemy.getYPosition();
    
        Lifeform closestPlayer = null;
        int closestDistance = Integer.MAX_VALUE;
    
        List<Player> players = world.getObjects(Player.class);
    
        for (Player player : players) {
            int playerX = player.getXPosition();
            int playerY = player.getYPosition();
    
            int distanceX = Math.abs(playerX - enemyX);
            int distanceY = Math.abs(playerY - enemyY);
            int distance = distanceX + distanceY; // Manhattan distance
    
            if (distance <= 124 && distance < closestDistance) { // Within 2 tiles
                closestDistance = distance;
                closestPlayer = player;
            }
        }
    
        if (closestPlayer != null) { // Move towards the closest player
            int playerX = closestPlayer.getXPosition();
            int playerY = closestPlayer.getYPosition();
    
            int newX = enemyX;
            int newY = enemyY;
    
            if (playerX > enemyX) newX = Math.min(enemyX + 31, 371);
            else if (playerX < enemyX) newX = Math.max(enemyX - 31, 30);
    
            if (playerY > enemyY) newY = Math.min(enemyY + 32, 340);
            else if (playerY < enemyY) newY = Math.max(enemyY - 32, 52);
    
            if (newX != enemyX || newY != enemyY) {
                enemy.updatePosition(newX, newY);
            }
        } else { // Random movement if no players nearby
            int direction = Greenfoot.getRandomNumber(5);
    
            int newX = enemyX;
            int newY = enemyY;
    
            switch (direction) {
                case 0 -> newX = Math.max(enemyX - 31, 30);
                case 1 -> newX = Math.min(enemyX + 31, 371);
                case 2 -> newY = Math.max(enemyY - 32, 52);
                case 3 -> newY = Math.min(enemyY + 32, 340);
                case 4 -> {}
            }
    
            if (newX != enemyX || newY != enemyY) {
                enemy.updatePosition(newX, newY);
            }
        }
    }

    void updatePosition(int newX, int newY);

    int getXPosition();

    int getYPosition();
}




