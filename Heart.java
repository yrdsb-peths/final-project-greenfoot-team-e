import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Heart extends Actor {

    private GreenfootImage fullHeart;
    private GreenfootImage emptyHeart;
    private GreenfootImage halfHeart;
    //Sets the images for heart
    public Heart() {
        fullHeart = new GreenfootImage("HeartFull.png");
        fullHeart.scale(24,27);
        emptyHeart = new GreenfootImage("HeartNull.png");
        emptyHeart.scale(24,27);
        halfHeart = new GreenfootImage("HeartHalf.png");
        halfHeart.scale(24,27);
        setFull();
    }

    public void setFull() {
        setImage(fullHeart);
    }

    public void setEmpty() {
        setImage(emptyHeart);
    }
    public void setHalf() {
        setImage(halfHeart);
    }
}
