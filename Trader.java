import greenfoot.*; 

public class Trader extends Actor {
    public Trader() {
        GreenfootImage image = new GreenfootImage("images/TraderLarger.png");
        if (isTouching(Player.class)) {
            GameScreen.text.setValue("Old man says hello!");
        }
        
        // Scale the image
        int newWidth = (int) (image.getWidth() * 0.70);
        int newHeight = (int) (image.getHeight() * 0.70);
        image.scale(newWidth, newHeight);
        
        setImage(image);
    }
}
