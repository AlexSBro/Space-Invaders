import java.util.ArrayList;

public class GameObjectManager {

    private boolean rightKeyPressed;
    private boolean leftKeyPressed;
    private boolean spacePressed;

    private ArrayList<GameObject> gameObjects = new ArrayList<>();

    private ArrayList<GameObject> addedObjects = new ArrayList<>();
    private ArrayList<GameObject> deletedObjects = new ArrayList<>();

    private Player player;


    public GameObjectManager() {
        player = new Player(Board.BOARD_WIDTH/2, Board.BOARD_HEIGHT-60, 5, this);
        gameObjects.add(player);

        int ax = 10;
        int ay = 10;

        for (int i = 0; i < 10; i++) {
            Alien alien = new Alien(ax, ay, 10, this);
            ax += 40;
            if (i == 4) {
                ax = 10;
                ay += 40;
            }
            gameObjects.add(alien);
        }
    }

    public void addToRemovalQue(GameObject gameObject){
        deletedObjects.remove(gameObject);
    }

    public void addToQue(GameObject gameObject){
        addedObjects.add(gameObject);
    }

    public void updateObjects(){
        gameObjects.addAll(addedObjects);
        gameObjects.removeAll(deletedObjects);

        addedObjects = new ArrayList<>();
        deletedObjects = new ArrayList<>();
    }

    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void spacePressed(){
        this.spacePressed = true;
    }
    public void spaceReleased(){
        this.spacePressed = false;
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
    public boolean isSpacePressed() {
        return spacePressed;
    }
}

