import java.awt.*;
import java.util.Random;

public class StreakerAlien extends Alien {

    public StreakerAlien(int speed, int health, int hitPoints, GameObjectManager gameObjects) {
        super(speed, health, hitPoints, gameObjects);

        this.width = 50;
        this.height = 50;

        this.y = 0;

        Random random = new Random();
        this.x = random.nextInt(Board.BOARD_WIDTH - this.width);

    }

    public void tick() {
        super.tick();
    }

    @Override
    public void alienMovementAlgorithm(){
        super.alienMovementAlgorithm();
        this.y += this.speed;
    }

    public void paint(Graphics graphics) {
        Color color;

        switch (health){
            case 10:
                color = Color.lightGray;
                break;
            case 50:
                color = Color.gray;
                break;
            default:
                color = Color.darkGray;

        }

        char[][] array = {
                {' ',' ',' ',' ','X','X',' ',' ',' ',' '},
                {' ',' ',' ','X','X','X','X',' ',' ',' '},
                {' ',' ','X','X','X','X','X','X',' ',' '},
                {' ','X','X',' ','X','X',' ','X','X',' '},
                {' ','X','X','X','X','X','X','X','X',' '},
                {' ','X','X','X','X','X','X','X','X',' '},
                {' ',' ',' ','X',' ',' ','X',' ',' ',' '},
                {' ',' ','X',' ','X','X',' ','X',' ',' '},
                {' ','X',' ','X',' ',' ','X',' ','X',' '},
                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
        };

        SpriteDrawer.drawSprite(graphics, color, array, height, x, y);    }
}
