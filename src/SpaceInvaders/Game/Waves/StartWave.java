package SpaceInvaders.Game.Waves;

import SpaceInvaders.Game.GameObjectManager;
import SpaceInvaders.Game.Waves.AlienWave;
import SpaceInvaders.Game.Waves.WaveManager;
import SpaceInvaders.GameObjects.Letter;

public class StartWave extends AlienWave {

    public StartWave(GameObjectManager gameObjectManager, WaveManager waveManager) {
        super(gameObjectManager, waveManager);

        aliens.add(new Letter(200,200,0,0,0,1,1,gameObjectManager, this,'S'));
        aliens.add(new Letter(250,200,0,0,0,1,1,gameObjectManager, this,'T'));
        aliens.add(new Letter(300,200,0,0,0,1,1,gameObjectManager, this,'A'));
        aliens.add(new Letter(350,200,0,0,0,1,1,gameObjectManager, this,'R'));
        aliens.add(new Letter(400,200,0,0,0,1,1,gameObjectManager, this,'T'));

    }

}
