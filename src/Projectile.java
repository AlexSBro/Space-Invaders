import java.awt.*;
import java.util.ArrayList;

public class Projectile extends GameObject {

    public Projectile(int x, int y, int speed, GameObjectManager gameObjectManager) {
        super(x, y, speed, gameObjectManager);

        this.gameObjectManager = gameObjectManager;

        this.height = 20;
        this.width = 4;
    }

    @Override
    public void tick() {

        y -= speed;

    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(Color.cyan);
        graphics.fillRect(this.x, this.y, width, height);
    }

}
