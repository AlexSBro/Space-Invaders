import java.awt.*;

public class HunterAlien extends Alien {

    public HunterAlien(int x, int y, int speed, int health, int hitPoints, GameObjectManager gameObjectManager){
        super(x, y, speed, health, hitPoints, gameObjectManager);

        this.width = 50;
        this.height = 50;
    }

    public void tick(){
        super.tick();

        hunterMovementAlgorithm();
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
