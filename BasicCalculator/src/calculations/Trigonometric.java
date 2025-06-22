package calculations;
import fields.Fields;
import java.util.Scanner;

public class Trigonometric extends Fields {
    
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
        return 1/tan(thetaDegrees);
    }

    public static double asin(double ratio){
        return Math.toDegrees(Math.asin(ratio));
    }

    public static double acos(double ratio){
        return Math.toDegrees(Math.acos(ratio));
    }

    public static double atan(double ratio){
        return Math.toDegrees(Math.atan(ratio));
    }

    public static double acot(double ratio){
        return Math.toDegrees(Math.atan(1.0 / ratio));
    }

    private static double toRadians(double thetaDegrees) {
        return Math.toRadians(thetaDegrees);
    }

    public static void trigonometricCalcs(){
        System.out.println("Trigonometrik Hesaplamalar");
        System.out.print("İlk sayıyı gir :");
        String sayi1 = new Scanner(System.in).nextLine();
        System.out.print("İkinci sayıyı gir :");
        String sayi2 = new Scanner(System.in).nextLine();
        if(patternInt.matcher(sayi1).matches()&&
                patternPositiveIntAndDouble.matcher(sayi2).matches()){
            double sayi1Int = Integer.parseInt(sayi1);
            double sayi2IDouble = Integer.parseInt(sayi2);
            System.out.printf("%10s %10s %10s %10s %10s %10s%n","SIN","COS","TAN","COT","ATAN","ACOT");
            System.out.printf("%10.2f %10.2f %10.2f %10.2f %10.2f %10.2f%n",
                    sin(sayi1Int),
                    cos(sayi1Int),
                    tan(sayi1Int),
                    cot(sayi1Int),
                    atan(sayi2IDouble),
                    acot(sayi2IDouble));
        }
    }

}
