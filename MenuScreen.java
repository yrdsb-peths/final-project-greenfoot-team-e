import java.io.IOException;

import greenfoot.*;

public class MenuScreen extends World {
    public MenuScreen() {
        super(400, 600, 1);
        addObject(new Button(this::goToGameScreen, "StartButtonIdle.png", 114, 56), 200, 350);
        addObject(new Button(this::helpButton, "help-button.png",114,56),200,450);
        Label titleLabel = new Label("Lurking Below", 40);
        addObject(titleLabel, 200, 175);
        GameStateManager.currentLevel = 1;

        try {
            ScannerClass.clearFile("Inventory.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToGameScreen() {
        Greenfoot.setWorld(new GameScreen());
    }
    public void helpButton(){
        addObject(new HelpImage(), 300,300);
    }
}
