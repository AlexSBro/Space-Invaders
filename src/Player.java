import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y, int s, int health,  GameObjectManager gameObjectManager){
        super(x, y, s, health, gameObjectManager);

        this.width = 40;
        this.height = 40;

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

        if (this.x > Board.BOARD_WIDTH - this.width){
            this.x = Board.BOARD_WIDTH - this.width;
        }
        if (this.x < 0){
            this.x = 0;
        }
    }

    public void paint(Graphics graphics){

        char[][] array = {

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

        SpriteDrawer.drawSprite(graphics, Color.orange, array, height, x, y, 1);

    }
}
