import greenfoot.*;

public class CombatScreen extends World {

    public CombatScreen()
    {
        super(400,600,1);
        LoadCombatRoom();
    }

    private void LoadCombatRoom()
    {
        FloorI floor10 = new FloorI();
        addObject(floor10, 92, 84);
        CornerTL cornertl = new CornerTL();
        addObject(cornertl, 92, 84);
        FloorII floor20 = new FloorII();
        addObject(floor20, 92, 116);
        LeftWall leftwall1 = new LeftWall();
        addObject(leftwall1, 92, 116);
        FloorII floor30 = new FloorII();
        addObject(floor30, 92, 148);
        LeftWall leftwall2 = new LeftWall();
        addObject(leftwall2, 92, 148);
        FloorI floor40 = new FloorI();
        addObject(floor40, 92, 180);
        LeftWall leftwall3 = new LeftWall();
        addObject(leftwall3, 92, 180);
        FloorI floor50 = new FloorI();
        addObject(floor50, 92, 212);
        LeftWall leftwall4 = new LeftWall();
        addObject(leftwall4, 92, 212);
        FloorII floor11 = new FloorII();
        addObject(floor11, 123,84);
        WallI wall11 = new WallI();
        addObject(wall11, 123, 84);
        FloorII floor21 = new FloorII();
        addObject(floor21, 123,116);
        FloorI floor31 = new FloorI();
        addObject(floor31, 123,148);
        FloorI floor41 = new FloorI();
        addObject(floor41, 123,180);
        FloorII floor51 = new FloorII();
        addObject(floor51, 123,212);
        WallII wall51 = new WallII();
        addObject(wall51 , 123, 212);
        FloorI floor12 = new FloorI();
        addObject(floor12, 154,84);
        WallI wall12 = new WallI();
        addObject(wall12, 154, 84);
        FloorI floor22 = new FloorI();
        addObject(floor22, 154,116);
        FloorII floor32 = new FloorII();
        addObject(floor32, 154,148);
        FloorI floor42 = new FloorI();
        addObject(floor42, 154,180);
        FloorI floor52 = new FloorI();
        addObject(floor52, 154,212);
        WallI wall52 = new WallI();
        addObject(wall52 , 154, 212);
    }

}

