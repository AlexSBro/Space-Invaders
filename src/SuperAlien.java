import java.awt.*;

public class SuperAlien extends Alien {

    int health;
    int speed;

    int initialX;
    int initialY;

    boolean moveRight;
    boolean moveLeft;


    public SuperAlien(int x, int y, int s, int health, GameObjectManager gameObjectManager){
        super(x, y, s, health, gameObjectManager);

        this.health = health;
        this.speed = s;

        this.width = 40;
        this.height = 40;

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

    private void alienMovementAlgorithm() {
        if (this.moveLeft)
            this.x -= this.speed;    //this.speed;

        if (this.moveRight)
            this.x += this.speed;    //this.speed;

        if (this.x > Board.BOARD_WIDTH - ( 50 - this.initialX)) {
            this.moveLeft = true;
            this.moveRight = false;
            this.y += this.height + 5;
        }
        if (this.x <= this.initialX) {
            this.moveRight = true;
            this.moveLeft = false;
            this.y += this.height + 5;
        }
    }

    public void paint(Graphics graphics){
        graphics.fillRect(this.x, this.y, this.width, this.height);
    }

}
