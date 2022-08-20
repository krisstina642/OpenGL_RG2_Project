package Engine;

import World.World;
import World.GrassTile;
import graphics.Renderer;
import test.TestPlayer;

public class Main {

    public static void main(String[] args){
        Renderer.init();
        GameLoop.start();

        for (int x = 0; x < 10; x++){
            for (int y = 0; y < 10; y++){
                GrassTile tile = new GrassTile();
                tile.x = tile.width * x;
                tile.y = tile.height * y;
                World.addTile(tile);
            }
        }
        //test code
        //World.addTile(new GrassTile());
        World.addObject(new TestPlayer());

    }
}
