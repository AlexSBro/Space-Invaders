import java.awt.*;

public class HunterAlien extends Alien {

    public HunterAlien(int x, int y, int speed, int health, int hitPoints, GameObjectManager gameObjectManager){
        super(x, y, speed, health, hitPoints, gameObjectManager);

        this.width = 100;
        this.height = 100;

        this.color = Color.yellow;
        this.spriteDrawing = new char[][]{
                {' ', ' ', ' ', ' ', 'X', 'X', ' ', ' ', ' ', ' '},
                {' ', ' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', ' '},
                {' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' '},
                {' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' '},
                {' ', 'X', 'X', ' ', 'X', 'X', ' ', 'X', 'X', ' '},
                {' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' '},
                {' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' '},
                {' ', ' ', ' ', 'X', 'X', 'X', 'X', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', 'X', 'X', ' ', 'X', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
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

        if (playerCenter > alienCenter)
            this.x += this.speed;

        if (playerCenter < alienCenter)
            this.x -= this.speed;

        if (playerCenter == alienCenter)
            this.y += this.speed;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
    }
}
