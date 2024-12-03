import greenfoot.*;

public class FogTile extends Actor {
    private boolean isHidden = true;

    public void setVisibility(boolean hidden) {
        if (hidden != isHidden) {
            isHidden = hidden;
            if (isHidden) {
                setImage("images/FOW-Tile.png");
            } else {
                setImage((GreenfootImage) null); 
            }
        }
    }
}

