package Engine;

import World.World;
import graphics.Renderer;
import test.TestPlayer;
import World.Tile;

public class Main {

    public static void main(String[] args){

        Renderer.init();
        GameLoop.start();

        for (int y = -Math.round(Renderer.unitsTall/2/Renderer.STEP); y < Math.round(Renderer.unitsTall/2/Renderer.STEP); y++){
            for (int x = -Math.round(Renderer.unitsWide/2/Renderer.STEP); x < Math.round(Renderer.unitsWide/2/Renderer.STEP); x++){
                Tile tile = new Tile();
                tile.width=Renderer.STEP;
                tile.height=Renderer.STEP;
                tile.x = tile.width * x;
                tile.y = tile.height * y;
                //tile.update();
                World.addTile(tile);
            }
        }
        World.update();
        //test code
        //World.addTile(new GrassTile());
        TestPlayer tp=new TestPlayer();
        tp.width=0;
        tp.height=0;
        World.addObject(tp);

    }
}
