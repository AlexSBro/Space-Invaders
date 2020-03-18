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


    public void tick(){}

    public void paint(Graphics graphics){}


}
