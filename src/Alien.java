import java.awt.*;

public class Alien extends GameObject {

    int initialX;
    int initialY;

    boolean moveRight;
    boolean moveLeft;
    boolean isVisible;



    public Alien(int x, int y, int s){
        super(x, y, s);

        this.initialX = x;
        this.initialY = y;

        moveLeft = false;
        moveRight = true;
        isVisible = true;

        this.width = 30;
        this.height = 30;
    }

    public void tick(){

        if (this.moveLeft)
            this.x -= 1;    //this.speed;

        if (this.moveRight)
            this.x += 1;    //this.speed;

        if (this.x > Board.BOARD_WIDTH - (200 - this.initialX)) {
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
