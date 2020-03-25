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

                        {' ',' ',' ','x',' ','x',' ',' ',' ',' '},
                        {' ','x','x','x','x','X','x','x',' ',' '},
                        {'x',' ','x','X','X','X','X','x','x',' '},
                        {' ','x','X','X','X','X','X','X','x',' '},
                        {' ','X','X','X','X','X','X','X','x','x'},
                        {' ','x','X','X','X','X','X','X','X','x'},
                        {' ','x',' ','X','X','X','X','X',' ',' '},
                        {'x','x','x','x','X','x','X','x','x',' '},
                        {' ',' ','x','x','x','x','x','x','x',' '},
                        {' ',' ',' ',' ',' ',' ','x','x','x','x'}};
                break;
            case 4:
                this.spriteDrawing = new char[][] {

                        {' ',' ',' ','x',' ','x',' ',' ',' ',' '},
                        {' ','x','x','x','x','X',' ','x',' ',' '},
                        {'x',' ','x','X','X','X','X','x','x',' '},
                        {' ','x','X','X','X','X','X','X','x',' '},
                        {' ','X','X','X','X','X','X','X','x',' '},
                        {' ','x','X','X','X','X','X','x',' ',' '},
                        {' ','x',' ','X','X','X',' ',' ',' ',' '},
                        {'x','x','x','x','X','x',' ','x','x',' '},
                        {' ',' ','x','x','x','x','x','x','x',' '},
                        {' ',' ',' ',' ',' ',' ','x','x',' ',' '}};
                break;
            case 3:
                this.spriteDrawing = new char[][] {

                        {' ',' ',' ','x',' ','x',' ',' ',' ',' '},
                        {' ','x',' ','x','x',' ',' ',' ',' ',' '},
                        {'x',' ','x','X',' ','X',' ','x',' ',' '},
                        {' ','x','X','X','X','X','X',' ','x',' '},
                        {' ','X','X','X','X','X','x','X','x',' '},
                        {' ',' ','X','X','X','X','X','x',' ',' '},
                        {' ','x',' ','X','X','X',' ',' ',' ',' '},
                        {'x','x','x','x','X','x',' ',' ',' ',' '},
                        {' ',' ','x','x','x','x','x','x','x',' '},
                        {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}};
                break;
            case 2:
                this.spriteDrawing = new char[][] {

                        {' ',' ',' ','x',' ','x',' ',' ',' ',' '},
                        {' ','x',' ','x',' ',' ',' ',' ',' ',' '},
                        {'x',' ','x','X',' ','X',' ','x',' ',' '},
                        {' ',' ','X','X','X','X','X',' ','x',' '},
                        {' ','X','X','X','X','X',' ','X','x',' '},
                        {' ',' ','X','X','X','X','X',' ',' ',' '},
                        {' ','x',' ','X',' ','X',' ',' ',' ',' '},
                        {' ','x','x','x','x','x',' ',' ',' ',' '},
                        {' ',' ',' ',' ',' ','x','x','x','x',' '},
                        {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}};
                break;
            case 1:
                this.spriteDrawing = new char[][] {

                        {' ',' ',' ',' ',' ','x',' ',' ',' ',' '},
                        {' ',' ',' ','x',' ',' ',' ',' ',' ',' '},
                        {' ',' ','x',' ',' ','X',' ','x',' ',' '},
                        {' ',' ',' ',' ','X','X','X',' ','x',' '},
                        {' ',' ',' ','X','X','X',' ','X','x',' '},
                        {' ',' ',' ',' ','X','X','X',' ',' ',' '},
                        {' ','x',' ',' ',' ','X',' ',' ',' ',' '},
                        {' ',' ',' ','x','x','x',' ',' ',' ',' '},
                        {' ',' ',' ',' ',' ',' ',' ','x','x',' '},
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
