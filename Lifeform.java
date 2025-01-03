import greenfoot.Greenfoot;

public interface Lifeform {
    default void movement(Lifeform lifeform) {
        int x = lifeform.getXPosition();
        int y = lifeform.getYPosition();
    
            int direction = Greenfoot.getRandomNumber(5);
    
            int newX = x;
            int newY = y;
    
            switch (direction) {
                case 0 -> newX = Math.max(x - 20, 30);  
                case 1 -> newX = Math.min(x + 20, 370); 
                case 2 -> newY = Math.max(y - 20, 30);  
                case 3 -> newY = Math.min(y + 20, 370); 
                case 4 -> {} 
            }
    

            if (newX != x || newY != y) {
                lifeform.updatePosition(newX, newY);
            }
    }
    
    

    void updatePosition(int newX, int newY);

    int getXPosition();

    int getYPosition();
}




