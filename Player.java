import greenfoot.*;

public class Player extends Actor implements Lifeform {
    private int x = 200;
    private int y = 200;
    public static boolean keyHeld = false;
    public static String key;

    private static final String[] IDLE_FRAMES = { "HeroIdle0.png", "HeroIdle1.png", "HeroIdle2.png", "HeroIdle3.png", "HeroIdle4.png", "HeroIdle5.png", "HeroIdle6.png" };
    private static final String[] DEATH_FRAMES = { "HeroDeath0.png", "HeroDeath1.png", "HeroDeath2.png", "HeroDeath3.png", "HeroDeath4.png", "HeroDeath5.png", "HeroDeath6.png", "HeroDeath7.png", "HeroDeath8.png", "HeroDeath9.png", "HeroDeath10.png", "HeroDeath11.png" };
    private static final String[] HIT_FRAMES = { "HeroHit0.png", "HeroHit1.png", "HeroHit2.png", "HeroHit3.png" };
    private static final String[] WALK_FRAMES = { "HeroWalk0.png", "HeroWalk1.png", "HeroWalk2.png", "HeroWalk3.png", "HeroWalk4.png", "HeroWalk5.png", "HeroWalk6.png", "HeroWalk7.png" };
    private static final String[] ATTACK_FRAMES = { "HeroAttack1-0.png", "HeroAttack1-1.png", "HeroAttack1-2.png", "HeroAttack1-3.png", "HeroAttack1-4.png", "HeroAttack1-5.png" };

    private int animationFrame = 0;
    private int frameCounter = 0;
    private String[] currentAnimation = IDLE_FRAMES;
    private boolean isAnimating = false;

    public void act() {
        key = Greenfoot.getKey();
        if (key != null && !keyHeld) {
            keyHeld = true;
            movePlayer(key);
            if (!isAnimating) {
                heroWalk(); // Play walk animation during movement
            }
        } else if (key == null) {
            keyHeld = false;
            if (!isAnimating) {
                heroIdle(); // Default to idle animation when not moving
            }
        }
        playAnimation();
    }

    private void movePlayer(String key) {
        int x = getX();
        int y = getY();

        switch (key) {
            case "a" -> x = Math.max(x - 31, 30);
            case "d" -> x = Math.min(x + 31, 372);
            case "w" -> y = Math.max(y - 32, 52);
            case "s" -> y = Math.min(y + 32, 340);
        }

        updatePosition(x, y);
        GameStateManager.playerX=x;
        GameStateManager.playerY=y;
    }

    @Override
    public void updatePosition(int newX, int newY) {
        x = newX;
        y = newY;
        setLocation(x, y);
    }

    @Override
    public int getXPosition() {
        return x;
    }

    @Override
    public int getYPosition() {
        return y;
    }

    // Animation methods
    public void heroIdle() {
        setAnimation(IDLE_FRAMES);
    }

    public void heroDeath() {
        setAnimation(DEATH_FRAMES);
    }

    public void heroHit() {
        setAnimation(HIT_FRAMES);
    }

    public void heroWalk() {
        setAnimation(WALK_FRAMES);
    }

    public void heroAttack() {
        setAnimation(ATTACK_FRAMES);
    }

    private void setAnimation(String[] frames) {
        currentAnimation = frames;
        animationFrame = 0;
        isAnimating = true;
    }

    private void playAnimation() {
        if (isAnimating) {
            if (frameCounter++ % 10 == 0) { // Adjust the speed of animation (higher -> slower)
                setImage(currentAnimation[animationFrame]);
                animationFrame++;
                if (animationFrame >= currentAnimation.length) {
                    animationFrame = 0;
                    isAnimating = false; // Stop animating after completing the sequence
                }
            }
        }
    }
}
