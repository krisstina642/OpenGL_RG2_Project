package test;

import Engine.GameLoop;
import World.GameObject;
import com.jogamp.newt.event.KeyEvent;
import graphics.Animation;
import graphics.Graphics;
import graphics.Renderer;
import input.KeyInput;
import input.MouseInput;
import resource.ImageResource;

public class TestPlayer extends GameObject {

    public TestPlayer(){
        animations = new Animation[1];
        animations[0] = new Animation();
        animations[0].frames = new ImageResource[2];
        animations[0].frames[0]=new ImageResource("/res/image.jpg");
        animations[0].frames[1]=new ImageResource("/res/image2.jpg");
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
