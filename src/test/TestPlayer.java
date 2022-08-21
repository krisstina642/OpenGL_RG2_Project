package test;

import Engine.GameLoop;
import World.GameObject;
import com.jogamp.newt.event.KeyEvent;
import graphics.Renderer;
import input.KeyInput;
import input.MouseInput;

public class TestPlayer extends GameObject {

    public TestPlayer(){
        red=1;
        green=0;
        blue=1;
    }

    @Override
    public void update(){
        float xInput = 0;
        float yInput = 0;

        if (KeyInput.isKeyPressed(KeyEvent.VK_A)){
            xInput --;
        }
        if (KeyInput.isKeyPressed(KeyEvent.VK_D)){
            xInput ++;
        }
        if (KeyInput.isKeyPressed(KeyEvent.VK_W)){
            yInput ++;
        }
        if (KeyInput.isKeyPressed(KeyEvent.VK_S)){
            yInput --;
        }

        float a= GameLoop.updateDelta();
        x += xInput * a;
        y += yInput * a;
        rotation = (float) Math.toDegrees(Math.atan2(MouseInput.getWorldX() - x ,MouseInput.getWorldY() - y));

        // Da se kamera pomera
            Renderer.cameraX = x;
            Renderer.cameraY = y;

       // Renderer.cameraX +=1.0f * GameLoop.updateDelta();
       // x+=0.1f;
    }

   /* @Override
    public void render() {

        //Graphics.fillRect(x,y,width,height);
    }*/
}
