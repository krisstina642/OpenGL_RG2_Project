package graphics;


import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import input.KeyInput;
import input.MouseInput;

public class Renderer {
    private static GLWindow window = null;
    private static GLProfile profile= null;

    public static int screenWidth = 1080;
    public static int screenHeight = 680;
    public static float STEP=1f/180f;
    public static int MAX_NUM_OF_ITTERATIONS =5;

    public static float unitsWide = 6;
    public static float unitsTall;

    public static float cameraX = 0;
    public static float cameraY = 0;

    public static void init(){
        GLProfile.initSingleton();
        profile= GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);

        window = GLWindow.create(caps);
        window.setSize(screenWidth,screenHeight);
        window.setResizable(false);
        window.addGLEventListener(new EventListener());
        window.addMouseListener(new MouseInput());
        window.addKeyListener(new KeyInput());
        window.requestFocus();
        unitsTall = getWindowHeight()/(getWindowWidth()/unitsWide);
       // FPSAnimator animator = new FPSAnimator(window, 60);
       // animator.start();

        window.setFullscreen(false);
        window.setVisible(true);

    }

    public static void render(){
        if (window==null){
            return;
        }
        window.display();
    }

    public static GLProfile getProfile(){
        return profile;
    }

   /* public static void main(String[] args){
        init();
    } */

    public static int getWindowWidth(){
        return window.getWidth();
    }

    public static int getWindowHeight(){
        return window.getHeight();
    }
}
