import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {
    public Player p1;
    public Player p2;
    public Play() {
 
    }
 
    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {
        p1 = new Player(600, 200, 22, 44, "img/char1.png");
        p2 = new Player(180, 200, 22, 44, "img/char2.png");
    }
 
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {
        p1.drawThis();
        p2.drawThis();
 
    }
 
    public void update(GameContainer gc, StateBasedGame sbg, int delta)
            throws SlickException {
        if (gc.getInput().isKeyDown(Input.KEY_LEFT)) {
            p1.xv = -1 * p1.speed;
        }
        else if (gc.getInput().isKeyDown(Input.KEY_RIGHT)) {
            p1.xv = p1.speed;
        }
        else p1.xv = 0;
        if (gc.getInput().isKeyDown(Input.KEY_UP)) {
            p1.jump();
        }
        if (gc.getInput().isKeyDown(Input.KEY_A)) {
            p2.xv = -1 * p2.speed;
        }
        else if (gc.getInput().isKeyDown(Input.KEY_D)) {
            p2.xv = p2.speed;
        }
        else p2.xv = 0;
        if (gc.getInput().isKeyDown(Input.KEY_W)) {
            p2.jump();
        }
        p1.movePlayer();
        p2.movePlayer();
        p1.adjustTo(p2);
        // TODO: Some sort of controls would go here
    }
 
    public int getID() {
        return 0;
    }
}