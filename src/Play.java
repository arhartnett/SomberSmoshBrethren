package src;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
 
public class Play extends BasicGameState {
    public Player p1;
    public Player p2;
    public Play() {
 
    }
 
    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {
        p1 = new Player(20, 100, "src/red.png");
        p2 = new Player(780, 100, "src/blue.png");
        p1.xv = 5;
        p2.xv = -4;
    }
 
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {
        p1.drawThis();
        p2.drawThis();
 
    }
 
    public void update(GameContainer gc, StateBasedGame sbg, int delta)
            throws SlickException {
        p1.movePlayer();
        p2.movePlayer();
        if (p1.checkHit(p2) > 0) {
            p1.xv = 0;
            p2.xv = 0;
            System.out.println(p1.checkHit(p2));
        }
    }
 
    public int getID() {
        return 0;
    }
}