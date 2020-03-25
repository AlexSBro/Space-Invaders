import java.awt.*;
import java.util.ArrayList;

public class Projectile extends GameObject {

    public Projectile(int centerx, int y, int speed, GameObjectManager gameObjectManager) {
        super(centerx - 4/2, y, 8, 16, speed, 1, gameObjectManager);

        this.gameObjectManager = gameObjectManager;

        this.spriteDrawing = new char[][]{
                {' ', 'x', 'x', ' '},
                {' ', 'x', 'x', ' '},
                {'x', 'X', 'X', 'x'},
                {' ', 'X', 'X', ' '},
                {' ', 'X', 'X', ' '},
                {' ', 'X', 'X', ' '},
                {' ', 'X', 'X', ' '},
                {' ', 'X', 'X', ' '}};

    }

    @Override
    public void tick() {
        super.tick();

        y -= speed;
    }



//    @Override
////    public void paint(Graphics graphics) {
////        graphics.setColor(Color.white);
////        graphics.fillRect(this.x, this.y, width, height);
////    }

    @Override
    protected Color getColor() {
        return Color.gray;
    }

    @Override
    protected Color getSecondaryColor(){

        return Color.cyan;

    }
}
