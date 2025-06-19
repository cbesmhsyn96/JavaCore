package geometricshapes;
import validations.PatternValidations;
import java.util.Scanner;

public class Circle extends PatternValidations {

    private static Scanner scanner = new Scanner(System.in);

    public static void circleArea(int radius){
        double area = pi_number*Math.pow(radius,2);
        System.out.printf("\nAlan = %.2f", area);
    }

    public static void circlePerimeter(int radius){
        double perimeter = 2*pi_number*radius;
        System.out.printf("\nÇevre = %.2f\n", perimeter);
    }

    public static void allCoveredMethodCircle(boolean startingValue){
        boolean status = startingValue;
        do{
            System.out.println("\nDaire için hesaplama başlatılıyor...");
            System.out.print("\nDairenin yarıçapını giriniz :");
            String radius = scanner.nextLine();
            if(intPattern.matcher(radius).matches()){
                int radiusValue = Integer.parseInt(radius);
                if(radiusValue>0){
                    circleArea(radiusValue);
                    circlePerimeter(radiusValue);
                }else{
                    System.out.println("Negatif değer girilemez...!");
                }
            }
            System.out.print("Daire hesaplamasına devam edilsin mi[Evet/Hayır] :");
            String textYesNo = scanner.nextLine();
            if(yesNoPattern.matcher(textYesNo).matches()){
                if(textYesNo.equals("Evet")){
                    status = true;
                }else{
                    System.out.println("\n\n-------------------------------------------------------");
                    System.out.println("Daire için alan ve çevre hesaplaması sonlandırılıyor...");
                    System.out.println("-------------------------------------------------------\n\n");
                    status = false;
                }
            }else{
                status = true;
            }
        }while(status == true);
    }

}