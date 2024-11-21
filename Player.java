import greenfoot.*;
public class Player extends Actor implements Lifeform{
    int x=300;
    int y=200;
    boolean gameOn=false;
    public void act(){
        gameOn=true;
        while(gameOn){
            move(x,y);
        }
        
    }
}
