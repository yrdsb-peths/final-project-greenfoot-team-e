import greenfoot.Greenfoot;

public interface Lifeform {
    default void movement(int x,int y, boolean keyHeld) {
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
            
        } else if (key == null) {
            keyHeld = false; 
        }
    }
    default int hp(int health){
        if(health==1){
            return 20;
        }else{
            return 10;
        }
    }
}


