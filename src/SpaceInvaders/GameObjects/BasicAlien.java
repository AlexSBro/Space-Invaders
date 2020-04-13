package SpaceInvaders.GameObjects;

import SpaceInvaders.Game.AlienWave;
import SpaceInvaders.Utilities.ColorBuilder;
import SpaceInvaders.Game.GameObjectManager;
import SpaceInvaders.Game.Settings;

import java.awt.*;

public class BasicAlien extends Alien {

    public BasicAlien(int x, int y, int speed, int health, int hitPoints, GameObjectManager gameObjectManager, AlienWave alienWave){
        super(x, y, 32, 32, speed, health, hitPoints, gameObjectManager, alienWave);

        this.initialX = x;
        this.initialY = y;

        moveLeft = false;
        moveRight = true;

        this.spriteDrawing = new char[][] {
                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ',' ','X',' ',' ',' ',' ','X',' ',' '},
                {' ',' ',' ','X',' ',' ','X',' ',' ',' '},
                {' ',' ','X','X','X','X','X','X',' ',' '},
                {' ','X','X',' ','X','X',' ','X','X',' '},
                {'X','X','X','X','X','X','X','X','X','X'},
                {'X',' ','X','X','X','X','X','X',' ','X'},
                {'X',' ','X',' ',' ',' ',' ','X',' ','X'},
                {' ',' ',' ','X','X','X','X',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
        };

        this.gameObjectManager = gameObjectManager;
    }


    public void tick(){
        super.tick();

    }

    @Override
    public void alienMovementAlgorithm(){
        super.alienMovementAlgorithm();

        if (this.x > Settings.BOARD_WIDTH - (210 - this.initialX)) {
            this.moveLeft = true;
            this.moveRight = false;
            this.y += this.height + 4;
        }
        if (this.x <= this.initialX) {
            this.moveRight = true;
            this.moveLeft = false;
            this.y += this.height + 4;
        }
    }

    @Override
    protected Color getColor() {
        return ColorBuilder.buildSoftGreen(getHealthAlpha());
    }

}
