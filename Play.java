import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {
    public Player p1;
    public Player p2;
    public static final int[] ARROWS = {Input.KEY_UP, Input.KEY_LEFT, Input.KEY_RIGHT};
    public static final int[] WAD = {Input.KEY_W, Input.KEY_A, Input.KEY_D};
    public static Solid floor = new Solid(0,300, 800, 600);
    public Play() {
 
    }
 
    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {
        p1 = new Player(600, 210, 22, 44, "img/char1sprite.png", ARROWS);
        p2 = new Player(180, 210, 22, 44, "img/char2sprite.png", WAD);
    }
 
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {
        p1.drawThis();
        p2.drawThis();
 
    }
 
    public void update(GameContainer gc, StateBasedGame sbg, int delta)
            throws SlickException {
        p1.control(gc, delta);
        p2.control(gc, delta);
    }
 
    public int getID() {
        return 0;
    }
}