package SpaceInvaders.GameObjects;

import SpaceInvaders.Game.GameObjectManager;
import SpaceInvaders.Game.Settings;
import SpaceInvaders.Game.Waves.AlienWave;

public class Alien extends GameObject {

    protected int hitPoints;
    protected int scoreValue;

    protected int initialX;
    protected int initialY;

    protected boolean moveRight;
    protected boolean moveLeft;

    private AlienWave alienWave;

    public Alien(int x, int y, int width, int height, int speed, int health, int hitPoints, GameObjectManager gameObjects, AlienWave alienWave) {
        super(x, y, width, height, speed, health, gameObjects);
        this.alienWave = alienWave;
        this.hitPoints = hitPoints;
        scoreValue = hitPoints;
    }

    public Alien(int width, int height, int speed, int health, int hitPoints, GameObjectManager gameObjects, AlienWave alienWave) {
        super(width, height, speed, health, gameObjects);
        this.alienWave = alienWave;
        this.hitPoints = hitPoints;
        scoreValue = hitPoints;
    }

    public void tick() {
        super.tick();

        alienMovementAlgorithm();
        registerHits();
        checkAlienPassedPlayer();
    }

    public void alienMovementAlgorithm() {
        if (this.moveLeft)
            this.x -= speed;

        if (this.moveRight)
            this.x += speed;
    }

    public void checkAlienPassedPlayer(){
        if(this.y + this.height >= Settings.BOARD_HEIGHT - 60){
            if(gameObjectManager.getPlayer() != null) {
                gameObjectManager.getPlayer().hit(this.hitPoints);
            }
            removeSelf();
        }
    }

    protected void registerHits(){
        for(GameObject gameObject: gameObjectManager.getGameObjects()){
            if (gameObject instanceof Projectile && gameObjectManager.isIntersecting(this, gameObject)) {
                this.health--;
                if (health == 0){
                    removeSelf();
                    gameObjectManager.addScore(scoreValue);
                }
                //This is removing the projectile
                gameObject.removeSelf();
            }
        }
    }

    @Override
    public void removeSelf() {
        super.removeSelf();
        alienWave.removeAlien(this);
    }

    public int getHitPoints() {
        return hitPoints;
    }
}
