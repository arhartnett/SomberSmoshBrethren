import java.awt.*;

public class Entity {
    public int x;
    public int y;
    public double xv = 0.0;
    public double yv = 0.0;
    public int h;
    public int w;
    public double oldTime;
    public double newTime;
    public double deltaT;
    public String img;
    public Rectangle hitbox;
    
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public void move() {
        this.x += this.xv*deltaT;
        this.y += this.yv*deltaT;
    }
    /*
    0 = not hitting
    1 = hit from left
    2 = hit from right
    3 = hit from top
    4 = hit from bottom
     */
    public int checkHit(Entity that) {
        Rectangle nextX = new Rectangle((int)(this.x + this.xv), this.y,
                this.w, this.h);
        Rectangle nextY = new Rectangle(this.x, (int)(this.y + this.yv),
                this.w, this.h);
        boolean nextXtest = nextX.intersects(that.hitbox);
        boolean nextYtest = nextY.intersects(that.hitbox);
        if (nextXtest && nextYtest) {
            if (this.xv > this.yv) {
                if (this.xv > 0) return 1;
                else return 2;
            }
            else {
                if (this.yv > 0) return 3;
                else return 4;
            }
        }
        else if (nextXtest) {
            if (this.xv > 0) return 1;
            else return 2;

        }
        else if (nextYtest) {
            if (this.yv > 0) return 3;
            else return 4;
        }
        else return 0;
    }
    
    public void update() {
        
        
    }
    
    public String toString() {
     return ("(" + x + ", " + y + ")");
    }
}
