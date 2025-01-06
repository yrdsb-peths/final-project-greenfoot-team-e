import greenfoot.*;

public class Skeleton extends Enemy {
    private static final String[] IDLE_FRAMES = { "SkelIdle0.png", "SkelIdle1.png", "SkelIdle2.png", "SkelIdle3.png", "SkelIdle4.png", "SkelIdle5.png", "SkelIdle6.png", "SkelIdle7.png", "SkelIdle8.png", "SkelIdle9.png", "SkelIdle10.png" };
    private static final String[] WALK_FRAMES = { "SkelWalk0.png", "SkelWalk1.png", "SkelWalk2.png", "SkelWalk3.png", "SkelWalk4.png", "SkelWalk5.png", "SkelWalk6.png", "SkelWalk7.png", "SkelWalk8.png", "SkelWalk9.png", "SkelWalk10.png", "SkelWalk11.png", "SkelWalk12.png" };
    private static final String[] ATTACK_FRAMES = { "SkelAttack0.png", "SkelAttack1.png", "SkelAttack2.png", "SkelAttack3.png", "SkelAttack4.png", "SkelAttack5.png", "SkelAttack6.png", "SkelAttack7.png", "SkelAttack8.png", "SkelAttack9.png", "SkelAttack10.png", "SkelAttack11.png", "SkelAttack12.png", "SkelAttack13.png", "SkelAttack14.png", "SkelAttack15.png", "SkelAttack16.png", "SkelAttack17.png" };
    private static final String[] HIT_FRAMES = { "SkelHit0.png", "SkelHit1.png", "SkelHit2.png", "SkelHit3.png", "SkelHit4.png", "SkelHit5.png","SkelHit6.png", "SkelHit7.png", "SkelHit8.png" };
    private static final String[] DEATH_FRAMES = { "SkelDeath0.png", "SkelDeath1.png", "SkelDeath2.png", "SkelDeath3.png", "SkelDeath4.png", "SkelDeath5.png", "SkelDeath6.png", "SkelDeath7.png", "SkelDeath8.png", "SkelDeath9.png", "SkelDeath10.png", "SkelDeath11.png", "SkelDeath12.png", "SkelDeath13.png", "SkelDeath14.png" };
    private static final String[] REACT_FRAMES = { "SkelReact0.png", "SkelReact1.png", "SkelReact2.png", "SkelReact3.png"};

    public Skeleton() {
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

    protected String[] getReactFrames() {
        return REACT_FRAMES;
    }
}
