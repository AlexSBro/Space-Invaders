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


    public GameObject(){

    }

    public GameObject(int x, int y, int speed, int health, GameObjectManager gameObjects){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.health = health;
        this.gameObjectManager = gameObjects;
    }


    public void tick(){
        if (isOutOfBounds())
            removeSelf();
    }

    public void removeSelf(){
        gameObjectManager.addToRemovalQue(this);
    }

    private boolean isOutOfBounds(){
        return x > Board.BOARD_WIDTH || x < -width || y > Board.BOARD_HEIGHT || y + height < 0;
    }

    public void paint(Graphics graphics){}
}
