import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import greenfoot.*;
// combat screen where player fights the enemy
public class CombatScreen extends World {
    private boolean defeated=true;
    private List<Heart> hearts = new ArrayList<>();
    private List<Heart> enemyHearts = new ArrayList<>();
    private static final Random random = new Random();
    public CombatScreen(){   
        super(400,600,1);
        setBackground("Background.png");
        switch (GameStateManager.currentEnemy) {
            //sets the stats for the enemies. Case 0 is skeleton, 1 is slime, and 2 is zombie
            case 0:
                CombatManager.currentEnemyHP=CombatManager.skeletonHP;
                CombatManager.currentEnemyMaxHP=CombatManager.skeletonHP;
                CombatManager.currentEnemySPD=CombatManager.skeletonSPD;
                CombatManager.currentEnemyATK=CombatManager.skeletonATK;
                CombatManager.currentEnemyACC=CombatManager.skeletonACC;
                break;
            case 1:
                CombatManager.currentEnemyHP=CombatManager.slimeHP;
                CombatManager.currentEnemyMaxHP=CombatManager.slimeHP;
                CombatManager.currentEnemySPD=CombatManager.slimeSPD;
                CombatManager.currentEnemyATK=CombatManager.slimeATK;
                CombatManager.currentEnemyACC=CombatManager.slimeACC;
                break;
            case 2:
            default:
                CombatManager.currentEnemyHP=CombatManager.zombieHP;
                CombatManager.currentEnemyMaxHP=CombatManager.zombieHP;
                CombatManager.currentEnemySPD=CombatManager.zombieSPD;
                CombatManager.currentEnemyATK=CombatManager.zombieATK;
                CombatManager.currentEnemyACC=CombatManager.zombieACC;
                break;
                
        }

        EnemyCombatSprite enemy=new EnemyCombatSprite();
        addObject(enemy,300,300);
        addObject(new Button(this::attack, "Attack-button.png",150, 100), 100, 500);
        initializeHearts();
        initializeEnemyHearts();
    }
    public void returnGameScreen(){
        //return to game screen
        if(CombatManager.currentEnemyHP<=0){
            System.out.println("You defeated the enemy!");
            Greenfoot.setWorld(new GameScreen());
        }
    }
    public void attack(){
        //player attack mechanics
        int playerACC = Greenfoot.getRandomNumber(99);
        int enemyACC = Greenfoot.getRandomNumber(99);
        if(playerACC<CombatManager.playerACC){
            CombatManager.currentEnemyHP-=CombatManager.playerATK+CombatManager.swordType;
            int totalDamage=CombatManager.playerATK+CombatManager.swordType;
            System.out.println("You dealt "+totalDamage+" damage");
        }else{
            System.out.println("You missed!");
        }
        if(enemyACC<CombatManager.currentEnemyACC){
            CombatManager.playerHP-=CombatManager.currentEnemyATK;
            System.out.println("The enemy dealt "+CombatManager.currentEnemyATK+" damage");
        }else{
            System.out.println("Enemy missed!");
        }

        initializeHearts();
        initializeEnemyHearts();
        if(CombatManager.playerHP<=0){
            handleGameOver();
        }
        returnGameScreen();
    }
    private void initializeEnemyHearts() {
        enemyHearts.clear();
        int heartsCount = (int) Math.ceil(CombatManager.currentEnemyMaxHP / 2.0); // Total hearts needed
        for (int i = 0; i < heartsCount; i++) {
            Heart heart = new Heart();
            if (i < CombatManager.currentEnemyHP / 2) {
                heart.setFull(); // Full heart
            } else if (i == CombatManager.currentEnemyHP / 2 && CombatManager.currentEnemyHP % 2 != 0) {
                heart.setHalf(); // Half heart
            } else {
                heart.setEmpty(); // Empty heart
            }
            enemyHearts.add(heart);
            addObject(heart, 375 - (i * 20), 200); // Adjust positions as needed
        }
    }
    private void initializeHearts() {
        int heartsCount = (int) Math.ceil(CombatManager.playerHPMax / 2.0); // Total hearts needed
        for (int i = 0; i < heartsCount; i++) {
            Heart heart = new Heart();
            if (i < CombatManager.playerHP / 2) {
                heart.setFull(); // Full heart
            } else if (i == CombatManager.playerHP / 2 && CombatManager.playerHP % 2 != 0) {
                heart.setHalf(); // Half heart
            } else {
                heart.setEmpty(); // Empty heart
            }
            hearts.add(heart);
            addObject(heart, 375 - (i * 20), 420); // Adjust positions as needed
        }
    }
    private void handleGameOver() {
        System.out.println("Game Over!");
        Greenfoot.stop(); // Stop the game
    }
}

