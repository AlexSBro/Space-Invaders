import java.awt.*;

public class Explosion extends GameObject {

    public Explosion(int x, int y, int width, int height, int speed, GameObjectManager gameObjectManager) {
        super(x, y, width, height, speed, 5, gameObjectManager);


    }

    @Override
    public void tick() {
        super.tick();

        switch (health){
            case 5:
                this.spriteDrawing = new char[][] {

                        {'X','X','X','X','X','X','X','X','X','X'},
                        {' ',' ',' ',' ','X','X',' ',' ',' ',' '},
                        {'X','X','X','X','X','X','X','X','X','X'},
                        {' ',' ',' ',' ','X','X',' ',' ',' ',' '},
                        {'X','X','X','X','X','X','X','X','X','X'},
                        {' ',' ',' ',' ','X','X',' ',' ',' ',' '},
                        {'X','X','X','X','X','X','X','X','X','X'},
                        {' ','X','X','X','X','X','X','X','X',' '},
                        {'X','X','X','X','X','X','X','X','X','X'},
                        {' ',' ','X','X','X','X','X','X',' ',' '},
                };
                break;
            case 4:
                break;
            case 3:
                break;
            case 2:
                break;
            case 1:
                break;

        }


        health -= 1;

        if (health == 0)
            removeSelf();

    }

    @Override
    protected Color getColor() {
        return ColorBuilder.buildRed(getHealthAlpha());
    }
}
