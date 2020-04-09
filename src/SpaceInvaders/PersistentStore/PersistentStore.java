package SpaceInvaders.PersistentStore;

import SpaceInvaders.Game.Settings;

import java.io.*;

public class PersistentStore {

    public static File highScoreFile = new File(Settings.HIGH_SCORE_FILE);
    public static String highScoreValue;

    private static void createFile(String fileName){
        highScoreFile = new File(fileName);
        try {
            highScoreFile.createNewFile();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private static boolean checkFileExists(){
        if (highScoreFile == null)
            return false;
        return highScoreFile.exists();
    }

    public static void readHighScore(int currentScore)  {
        if (!checkFileExists())
            createFile(Settings.HIGH_SCORE_FILE);


        FileReader readFile;
        BufferedReader reader = null;
        try {
            readFile = new FileReader(Settings.HIGH_SCORE_FILE);
            reader = new BufferedReader(readFile);
            String score = reader.readLine();
            if (score == null || currentScore > Integer.parseInt(score) )
                writeHighScore(currentScore);
            highScoreValue = score;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if (reader != null)
                    reader.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void writeHighScore(int score){
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(Settings.HIGH_SCORE_FILE);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.valueOf(score));
        }
        catch (Exception e){
            System.out.println("file error");
            e.printStackTrace();
        } finally {
            try{
                if (bufferedWriter != null)
                    bufferedWriter.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
