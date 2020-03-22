import java.awt.*;

public class HunterAlien extends Alien {

    public HunterAlien(int x, int y, int speed, int health, int hitPoints, GameObjectManager gameObjectManager){
        super(x, y, speed, health, hitPoints, gameObjectManager);

        this.width = 100;
        this.height = 100;
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

    public void paint(Graphics graphics){
        Color color;

        switch (health){
            case 10:
                color = Color.lightGray;
                break;
            case 50:
                color = Color.gray;
                break;
            default:
                color = Color.orange;

        }


        char[][] array = {
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

        SpriteDrawer.drawSprite(graphics, color, array, height, x, y);
    }
}
