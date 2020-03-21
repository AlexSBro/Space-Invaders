import java.awt.*;

public class StreakerAlien extends Alien {

    public StreakerAlien(int x, int y, int speed, int health, GameObjectManager gameObjects) {
        super(x, y, speed, health, gameObjects);

        this.width = 50;
        this.height = 50;
    }

    @Override
    public void alienMovementAlgorithm() {

        this.y += speed;

    }

    @Override
    public void tick() {
        super.tick();

        alienMovementAlgorithm();
        registerHits();
    }

    @Override
    public void removeSelf() {
        super.removeSelf();
    }

    @Override
    public void paint(Graphics graphics) {
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

        SpriteDrawer.drawSprite(graphics, color, array, height, x, y);    }
}
