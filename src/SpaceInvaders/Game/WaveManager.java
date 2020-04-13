package SpaceInvaders.Game;

import SpaceInvaders.GameObjects.*;

import java.util.ArrayList;
import java.util.Stack;

public class WaveManager {

    private int waveNumber = -1;

    protected GameObjectManager gameObjectManager;
    private AlienWave currentWave;

    private Stack<AlienWave> alienWaves = new Stack<>();

    public WaveManager(GameObjectManager gameObjectManager){
        this.gameObjectManager = gameObjectManager;

        alienWaves.push(generateHunterAlien(2, 50, 150));
        alienWaves.push(generateStreakerAlien(1, 10, 25));
        alienWaves.push(generateBasicAliens(8, 3, 10));
        alienWaves.push(generateStartString());

    }

    private AlienWave generateStartString(){
        AlienWave alienWave = new AlienWave(this);

        alienWave.addGameObject(new Letter(200,200,0,0,0,1,1,gameObjectManager, alienWave,'S'));
        alienWave.addGameObject(new Letter(250,200,0,0,0,1,1,gameObjectManager, alienWave,'T'));
        alienWave.addGameObject(new Letter(300,200,0,0,0,1,1,gameObjectManager, alienWave,'A'));
        alienWave.addGameObject(new Letter(350,200,0,0,0,1,1,gameObjectManager, alienWave,'R'));
        alienWave.addGameObject(new Letter(400,200,0,0,0,1,1,gameObjectManager, alienWave,'T'));

        return alienWave;
    }

    private AlienWave generateBasicAliens(int speed, int health, int hitPoints){
        AlienWave alienWave = new AlienWave(this);

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
        AlienWave alienWave = new AlienWave(this);

        alienWave.addGameObject(new StreakerAlien(speed, health, hitPoints, gameObjectManager, alienWave));

        return alienWave;
    }

    private AlienWave generateHunterAlien(int speed, int health, int hitPoints){
        AlienWave alienWave = new AlienWave(this);

        alienWave.addGameObject(new HunterAlien(speed, health, hitPoints, gameObjectManager, alienWave));

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
        alienWaves.pop();
        if(!alienWaves.empty()) {
            currentWave = alienWaves.peek();
            gameObjectManager.setNextWave(currentWave);
        }
    }

    public int getWaveNumber() {
        return waveNumber;
    }
}
