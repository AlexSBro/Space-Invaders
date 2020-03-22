import java.util.ArrayList;

public class WaveManager {

    private int waveNumber = -1;

    protected GameObjectManager gameObjectManager;

    private ArrayList<ArrayList<GameObject>> waves = new ArrayList<>();

    public WaveManager(GameObjectManager gameObjectManager){
        this.gameObjectManager = gameObjectManager;

        waves.add(generateBasicAliens(20, 1, 5));
        waves.add(generateStreakerAlien(1, 100, 50));
//        waves.add(generateBasicAliens(5, 2));
//        waves.add(generateBasicAliens(5, 2));
//        waves.add(generateBasicAliens(5, 2));
//        waves.add(generateBasicAliens(5, 2));
//        waves.add(generateBasicAliens(10, 3));
    }

    private ArrayList<GameObject> generateStreakerAlien(int speed, int health, int hitPoints){
        ArrayList<GameObject> wave = new ArrayList<>();

        wave.add(new StreakerAlien(Board.BOARD_WIDTH/2, 0, speed, health, hitPoints, gameObjectManager));

        return wave;
    }

    private ArrayList<GameObject> generateSuperAlien(int speed, int health, int hitPoints){
        ArrayList<GameObject> wave = new ArrayList<>();

        wave.add(new SuperAlien(Board.BOARD_WIDTH, 0, speed, health, hitPoints, gameObjectManager));

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
        waveNumber++;
        if (waveNumber < waves.size()) {
            return waves.get(waveNumber);
        }else{
            return null;
        }
    }


}
