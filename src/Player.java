package src;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.awt.*;

public class Player extends Entity{
    public Image sprite;
    public Rectangle hitbox;
    public Player(int x1, int y1, String imgName) throws SlickException
    {
        x = x1;
        y = y1;
        img = imgName;
        
        sprite = new Image(img);
        w = sprite.getWidth();
        h = sprite.getHeight();
        hitbox = new Rectangle(x, y, w, h);
    }

    // also updates hitbox position
    public void movePlayer() {
        this.hitbox.x += this.xv;
        this.hitbox.y += this.yv;
        this.move();
    }

    public int checkHit(Player that) {
        if (this.hitbox.intersects(that.hitbox)) {
            return 1;
        }
        // TODO: more int options for what side the collision occurs on
        else return 0;
    }
    
    public void drawThis()
    {
        sprite.draw(x, y);
    }
}
