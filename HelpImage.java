import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class HelpImage extends Actor {
    GreenfootImage helpImage = new GreenfootImage("Help-Image.png");
    public HelpImage() {
        
    }
    public void act()
    {
         
        if(Greenfoot.isKeyDown("h")) {
            move(-2);
        }
        if(Greenfoot.isKeyDown("d")) {
            move(2);
        }
        
        
        
    }
    
}
