import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Heart extends Actor {

    private GreenfootImage fullHeart;
    private GreenfootImage emptyHeart;

    public Heart() {
        fullHeart = new GreenfootImage("HeartFull.png");
        fullHeart.scale(24,27);
        emptyHeart = new GreenfootImage("HeartNull.png");
        emptyHeart.scale(24,27);
        setFull();
    }

    public void setFull() {
        setImage(fullHeart);
    }

    public void setEmpty() {
        setImage(emptyHeart);
    }
}
