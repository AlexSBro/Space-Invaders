import java.awt.*;
import java.awt.AlphaComposite;
import java.awt.image.BufferedImage;

public class SpriteDrawer {

    public static void drawSprite(Graphics graphics, Color color1, Color color2, char[][] coordinates, int width, int height, int x, int y){

        graphics.setColor(color1);

        float xRatio = width/coordinates[0].length;
        float yRatio = height/coordinates.length;

        for(int innerY = 0; innerY < coordinates.length; innerY++){
            for(int innerX = 0; innerX < coordinates[innerY].length; innerX++){
                if(coordinates[innerY][innerX] == 'X'){
                    graphics.fillRect((int)(x + innerX*xRatio), (int)(y + innerY*yRatio), (int) xRatio, (int) yRatio);
                }
                else if(coordinates[innerY][innerX] == 'o'){
                    graphics.setColor(color2);
                    graphics.fillRect((int) (x + innerX*xRatio), (int) (y + innerY*yRatio), (int) xRatio, (int) yRatio);
                    graphics.setColor(color1);
                }
            }
        }
    }
}
