package World;

import graphics.Graphics;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class World {

    private static ConcurrentLinkedQueue<Tile> tiles = new ConcurrentLinkedQueue<Tile>();
    private static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    public static void update(){
        //System.out.println("update");
        for (GameObject go: gameObjects){
            go.update();
        }
    }
    public static void render(){
        //Graphics.fillRect(0,0,1,1);

        for (GameObject go: gameObjects){
            go.render();
        }
        for (Tile tile: tiles){
            tile.render();
        }
    }

    public static void addObject(GameObject go){
        gameObjects.add(go);
    }
    public static void addTile(Tile go){
        tiles.offer(go);
    }


}
