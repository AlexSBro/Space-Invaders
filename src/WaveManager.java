import java.util.ArrayList;

public class WaveManager {

    private int waveNumber = -1;

    protected GameObjectManager gameObjectManager;

    private ArrayList<ArrayList<GameObject>> waves = new ArrayList<>();

    public WaveManager(GameObjectManager gameObjectManager){
        this.gameObjectManager = gameObjectManager;

//        waves.add(generateStreakerAlien(1, 10, 25));
//        waves.add(generateStreakerAlien(4, 10, 25));
//        waves.add(generateStreakerAlien(2, 10, 25));
//        waves.add(generateStreakerAlien(4, 10, 25));
//        waves.add(generateStreakerAlien(2, 10, 25));
//        waves.add(generateStreakerAlien(4, 5, 25));
//        waves.add(generateStreakerAlien(2, 10, 25));
//        waves.add(generateStreakerAlien(4, 5, 25));
//        waves.add(generateStreakerAlien(4, 5, 25));
//        waves.add(generateStreakerAlien(4, 5, 25));
//        waves.add(generateBasicAliens(2, 1, 5));
//        waves.add(generateBasicAliens(4, 2, 10));
//        waves.add(generateBasicAliens(8, 3, 10));
        waves.add(generateHunterAlien(2, 50, 150));
    }

    private ArrayList<GameObject> generateStreakerAlien(int speed, int health, int hitPoints){
        ArrayList<GameObject> wave = new ArrayList<>();

        wave.add(new StreakerAlien(speed, health, hitPoints, gameObjectManager));

        return wave;
    }

    private ArrayList<GameObject> generateHunterAlien(int speed, int health, int hitPoints){
        ArrayList<GameObject> wave = new ArrayList<>();

        wave.add(new HunterAlien(Board.BOARD_WIDTH/2, 0, speed, health, hitPoints, gameObjectManager));

        return wave;
    }

    private ArrayList<GameObject> generateBasicAliens(int speed, int health, int hitPoints){
        ArrayList<GameObject> wave = new ArrayList<>();

        int ax = 10;
        int ay = 10;

        for (int i = 0; i < 10; i++) {
            BasicAlien basicAlien = new BasicAlien(ax, ay, speed, health, hitPoints, gameObjectManager);
            ax += 40;
            if (i == 4) {
                ax = 10;
                ay += 40;
            }
            wave.add(basicAlien);
        }

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
