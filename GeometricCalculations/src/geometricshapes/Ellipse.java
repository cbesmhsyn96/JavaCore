package geometricshapes;

import validations.PatternValidations;

import java.util.Scanner;

import static trigonometry.TrigHelper.cotRadians;

public class Ellipse extends PatternValidations {

    private static Scanner scanner = new Scanner(System.in);

    public static void ellipseArea(double majorAxis, double minorAxis){
        double majorAxisDiv2 = majorAxis/2;
        double minorAxisDiv2 = minorAxis/2;
        double area = pi_number*majorAxisDiv2*minorAxisDiv2;
        System.out.printf("\nAlan = %.2f", area);
    }

    public static void ellipsePerimeter(double majorAxis, double minorAxis){
        double majorAxisDiv2 = majorAxis/2;
        double minorAxisDiv2 = minorAxis/2;
        double perimeter = pi_number*(3*(majorAxisDiv2+minorAxisDiv2)
                -Math.sqrt(((3*majorAxisDiv2+minorAxisDiv2)*(majorAxisDiv2+3*minorAxisDiv2))));
        System.out.printf("\nÇevre = %.2f\n", perimeter);
    }

    public static void allCoveredMethodEllipse(boolean startingValue){
        boolean status = startingValue;
        do{
            System.out.println("\nElips için hesaplama başlatılıyor...");
            System.out.print("Büyük eksen uzunluğu (major axis) :");
            String majorAxis = scanner.nextLine();
            System.out.print("Küçük eksen uzunluğu (minor axis) :");
            String minorAxis = scanner.nextLine();
            if(intPattern.matcher(majorAxis).matches()&&intPattern.matcher(minorAxis).matches()){
                int majorAxisInt = Integer.parseInt(majorAxis);
                int minorAxisInt = Integer.parseInt(minorAxis);
                if(majorAxisInt>0&&minorAxisInt>0){
                    ellipseArea(majorAxisInt,minorAxisInt);
                    ellipsePerimeter(majorAxisInt,minorAxisInt);
                }else{
                    System.out.println("Negatif değer girilemez...!");
                }
            }
            System.out.print("Elips hesaplamasına devam edilsin mi[Evet/Hayır] :");
            String textYesNo = scanner.nextLine();
            if(yesNoPattern.matcher(textYesNo).matches()){
                if(textYesNo.equals("Evet")){
                    status = true;
                }else{
                    System.out.println("\n\n-------------------------------------------------------");
                    System.out.println("Elips için alan ve çevre hesaplaması sonlandırılıyor...");
                    System.out.println("-------------------------------------------------------\n\n");
                    status = false;
                }
            }else{
                status = true;
            }
        }while(status == true);
    }
}
