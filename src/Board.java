
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import java.awt.image.*;
import java.util.ArrayList;


public class Board  extends JPanel implements Runnable, MouseListener
{
    boolean ingame = true;

    private Dimension dimension;
    public  static int BOARD_WIDTH = 640;
    public  static int BOARD_HEIGHT = 640;
    int x = 0;
    BufferedImage img;
    String message = "Click Board to Start";
    private Thread animator;

    private ArrayList<GameObject> gameObjects = new ArrayList<>();

    Player player;

    public Board() {
        addKeyListener(new TAdapter());
        addMouseListener(this);
        setFocusable(true);
        dimension = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);

        player = new Player(BOARD_WIDTH/2, BOARD_HEIGHT-60, 5);
        gameObjects.add(player);

        int ax = 10;
        int ay = 10;

        for (int i = 0; i < 10; i++) {
            Alien alien = new Alien(ax, ay, 10);
            ax += 40;
            if (i == 4) {
                ax = 10;
                ay += 40;
            }
            gameObjects.add(alien);
        }

        setBackground(Color.black);

        if (animator == null || !ingame) {
            animator = new Thread(this);
            animator.start();
        }


        setDoubleBuffered(true);
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);

        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, dimension.width, dimension.height);

//        Font small = new Font("Helvetica", Font.BOLD, 14);
//        FontMetrics fontMetrics = this.getFontMetrics(small);
//        graphics.setColor(Color.black);
//        graphics.setFont(small);
//        graphics.drawString(message, 10, dimension.height-60);

        //represents player
        for (GameObject object: gameObjects){
            object.paint(graphics);
        }

        Toolkit.getDefaultToolkit().sync();
        graphics.dispose();
    }

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            player.moveRight = false;
            player.moveLeft = false;

        }

        public void keyPressed(KeyEvent e) {
//System.out.println( e.getKeyCode());
            // message = "Key Pressed: " + e.getKeyCode();
            int key = e.getKeyCode();
            if(key==39){
                player.moveRight = true;
            }
            if (key == 37){
                player.moveLeft = true;
            }



        }

    }




    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void tick(){
       for (GameObject object: gameObjects) {
           object.tick();
       }
    }

    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();
        int animationDelay = 5;
        long time =
                System.currentTimeMillis();
        while (true) {//infinite loop
            // spriteManager.update();
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
