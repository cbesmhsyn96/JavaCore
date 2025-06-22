import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RunProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern numberPattern = Pattern.compile("\\d+");
        Quadrilateral quadrilateral = new Quadrilateral();
        Calculation calculation = new Calculation();
        String shorterLeg;
        String longerLeg;
        do{
            System.out.print("Kısa kenar :");
            shorterLeg = scanner.nextLine();
            if (!numberPattern.matcher(shorterLeg).matches()){
                System.out.println("Hatalı giriş...");
                continue;
            }else{
                quadrilateral.setShorterLeg(Integer.parseInt(shorterLeg));
            }
            System.out.print("Uzun kenar :");
            longerLeg = scanner.nextLine();
            if(!numberPattern.matcher(longerLeg).matches()){
                System.out.println("Hatalı giriş...");
                continue;
            }else{
                quadrilateral.setLongerLeg(Integer.parseInt(longerLeg));
                break;
            }
        }while (true);
        System.out.println("Hipotenüs = "+(int)calculation.calcHypotenuse(quadrilateral.getShorterLeg(), quadrilateral.getLongerLeg()));
    }
}