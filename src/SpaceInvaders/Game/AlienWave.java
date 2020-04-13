package SpaceInvaders.Game;

import SpaceInvaders.GameObjects.Alien;
import SpaceInvaders.GameObjects.GameObject;

import java.util.ArrayList;

public class AlienWave {

    private boolean canExit = true;

    private ArrayList<GameObject> aliens = new ArrayList<>();
    private WaveManager waveManager;

    public AlienWave(WaveManager waveManager) {
        this.waveManager = waveManager;
    }

    public void tick(){
        if(aliens.size() == 0 && canExit){
            waveManager.nextWave();
        }
    }

    public void addGameObject(GameObject gameObject){
        aliens.add(gameObject);
    }

    public ArrayList<GameObject> getAliens() {
        return aliens;
    }

    public void removeAlien(Alien killedAlien){
        aliens.remove(killedAlien);
    }

}
