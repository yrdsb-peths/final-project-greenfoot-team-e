import greenfoot.*;
import java.util.Random;

public class CombatScreen extends World {

    public CombatScreen()
    {
        LoadCombatRoom();
    }

    private void LoadCombatRoom()
    {
        FloorI floor1 = new FloorI();
        getWorld().addObject(floor1, 92, 84);
        floor1.setLocation(92,84);
    }

}

