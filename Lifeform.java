import greenfoot.Actor;
import greenfoot.Greenfoot;

public interface Lifeform {
    default void movement(Lifeform lifeform) {
        int x = lifeform.getXPosition();
        int y = lifeform.getYPosition();
    
            int direction = Greenfoot.getRandomNumber(5);
    
            int newX = x;
            int newY = y;
    
            switch (direction) {
                case 0 -> newX = Math.max(x - 31, 30);  
                case 1 -> newX = Math.min(x + 31, 371); 
                case 2 -> newY = Math.max(y - 32, 20);  
                case 3 -> newY = Math.min(y + 32, 372); 
                case 4 -> {} 
            }

            if (newX != x || newY != y) {
                lifeform.updatePosition(newX, newY);
            }
    }
    
    default boolean isTouchingWall() {
        if (this instanceof Actor actor) {
            for (Object obj : actor.getIntersectingObjects(Actor.class)) {
                if (obj instanceof Actor otherActor) {
                    String imageName = otherActor.getImage().toString().toLowerCase();
                    if (imageName.contains("wall")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    void updatePosition(int newX, int newY);

    int getXPosition();

    int getYPosition();
}




