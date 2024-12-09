import greenfoot.*;


public class Player extends Actor implements Lifeform {
    private int x = 30;
    private int y = 20;
    private boolean keyHeld = false;
    private Enemy enemy;

    public Player(Enemy enemy) {
        this.enemy = enemy;
    }

    public void act() {
        movement(this, keyHeld);
        enemy.encounter(this);
    }
    @Override
        public void movement(Lifeform lifeform, boolean keyHeld) {
        String key = Greenfoot.getKey();

        if (key != null && !keyHeld) {
            keyHeld = true;

            int x = lifeform.getXPosition();
            int y = lifeform.getYPosition();

            if (key.equals("a")) {
                x = Math.max(x - 20, 20);
            } else if (key.equals("d")) {
                x = Math.min(x + 20, 370);
            } else if (key.equals("w")) {
                y = Math.max(y - 20, 30);
            } else if (key.equals("s")) {
                y = Math.min(y + 20, 370);
            }

            lifeform.updatePosition(x, y);
            enemy.moveRandomly();
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
