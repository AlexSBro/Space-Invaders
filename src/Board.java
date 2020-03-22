
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;

import javax.swing.JPanel;


public class Board  extends JPanel implements Runnable {
    boolean running = true;

    private Dimension dimension;
    public  static int BOARD_WIDTH = 640;
    public  static int BOARD_HEIGHT = 640;

    private Thread animator;

    private GameObjectManager gameObjectManager = new GameObjectManager();

    public Board() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        dimension = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);

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
            gameObjectManager.rightKeyReleased();
            gameObjectManager.leftKeyReleased();
            gameObjectManager.rightKeyReleased();

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
                gameObjectManager.spacePressed();
            }

        }

    }

    public void paint(Graphics graphics) {
        super.paint(graphics);

        //background
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, dimension.width, dimension.height);
        //health bar
        graphics.setColor(Color.green);
        graphics.fillRect(BOARD_WIDTH - 110,BOARD_HEIGHT - 40, gameObjectManager.getPlayer().health, 10);
        //damage taken
        graphics.setColor(Color.red);
        graphics.fillRect(BOARD_WIDTH - 110 + gameObjectManager.getPlayer().health,BOARD_HEIGHT - 40, 100 - gameObjectManager.getPlayer().health, 10);

        for (GameObject object: gameObjectManager.getGameObjects()){
            object.paint(graphics);
        }

        Toolkit.getDefaultToolkit().sync();
        graphics.dispose();
    }
}
