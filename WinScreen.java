import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class WinScreen extends World {
    Label stats=new Label("You killed "+GameStateManager.totalEnemiesKilled+" enemies",30);
    public WinScreen(){    
        super(400, 600, 1);
        setBackground("You-Win.png");
        addObject(stats, 200, 400);
    }

}