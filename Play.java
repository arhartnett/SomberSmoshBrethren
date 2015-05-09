import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {
    public Player p1;
    public Player p2;
    public static Solid floor = new Solid(0,300, 800, 600);
    public Play() {
 
    }
 
    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {
        p1 = new Player(600, 210, 22, 44, "img/char1sprite.png");
        //p2 = new Player(180, 210, 22, 44, "img/char2.png");
    }
 
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {
        p1.drawThis();
        //p2.drawThis();
 
    }
 
    public void update(GameContainer gc, StateBasedGame sbg, int delta)
            throws SlickException {
        p1.walkLeft.update(delta);
        p1.control(gc);
        /*if (gc.getInput().isKeyDown(Input.KEY_A)) {
            p2.xv = -1 * p2.speed;
        }
        else if (gc.getInput().isKeyDown(Input.KEY_D)) {
            p2.xv = p2.speed;
        }
        else p2.xv = 0;
        if (gc.getInput().isKeyDown(Input.KEY_W)) {
            p2.jump();
        }*/
        p1.movePlayer();
        //p2.movePlayer();
        //p1.adjustTo(p2);
        // TODO: Some sort of controls would go here
    }
 
    public int getID() {
        return 0;
    }
}