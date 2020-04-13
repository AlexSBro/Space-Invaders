package SpaceInvaders.Game;

import SpaceInvaders.GameObjects.Alien;
import SpaceInvaders.GameObjects.GameObject;

import java.util.ArrayList;

public class AlienWave {

    private ArrayList<GameObject> aliens = new ArrayList<>();

    private void tick(){

    }

    public void addGameObject(GameObject gameObject){
        aliens.add(gameObject);
    }

    public ArrayList<GameObject> getAliens() {
        return aliens;
    }

    public void remove(Alien killedAlien){
        aliens.remove(killedAlien);
    }

}
