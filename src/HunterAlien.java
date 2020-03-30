import java.awt.*;

public class HunterAlien extends Alien {

    public HunterAlien(int speed, int health, int hitPoints, GameObjectManager gameObjectManager){
        super(96, 48, speed, health, hitPoints, gameObjectManager);

        this.x = Settings.BOARD_WIDTH/2 - width/2;
        this.y = 10;


        this.spriteDrawing = new char[][] {

                {' ',' ',' ',' ',' ','X','X','X','X','X','X',' ',' ',' ',' ',' '},
                {' ',' ',' ','X','X','X','X','X','X','X','X','X','X',' ',' ',' '},
                {' ',' ','X','X','X','X','X','X','X','X','X','X','X','X',' ',' '},
                {' ','X','X',' ','X','X',' ','X','X',' ','X','X',' ','X','X',' '},
                {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'},
                {' ',' ','X','X','X',' ',' ','X','X',' ',' ','X','X','X',' ',' '},
                {' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
        };

    }

    public void tick(){
        super.tick();

    }

    @Override
    public void alienMovementAlgorithm(){
        super.alienMovementAlgorithm();

        int playerCenter = gameObjectManager.getPlayer().x  + gameObjectManager.getPlayer().width/2 ;
        int alienCenter = this.x + this.width/2;

        if (playerCenter <= alienCenter + this.speed && playerCenter >= alienCenter - this.speed)
            this.y += this.speed;

        else if (playerCenter > alienCenter)
            this.x += this.speed;

        else if (playerCenter < alienCenter)
            this.x -= this.speed;

        if (isOutOfBounds()){
            preventMovingOutOfBounds();
            this.y += this.speed;
        }
    }

    @Override
    protected Color getColor() {
        return ColorBuilder.buildSoftYellow(getHealthAlpha());
    }

}
