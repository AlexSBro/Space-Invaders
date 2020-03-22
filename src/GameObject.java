import java.awt.*;
import java.util.ArrayList;

public class GameObject {

    protected GameObjectManager gameObjectManager;

    protected int health;
    protected int speed;

    protected int x;
    protected int y;

    protected int width;
    protected int height;


    public GameObject(int x, int y, int speed, int health, GameObjectManager gameObjectManager){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.health = health;
        this.gameObjectManager = gameObjectManager;
    }

    public GameObject(int speed, int health, GameObjectManager gameObjectManager){
        this.speed = speed;
        this.health = health;
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
    }

    private boolean isOutOfBounds(){
        return x > Board.BOARD_WIDTH || x < -width || y > Board.BOARD_HEIGHT || y + height < 0;
    }

    public void paint(Graphics graphics){}
}
