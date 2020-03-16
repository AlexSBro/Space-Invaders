import java.awt.*;

public class GameObject {

    protected int x;
    protected int y;

    protected int width;
    protected int height;

    protected int speed;

    public GameObject(){

    }

    public GameObject(int x, int y, int speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
    }


    public void tick(){}

    public void paint(Graphics graphics){}


}
