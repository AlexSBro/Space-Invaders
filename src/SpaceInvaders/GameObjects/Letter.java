package SpaceInvaders.GameObjects;

import SpaceInvaders.Game.Waves.AlienWave;
import SpaceInvaders.Game.GameObjectManager;
import SpaceInvaders.Game.Settings;

import java.awt.*;

public class Letter extends Alien {

    char letter = 'a';

    public Letter(int x, int y, int width, int height, int speed, int health, int hitPoints, GameObjectManager gameObjects, AlienWave alienWave, char letter) {
        super(x, y, 35, 40, speed, health, hitPoints, gameObjects, alienWave);
        this.letter = letter;
    }

    public void paint(Graphics graphics){


        graphics.setColor(Color.green);
        Font font = new Font("Monotype Corsiva", Font.PLAIN, 50);

        graphics.setFont(font);
        graphics.drawString(String.valueOf(letter), this.x, this.y + this.height);

        if(Settings.DEBUG) {
            graphics.setColor(Color.red);
            graphics.drawRect(x, y, width, height);
        }


    }


}
