import java.io.*;

public class PersistantStore {

    public static File highScoreFile = new File(Settings.highScoreFile);









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

    public static String readHighScore(int currentScore)  {
        if (!checkFileExists())
            createFile(Settings.highScoreFile);


        FileReader readFile = null;
        BufferedReader reader = null;
        try {
            readFile = new FileReader(Settings.highScoreFile);
            reader = new BufferedReader(readFile);
            if (currentScore > Integer.parseInt(reader.readLine()) || reader.readLine() == null)
                writeHighScore(currentScore);
            return reader.readLine();
        }
        catch (Exception e){
            return "-1";
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
        FileWriter fileWriter = null;
        BufferedWriter writer = null;
        try {
            fileWriter = new FileWriter(Settings.highScoreFile);
            writer = new BufferedWriter(fileWriter);
            writer.write(String.valueOf(score));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if (writer != null)
                    writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
