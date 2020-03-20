import java.awt.*;

public class BasicAlien extends Alien {

    public BasicAlien(int x, int y, int s, int health, GameObjectManager gameObjectManager){
        super(x, y, s, health, gameObjectManager);

        this.health = health;
        this.speed = s;

        this.width = 30;
        this.height = 30;

        this.initialX = x;
        this.initialY = y;

        moveLeft = false;
        moveRight = true;

        this.gameObjectManager = gameObjectManager;
    }


    public void tick(){
        super.tick();

        alienMovementAlgorithm();
        registerHits();
    }


    public void paint(Graphics graphics){
        graphics.fillRect(this.x, this.y, this.width, this.height);
    }
}