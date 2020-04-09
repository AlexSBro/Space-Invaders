package SpaceInvaders.GameObjects;

import SpaceInvaders.Game.GameObjectManager;

import java.awt.*;

public class Projectile extends GameObject {

    public Projectile(int centerx, int y, int speed, GameObjectManager gameObjectManager) {
        super(centerx - 5/2 - 1, y, 5, 16, speed, 1, gameObjectManager);

        this.gameObjectManager = gameObjectManager;

        this.spriteDrawing = new char[][]{
                {' ', ' ', 'o', ' ', ' '},
                {' ', 'o', 'o', 'o', ' '},
                {'o', 'X', 'X', 'X', 'o'},
                {' ', 'X', 'X', 'X', ' '},
                {' ', 'X', 'X', 'X', ' '},
                {' ', 'X', 'X', 'X', ' '},
                {' ', 'X', 'X', 'X', ' '},
                {' ', ' ', 'X', ' ', ' '}};

    }

    @Override
    public void tick() {
        super.tick();

        y -= speed;
    }

    @Override
    protected Color getColor() {
        return Color.gray;
    }

    @Override
    protected Color getSecondaryColor(){

        return Color.cyan;

    }
}
