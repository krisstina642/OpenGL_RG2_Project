package Engine;

import World.World;
import graphics.Renderer;

public class GameLoop {
    private static boolean running = false;

    private static int updates = 0;
    private static final int MAX_UPDATES = 5;
    private static long lastUpdateTime=0;

    private static int targetFPS = 60;
    private static int targetTime = 1000000000/targetFPS;

    public static void start(){
        Thread thread = new Thread(){
            public void run(){
                running= true;
                int fps=0;
                lastUpdateTime=System.nanoTime();
                long lastFps=System.nanoTime();
                while (running){

                    long currentTime= System.nanoTime();
                    updates=0;

                    while (currentTime-lastUpdateTime >= targetTime){
                        World.update();
                        lastUpdateTime += targetTime;
                        updates++;
                        if (updates> MAX_UPDATES){
                            break;
                        }
                    }
                   // System.out.println("sadasdasdasdsa");
                    Renderer.render();

                /*    fps++;
                    if (System.nanoTime()>=lastFps+ 1000000000){
                        System.out.println(fps);
                        fps=0;
                        lastFps=System.nanoTime();
                    }*/

                    long timeTaken = System.nanoTime()-currentTime;
                    if (targetTime>timeTaken){
                        try {
                            Thread.sleep((targetTime - timeTaken) / 1000000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                 /*   long startTime = System.nanoTime();
                    // input
                    // update
                    World.update();
                    // render
                    Renderer.render();

                    long timeTaken = System.nanoTime() - startTime;
                    if (timeTaken < targetTime){
                        try {
                            Thread.sleep((targetTime-timeTaken)/1000000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                  */
                }
            }
        };
        thread.setName("GameLoop");
        thread.start();
    }
    public static float updateDelta(){
        return 1.0f / 1000000000 * targetTime;
    }
}
