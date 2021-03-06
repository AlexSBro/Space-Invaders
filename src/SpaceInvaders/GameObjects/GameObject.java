package SpaceInvaders.GameObjects;

import SpaceInvaders.Game.GameObjectManager;
import SpaceInvaders.Game.Settings;
import SpaceInvaders.Utilities.ColorBuilder;
import SpaceInvaders.Utilities.SpriteDrawer;

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
            gameObjectManager.addToQue(new Explosion(x, y, width, height, speed, ((Alien) this).getHitPoints(), gameObjectManager));
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

        SpriteDrawer.drawSprite(graphics, getColor(), getSecondaryColor(), spriteDrawing, this.width, this.height, this.x, this.y);

    }

    protected float getHealthAlpha(){
        float healthDecimal = (float) health/(float) initialHealth;
        return healthDecimal/2 + 0.5f;
    }

    protected Color getColor(){

        return ColorBuilder.buildGreen(getHealthAlpha());

    }

    protected Color getSecondaryColor(){

        return ColorBuilder.buildGreen(getHealthAlpha());

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getHealth() {
        return health;
    }

}
