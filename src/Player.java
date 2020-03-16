import java.awt.*;

public class Player extends GameObject {

    boolean rightKeyPressed;
    boolean leftKeyPressed;

    public Player(int x, int y, int s){
        super(x, y, s);

        leftKeyPressed = false;
        rightKeyPressed = false;

        this.width = 20;
        this.height = 20;

    }

    public void paint(Graphics graphics){
        graphics.setColor(Color.red);
        graphics.fillRect(this.x, this.y, width, height);

    }

    public void tick(){
        if (this.rightKeyPressed) {
            this.x += this.speed;
        }
        if (this.leftKeyPressed && this.x > 0) {
            this.x -= this.speed;
        }

        if (this.x > Board.BOARD_WIDTH - this.width){
            this.x = Board.BOARD_WIDTH - this.width;
        }
        if (this.x < 0){
            this.x = 0;
        }


    }
}
