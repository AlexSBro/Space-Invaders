import java.util.ArrayList;

public class GameObjectManager {

    private ArrayList<GameObject> gameObjects = new ArrayList<>();
    private ArrayList<GameObject> addedObjects = new ArrayList<>();

    public void addToQue(GameObject gameObject){
        addedObjects.add(gameObject);
    }

}

