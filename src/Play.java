package src;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
 
public class Play extends BasicGameState {
    
    public Play() {
 
    }
 
    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {
 
    }
 
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {
            Player test = new Player(20, 20, "src/lena512.bmp");
            test.drawThis();
 
    }
 
    public void update(GameContainer gc, StateBasedGame sbg, int delta)
            throws SlickException {
        
    }
 
    public int getID() {
        return 0;
    }
}