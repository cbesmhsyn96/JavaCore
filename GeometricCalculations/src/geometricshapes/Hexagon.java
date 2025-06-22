package geometricshapes;

import validations.PatternValidations;
import java.util.Scanner;

import static trigonometry.TrigHelper.cotRadians;

public class Hexagon extends PatternValidations {

    private static Scanner scanner = new Scanner(System.in);

    public static void regularHexagonArea(double edge){
        double area = ((Math.pow(edge,2)*cotRadians(pi_number/6))*6)/4;
        System.out.printf("\nAlan = %.2f", area);
    }

    public static void regularHexagonPerimeter(double edge){
        double perimeter = 6*edge;
        System.out.printf("\nÇevre = %.2f\n", perimeter);
    }

    public static void allCoveredMethodRegularHexagon(boolean startingValue){
        boolean status = startingValue;
        do{
            System.out.println("\nAltıgen için hesaplama başlatılıyor...");
            System.out.print("\nAltıgenin 1 kenarının uzunluğunu giriniz :");
            String edge = scanner.nextLine();
            if(intPattern.matcher(edge).matches()){
                int edgeInt = Integer.parseInt(edge);
                if(edgeInt>0){
                    regularHexagonArea(edgeInt);
                    regularHexagonPerimeter(edgeInt);
                }else{
                    System.out.println("Negatif değer girilemez...!");
                }
            }
            System.out.print("Altıgen hesaplamasına devam edilsin mi[Evet/Hayır] :");
            String textYesNo = scanner.nextLine();
            if(yesNoPattern.matcher(textYesNo).matches()){
                if(textYesNo.equals("Evet")){
                    status = true;
                }else{
                    System.out.println("\n\n-------------------------------------------------------");
                    System.out.println("Altıgen için alan ve çevre hesaplaması sonlandırılıyor...");
                    System.out.println("-------------------------------------------------------\n\n");
                    status = false;
                }
            }else{
                status = true;
            }
        }while(status == true);
    }
}
