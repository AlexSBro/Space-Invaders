package SpaceInvaders.GameObjects;

import SpaceInvaders.Utilities.ColorBuilder;
import SpaceInvaders.Game.GameObjectManager;
import SpaceInvaders.Game.Settings;

import java.awt.*;

public class Player extends GameObject {

    protected int score = 0;

    public Player(int speed, int health,  GameObjectManager gameObjectManager){
        super(Settings.BOARD_WIDTH/2 - 30/2, Settings.BOARD_HEIGHT - 70, 30,  32, speed, health, gameObjectManager);

        this.score = 0;

        this.spriteDrawing = new char[][] {

                {' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ','X','X','X',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ','X','X','X',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ','X','X','X',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ','o',' ',' ','X','X','X',' ',' ','o',' ',' ',' '},
                {' ',' ',' ','o',' ','X','X','X','X','X',' ','o',' ',' ',' '},
                {'o',' ',' ','X','o','X','X','o','X','X','o','X',' ',' ','o'},
                {'o',' ',' ','o','X','X','o','o','o','X','X','o',' ',' ','o'},
                {'X',' ',' ','X','X','X','o','X','o','X','X','X',' ',' ','X'},
                {'X',' ','X','X','X','X','X','X','X','X','X','X','X',' ','X'},
                {'X','X','X','X','X','o','X','X','X','o','X','X','X','X','X'},
                {'X','X','X',' ','o','o','X','o','X','o','o',' ','X','X','X'},
                {'X','X',' ',' ','o','o',' ','o',' ','o','o',' ',' ','X','X'},
                {'X',' ',' ',' ',' ',' ',' ','o',' ',' ',' ',' ',' ',' ','X'}};

    }

    public void tick(){
        super.tick();

        playerMovement();
        playerShooting();
    }

    private void playerShooting() {
        if(gameObjectManager.isFireShot()) {
            gameObjectManager.addToQue(new Projectile(this.x + this.width/2, this.y - 10, 10, gameObjectManager));
            gameObjectManager.fireShot(false);
        }
    }

    private void playerMovement() {
        if (gameObjectManager.isRightKeyPressed()) {
            this.x += this.speed;
        }
        if (gameObjectManager.isLeftKeyPressed() && this.x > 0) {
            this.x -= this.speed;
        }

        preventMovingOutOfBounds();
    }

    @Override
    public void removeSelf() {
        super.removeSelf();
    }

    public void addScore(int score){
        this.score += score;
    }

    @Override
    protected Color getColor() {
        return Color.white;
    }

    @Override
    protected Color getSecondaryColor() {
        return ColorBuilder.buildSoftOrange(getHealthAlpha());
    }

    public int getScore() {
        return score;
    }
}
