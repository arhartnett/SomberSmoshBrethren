package src;

public class Entity {
    public int x;
    public int y;
    public double xv;
    public double yv;
    public int h;
    public int w;
    public String img;
    
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    public String toString() {
     return (x + ", " + y);
    }
}
