import greenfoot.*;
public class Player extends Actor {
    int x=300;
    int y=200;
    boolean gameOn=false;
    public void act(){
        gameOn=true;
        while(gameOn){
            move();
        }
    }
    public void move(){
        if(Greenfoot.isKeyDown("a")){
            x-=50;
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            x+=50;
        }
        else if(Greenfoot.isKeyDown("w"))
        {
            y+=50;
        }
        else if(Greenfoot.isKeyDown("s"))
        {
            y-=50;
        }
    }
}
