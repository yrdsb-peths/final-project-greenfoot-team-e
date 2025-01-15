import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class EnemyCombatSprite extends Actor {
    GreenfootImage skeletonImage = new GreenfootImage("SkelAttack0.png");
    GreenfootImage zombieImage = new GreenfootImage("ZombieIdle0.png");
    GreenfootImage slimeImage = new GreenfootImage("slime-idle-0.png");
    GreenfootImage deathKnightImage = new GreenfootImage("DeathKnightIdle0.png");
    public EnemyCombatSprite(){
        switch (GameStateManager.currentEnemy) {
            case 0:
                setImage(skeletonImage);
                break;
            case 1:
                setImage(slimeImage);
                break;
            case 2:
            default:
                setImage(zombieImage);
                break;
            case 3:
                setImage(deathKnightImage);
                break;
        }
    }
}
