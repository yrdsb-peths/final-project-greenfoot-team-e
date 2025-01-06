import greenfoot.*;

public class Zombie extends Enemy {
    private static final String[] IDLE_FRAMES = { "zombie_idle_0.png", "zombie_idle_1.png" };
    private static final String[] WALK_FRAMES = { "zombie_walk_0.png", "zombie_walk_1.png" };
    private static final String[] ATTACK_FRAMES = { "zombie_attack_0.png", "zombie_attack_1.png" };
    private static final String[] HIT_FRAMES = { "zombie_hit_0.png" };
    private static final String[] DEATH_FRAMES = { "zombie_death_0.png", "zombie_death_1.png" };

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
}
