import java.awt.*;

public class BasicAlien extends Alien {

    public BasicAlien(int x, int y, int speed, int health, int hitPoints, GameObjectManager gameObjectManager){
        super(x, y, speed, health, hitPoints, gameObjectManager);

        this.width = 32;
        this.height = 32;

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
        this.color = Color.green;


        this.gameObjectManager = gameObjectManager;
    }


    public void tick(){
        super.tick();

    }

    @Override
    public void alienMovementAlgorithm(){
        super.alienMovementAlgorithm();

        if (this.x > Board.BOARD_WIDTH - (210 - this.initialX)) {
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

}
