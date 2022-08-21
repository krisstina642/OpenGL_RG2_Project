package input;


import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import graphics.Renderer;

public class MouseInput implements MouseListener {

    private static int x = 0;
    private static int y = 0;

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public static float getWorldX(){
        return Renderer.unitsWide / Renderer.getWindowWidth() * x - Renderer.unitsWide/2 + Renderer.cameraX;
    }

    public static float getWorldY(){
        Renderer.unitsTall = Renderer.unitsWide * ((float) ((float)Renderer.getWindowHeight()/(float)Renderer.getWindowWidth()));
        return Renderer.unitsTall / Renderer.getWindowHeight() * y - Renderer.unitsTall/2 + Renderer.cameraY;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getX()+ " "+mouseEvent.getY());
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        x= mouseEvent.getX();
        y= mouseEvent.getY();
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseWheelMoved(MouseEvent mouseEvent) {

    }
}
