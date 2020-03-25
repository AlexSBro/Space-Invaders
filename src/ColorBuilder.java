import java.awt.*;

public class ColorBuilder {

    public static Color buildRed(float alpha){
        return new Color(1f, 0f, 0f, alpha);
    }

    public static Color buildSoftRed(float alpha){
        return new Color(.777f, .111f, 0f, alpha);
    }

    public static Color buildGreen(float alpha){
        return new Color(0f, 1f, 0.5f, alpha);
    }

    public static Color buildSoftGreen(float alpha){
        return new Color(0.5f, 1f, 0.5f, alpha);
    }

    public static Color buildBlue(float alpha){
        return new Color(0f, 0f, 1f, alpha);
    }

    public static Color buildWhite(float alpha){
        return new Color(1f, 1f, 1f, alpha);
    }

    public static Color buildOrange(float alpha){
        return new Color(1f, 0.666f, 0f, alpha);
    }

    public static Color buildSoftOrange(float alpha){
        return new Color(1f, 0.5f, 0f, alpha);
    }

    public static Color buildYellow(float alpha){
        return new Color(1f, 1f, 0f, alpha);
    }

    public static Color buildSoftYellow(float alpha){
        return new Color(1f, 1f, .5f, alpha);
    }
}
