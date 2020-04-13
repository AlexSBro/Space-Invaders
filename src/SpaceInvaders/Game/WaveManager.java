package SpaceInvaders.Game;

import SpaceInvaders.GameObjects.*;

import java.util.ArrayList;

public class WaveManager {

    private int waveNumber = -1;

    protected GameObjectManager gameObjectManager;

    private ArrayList<AlienWave> alienWaves = new ArrayList<>();

    public WaveManager(GameObjectManager gameObjectManager){
        this.gameObjectManager = gameObjectManager;

        alienWaves.add(generateStartString());
        alienWaves.add(generateHunterAlien(2, 50, 150));
        alienWaves.add(generateStreakerAlien(1, 10, 25));
        alienWaves.add(generateBasicAliens(8, 3, 10));

    }

    private AlienWave generateStartString(){
        AlienWave alienWave = new AlienWave();

        alienWave.addGameObject(new Letter(200,200,0,0,0,1,1,gameObjectManager, alienWave,'S'));
        alienWave.addGameObject(new Letter(250,200,0,0,0,1,1,gameObjectManager, alienWave,'T'));
        alienWave.addGameObject(new Letter(300,200,0,0,0,1,1,gameObjectManager, alienWave,'A'));
        alienWave.addGameObject(new Letter(350,200,0,0,0,1,1,gameObjectManager, alienWave,'R'));
        alienWave.addGameObject(new Letter(400,200,0,0,0,1,1,gameObjectManager, alienWave,'T'));

        return alienWave;
    }

    private AlienWave generateBasicAliens(int speed, int health, int hitPoints){
        AlienWave alienWave = new AlienWave();

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
        AlienWave alienWave = new AlienWave();

        alienWave.addGameObject(new StreakerAlien(speed, health, hitPoints, gameObjectManager, alienWave));

        return alienWave;
    }

    private AlienWave generateHunterAlien(int speed, int health, int hitPoints){
        AlienWave alienWave = new AlienWave();

        alienWave.addGameObject(new HunterAlien(speed, health, hitPoints, gameObjectManager, alienWave));

        return alienWave;
    }

    public AlienWave getNextWave(){
        if (waveNumber+1 < alienWaves.size()) {
            waveNumber++;
            return alienWaves.get(waveNumber);
        }else{
            return null;
        }
    }

    public int getWaveNumber() {
        return waveNumber;
    }
}
