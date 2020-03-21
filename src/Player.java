import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y, int s, int health,  GameObjectManager gameObjectManager){
        super(x, y, s, health, gameObjectManager);

        this.gameObjectManager = gameObjectManager;

        this.width = 40;
        this.height = 40;

    }


    public void tick(){
        super.tick();

        playerMovement();
        playerShooting();
    }

    private void playerShooting() {
        if(gameObjectManager.isSpacePressed()) {
            gameObjectManager.addToQue(new Projectile(this.x + this.width/2 - 2, this.y - 20, 10, gameObjectManager));
            gameObjectManager.spaceReleased();
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
//        graphics.setColor(Color.orange);
//
//        int tenth = height/10;
//        graphics.fillRect(this.x + (4*tenth), this.y, 2*tenth, tenth*3);
//        graphics.fillRect(this.x + (2*tenth), this.y + 3*tenth, 6*tenth, tenth*1);
//        graphics.fillRect(this.x + (1*tenth), this.y + 4*tenth, 8*tenth, tenth*1);
//        graphics.fillRect(this.x + (0*tenth), this.y + 5*tenth, 10*tenth, tenth*5);

        char[][] array = {
                {' ',' ',' ',' ','X','X',' ',' ',' ',' '},
                {' ',' ',' ',' ','X','X',' ',' ',' ',' '},
                {' ',' ',' ',' ','X','X',' ',' ',' ',' '},
                {' ',' ',' ','X','X','X','X',' ',' ',' '},
                {' ',' ','X','X','X','X','X','X',' ',' '},
                {' ','X','X','X','X','X','X','X','X',' '},
                {'X','X','X','X','X','X','X','X','X','X'},
                {'X','X','X','X','X','X','X','X','X','X'},
                {'X','X','X','X','X','X','X','X','X','X'},
                {'X','X','X','X','X','X','X','X','X','X'},
        };

        SpriteDrawer.drawSprite(graphics, Color.orange, array, height, x, y);


    }
}
