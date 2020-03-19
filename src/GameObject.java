import java.awt.*;
import java.util.ArrayList;

public class GameObject {

    protected GameObjectManager gameObjectManager;

    protected int x;
    protected int y;

    protected int width;
    protected int height;

    protected int speed;

    public GameObject(){

    }

    public GameObject(int x, int y, int speed, GameObjectManager gameObjects){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.gameObjectManager = gameObjects;
    }

    public void removeSelf(){
        gameObjectManager.addToRemovalQue(this);
    }

    public void tick(){

        //testing if out of board bounds (X or Y), will delete itself if so.
        if (x + width > Board.BOARD_WIDTH || x + width < Board.BOARD_WIDTH || y + height > Board.BOARD_HEIGHT || y + height < Board.BOARD_HEIGHT){
            removeSelf();
        }
    }

    public void paint(Graphics graphics){}


}
