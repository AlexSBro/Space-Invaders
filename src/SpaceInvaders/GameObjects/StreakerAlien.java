package SpaceInvaders.GameObjects;

import SpaceInvaders.Game.AlienWave;
import SpaceInvaders.Utilities.ColorBuilder;
import SpaceInvaders.Game.GameObjectManager;
import SpaceInvaders.Game.Settings;

import java.awt.*;
import java.util.Random;

public class StreakerAlien extends Alien {

    public StreakerAlien(int speed, int health, int hitPoints, GameObjectManager gameObjects, AlienWave alienWave) {
        super(48, 48, speed, health, hitPoints, gameObjects, alienWave);

        this.y = 0;

        Random random = new Random();
        this.x = random.nextInt(Settings.BOARD_WIDTH - this.width);

        this.spriteDrawing = new char[][]{
                {' ', ' ', ' ', 'X', 'X', ' ', ' ', ' '},
                {' ', ' ', 'X', 'X', 'X', 'X', ' ', ' '},
                {' ', 'X', 'X', 'X', 'X', 'X', 'X', ' '},
                {'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {' ', ' ', 'X', ' ', ' ', 'X', ' ', ' '},
                {' ', 'X', ' ', 'X', 'X', ' ', 'X', ' '},
                {'X', ' ', 'X', ' ', ' ', 'X', ' ', 'X'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
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
