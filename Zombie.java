import greenfoot.*;

public class Zombie extends Enemy {
    private static final String[] IDLE_FRAMES = { "ZombieIdle0.png", "ZombieIdle1.png", "ZombieIdle2.png", "ZombieIdle3.png", "ZombieIdle4.png", "ZombieIdle5.png", "ZombieIdle6.png", "ZombieIdle7.png"};
    private static final String[] WALK_FRAMES = { "ZombieWalk0.png", "ZombieWalk1.png", "ZombieWalk2.png", "ZombieWalk3.png", "ZombieWalk4.png", "ZombieWalk5.png", "ZombieWalk6.png", "ZombieWalk7.png" };
    private static final String[] ATTACK_FRAMES = { "ZombieAttack0.png", "ZombieAttack1.png", "ZombieAttack2.png", "ZombieAttack3.png", "ZombieAttack4.png", "ZombieAttack5.png", "ZombieAttack6.png" };
    private static final String[] HIT_FRAMES = { "ZombieHit0.png", "ZombieHit1.png", "ZombieHit2.png", "ZombieHit3.png" };
    private static final String[] DEATH_FRAMES = { "ZombieDeath0.png", "ZombieDeath1.png", "ZombieDeath2.png", "ZombieDeath3.png", "ZombieDeath4.png" , "ZombieDeath5.png", "ZombieDeath6.png", "ZombieDeath7.png"};
    private static final String[] HEAVY_ATTACK_FRAMES = { "ZombieHeavyAttack0.png", "ZombieHeavyAttack1.png", "ZombieHeavyAttack2.png", "ZombieHeavyAttack3.png", "ZombieHeavyAttack4.png", "ZombieHeavyAttack5.png", "ZombieHeavyAttack6.png", "ZombieHeavyAttack7.png", "ZombieHeavyAttack8.png", "ZombieHeavyAttack9.png", "ZombieHeavyAttack10.png", "ZombieHeavyAttack11.png", "ZombieHeavyAttack12.png", "ZombieHeavyAttack13.png", "ZombieHeavyAttack14.png", "ZombieHeavyAttack15.png", "ZombieHeavyAttack16.png", "ZombieHeavyAttack17.png", "ZombieHeavyAttack18.png", "ZombieHeavyAttack19.png", "ZombieHeavyAttack20.png", "ZombieHeavyAttack21.png"};

    public Zombie() {
        changeState(State.IDLE);
    }

    @Override
    protected String[] getIdleFrames() {
        return IDLE_FRAMES;
    }

    @Override
    protected String[] getWalkFrames() {
        return WALK_FRAMES;
    }

    @Override
    protected String[] getAttackFrames() {
        return ATTACK_FRAMES;
    }

    @Override
    protected String[] getHitFrames() {
        return HIT_FRAMES;
    }

    @Override
    protected String[] getDeathFrames() {
        return DEATH_FRAMES;
    }

    protected String[] getHeavyAttackFrames() {
        return HEAVY_ATTACK_FRAMES;
    }
}
