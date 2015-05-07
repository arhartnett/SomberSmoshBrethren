package src;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player extends Entity{
    public Image sprite;
    public Player(int x1, int y1, String imgName) throws SlickException
    {
        x = x1;
        y = y1;
        img = imgName;
        
        sprite = new Image(img);
        
     
    }
    
    
    public void drawThis()
    {
        sprite.draw(x, y);
    }
}
