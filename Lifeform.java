import greenfoot.Greenfoot;

public interface Lifeform {
    default void movement(Lifeform lifeform, boolean keyHeld) {
        String key = Greenfoot.getKey();

        if (key != null && !keyHeld) {
                keyHeld = true;
                int x = lifeform.getXPosition();
                int y = lifeform.getYPosition();
                int direction = Greenfoot.getRandomNumber(4);

            if (direction == 0) {
                x = Math.max(x - 20, 10);
            } else if (direction == 1) {
                x = Math.min(x + 20, 380);
            } else if (direction == 2) {
                y = Math.max(y - 20, 10);
            } else if (direction == 3) {
                y = Math.min(y + 20, 380);
            }

                updatePosition(x, y);
            } else if (key == null) {
                keyHeld = false;
        }
    }

    void updatePosition(int newX, int newY);

    int getXPosition();

    int getYPosition();
}




