import greenfoot.*;
public class CombatScreen extends World {
    private boolean defeated=true;
    public CombatScreen(){   
    super(400,600,1);
    Skeleton skeleton1=new Skeleton(defeated);
    Slime slime1=new Slime(defeated);
    Zombie zombie1=new Zombie(defeated);
    switch (GameStateManager.currentEnemy) {
        case 0:
            addObject(skeleton1,300,300);
            break;
        case 1:
            addObject(slime1,300,300);
            break;
        case 2:
        default:
            addObject(zombie1,300,300);
            break;
    }
        addObject(new Button(this::returnGameScreen, "StartButtonIdle.png",114, 56), 200, 350);
    }
    public void returnGameScreen(){
        Greenfoot.setWorld(new GameScreen());
    }
}

