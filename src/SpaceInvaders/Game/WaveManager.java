package SpaceInvaders.Game;

import SpaceInvaders.GameObjects.*;

import java.util.ArrayList;

public class WaveManager {

    private int waveNumber = -1;

    protected GameObjectManager gameObjectManager;

    private ArrayList<ArrayList<GameObject>> waves = new ArrayList<>();

    public WaveManager(GameObjectManager gameObjectManager){
        this.gameObjectManager = gameObjectManager;

        waves.add(generateStartString());
        waves.add(generateHunterAlien(2, 50, 150));
        waves.add(generateStreakerAlien(1, 10, 25));
        waves.add(generateBasicAliens(8, 3, 10));

    }

    private ArrayList<GameObject> generateStartString(){
        ArrayList<GameObject> wave = new ArrayList<>();

        wave.add(new Letter(200,200,0,0,0,1,1,gameObjectManager,'S'));
        wave.add(new Letter(250,200,0,0,0,1,1,gameObjectManager,'T'));
        wave.add(new Letter(300,200,0,0,0,1,1,gameObjectManager,'A'));
        wave.add(new Letter(350,200,0,0,0,1,1,gameObjectManager,'R'));
        wave.add(new Letter(400,200,0,0,0,1,1,gameObjectManager,'T'));

        return wave;
    }

    private ArrayList<GameObject> generateBasicAliens(int speed, int health, int hitPoints){
        ArrayList<GameObject> wave = new ArrayList<>();

        int ax = 8;
        int ay = 8;

        for (int i = 0; i < 10; i++) {
            BasicAlien basicAlien = new BasicAlien(ax, ay, speed, health, hitPoints, gameObjectManager);
            ax += 40;
            if (i == 4) {
                ax = 8;
                ay += 40;
            }
            wave.add(basicAlien);
        }

        return wave;
    }

    private ArrayList<GameObject> generateStreakerAlien(int speed, int health, int hitPoints){
        ArrayList<GameObject> wave = new ArrayList<>();

        wave.add(new StreakerAlien(speed, health, hitPoints, gameObjectManager));

        return wave;
    }

    private ArrayList<GameObject> generateHunterAlien(int speed, int health, int hitPoints){
        ArrayList<GameObject> wave = new ArrayList<>();

        wave.add(new HunterAlien(speed, health, hitPoints, gameObjectManager));

        return wave;
    }

    public ArrayList<GameObject> getNextWave(){
        if (waveNumber+1 < waves.size()) {
            waveNumber++;
            return waves.get(waveNumber);
        }else{
            return null;
        }
    }

    public int getWaveNumber() {
        return waveNumber;
    }
}
