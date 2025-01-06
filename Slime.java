import greenfoot.*;

public class Slime extends Enemy {
    private static final String[] IDLE_FRAMES = { "slime-idle-0.png", "slime-idle-1.png", "slime-idle-2", "slime-idle-3" };
    private static final String[] WALK_FRAMES = { "slime-move-0.png", "slime-move-1.png", "slime-move-2", "slime-move-3" };
    private static final String[] ATTACK_FRAMES = { "slime-attack-0.png", "slime-attack-1.png", "slime-attack-2.png", "slime-attack-3.png", "slime-attack-4.png" };
    private static final String[] HIT_FRAMES = { "slime-hurt-0.png", "slime-hurt-1", "slime-hut-2", "slime-hurt-3" };
    private static final String[] DEATH_FRAMES = { "slime-die-0.png", "slime-die-1.png", "slime-die-2", "slime-die-3" };

    public Slime() {
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
