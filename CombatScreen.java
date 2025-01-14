import greenfoot.*;

public class CombatScreen extends World 
{

    public CombatScreen()
    {
        super(400,600,1);
        EnemyCombatSprite enemy = new EnemyCombatSprite();
        addObject(enemy, 231, 148);

    }

}

