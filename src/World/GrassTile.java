package World;

import graphics.Animation;
import resource.ImageResource;

public class GrassTile extends Tile{

    public GrassTile(){
        animations = new Animation[1];
        animations[0] = new Animation();
        animations[0].frames = new ImageResource[1];
        animations[0].frames[0]=new ImageResource("/res/image.jpg");
    }
}
