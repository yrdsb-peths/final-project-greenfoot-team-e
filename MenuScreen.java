import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import greenfoot.*;

public class MenuScreen extends World {
    //Music
    GreenfootSound backgroudMusic = new GreenfootSound("backgroundMusic.wav");
    public MenuScreen() {
        //setup the menu screen
        super(400, 600, 1);
        setBackground("MenuBackground.png");
        addObject(new Button(this::goToGameScreen, "StartButtonIdle.png", 114, 56), 200, 450);
        addObject(new Button(this::helpButton, "help-button.png",150,100),200,550);
        Label titleLabel = new Label("Lurking Below", 40);
        addObject(titleLabel, 200, 175);
        GameStateManager.currentLevel = 1;
        backgroudMusic.playLoop();
        try {
            ScannerClass.clearFile("Inventory.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Creates new game
    public void goToGameScreen() {
        newGame();
        Greenfoot.setWorld(new GameScreen());
        backgroudMusic.pause();
        
    }
    public void helpButton(){
        addObject(new HelpImage(this), 200,300);
    }
    //reset stats
    public void newGame(){
        CombatManager.playerHP=10;
        CombatManager.playerHPMax=10;
        CombatManager.armorType=0;
        CombatManager.swordType=0;
        GameStateManager.playerX=0;
        GameStateManager.playerY=0;
        GameStateManager.currentLevel = 1;
        GameStateManager.treasureChestX=0;
        GameStateManager.treasureChestY=0;
        GameStateManager.treasureExists=false;
        GameStateManager.treasureTypeOpen=null;
        GameStateManager.treasureTypeClosed=null;
        GameStateManager.chestLooted=false;
        GameStateManager.traderX=0;
        GameStateManager.traderY=0;
        GameStateManager.traderExists=false;
        GameStateManager.entranceX=0;
        GameStateManager.entranceY=0;
        GameStateManager.levelSeeds.clear();
        GameStateManager.enemyData.clear();
        GameStateManager.currentEnemy=0;
        CombatManager.playerHP=10;
        CombatManager.playerATK=1;
        CombatManager.playerHealthPot=1;
        GameStateManager.totalEnemiesKilled=0;
    }
}