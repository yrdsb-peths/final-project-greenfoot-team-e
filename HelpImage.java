import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class HelpImage extends Actor {
    GreenfootImage helpImage = new GreenfootImage("HelpImage.png");
    public HelpImage() {
        setImage(helpImage);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("e")) {
            this.getWorld().removeObject(this);
        }
    }
    
}
