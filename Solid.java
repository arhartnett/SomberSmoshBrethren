import java.awt.*;


public class Solid extends Entity{
    public int x2;
    public int y2;
    public java.awt.Rectangle hitbox;
    
    public Solid (int xa, int ya, int xb, int yb)
    {
        x = xa;
        y = ya;
        x2 = xb;
        y2 = yb;
        
        hitbox = new Rectangle(xa, ya, xb-xa, yb-ya);
        
    }
    
    
}
