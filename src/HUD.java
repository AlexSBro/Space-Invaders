import java.awt.*;

public class HUD {

    public static void draw(Graphics graphics, int health, int level){
        drawHealthBar(graphics, health);
        drawLevel(graphics, level);
        if(health <= 0){
            drawGameOver(graphics);
        }
    }

    private static void drawLevel(Graphics graphics, int level){
        graphics.setColor(Color.white);
        Font font = new Font("Monotype Corsiva", Font.PLAIN, 20);

        graphics.setFont(font);
        graphics.drawString(String.valueOf(level),30, 30);
    }

    private static void drawGameOver(Graphics graphics){
        graphics.setColor(Color.red);
        Font font = new Font("Monotype Corsiva", Font.PLAIN, 50);

        graphics.setFont(font);
        graphics.drawString("GAME OVER",180, Settings.BOARD_HEIGHT/2 - 25);
    }

    private static void drawHealthBar(Graphics graphics, int health) {
        //health bar
        graphics.setColor(Color.green);
        graphics.fillRect(Settings.BOARD_WIDTH - 110,Settings.BOARD_HEIGHT - 40, health, 10);
        //damage taken
        graphics.setColor(Color.red);
        graphics.fillRect(Settings.BOARD_WIDTH - 110 + health,Settings.BOARD_HEIGHT - 40, 100 - health, 10);
    }

}
