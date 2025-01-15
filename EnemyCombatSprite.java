import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class EnemyCombatSprite extends Actor {
    GreenfootImage skeletonImage;
    GreenfootImage zombieImage;
    GreenfootImage slimeImage;

    public EnemyCombatSprite() {
        skeletonImage = new GreenfootImage("SkelAttack0.png");
        zombieImage = new GreenfootImage("ZombieIdle0.png");
        slimeImage = new GreenfootImage("slime-idle-0.png");

        skeletonImage.scale(200, 200);
        slimeImage.scale(200, 200);
        zombieImage.scale(200, 200);

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
        }
    }
}
