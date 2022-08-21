package input;

import World.World;
import com.jogamp.newt.event.InputEvent;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import graphics.Renderer;

public class KeyInput implements KeyListener {

    private static boolean[] keys = new boolean[256];
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode()==139){
            if(Renderer.MAX_NUM_OF_ITTERATIONS<100) Renderer.MAX_NUM_OF_ITTERATIONS++;
            System.out.println(Renderer.MAX_NUM_OF_ITTERATIONS);
            World.update();
        }
        if (keyEvent.getKeyCode()==140){
            if(Renderer.MAX_NUM_OF_ITTERATIONS>1) Renderer.MAX_NUM_OF_ITTERATIONS--;
            System.out.println(Renderer.MAX_NUM_OF_ITTERATIONS);
            World.update();
        }
        //if( 0 == ( InputEvent.AUTOREPEAT_MASK & keyEvent.getModifiers() ) )  { keys[keyEvent.getKeyCode()] = true;}
    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        //System.out.println(keyEvent.getKeyCode());
        //if( 0 == ( InputEvent.AUTOREPEAT_MASK & keyEvent.getModifiers() ) )  { keys[keyEvent.getKeyCode()] = false;}
    }

    public static boolean isKeyPressed(int keyCode){
        return keys[keyCode];
    }
}
