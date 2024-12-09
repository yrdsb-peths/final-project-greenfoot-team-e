import greenfoot.*;

public class MenuScreen extends World 
{
    private Label titleLabel;
    public MenuScreen() {
        super(400,600,1);
        TileWorld tileWorld = new TileWorld();
        tileWorld.generateRoomIn(this);
        addObject(new Button(this::goToGameScreen, "StartButtonIdle.png",114, 56), 300, 350);
        Label titleLabel = new Label("Lurking Below", 60);
        addObject(titleLabel, 300, 175);
    }

    public void goToGameScreen() 
    {
        //sets to the game screen when a button is pressed
        Greenfoot.setWorld(new GameScreen()); 
    }
}
