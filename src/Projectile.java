import java.awt.*;
import java.util.ArrayList;

public class Projectile extends GameObject {

    public Projectile(int x, int y, int speed, GameObjectManager gameObjectManager) {
        super(x, y, speed, 1, gameObjectManager);

        this.gameObjectManager = gameObjectManager;

        this.height = 20;
        this.width = 4;
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
