import java.awt.*;
import java.util.Random;

public class StreakerAlien extends Alien {

    public StreakerAlien(int speed, int health, int hitPoints, GameObjectManager gameObjects) {
        super(48, 48, speed, health, hitPoints, gameObjects);

        this.y = 0;

        Random random = new Random();
        this.x = random.nextInt(Settings.BOARD_WIDTH - this.width);

        this.spriteDrawing = new char[][]{
                {' ', ' ', ' ', 'X', 'X', ' ', ' ', ' '},
                {' ', ' ', 'X', 'X', 'X', 'X', ' ', ' '},
                {' ', 'X', 'X', 'X', 'X', 'X', 'X', ' '},
                {'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {' ', ' ', 'X', ' ', ' ', 'X', ' ', ' '},
                {' ', 'X', ' ', 'X', 'X', ' ', 'X', ' '},
                {'X', ' ', 'X', ' ', ' ', 'X', ' ', 'X'},
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
        return ColorBuilder.buildRed(getHealthAlpha());
    }

}
