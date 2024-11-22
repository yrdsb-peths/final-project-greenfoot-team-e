import greenfoot.*;

public class Player extends Actor {
    private int x = 10;
    private int y = 10;

    private boolean keyHeld = false;

    public void act() {
        String key = Greenfoot.getKey(); 
        
        if (key != null && !keyHeld) { 
            keyHeld = true;
            
            if (key.equals("a")) {
                x = Math.max(x - 20, 10); 
            } else if (key.equals("d")) {
                x = Math.min(x + 20, 390);
            } else if (key.equals("w")) {
                y = Math.max(y - 20, 10); 
            } else if (key.equals("s")) {
                y = Math.min(y + 20, 390); 
            }
            
            setLocation(x, y);
        } else if (key == null) {
            keyHeld = false; 
        }
    }
}
