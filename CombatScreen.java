import greenfoot.*;

public class CombatScreen extends World {

    public CombatScreen()
    {
        super(600,400,1);
        LoadCombatRoom();
    }

    private void LoadCombatRoom()
    {
        FloorI floor1 = new FloorI();
        addObject(floor1, 92, 84);
        floor1.setLocation(92,84);
        CornerTL cornertl = new CornerTL();
        addObject(cornertl, 92, 84);
        cornertl.setLocation(94,84);
        FloorII floor2 = new FloorII();
        addObject(floor2, 92, 116);
        LeftWall leftwall1 = new LeftWall();
        addObject(leftwall1, 92, 116);
        leftwall1.setLocation(92, 116);
    }

}

