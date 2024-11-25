import greenfoot.*;

public class Enemy extends Actor implements Lifeform {
    int x=Greenfoot.getRandomNumber(400);
    int y=Greenfoot.getRandomNumber(600);
    if(x%20!=10 || x==400){
        x=Greenfoot.getRandomNumber(400);
    }
    else if(y%20!=10 || y>=390) {
        y=Greenfoot.getRandomNumber(600); 
    }
    public void act(){
        movement(x,y);
        setLocation(x,y);
    }
}
