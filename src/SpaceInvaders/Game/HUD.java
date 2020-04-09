package SpaceInvaders.Game;

import SpaceInvaders.PersistentStore.PersistentStore;

import java.awt.*;

public class HUD {

    public static void draw(Graphics graphics, int health, int level, int score){
        drawHealthBar(graphics, health);
        drawLevel(graphics, level);
        drawScoreCounter(graphics, score);
        if(health <= 0){
            drawGameOver(graphics);
            drawHighScore(graphics, score);
        }
    }

    private static void drawLevel(Graphics graphics, int level){
        String levelString = "LEVEL : " + String.valueOf(level);

        graphics.setColor(Color.white);
        Font font = new Font("Monotype Corsiva", Font.PLAIN, 24);

        graphics.setFont(font);
        graphics.drawString(levelString,Settings.BOARD_WIDTH - 152, 32);
    }

    private static void drawGameOver(Graphics graphics){
        graphics.setColor(Color.red);
        Font font = new Font("Monotype Corsiva", Font.PLAIN, 50);

        graphics.setFont(font);
        graphics.drawString("GAME OVER",180, Settings.BOARD_HEIGHT/2 - 25);
    }

    private static void drawHighScore(Graphics graphics, int score){
        //String highScoreValue = String.valueOf(PersistentStore.readHighScore(score));
        String highScoreString = "HIGHSCORE: " + PersistentStore.highScoreValue;

        graphics.setColor(Color.white);
        Font font = new Font("Monotype Corsiva", Font.PLAIN, 50);

        graphics.setFont(font);
        graphics.drawString(highScoreString,150, Settings.BOARD_HEIGHT/2 + 25);
    }

    private static void drawHealthBar(Graphics graphics, int health) {
        //health bar
        graphics.setColor(Color.green);
        graphics.fillRect(Settings.BOARD_WIDTH - 110,Settings.BOARD_HEIGHT - 40, health, 10);
        //damage taken
        graphics.setColor(Color.red);
        graphics.fillRect(Settings.BOARD_WIDTH - 110 + health,Settings.BOARD_HEIGHT - 40, 100 - health, 10);
    }

    private static void drawScoreCounter(Graphics graphics, int score){
        String scoreString = "SCORE : " + String.valueOf(score);

        graphics.setColor(Color.white);
        Font font = new Font("Monotype Corsiva", Font.PLAIN, 24);

        graphics.setFont(font);
        graphics.drawString(scoreString, 30, 30);
    }

}
