import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;
//Lose screen
public class LoseScreen extends World {
    Label stats=new Label(GameStateManager.totalEnemiesKilled,30);
    public LoseScreen(){    
        super(400, 600, 1);
        setBackground("You-Lose.png");
        addObject(stats, 200, 400);
        
    }

}