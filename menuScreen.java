import greenfoot.*;

public class MenuScreen extends World 
{
    private Label titleLabel;
    public MenuScreen() {
        super(400,600,1);
        TileWorld tileWorld = new TileWorld();
        tileWorld.generateRoomIn(this);
        addObject(new Button(this::goToGameScreen, "load-game-button.png",114, 56), 200, 350);
        addObject(new Button(this::goToGameScreen, "start-button.png",114, 56), 200, 250);
        Label titleLabel = new Label("Lurking Below", 40);
        addObject(titleLabel, 200, 175);
    }

    public void goToGameScreen() 
    {
        //sets to the game screen when a button is pressed
        Greenfoot.setWorld(new GameScreen()); 
    }
}
