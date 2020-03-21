import java.awt.*;

public class BasicAlien extends Alien {

    public BasicAlien(int x, int y, int speed, int health, GameObjectManager gameObjectManager){
        super(x, y, speed, health, gameObjectManager);

        this.width = 30;
        this.height = 30;

        this.initialX = x;
        this.initialY = y;

        moveLeft = false;
        moveRight = true;

        this.gameObjectManager = gameObjectManager;
    }


    public void tick(){
        super.tick();
    }


    public void paint(Graphics graphics){
        Color color;

        switch (health){
            case 1:
                color = Color.lightGray;
                break;
            case 2:
                color = Color.gray;
                break;
            case 3:
                color = Color.darkGray;
                break;
            default:
                color = Color.lightGray;

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
