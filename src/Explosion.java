import java.awt.*;

public class Explosion extends GameObject {

    protected int scoreValue;

    public Explosion(int x, int y, int width, int height, int speed, int scoreValue, GameObjectManager gameObjectManager) {
        super(x, y, width, height, speed, 5, gameObjectManager);

        this.scoreValue = scoreValue;

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

    protected void drawExplosionScore(Graphics graphics, int x, int y, int width, int height, int scoreValue){
        Font font = new Font("Monotype Corsiva", Font.PLAIN, 16);
        graphics.setColor(Color.white);
        graphics.setFont(font);

        if (scoreValue < 10){
            graphics.drawString(String.valueOf(scoreValue),x + width/2 - 8, y + height/2 - 8);
        }

        if (scoreValue >= 10 && scoreValue < 100){
            graphics.drawString(String.valueOf(scoreValue),x + width/2 - 16, y + height/2 - 8);
        }

        if (scoreValue >= 100){
            graphics.drawString(String.valueOf(scoreValue),x + width/2 - 24, y + height/2 - 8);
        }

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
