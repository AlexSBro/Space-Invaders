import java.awt.*;

public class ColorBuilder {

    public static Color buildRed(float alpha){
        return new Color(255, 0, 0, alpha);
    }

    public static Color buildGreen(float alpha){
        return new Color(1f, 1f, 1f, alpha);
    }

    public static Color buildBlue(float alpha){
        return new Color(1f, 0, 0, alpha);
    }

    public static Color buildOrange(float alpha){
        return new Color(255, 0, 0, alpha);
    }
}
