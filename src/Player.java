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
    /*
      * returns 1 if other player hits from left, 2 if from right, 3 if from
      * top, 4 if from the bottom. Vertical/ horizontal distinction is based
      * on which has the greater net velocity.
     */
    public int checkHit(Player that) {
        if (this.hitbox.intersects(that.hitbox)) {
            if ((Math.abs(this.xv) + Math.abs(that.xv)) >
                    (Math.abs(this.yv) + Math.abs(that.yv))) { // if horizontal
                if (this.x > that.x) return 1;
                else                 return 2;
            }
            else {
                if (this.y > that.y) return 3;
                else                 return 4;
            }
        }
        else return 0;
    }
    
    public void drawThis()
    {
        sprite.draw(x, y);
    }
}
