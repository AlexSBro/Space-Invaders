import java.awt.*;

public class StreakerAlien extends Alien {

    public StreakerAlien(int x, int y, int speed, int health, int hitPoints, GameObjectManager gameObjects) {
        super(x, y, speed, health, hitPoints, gameObjects);

        this.width = 50;
        this.height = 50;
    }

    public void tick() {
        super.tick();

        streakerMovementAlgorithm();
    }

    public void paint(Graphics graphics) {
        Color color;

        switch (health){
            case 10:
                color = Color.lightGray;
                break;
            case 50:
                color = Color.gray;
                break;
            default:
                color = Color.darkGray;

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

        SpriteDrawer.drawSprite(graphics, color, array, height, x, y);    }
}
