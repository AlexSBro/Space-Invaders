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

    private ArrayList<GameObject> generateStreakerAlien(int speed, int health){
        ArrayList<GameObject> wave = new ArrayList<>();

        wave.add(new StreakerAlien(Board.BOARD_WIDTH, 0, speed, health, gameObjectManager));

        return wave;
    }

    private ArrayList<GameObject> generateBasicAliens(int speed, int health){
        ArrayList<GameObject> wave = new ArrayList<>();

        int ax = 10;
        int ay = 10;

        for (int i = 0; i < 10; i++) {
            BasicAlien basicAlien = new BasicAlien(ax, ay, speed, health, gameObjectManager);
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
        if (waveNumber < waves.size()-1) {
            waveNumber++;
            return waves.get(waveNumber);
        }else{
            return null;
        }
    }


}
