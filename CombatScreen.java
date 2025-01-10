import greenfoot.*;
public class CombatScreen extends World {
    private boolean defeated=true;
    public CombatScreen(){   
        super(400,600,1);
        EnemyCombatSprite enemy=new EnemyCombatSprite();
        addObject(enemy,300,300);
        addObject(new Button(this::returnGameScreen, "StartButtonIdle.png",114, 56), 200, 350);
        addObject(new Button(this::Inventory, "StartButtonIdle.png",114, 56), 200, 450);
    }
    public void Inventory(){
        InventoryChecker inventory=new InventoryChecker();
    }
    public void returnGameScreen(){
        Greenfoot.setWorld(new GameScreen());
    }
}

