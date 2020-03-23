import java.awt.*;
import java.util.Random;

public class StreakerAlien extends Alien {

    public StreakerAlien(int speed, int health, int hitPoints, GameObjectManager gameObjects) {
        super(speed, health, hitPoints, gameObjects);

        this.width = 48;
        this.height = 48;

        this.y = 0;

        Random random = new Random();
        this.x = random.nextInt(Board.BOARD_WIDTH - this.width);

        this.spriteDrawing = new char[][]{
                {' ', ' ', ' ', ' ', 'X', 'X', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', 'X', 'X', 'X', 'X', ' ', ' ', ' '},
                {' ', ' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', ' '},
                {' ', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', ' '},
                {' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' '},
                {' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' '},
                {' ', ' ', ' ', 'X', ' ', ' ', 'X', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', 'X', 'X', ' ', 'X', ' ', ' '},
                {' ', 'X', ' ', 'X', ' ', ' ', 'X', ' ', 'X', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        };

    }

    public void tick() {
        super.tick();
    }

    @Override
    public void alienMovementAlgorithm(){
        super.alienMovementAlgorithm();
        this.y += this.speed;
    }

    @Override
    protected Color getColor() {
        return ColorBuilder.buildRed(getHealthAlph());
    }

}
