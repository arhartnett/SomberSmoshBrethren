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
    
    public void update() {
        
        
    }
    
    public String toString() {
     return ("(" + x + ", " + y + ")");
    }
}
