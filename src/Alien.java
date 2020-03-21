public class Alien extends GameObject {

    protected int health;
    protected int speed;

    protected int initialX;
    protected int initialY;

    protected boolean moveRight;
    protected boolean moveLeft;

    public Alien(int x, int y, int speed, int health, GameObjectManager gameObjects) {
        super(x, y, speed, health, gameObjects);
    }

    @Override
    public void tick() {
        super.tick();

        alienMovementAlgorithm();
        registerHits();
    }

    public void alienMovementAlgorithm() {
        if (this.moveLeft)
            this.x -= speed;    //this.speed;

        if (this.moveRight)
            this.x += speed;    //this.speed;

        if (this.x > Board.BOARD_WIDTH - (200 - this.initialX)) {
            this.moveLeft = true;
            this.moveRight = false;
            this.y += this.height + 5;
        }
        if (this.x <= this.initialX) {
            this.moveRight = true;
            this.moveLeft = false;
            this.y += this.height + 5;
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
