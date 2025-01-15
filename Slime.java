import greenfoot.*;

public class Slime extends Enemy {
    private static final String[] IDLE_FRAMES = { "slime-idle-0.png", "slime-idle-1.png", "slime-idle-2.png", "slime-idle-3.png" };
    private static final String[] WALK_FRAMES = { "slime-move-0.png", "slime-move-1.png", "slime-move-2.png", "slime-move-3.png" };
    private static final String[] ATTACK_FRAMES = { "slime-attack-0.png", "slime-attack-1.png", "slime-attack-2.png", "slime-attack-3.png", "slime-attack-4.png" };
    private static final String[] HIT_FRAMES = { "slime-hurt-0.png", "slime-hurt-1.png", "slime-hut-2.png", "slime-hurt-3.png" };
    private static final String[] DEATH_FRAMES = { "slime-die-0.png", "slime-die-1.png", "slime-die-2.png", "slime-die-3.png" };
    private boolean defeated;
    GreenfootImage slimeImage = new GreenfootImage("slime-idle-0.png");
    public Slime(boolean defeated) {
        setImage(slimeImage);
        changeState(State.IDLE);
        this.defeated=defeated;
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
        return 1; 
    }
}
