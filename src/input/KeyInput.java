package input;

import com.jogamp.newt.event.InputEvent;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class KeyInput implements KeyListener {

    private static boolean[] keys = new boolean[256];
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if( 0 == ( InputEvent.AUTOREPEAT_MASK & keyEvent.getModifiers() ) )  { keys[keyEvent.getKeyCode()] = true;}
    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        System.out.println(keyEvent.getKeyCode());
        if( 0 == ( InputEvent.AUTOREPEAT_MASK & keyEvent.getModifiers() ) )  { keys[keyEvent.getKeyCode()] = false;}
    }

    public static boolean isKeyPressed(int keyCode){
        return keys[keyCode];
    }
}
