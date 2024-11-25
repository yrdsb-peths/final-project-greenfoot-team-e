import greenfoot.Greenfoot;

public interface Lifeform {
    default void movement(int x,int y) {
        int direction = Greenfoot.getRandomNumber(3); 
            if (direction==0) {
                x = Math.max(x - 20, 10); 
            } else if (direction==1) {
                x = Math.min(x + 20, 390);
            } else if (direction==2) {
                y = Math.max(y - 20, 10); 
            } else if (direction==3) {
                y = Math.min(y + 20, 390); 
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
