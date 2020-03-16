import java.awt.*;

public class Player extends GameObject {

    boolean moveRight;
    boolean moveLeft;

    public Player(int x, int y, int s){
        super(x, y, s);

        moveLeft = false;
        moveRight = false;

        this.width = 20;
        this.height = 20;

    }

    public void paint(Graphics graphics){
        graphics.setColor(Color.red);
        graphics.fillRect(this.x, this.y, width, height);
        if (this.moveRight == true)
            this.x += this.speed;
        if (this.moveLeft == true)
            this.x -= this.speed;
    }
}
