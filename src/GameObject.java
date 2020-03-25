import java.awt.*;

public class GameObject {

    protected GameObjectManager gameObjectManager;

    protected int health;
    private int initialHealth;
    protected int speed;

    protected char[][] spriteDrawing;

    protected int x;
    protected int y;

    protected int width;
    protected int height;


    public GameObject(int x, int y, int width, int height, int speed, int health, GameObjectManager gameObjectManager){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.speed = speed;
        this.health = health;
        this.initialHealth = health;
        this.gameObjectManager = gameObjectManager;
    }

    public GameObject(int width, int height, int speed, int health, GameObjectManager gameObjectManager){
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.health = health;
        this.initialHealth = health;
        this.gameObjectManager = gameObjectManager;
    }

    public void tick(){
        if (isOutOfBounds())
            removeSelf();
    }

    public void hit(int hitPoints){
        if(health - hitPoints <= 0){
            removeSelf();
            health = 0;
        }
        else
            health -= hitPoints;
    }


    public void removeSelf(){
        gameObjectManager.addToRemovalQue(this);
        if(this instanceof Alien){
            gameObjectManager.addToQue(new Explosion(x, y, width, height, speed, gameObjectManager));
        }
    }

    public boolean isOutOfBounds(){
        return x + width > Settings.BOARD_WIDTH || x < 0 || y > Settings.BOARD_HEIGHT || y + height < 0;
    }

    public void preventMovingOutOfBounds() {
        if (this.x > Settings.BOARD_WIDTH - this.width){
            this.x = Settings.BOARD_WIDTH - this.width;
        }
        if (this.x < 0){
            this.x = 0;
        }
    }

    public void paint(Graphics graphics){

        SpriteDrawer.drawSprite(graphics, getColor(), spriteDrawing, this.height, this.x, this.y);
        if(Settings.DEBUG) {
            graphics.setColor(Color.red);
            graphics.drawRect(x, y, width, height);
        }

    }

    protected float getHealthAlpha(){
        float healthDecimal = (float) health/(float) initialHealth;
        return healthDecimal/2 + 0.5f;
    }

    protected Color getColor(){

        return ColorBuilder.buildGreen(getHealthAlpha());

    }


}
