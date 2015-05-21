import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {
    public static Queue<Entity> entityList;
    public static Queue<Player> playerList;
    public static final int[] ARROWS = {Input.KEY_UP, Input.KEY_LEFT, Input.KEY_RIGHT};
    public static final int[] WAD = {Input.KEY_W, Input.KEY_A, Input.KEY_D};
    public static Solid floor;
    private static double oldTime = System.currentTimeMillis()/1000.0;
    private static double newTime;
    public static double deltaT;
    public Play() {
 
    }
 
    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {
        entityList = new Queue<Entity>();
        playerList = new Queue<Player>();
        floor = new Solid(50, gc.getHeight() - 200, gc.getWidth()-100, gc.getHeight());
        Player p1 = new Player(600, 210, 66, 132, "img/char1sprite.png", ARROWS);
        Player p2 = new Player(180, 210, 66, 132, "img/char2sprite.png", WAD);
        playerList.enqueue(p1);
        playerList.enqueue(p2);
        entityList.enqueue(floor);
    }
 
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {
        g.setColor(Color.white);
        g.fillRect(50, gc.getHeight() - 200, gc.getWidth()-100, gc.getHeight());
        for (Player player : playerList) {
            player.drawThis();
        }
    }
 
    public void update(GameContainer gc, StateBasedGame sbg, int delta)
            throws SlickException {
        newTime = System.currentTimeMillis()/1000.0;
        deltaT = (newTime - oldTime);
        oldTime = newTime;
        for (Player player : playerList) {
            player.control(gc, delta);
        }
    }
 
    public int getID() {
        return 0;
    }
}