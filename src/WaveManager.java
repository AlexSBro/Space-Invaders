import java.util.ArrayList;

public class WaveManager {

    private int waveNumber = -1;

    protected GameObjectManager gameObjectManager;

    private ArrayList<ArrayList<GameObject>> waves = new ArrayList<>();

    public WaveManager(GameObjectManager gameObjectManager){
        this.gameObjectManager = gameObjectManager;

        waves.add(generateBasicAliens(1, 1));
        waves.add(generateBasicAliens(5, 2));
        waves.add(generateBasicAliens(10, 3));
    }

    private ArrayList<GameObject> generateBasicAliens(int speed, int health){
        ArrayList<GameObject> wave2 = new ArrayList<>();

        int ax = 10;
        int ay = 10;

        for (int i = 0; i < 10; i++) {
            BasicAlien basicAlien = new BasicAlien(ax, ay, speed, health, gameObjectManager);
            ax += 40;
            if (i == 4) {
                ax = 10;
                ay += 40;
            }
            wave2.add(basicAlien);
        }

        return wave2;
    }

    public ArrayList<GameObject> getNextWave(){
        waveNumber++;
        return waves.get(waveNumber);
    }


}
