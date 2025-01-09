import greenfoot.*;

public abstract class Enemy extends Actor implements Lifeform {
    public enum State { IDLE, WALK, ATTACK, HIT, DEATH }

    private State currentState = State.IDLE;
    private int frameIndex = 0; // Current frame of the animation
    private int frameDelay = 8; // Controls animation speed
    private int frameCounter = 0; // Counter to manage delay
    private String[] currentAnimationFrames; // Holds the current animation frames

    private boolean defeated;
    private GameScreen gameScreen;

    public Enemy() {
        updateAnimation();
        this.defeated = false;
        
    }

    @Override
    public void act() {
        updateAnimation();
        
        if (!defeated) {
            if (gameScreen != null) {
                gameScreen.saveGameState(); // Save the game state before transitioning
            }    
            eMovement(Player.keyHeld);
            encounter(Player.class);
        }
    }
    public void gameScreen(GameScreen gameScreen){
        this.gameScreen=gameScreen;
    }

    public void setAnimationFrames(String[] frames) {
        currentAnimationFrames = frames;
        frameIndex = 0;
    }

    private void updateAnimation() {
        if (currentAnimationFrames == null || currentAnimationFrames.length == 0) return;

        frameCounter++;
        if (frameCounter >= frameDelay) {
            frameCounter = 0;
            frameIndex = (frameIndex + 1) % currentAnimationFrames.length;
            setImage(currentAnimationFrames[frameIndex]);
        }
    }

    public void changeState(State newState) {
        if (currentState != newState) {
            currentState = newState;
            loadAnimationForState();
        }
    }

    private void loadAnimationForState() {
        switch (currentState) {
            case IDLE:
                setAnimationFrames(getIdleFrames());
                break;
            case WALK:
                setAnimationFrames(getWalkFrames());
                break;
            case ATTACK:
                setAnimationFrames(getAttackFrames());
                break;
            case HIT:
                setAnimationFrames(getHitFrames());
                break;
            case DEATH:
                setAnimationFrames(getDeathFrames());
                break;
        }
    }

    protected String[] getIdleFrames() {
        return new String[0];
    }

    protected String[] getWalkFrames() {
        return new String[0];
    }

    protected String[] getAttackFrames() {
        return new String[0];
    }

    protected String[] getHitFrames() {
        return new String[0];
    }

    protected String[] getDeathFrames() {
        return new String[0];
    }

    @Override
    public void updatePosition(int newX, int newY) {
        setLocation(newX, newY);
    }

    @Override
    public int getXPosition() {
        return getX();
    }

    @Override
    public int getYPosition() {
        return getY();
    }

    public boolean isDefeated(){
        return this.defeated;
    }
    public abstract int getType();

    public void eMovement(boolean keyHeld) {
        if (keyHeld) {
            String key = Player.key;
            if ("a".equals(key) || "s".equals(key) || "w".equals(key) || "d".equals(key)) {
                movement(this);
                changeState(State.WALK);
            }
        } else {
            changeState(State.IDLE);
        }
    }
    public void encounter(Class<?> Player) {
        if(!defeated&&this.isTouching(Player.class)){
            defeated=true; 
            System.out.println("FIGHT STARTED");
            if (gameScreen != null) {
                gameScreen.saveGameState(); // Save the game state before transitioning
            }   
            Greenfoot.setWorld(new CombatScreen());
        }
    }
}

