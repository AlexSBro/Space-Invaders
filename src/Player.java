import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y, int s, int health,  GameObjectManager gameObjectManager){
        super(x, y, 48,  48, s, health, gameObjectManager);


        this.spriteDrawing = new char[][] {

                {' ',' ',' ',' ','X','X',' ',' ',' ',' '},
                {' ',' ',' ',' ','X','X',' ',' ',' ',' '},
                {' ',' ',' ',' ','X','X',' ',' ',' ',' '},
                {' ',' ',' ',' ','X','X',' ',' ',' ',' '},
                {' ',' ',' ',' ','X','X',' ',' ',' ',' '},
                {' ',' ',' ',' ','X','X',' ',' ',' ',' '},
                {' ',' ','X','X','X','X','X','X',' ',' '},
                {' ','X','X','X','X','X','X','X','X',' '},
                {' ','X','X','X','X','X','X','X','X',' '},
                {' ',' ','X','X','X','X','X','X',' ',' '},
        };

    }

    public void tick(){
        super.tick();

        playerMovement();
        playerShooting();

    }

    private void playerShooting() {
        if(gameObjectManager.isFireShot()) {
            gameObjectManager.addToQue(new Projectile(this.x + this.width/2 - 2, this.y - 20, 10, gameObjectManager));
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
    protected Color getColor() {
        return ColorBuilder.buildWhite(getHealthAlpha());
    }

}
