import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;
//help screen with instructions
public class HelpImage extends Actor {
    //creates help screen
    GreenfootImage helpImage = new GreenfootImage("HelpImage.png");
    World world;
    public HelpImage(World world) {
        this.world=world;
        setImage(helpImage);
    }
    public void act()
    {  
        if(Greenfoot.isKeyDown("h")) {
            world.removeObject(this);
        }  
    }
    
}
