import greenfoot.*;
public class CombatScreen extends World {
    public CombatScreen(){
    super(400,600,1);
    addObject(new Button(this::returnGameScreen, "StartButtonIdle.png",114, 56), 200, 350);
    }
    public void returnGameScreen(){
        Greenfoot.setWorld(new GameScreen());
    }
}

