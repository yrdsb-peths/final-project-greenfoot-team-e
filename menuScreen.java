import greenfoot.*;

public class MenuScreen extends World 
{
    private Label titleLabel;
    public MenuScreen() {
        super(600,400,1);
        setBackground("background.png");
        addObject(new Button(this::goToGameScreen, "StartButtonIdle.png",114, 56), 300, 350);
        Label titleLabel = new Label("Lurking Below", 100);
        addObject(titleLabel, 300, 250);
    }

    public void goToGameScreen() 
    {
        //sets to the game screen when a button is pressed
        Greenfoot.setWorld(new GameScreen()); 
    }
}
