package SpaceInvaders.Game.Waves;

import SpaceInvaders.Game.GameObjectManager;
import SpaceInvaders.GameObjects.*;

import java.util.Stack;

public class WaveManager {

    private int waveNumber = 1;

    protected GameObjectManager gameObjectManager;
    private AlienWave currentWave;

    protected Stack<AlienWave> alienWaves = new Stack<>();

    public WaveManager(GameObjectManager gameObjectManager){
        this.gameObjectManager = gameObjectManager;

        alienWaves.push(new HunterAlienWave(gameObjectManager, this));
        alienWaves.push(generateStreakerAlien(1, 10, 25));
        alienWaves.push(generateBasicAliens(8, 3, 10));
        alienWaves.push(new StartWave(gameObjectManager,this));

    }

    private AlienWave generateBasicAliens(int speed, int health, int hitPoints){
        AlienWave alienWave = new AlienWave(gameObjectManager,this);

        int ax = 8;
        int ay = 8;

        for (int i = 0; i < 10; i++) {
            BasicAlien basicAlien = new BasicAlien(ax, ay, speed, health, hitPoints, gameObjectManager, alienWave);
            ax += 40;
            if (i == 4) {
                ax = 8;
                ay += 40;
            }
            alienWave.addGameObject(basicAlien);
        }

        return alienWave;
    }

    private AlienWave generateStreakerAlien(int speed, int health, int hitPoints){
        AlienWave alienWave = new AlienWave(gameObjectManager,this);

        alienWave.addGameObject(new StreakerAlien(speed, health, hitPoints, gameObjectManager, alienWave));

        return alienWave;
    }

    private AlienWave generateHunterAlien(int speed, int health, int hitPoints){
        AlienWave alienWave = new AlienWave(gameObjectManager,this);



        return alienWave;
    }

    public void start(){
        this.currentWave = alienWaves.peek();
        gameObjectManager.setNextWave(alienWaves.peek());
    }

    public void tick(){
        if(currentWave != null) {
            currentWave.tick();
        }
    }

    public void nextWave(){
        if(!alienWaves.empty()) {
            alienWaves.pop();
            if(!alienWaves.empty()) {
                currentWave = alienWaves.peek();
                gameObjectManager.setNextWave(currentWave);
                waveNumber ++;
            }
        }
    }

    public int getWaveNumber() {
        return waveNumber;
    }
}
