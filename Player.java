import greenfoot.*;

public class Player extends Actor implements Lifeform {
    private int x = 30;
    private int y = 20;
    private boolean keyHeld = false;
    private Enemy enemy;
    private FogOfWar fogOfWar;

    public Player(Enemy enemy, FogOfWar fogOfWar) {
        this.enemy = enemy;
        this.fogOfWar = fogOfWar; 
    }

    public void act() {
        movement(this, keyHeld);
    }

    @Override
    public void movement(Lifeform lifeform, boolean keyHeld) {
        String key = Greenfoot.getKey();

        if (key != null && !keyHeld) {
            keyHeld = true;

            int x = lifeform.getXPosition();
            int y = lifeform.getYPosition();

            if (key.equals("a")) {
                x = Math.max(x - 31, 31);
            } else if (key.equals("d")) {
                x = Math.min(x + 31, 400 - 31);
            } else if (key.equals("w")) {
                y = Math.max(y - 32, 32);
            } else if (key.equals("s")) {
                y = Math.min(y + 32, 400 - 32);
            }

            lifeform.updatePosition(x, y);
            enemy.moveRandomly();
            fogOfWar.updateFog(x, y);
        } else if (key == null) {
            keyHeld = false;
        }
    }

    @Override
    public void updatePosition(int newX, int newY) {
        x = newX;
        y = newY;
        setLocation(x, y);
    }

    @Override
    public int getXPosition() {
        return x;
    }

    @Override
    public int getYPosition() {
        return y;
    }
}
