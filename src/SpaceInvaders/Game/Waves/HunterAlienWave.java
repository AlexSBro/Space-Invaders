package SpaceInvaders.Game.Waves;

import SpaceInvaders.Game.GameObjectManager;
import SpaceInvaders.GameObjects.HunterAlien;
import SpaceInvaders.GameObjects.Letter;

public class HunterAlienWave extends AlienWave {

    public HunterAlienWave(GameObjectManager gameObjectManager, WaveManager waveManager) {
        super(gameObjectManager, waveManager);

        aliens.add(new HunterAlien(2, 50, 150, gameObjectManager, this));
    }

}
