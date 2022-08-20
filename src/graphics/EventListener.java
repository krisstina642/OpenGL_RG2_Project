package graphics;

import World.World;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import resource.ImageResource;

public class EventListener implements GLEventListener {

    public static GL2 gl = null;
    public static float x=0;
    public static ImageResource image=null;

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL2 gl2 = glAutoDrawable.getGL().getGL2();
        gl2.glClearColor(0.5f,0,0,1);

        gl2.glEnable(GL2.GL_TEXTURE_2D);
        gl2.glEnable(GL2.GL_BLEND);
        gl2.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
        //image= new ImageResource("/res/image.jpg");
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        gl = glAutoDrawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);



        gl.glTranslatef(-Renderer.cameraX, -Renderer.cameraY,0);
        World.render();
        gl.glTranslatef(Renderer.cameraX, Renderer.cameraY,0);
        //Graphics.fillRect(0,0,2,2);
        //Graphics.setColor(1,0.5f,0.5f,1);
        //Graphics.drawImage(image,0,0,Renderer.unitsWide,Renderer.unitsWide);
        //x+=0.05f;
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {
        GL2 gl=glAutoDrawable.getGL().getGL2();

        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glOrtho(-Renderer.unitsWide/2,Renderer.unitsWide/2,-Renderer.unitsTall/2,Renderer.unitsTall/2,-1,1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }
}
