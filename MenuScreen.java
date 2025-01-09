import greenfoot.*;

public class MenuScreen extends World 
{
    public MenuScreen() {
        super(400,600,1);
        addObject(new Button(this::goToGameScreen, "StartButtonIdle.png",114, 56), 200, 350);
        Label titleLabel = new Label("Lurking Below", 40);
        addObject(titleLabel, 200, 175);
        GameStateManager.currentLevel=1;
    }

    public void goToGameScreen() 
    {
        //sets to the game screen when a button is pressed
        Greenfoot.setWorld(new GameScreen()); 
    }
}
