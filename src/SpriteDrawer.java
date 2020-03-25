import java.awt.*;
import java.awt.AlphaComposite;
import java.awt.image.BufferedImage;

public class SpriteDrawer {

    public static void drawSprite(Graphics graphics, Color color, char[][] coordinates, int size, int x, int y){

        graphics.setColor(color);

        float eigth = size/8;

        for(int innerY = 0; innerY < coordinates.length; innerY++){
            for(int innerX = 0; innerX < coordinates[innerY].length; innerX++){
                if(coordinates[innerY][innerX] == 'X'){
                    graphics.fillRect((int)(x + innerX*eigth), (int)(y + innerY*eigth), (int) eigth, (int) eigth);
                }
                else if(coordinates[innerY][innerX] == 'x'){
                    graphics.setColor(ColorBuilder.buildSoftOrange(.8f));
                    graphics.fillRect((int) (x + innerX*eigth), (int) (y + innerY*eigth), (int) eigth, (int) eigth);
                    graphics.setColor(color);
                }
            }
        }
    }
}
