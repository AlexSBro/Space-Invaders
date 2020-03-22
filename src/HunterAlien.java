import java.awt.*;

public class HunterAlien extends Alien {

    public HunterAlien(int x, int y, int speed, int health, int hitPoints, GameObjectManager gameObjectManager){
        super(x, y, speed, health, hitPoints, gameObjectManager);

        this.spriteDrawing = new char[][] {
                {' ',' ',' ',' ','X','X',' ',' ',' ',' '},
                {' ',' ','X','X','X','X','X','X',' ',' '},
                {' ','X','X','X','X','X','X','X','X',' '},
                {' ','X','X','X','X','X','X','X','X',' '},
                {' ','X','X',' ','X','X',' ','X','X',' '},
                {' ','X','X','X','X','X','X','X','X',' '},
                {' ','X','X','X','X','X','X','X','X',' '},
                {' ',' ',' ','X','X','X','X',' ',' ',' '},
                {' ',' ','X',' ','X','X',' ','X',' ',' '},
                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
        };
        this.color = Color.yellow;

        this.width = 64;
        this.height = 64;
    }

    public void tick(){
        super.tick();

    }

    @Override
    public void alienMovementAlgorithm(){
        super.alienMovementAlgorithm();

        int playerCenter = gameObjectManager.getPlayer().x  + gameObjectManager.getPlayer().width/2 ;
        int alienCenter = this.x + this.width/2;

        if (playerCenter > alienCenter)
            this.x += this.speed;

        if (playerCenter < alienCenter)
            this.x -= this.speed;

        if (playerCenter == alienCenter)
            this.y += this.speed;

        if (isOutOfBounds()){
            preventMovingOutOfBounds();
            this.y += this.speed;
        }
    }

}
