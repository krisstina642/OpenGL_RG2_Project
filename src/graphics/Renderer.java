package graphics;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;
import input.MouseInput;

public class Renderer {
    private static GLWindow window = null;
    private static GLProfile profile= null;

    public static int screenWidth = 640;
    public static int screenHeight = 340;

    public static float unitsWide = 10;

    public static void init(){
        GLProfile.initSingleton();
        profile= GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);

        window = GLWindow.create(caps);
        window.setSize(screenWidth,screenHeight);
        window.setResizable(false);
        window.addGLEventListener(new EventListener());
        window.addMouseListener(new MouseInput());
        //window.requestFocus();

        FPSAnimator animator = new FPSAnimator(window, 60);
        animator.start();

        //window.setFullscreen(true);
        window.setVisible(true);
    }

    public static GLProfile getProfile(){
        return profile;
    }

    public static void main(String[] args){
        init();
    }

    public static int getWindowWidth(){
        return window.getWidth();
    }

    public static int getWindowHeight(){
        return window.getHeight();
    }
}
