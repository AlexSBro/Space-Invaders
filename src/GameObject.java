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
        removeIfOutOfBounds();
    }

    private void removeIfOutOfBounds() {
        //testing if out of board bounds (X or Y), will delete itself if so.
        if (x > Board.BOARD_WIDTH || x < -width || y > Board.BOARD_HEIGHT || y + height < 0){
            removeSelf();
        }
    }

    public void paint(Graphics graphics){}

}
