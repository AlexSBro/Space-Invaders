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

        this.color = Color.pink;
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

}
