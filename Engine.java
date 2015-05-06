import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Engine extends BasicGame {
    private static final String TITLE = "Somber Smosh Brethren";
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
    public Engine(String title) {
        super(title);
    }

    public static void main(String[] args) {

        try {
            AppGameContainer game = new AppGameContainer(new Engine(TITLE));
            game.setMaximumLogicUpdateInterval(60);
            game.setDisplayMode(WIDTH, HEIGHT, false);
            game.setTargetFrameRate(60);
            game.setAlwaysRender(true);
            game.setVSync(true);
            game.setShowFPS(true);
            game.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public void init(GameContainer gc) throws SlickException {}
    public void render(GameContainer gc, Graphics g) throws SlickException {}
    public void update(GameContainer gc, int delta) throws SlickException {}
}