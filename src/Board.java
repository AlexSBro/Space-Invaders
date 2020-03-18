
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import java.util.ArrayList;


public class Board  extends JPanel implements Runnable {
    boolean running = true;

    private Dimension dimension;
    public  static int BOARD_WIDTH = 640;
    public  static int BOARD_HEIGHT = 640;

    private Thread animator;

    private GameObjectManager gameObjectManager;

    Player player;

    public Board() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        dimension = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);

        addGameObjects();

        setBackground(Color.black);

        if (animator == null || !running) {
            animator = new Thread(this);
            animator.start();
        }


        setDoubleBuffered(true);
    }

    private void addGameObjects() {
        player = new Player(BOARD_WIDTH/2, BOARD_HEIGHT-60, 5, gameObjectManager);
        gameObjectManager.addToQue(player);

        int ax = 10;
        int ay = 10;

        for (int i = 0; i < 10; i++) {
            Alien alien = new Alien(ax, ay, 10, gameObjectManager);
            ax += 40;
            if (i == 4) {
                ax = 10;
                ay += 40;
            }
            gameObjectManager.addToQue(alien);
        }
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);

        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, dimension.width, dimension.height);


        for (GameObject object: gameObjectManager){
            object.paint(graphics);
        }

        Toolkit.getDefaultToolkit().sync();
        graphics.dispose();
    }

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            player.rightKeyPressed = false;
            player.leftKeyPressed = false;

        }

        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();
            if(key==39){
                player.rightKeyPressed = true;
            }
            if (key == 37){
                player.leftKeyPressed = true;
            }
            if (key == 32){
                player.spacePressed = true;
            }

        }

    }

    public void tick(){
       for (GameObject object: gameObjectManager) {
           object.tick();
       }
    }

    public void run() {

        int animationDelay = 5;
        long time =
                System.currentTimeMillis();
        while (true) {//infinite loop
            tick();
            repaint();
            try {
                time += animationDelay;
                Thread.sleep(Math.max(0,time -
                        System.currentTimeMillis()));
            }catch (InterruptedException e) {
                System.out.println(e);
            }//end catch
        }//end while loop

    }//end of run

}//end of class
