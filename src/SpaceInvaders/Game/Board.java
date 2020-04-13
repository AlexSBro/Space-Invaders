package SpaceInvaders.Game;

import SpaceInvaders.GameObjects.GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;


public class Board  extends JPanel implements Runnable {
    boolean running = true;

    boolean originalSpacePress = true;

    private Thread animator;

    private GameObjectManager gameObjectManager = new GameObjectManager();

    public Board() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.black);

        if (animator == null || !running) {
            animator = new Thread(this);
            animator.start();
        }


        setDoubleBuffered(true);
    }

    public void tick(){
        gameObjectManager.tick();
    }

    public synchronized void run() {

        long initialTime = System.nanoTime();
        final double timeF = 1000000000 / Settings.FPS;
        double  deltaF = 0;
        int frames = 0, ticks = 0;
        long timer = System.currentTimeMillis();

        while (running) {

            long currentTime = System.nanoTime();
            deltaF += (currentTime - initialTime) / timeF;
            initialTime = currentTime;

            if (deltaF >= 1) {
                gameObjectManager.updateObjects();
                repaint();
                tick();

                ticks ++;
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                if (Settings.RENDER_TIME) {
                    System.out.println(String.format("UPS: %s, FPS: %s", ticks, frames));
                }
                frames = 0;
                ticks = 0;
                timer += 1000;
            }
        }


    }

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if(key==39){
                gameObjectManager.rightKeyReleased();
            }
            if (key == 37){
                gameObjectManager.leftKeyReleased();
            }
            if (key == 32){
                originalSpacePress = true;
            }

        }

        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();
            if(key == 39){
                gameObjectManager.rightKeyPressed();
            }
            if (key == 37){
                gameObjectManager.leftKeyPressed();
            }
            if (key == 32){
                if(originalSpacePress) {
                    gameObjectManager.fireShot(true);
                    originalSpacePress = false;
                }
            }

        }

    }

    public void paint(Graphics graphics) {
        super.paint(graphics);

        //background
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, Settings.BOARD_WIDTH, Settings.BOARD_HEIGHT);

        HUD.draw(graphics, gameObjectManager.getPlayer().getHealth(), gameObjectManager.getWaveNumber(), gameObjectManager.getPlayer().getScore());

        for (GameObject object: gameObjectManager.getGameObjects()){
            object.paint(graphics);
        }

        Toolkit.getDefaultToolkit().sync();
        graphics.dispose();
    }
}
