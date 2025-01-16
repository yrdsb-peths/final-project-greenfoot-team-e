import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
public class EnemyCombatSprite extends Actor {
    //enemy attack and idle images
    GreenfootImage skeletonImage = new GreenfootImage("SkelAttack0.png");
    GreenfootImage zombieImage = new GreenfootImage("ZombieIdle0.png");
    GreenfootImage slimeImage = new GreenfootImage("slime-idle-0.png");
    public EnemyCombatSprite(){
        switch (GameStateManager.currentEnemy) {
            case 0:
                setImage("SkelAttack0.png");
                break;
            case 1:
                setImage("slime-idle-0.png");
                break;
            case 2:
            default:
                setImage("ZombieIdle0.png");
                break;
        }
    }
}
