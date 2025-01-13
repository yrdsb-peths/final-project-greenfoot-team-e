import greenfoot.*;

public class CombatScreen extends World 
{

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
        FloorI floor13 = new FloorI();
        addObject(floor13, 185,84);
        WallI wall13 = new WallI();
        addObject(wall13, 185, 84);
        FloorII floor23 = new FloorII();
        addObject(floor23, 185,116);
        FloorII floor33 = new FloorII();
        addObject(floor33, 185,148);
        FloorII floor43 = new FloorII();
        addObject(floor43, 185,180);
        FloorI floor53 = new FloorI();
        addObject(floor53, 185,212);
        WallII wall53 = new WallII();
        addObject(wall53 , 185, 212);
        FloorII floor14 = new FloorII();
        addObject(floor14, 216,84);
        WallII wall14 = new WallII();
        addObject(wall14, 216, 84);
        FloorI floor24 = new FloorI();
        addObject(floor24, 216,116);
        FloorI floor34 = new FloorI();
        addObject(floor34, 216,148);
        FloorII floor44 = new FloorII();
        addObject(floor44, 216,180);
        FloorII floor54 = new FloorII();
        addObject(floor54, 154,212);
        WallI wall54 = new WallI();
        addObject(wall54 , 216, 212);
        FloorII floor15 = new FloorII();
        addObject(floor15, 247,84);
        WallI wall15 = new WallI();
        addObject(wall15, 247, 84);
        FloorII floor25 = new FloorII();
        addObject(floor25, 247,116);
        FloorI floor35 = new FloorI();
        addObject(floor35, 247,148);
        FloorI floor45 = new FloorI();
        addObject(floor45, 247,180);
        FloorI floor55 = new FloorI();
        addObject(floor55, 247,212);
        WallII wall55 = new WallII();
        addObject(wall55 , 247, 212);
        FloorI floor16 = new FloorI();
        addObject(floor16, 278,84);
        WallI wall16 = new WallI();
        addObject(wall16, 278, 84);
        FloorII floor26 = new FloorII();
        addObject(floor26, 278,116);
        FloorI floor36 = new FloorI();
        addObject(floor36, 278,148);
        FloorII floor46 = new FloorII();
        addObject(floor46, 278,180);
        FloorII floor56 = new FloorII();
        addObject(floor56, 278,212);
        WallII wall56 = new WallII();
        addObject(wall56 , 278, 212);
        FloorII floor17 = new FloorII();
        addObject(floor17, 309, 84);
        CornerTR cornertr = new CornerTR();
        addObject(cornertr, 309, 84);
        FloorI floor27 = new FloorI();
        addObject(floor27, 309, 116);
        RightWall rightwall1 = new RightWall();
        addObject(rightwall1, 309, 116);
        FloorII floor37 = new FloorII();
        addObject(floor37, 309, 148);
        RightWall rightwall2 = new RightWall();
        addObject(rightwall2, 309, 148);
        FloorI floor47 = new FloorI();
        addObject(floor47, 309, 180);
        RightWall rightwall3 = new RightWall();
        addObject(rightwall3, 309, 180);
        FloorI floor57 = new FloorI();
        addObject(floor57, 309, 212);
        RightWall rightwall4 = new RightWall();
        addObject(rightwall4, 309, 212);
    }

}

