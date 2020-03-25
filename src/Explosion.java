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

                        {' ',' ',' ','o',' ','o',' ',' ',' ',' '},
                        {' ','o','o','o','o','X','o','o',' ',' '},
                        {'o',' ','o','X','X','X','X','o','o',' '},
                        {' ','o','X','X','X','X','X','X','o',' '},
                        {' ','X','X','X','X','X','X','X','o','o'},
                        {' ','o','X','X','X','X','X','X','X','o'},
                        {' ','o',' ','X','X','X','X','X',' ',' '},
                        {'o','o','o','o','X','o','X','o','o',' '},
                        {' ',' ','o','o','o','o','o','o','o',' '},
                        {' ',' ',' ',' ',' ',' ','o','o','o','o'}};
                break;
            case 4:
                this.spriteDrawing = new char[][] {

                        {' ',' ',' ','o',' ','o',' ',' ',' ',' '},
                        {' ','o','o','o','o','X',' ','o',' ',' '},
                        {'o',' ','o','X','X','X','X','o','o',' '},
                        {' ','o','X','X','X','X','X','X','o',' '},
                        {' ','X','X','X','X','X','X','X','o',' '},
                        {' ','o','X','X','X','X','X','o',' ',' '},
                        {' ','o',' ','X','X','X',' ',' ',' ',' '},
                        {'o','o','o','o','X','o',' ','o','o',' '},
                        {' ',' ','o','o','o','o','o','o','o',' '},
                        {' ',' ',' ',' ',' ',' ','o','o',' ',' '}};
                break;
            case 3:
                this.spriteDrawing = new char[][] {

                        {' ',' ',' ','o',' ','o',' ',' ',' ',' '},
                        {' ','o',' ','o','o',' ',' ',' ',' ',' '},
                        {'o',' ','o','X',' ','X',' ','o',' ',' '},
                        {' ','o','X','X','X','X','X',' ','o',' '},
                        {' ','X','X','X','X','X','o','X','o',' '},
                        {' ',' ','X','X','X','X','X','o',' ',' '},
                        {' ','o',' ','X','X','X',' ',' ',' ',' '},
                        {'o','o','o','o','X','o',' ',' ',' ',' '},
                        {' ',' ','o','o','o','o','o','o','o',' '},
                        {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}};
                break;
            case 2:
                this.spriteDrawing = new char[][] {

                        {' ',' ',' ','o',' ','o',' ',' ',' ',' '},
                        {' ','o',' ','o',' ',' ',' ',' ',' ',' '},
                        {'o',' ','o','X',' ','X',' ','o',' ',' '},
                        {' ',' ','X','X','X','X','X',' ','o',' '},
                        {' ','X','X','X','X','X',' ','X','o',' '},
                        {' ',' ','X','X','X','X','X',' ',' ',' '},
                        {' ','o',' ','X',' ','X',' ',' ',' ',' '},
                        {' ','o','o','o','o','o',' ',' ',' ',' '},
                        {' ',' ',' ',' ',' ','o','o','o','o',' '},
                        {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}};
                break;
            case 1:
                this.spriteDrawing = new char[][] {

                        {' ',' ',' ',' ',' ','o',' ',' ',' ',' '},
                        {' ',' ',' ','o',' ',' ',' ',' ',' ',' '},
                        {' ',' ','o',' ',' ','X',' ','o',' ',' '},
                        {' ',' ',' ',' ','X','X','X',' ','o',' '},
                        {' ',' ',' ','X','X','X',' ','X','o',' '},
                        {' ',' ',' ',' ','X','X','X',' ',' ',' '},
                        {' ','o',' ',' ',' ','X',' ',' ',' ',' '},
                        {' ',' ',' ','o','o','o',' ',' ',' ',' '},
                        {' ',' ',' ',' ',' ',' ',' ','o','o',' '},
                        {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}};
                break;
        }

        health -= 1;

        if (health == 0)
            removeSelf();
    }

    @Override
    protected Color getColor() {
        return ColorBuilder.buildSoftRed(getHealthAlpha());
    }

    @Override
    protected Color getSecondaryColor() {
        return ColorBuilder.buildSoftOrange(getHealthAlpha());
    }
}
