package SpaceInvaders.Game.Waves;

import SpaceInvaders.Game.GameObjectManager;
import SpaceInvaders.Game.Waves.WaveManager;
import SpaceInvaders.GameObjects.Alien;
import SpaceInvaders.GameObjects.GameObject;

import java.util.ArrayList;

public class AlienWave {

    private boolean canExit = true;

    protected ArrayList<GameObject> aliens = new ArrayList<>();
    protected WaveManager waveManager;
    protected GameObjectManager gameObjectManager;

    public AlienWave(GameObjectManager gameObjectManager, WaveManager waveManager) {
        this.gameObjectManager = gameObjectManager;
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
