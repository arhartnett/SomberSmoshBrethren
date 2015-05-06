import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*; // NULL

import java.nio.ByteBuffer;

import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWvidmode;
import org.lwjgl.opengl.GLContext;

import Input.Input;

public class Main implements Runnable{
    private Thread thread;
    public boolean running = true;
    
    private GLFWKeyCallback keyCallback;
    
    
    public Long window;
    
    public static void main(String args[]) {
        Main game = new Main();
        game.start();
    }
    
    public void start()
    {
        running = true;
        thread = new Thread(this, "EndlessRunnder");
        thread.start();
    }
    
    public void init()
    {
        if(glfwInit() != GL_TRUE){
            System.err.println("GLFW initialization failed!");
        }
        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);

        window = glfwCreateWindow(800, 600, "Endless Runner", NULL, NULL);
        
        if(window == NULL){
            System.err.println("Could not create our Window!");
        }
        
        glfwSetKeyCallback(window, keyCallback = new Input());
        
        
        ByteBuffer vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(window, 100, 100);
        
        glfwMakeContextCurrent(window);
        
        glfwShowWindow(window);
        GLContext.createFromCurrent();
        
        glClearColor(0.56f, 0.258f, 0.425f, 1.0f);
        glEnable(GL_DEPTH_TEST);
        
        System.out.println("OpeGL: " + glGetString(GL_VERSION));
        
    }
    
    public void update()
    {
        glfwPollEvents();
        
        if(Input.keys[GLFW_KEY_SPACE]){
            System.out.println("Space key pressed!");
        }
        
    }
    public void render(){
        glfwSwapBuffers(window);
        
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        
    }

    @Override
    public void run(){
        init();
        while(running){
            update();
            render();
            
            
            if(glfwWindowShouldClose(window) == GL_TRUE){
                running = false;
            }
        }
        keyCallback.release();
    }
}
