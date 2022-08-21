package World;

import graphics.Graphics;

public class GameObject {

    public float x;
    public float y;

    public float width = 1;
    public float height = 1;
    public float red=1;
    public float green=1;
    public float blue=1;
    public float a=1;

    public float rotation = 0;

    public void update(){
    }

    public void render(){
        Graphics.setColor(red,green,blue,a);
        Graphics.fillRect(x,y,width,height);
      /*  animations[currentAnimation].play();
        Graphics.setRotation(rotation);
        Graphics.drawImage(animations[currentAnimation].getImage(),x,y,width,height);
        Graphics.setRotation(0);*/

    }
}
