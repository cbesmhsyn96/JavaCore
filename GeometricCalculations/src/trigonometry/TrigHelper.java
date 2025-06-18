package trigonometry;

public class TrigHelper {
    public static double sin(double thetaDegrees){
        return Math.sin(toRadians(thetaDegrees));
    }
    public static double cos(double thetaDegrees){
        return Math.cos(toRadians(thetaDegrees));
    }
    public static double tan(double thetaDegrees){
        return Math.tan(toRadians(thetaDegrees));
    }
    public static double cot(double thetaDegrees){
        return 1/Math.tan(toRadians(thetaDegrees));
    }
    private static double toRadians(double thetaDegrees){
        return Math.toRadians(thetaDegrees);
    }
}
