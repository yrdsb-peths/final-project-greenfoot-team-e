import greenfoot.*;

public class DeathKnight extends Enemy 
{
    private static final String[] IDLE_FRAMES = { "DeathKnightIdle0.png", "DeathKnightIdle1.png", "DeathKnightIdle2.png", "DeathKnightIdle3.png", "DeathKnightIdle4.png", "DeathKnightIdle5.png", "DeathKnightIdle6.png", "DeathKnightIdle7.png", "DeathKnightIdle8.png"};
    private static final String[] WALK_FRAMES = { "DeathKnightWalk0.png", "DeathKnightWalk1.png", "DeathKnightWalk2.png", "DeathKnightWalk3.png", "DeathKnightWalk4.png", "DeathKnightWalk5.png"};
    private static final String[] ATTACK_FRAMES = { "DeathKnightAttack0.png", "DeathKnightAttack1.png", "DeathKnightAttack2.png", "DeathKnightAttack3.png", "DeathKnightAttack4.png", "DeathKnightAttack5.png", "DeathKnightAttack6.png", "DeathKnightAttack7.png", "DeathKnightAttack8.png", "DeathKnightAttack9.png", "DeathKnightAttack10.png", "DeathKnightAttack11.png"};
    private static final String[] HIT_FRAMES = { "DeathKnightHit0.png", "DeathKnightHit1.png", "DeathKnightHit2.png", "DeathKnightHit3.png", "DeathKnightHit4" };
    private static final String[] DEATH_FRAMES = { "DeathKnightDeath0.png", "DeathKnightDeath1.png", "DeathKnightDeath2.png", "DeathKnightDeath3.png", "DeathKnightDeath4.png" , "DeathKnightDeath5.png", "DeathKnightDeath6.png", "DeathKnightDeath7.png", "DeathKnightDeath8.png", "DeathKnightDeath9.png", "DeathKnightDeath10.png", "DeathKnightDeath11.png", "DeathKnightDeath12.png", "DeathKnightDeath13.png", "DeathKnightDeath14.png", "DeathKnightDeath15.png", "DeathKnightDeath16.png", "DeathKnightDeath17.png", "DeathKnightDeath18.png", "DeathKnightDeath19.png", "DeathKnightDeath20.png", "DeathKnightDeath21.png", "DeathKnightDeath22.png"};
    private boolean defeated;
    GreenfootImage deathKnightImage = new GreenfootImage("DeathKnightIdle0.png");
    public DeathKnight(boolean defeated) {
        setImage(deathKnightImage);
        changeState(State.IDLE);
        this.defeated=defeated;
    }
    @Override
    public void act() {
        updateAnimation();
        
        if (!defeated) {
            encounter(Player.class);
        }
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

    @Override
    public int getType() {
        return 3;
    }
}

