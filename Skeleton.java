import greenfoot.*;

public class Skeleton extends Enemy {
    private static final String[] IDLE_FRAMES = { "skeleton_idle_0.png", "skeleton_idle_1.png" };
    private static final String[] WALK_FRAMES = { "skeleton_walk_0.png", "skeleton_walk_1.png" };
    private static final String[] ATTACK_FRAMES = { "skeleton_attack_0.png", "skeleton_attack_1.png" };
    private static final String[] HIT_FRAMES = { "skeleton_hit_0.png" };
    private static final String[] DEATH_FRAMES = { "skeleton_death_0.png", "skeleton_death_1.png" };

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
}
