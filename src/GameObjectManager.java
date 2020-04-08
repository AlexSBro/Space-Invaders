import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameObjectManager {

    private boolean rightKeyPressed;
    private boolean leftKeyPressed;

    private boolean fireShot = false;

    private WaveManager waveManager;

    private CopyOnWriteArrayList<GameObject> gameObjects = new CopyOnWriteArrayList<>();

    private ArrayList<GameObject> addedObjects = new ArrayList<>();
    private ArrayList<GameObject> deletedObjects = new ArrayList<>();

    private Player player;

    public GameObjectManager() {
        waveManager = new WaveManager(this);

        player = new Player(8, 100,this);
        gameObjects.add(player);
    }


    public void updateObjects(){

        gameObjects.addAll(addedObjects);
        gameObjects.removeAll(deletedObjects);

        addedObjects = new ArrayList<>();
        deletedObjects = new ArrayList<>();

    }

    public void getNextWave(){
        ArrayList<GameObject> nextWave = waveManager.getNextWave();
        if (nextWave != null) {
            gameObjects.addAll(nextWave);
        }

    }

    public void start(){
        waveManager = new WaveManager(this);
        player = new Player(8, 100,this);
        gameObjects = new CopyOnWriteArrayList<>();
        gameObjects.add(player);
    }

    public boolean isIntersecting(GameObject gameObjectA, GameObject gameObjectB){

        int topA = gameObjectA.y;
        int bottomA = gameObjectA.y + gameObjectA.height;
        int leftA = gameObjectA.x;
        int rightA = gameObjectA.x + gameObjectA.width;

        int topB = gameObjectB.y;
        int bottomB = gameObjectB.y + gameObjectB.height;
        int leftB = gameObjectB.x;
        int rightB = gameObjectB.x + gameObjectB.width;

        return ((topA <= bottomB && bottomA >= bottomB) || (bottomA >= topB && bottomA <= bottomB)) && ((rightA >= leftB && leftA <= leftB) || (leftA <= rightB && leftA >= leftB));
    }

    public int getWaveNumber() {
        return waveManager.getWaveNumber();
    }

    public void addToQue(GameObject gameObject){
        addedObjects.add(gameObject);
    }

    public void addToRemovalQue(GameObject gameObject){
        deletedObjects.add(gameObject);
    }

    public Player getPlayer() {
        return player;
    }

    public CopyOnWriteArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    public boolean isFireShot() {
        return fireShot;
    }

    public void fireShot(boolean fireShot){

        if(player.health != 0){
            this.fireShot = fireShot;
        }else {
            start();
        }

    }

    public void rightKeyPressed(){
        this.rightKeyPressed = true;
    }
    public void rightKeyReleased(){
        this.rightKeyPressed = false;
    }

    public void leftKeyPressed(){
        this.leftKeyPressed = true;
    }
    public void leftKeyReleased(){
        this.leftKeyPressed = false;
    }

    public boolean isRightKeyPressed() {
        return rightKeyPressed;
    }
    public boolean isLeftKeyPressed() {
        return leftKeyPressed;
    }

    public void addScore(int score){
        this.player.addScore(score);
    }

}

