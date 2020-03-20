public class Alien extends GameObject {


    public Alien(int x, int y, int speed, int health, GameObjectManager gameObjects) {
        super(x, y, speed, health, gameObjects);
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
