
import java.awt.Color;
import java.awt.Dimension;
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
        boolean hasAlien = false;
        for (GameObject object: gameObjectManager.getGameObjects()) {
            object.tick();
            if(object instanceof Alien){
                hasAlien = true;
            }
        }
        if(!hasAlien){
            gameObjectManager.getNextWave();
        }
    }

    public synchronized void run() {

        while (true) {

            synchronized (this) {
                gameObjectManager.updateObjects();
                tick();
                repaint();
            }

            try {
                Thread.sleep(20 );
            }catch (InterruptedException e) {
                System.out.println(e);
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
            if(key==39){
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

        HUD.draw(graphics, gameObjectManager.getPlayer().health, gameObjectManager.getWaveNumber() + 1);

        for (GameObject object: gameObjectManager.getGameObjects()){
            object.paint(graphics);
        }

        Toolkit.getDefaultToolkit().sync();
        graphics.dispose();
    }
}
