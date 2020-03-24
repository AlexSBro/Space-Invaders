import java.awt.*;
import java.util.ArrayList;

public class Projectile extends GameObject {

    public Projectile(int x, int y, int speed, GameObjectManager gameObjectManager) {
        super(x, y, 4, 20, speed, 1, gameObjectManager);

        this.gameObjectManager = gameObjectManager;

    }

    @Override
    public void tick() {
        super.tick();

        y -= speed;
    }



    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.fillRect(this.x, this.y, width, height);
    }
}
