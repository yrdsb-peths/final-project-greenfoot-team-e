import greenfoot.Greenfoot;

public interface Lifeform {
    default void move(int x, int y) {
        if (Greenfoot.isKeyDown("a")) {
            x -= 50;
        } else if (Greenfoot.isKeyDown("d")) {
            x += 50;
        } else if (Greenfoot.isKeyDown("w")) {
            y += 50;
        } else if (Greenfoot.isKeyDown("s")) {
            y -= 50;
        }

        System.out.println("New position: x=" + x + ", y=" + y);
    }
}
