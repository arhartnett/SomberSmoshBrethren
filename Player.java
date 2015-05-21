import org.newdawn.slick.*;
import org.newdawn.slick.Image;

import java.awt.*;

public class Player extends Entity{
    public static final double GRAVITY = 30.0*70.0;
    public SpriteSheet sheet;
    public Image sprite;
    public org.newdawn.slick.Animation walkLeft;
    public org.newdawn.slick.Animation walkRight;
    private double speed;
    private double jumpSpeed;
    private int state;
    public boolean isJumping;
    public boolean isFalling;
    public static final double pixRatio = 70.0;
   // public double oldTime = System.currentTimeMillis();
    int[] controls;

    public Player(int x1, int y1, int width, int height, String imgName, int[] givenControls) throws SlickException
    {
        state = 0;
        x = x1;
        y = y1;
        controls = givenControls;
        sheet = new SpriteSheet(imgName, 48, 48);
        sprite = sheet.getSprite(0, 0).getScaledCopy(3);
        walkLeft = new org.newdawn.slick.Animation();
        walkRight = new org.newdawn.slick.Animation();
        int animationSpeed = 250;
        for(int col = 2; col <= 4; col ++){
            walkRight.addFrame(sheet.getSprite(col, 0).getScaledCopy(3), animationSpeed);
        }
        walkRight.addFrame(sheet.getSprite(3,0).getScaledCopy(3), animationSpeed);
        for(int col = 2; col <= 4; col ++){
            walkLeft.addFrame(sheet.getSprite(col, 1).getScaledCopy(3), animationSpeed);
        }
        walkLeft.addFrame(sheet.getSprite(3, 1).getScaledCopy(3), animationSpeed);
        speed = 5.0*pixRatio;
        jumpSpeed = -12.0*pixRatio;
        isJumping = false; isFalling = true;

        w = width;
        h = height;
        hitbox = new Rectangle((x + (w/2)), (y + (y-h)), w, h);
    }

    private void gravCalc() {
        if (this.isFalling || this.isJumping) {
            this.yv += GRAVITY*Play.deltaT;
        }
        if (isJumping && this.yv <= 0) {
            this.isJumping = false;
            this.isFalling = true;
        }
        // basic floor
        if (this.hitbox.intersects(Play.floor.hitbox)) {
            this.y = Play.floor.y - (this.h+20);
            this.yv = 0.0;
            this.hitbox.y = Play.floor.y - (this.h+20);
            this.isJumping = false;
            this.isFalling = false;
        }
    }
    public void jump() {
        if (!this.isFalling) {
            this.yv = this.jumpSpeed;
            this.isJumping = true;
        }
    }
    public void control(GameContainer gc, int delta) {
        if (gc.getInput().isKeyDown(this.controls[1])) {
            this.xv = -1 * this.speed;
            this.state = 1;
            this.walkLeft.update(delta);
        }
        else if (gc.getInput().isKeyDown(this.controls[2])) {
            this.xv = this.speed;
            this.state = 2;
            this.walkRight.update(delta);
        }
        else {
            this.xv = 0;
            this.state = 0;
        }
        if (gc.getInput().isKeyDown(this.controls[0])) {
            this.jump();
            this.state = 3;
        }
        this.movePlayer();
    }
    // also updates hitbox position
    public void movePlayer() {
        this.hitbox.x += this.xv*Play.deltaT;
        this.hitbox.y += this.yv*Play.deltaT;
        this.move();
        this.gravCalc();
    }
    public void move() {
        this.x += this.xv*Play.deltaT;
        this.y += this.yv*Play.deltaT;
    }
    
    public void update(){

        movePlayer();
        
        
        
    }
    
    /*
      * returns 1 if other player hits from left, 2 if from right, 3 if from
      * top, 4 if from the bottom. Vertical/ horizontal distinction is based
      * on which has the greater net velocity.
     */
    public int checkHit(Player that) {
        if (this.hitbox.intersects(that.hitbox)) {
            if (Math.abs(this.xv) + Math.abs(that.xv) +
                    Math.abs(this.yv) + Math.abs(that.yv) == 0) {
                return 0;
            }
            if ((Math.abs(this.xv) + Math.abs(that.xv)) >
                    (Math.abs(this.yv) + Math.abs(that.yv))) { // if horizontal
                if (this.x > that.x) return 1;
                else                 return 2;
            }
            else {
                if (this.y > that.y) return 3;
                else                 return 4;
            }
        }
        else return 0;
    }

    /*
    uses the checkHit, but also adjusts the position to avoid overlap.
     */
    public void adjustTo(Player that) {
        int compare = this.checkHit(that);
        if (compare > 0) System.out.println("collision");
        if (compare == 0) return;
        else if (compare == 1) { // left
            this.x = that.x + that.w;
            this.xv = 0;
            that.xv = 0;
        }
        else if (compare == 2) { //right
            this.x = that.x - this.w;
            this.xv = 0;
            that.xv = 0;
        }
        else if (compare == 3) { // down
            this.y = that.y + that.h;
            this.yv = 0;
            that.yv = 0;
        }
        else if (compare == 4) { // up
            this.y = that.y - this.h;
            this.yv = 0;
            that.yv = 0;
        }
    }
    
    public void drawThis()
    {
        if (this.state == 0) this.sprite.draw(x, y);
        else if (this.state == 1) this.walkLeft.draw(x, y);
        else if (this.state == 2) this.walkRight.draw(x, y);
        else this.sprite.draw(x, y);

    }
}
