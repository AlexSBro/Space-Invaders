import java.awt.*;

public class Alien extends GameObject {

    boolean moveRight;
    boolean moveLeft;
    boolean isVisible;



    public Alien(int x, int y, int s){
        super(x, y, s);

        moveLeft = false;
        moveRight = true;
        isVisible = true;

        this.width = 30;
        this.height = 30;
    }

    public void tick(){

        if (this.moveLeft)
            this.x -= 2;    //this.speed;

        if (this.moveRight)
            this.x += 2;    //this.speed;

        if (this.x > Board.BOARD_WIDTH) {
                this.moveLeft = true;
                this.moveRight = false;
                this.y += 5;
        }
        if (this.x < 0) {
                this.moveRight = true;
                this.moveLeft = false;
                this.y += 5;
        }

    }

    public void paint(Graphics graphics){
        graphics.fillRect(this.x, this.y, this.width, this.height);
    }
}
