package src;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
 
public class Main extends StateBasedGame{
   
   public static final String gamename = "Somber Smosh Brethren";
   public static final int play = 0;
   public static final int xSize = 800;
   public static final int ySize = 600;
   public static final int frameRate = 60;
   
   public Main(String gamename){
      super(gamename);
      this.addState(new Play());
   }
   
   public void initStatesList(GameContainer gc) throws SlickException{
      this.getState(play).init(gc, this);
      this.enterState(play);
   }
   
   public static void main(String[] args) {
      AppGameContainer appgc;
      try{
         appgc = new AppGameContainer(new Main(gamename));
         appgc.setDisplayMode(xSize, ySize, false);
         appgc.setTargetFrameRate(frameRate);
         appgc.start();
      }catch(SlickException e){
         e.printStackTrace();
      }
   }
}