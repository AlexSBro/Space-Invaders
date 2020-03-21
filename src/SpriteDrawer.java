import java.awt.*;

public class SpriteDrawer {

    public static void drawSprite(Graphics graphics, Color color, char[][] coordinates, int size, int x, int y){
        graphics.setColor(color);
        int tenth = size/10;

        for(int innerY = 0; innerY < coordinates.length; innerY++){
            for(int innerX = 0; innerX < coordinates[innerY].length; innerX++){
                if(coordinates[innerY][innerX] == 'X'){
                    graphics.fillRect(x + innerX*tenth, y + innerY*tenth, tenth, tenth);
                }
            }
        }
    }

}
