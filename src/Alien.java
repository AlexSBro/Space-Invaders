public class Alien extends GameObject {

    protected int hitPoints;

    protected int initialX;
    protected int initialY;

    protected boolean moveRight;
    protected boolean moveLeft;

    public Alien(int x, int y, int width, int height, int speed, int health, GameObjectManager gameObjects) {
        super(x, y, width, height, speed, health, gameObjects);
        this.hitPoints = hitPoints;
    }

    public Alien(int width, int height, int speed, int health, int hitPoints, GameObjectManager gameObjects) {
        super(width, height, speed, health, gameObjects);
        this.hitPoints = hitPoints;
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
        if(this.y + this.height >= Board.BOARD_HEIGHT - 60){
            gameObjectManager.getPlayer().hit(this.hitPoints);
            removeSelf();
        }
    }

    protected void registerHits(){
        for(GameObject gameObject: gameObjectManager.getGameObjects()){
            if (gameObject instanceof Projectile && gameObjectManager.isIntersecting(this, gameObject)) {
                this.health--;
                if (health == 0)
                    removeSelf();
                gameObject.removeSelf();
            }
        }
    }


}
